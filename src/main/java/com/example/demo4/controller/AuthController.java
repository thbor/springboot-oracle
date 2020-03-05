package com.example.demo4.controller;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.example.demo4.GlobalConstant;
import com.example.demo4.dto.UserInfo;
import com.example.demo4.service.UserAndPermissionService;
import com.example.demo4.sys.error.CustomException;
import com.example.demo4.utils.MySystemUtil;
import com.example.demo4.utils.StatusConstants;
import com.example.demo4.vo.MessageInfo;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;


@RestController
@RequestMapping("auth")
public class AuthController {
    @Autowired
    private UserAndPermissionService userAndPermissionService;
    @GetMapping("/getAccessToken")
    public MessageInfo getAccessToken(@RequestParam String code, String redirect_uri) {

        //組裝param
        String param = "grant_type=authorization_code&code=" + code  //即code
                + "&redirect_uri="+redirect_uri;
        String result = sendPostToAuthServer(param, "token");
        JSONObject jsonObejct = null;
        try{
            jsonObejct= JSONObject.parseObject(result);
        }catch (JSONException e){
            e.printStackTrace();
            return MySystemUtil.returnMessage(StatusConstants.FAILED, null, e.toString());
        }
        String  accessToken = jsonObejct.getString("access_token");

        String userInfo = GetInfoFromAuthServer(accessToken, "userinfo");

        JSONObject userInfoJson = null;
        try{
            userInfoJson= JSONObject.parseObject(userInfo);
        }catch (JSONException e){
            e.printStackTrace();
        }

        UserInfo user = userAndPermissionService.getCurrentUserInfoByWorkId(userInfoJson.getString("sub"));
        if(user == null){
            jsonObejct.putAll(userInfoJson);
            return MySystemUtil.returnMessage(StatusConstants.SUCCESS, null, jsonObejct.toJSONString());
        }
        String factoryNo = user.getFactoryno();
        String punit = user.getPunit();
        if(!MySystemUtil.isEmpty(factoryNo)){
            jsonObejct.put("factoryNo",factoryNo);
        }
        if(!MySystemUtil.isEmpty(punit)){
            jsonObejct.put("punit",punit);
        }

        jsonObejct.putAll(userInfoJson);

        return MySystemUtil.returnMessage(StatusConstants.SUCCESS, null, jsonObejct.toJSONString());
    }
    /**
     * @return result from AuthServer
     * @Description send a http post request to Auth Server
     * @Param param, path    param: http body such as grant_types, scopes, code
     * path: url such as token, introspect
     **/
    private String sendPostToAuthServer(String param, String path) {
        HttpURLConnection con = null;
        String result = "";
        // 获得数据字节数据，请求数据流的编码，必须和服务器端处理请求流的编码一致,StandardCharsets.UTF_8可以避免寫trycatch
        byte[] postData = param.getBytes(StandardCharsets.UTF_8);
        try {
            URL myurl = new URL(GlobalConstant.AuthBaseUrl + path);
            con = (HttpURLConnection) myurl.openConnection();
            con.setDoOutput(true);
            con.setRequestMethod("POST");
            String encoded =
                    Base64.getEncoder().encodeToString((GlobalConstant.ClientId + ":" + GlobalConstant.SecretKey).getBytes(StandardCharsets.UTF_8));
            con.setRequestProperty("Authorization", "Basic " + encoded);

            try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
                wr.write(postData);
            }
            StringBuilder content;

            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()))) {

                String line;
                content = new StringBuilder();

                while ((line = in.readLine()) != null) {
                    content.append(line);
                    content.append(System.lineSeparator());
                }
            }
            result = content.toString();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            //訪問碼失效
            if (e.getMessage().contains("401")) {
                throw new CustomException(StatusConstants.UNAUTHORIZED, "訪問碼失效");
            } else if (e.getMessage().contains("Connection timed out")) {
                throw new CustomException(StatusConstants.TIME_OUT, "服務器響應超時，請稍後再試");
            } else {
                throw new CustomException(StatusConstants.FAILED, "未知錯誤"); //永遠都不要發生
            }
        } finally {
            con.disconnect();
        }
        return result;
    }
    /**
     * @return result from AuthServer
     * @Description send a http GET request to Auth Server
     * @Token Bearer token
     * path: url such as token, introspect, profile
     **/
    private String GetInfoFromAuthServer(String token, String path) {
        // 获得Http客户
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        String result = "";

//		HttpGet httpGet = new HttpGet("http://localhost:12345/doGetControllerTwo" + "?" + params);
        HttpGet httpGet = new HttpGet(GlobalConstant.AuthBaseUrl+path);
        // 响应模型(HttpResponse用CloseableHttpResponse，DefaultHttpClient用CloseableHttpClient)
        CloseableHttpResponse response = null;
        try {
            // 配置信息
            RequestConfig requestConfig = RequestConfig.custom()
                    // 设置连接超时时间(单位毫秒)
                    .setConnectTimeout(5000)
                    // 设置请求超时时间(单位毫秒)
                    .setConnectionRequestTimeout(5000)
                    // socket读写超时时间(单位毫秒)
                    .setSocketTimeout(5000)
                    // 设置是否允许重定向(默认为true)
                    .setRedirectsEnabled(true).build();

            // 将上面的配置信息 运用到这个Get请求里
            httpGet.setConfig(requestConfig);
            httpGet.setHeader("Authorization","Bearer "+token);
            // 由客户端执行(发送)Get请求
            response = httpClient.execute(httpGet);

            // 从响应模型中获取响应实体
            HttpEntity responseEntity = response.getEntity();
            System.out.println("响应状态为:" + response.getStatusLine());
            if (responseEntity != null) {
                long resLen = responseEntity.getContentLength();
                System.out.println("响应内容长度为:" + resLen);
                result = EntityUtils.toString(responseEntity);
                System.out.println("响应内容为:" + result);
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 释放资源
                if (httpClient != null) {
                    httpClient.close();
                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
