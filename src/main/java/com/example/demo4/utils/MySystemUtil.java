package com.example.demo4.utils;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.demo4.vo.MessageInfo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class MySystemUtil {

    public static final String  regexS = "^\\d+$";
    public final static String yyyy_MM_dd ="yyyy-MM-dd";
    public final static String HH_mm_ss = "HH:mm:ss";
    public final static String yyyy_MM_dd_HH_mm_ss ="yyyy-MM-dd HH:mm:ss";

    /**
     * 返回Json格式消息对象
     * @param data
     * @param msg
     * @return
     */
    public static MessageInfo returnMessage(String code , String msg , String type, Object data){
        MessageInfo messageInfo = new MessageInfo();
        messageInfo.setCode(code);
        messageInfo.setMsg(msg);
        messageInfo.setType(type);
        messageInfo.setData(data);
        return  messageInfo;
    }
    public static MessageInfo returnMessage(String code ,String msg){
        MessageInfo messageInfo = new MessageInfo();
        messageInfo.setCode(code);
        messageInfo.setMsg(msg);
        return  messageInfo;
    }

    public static MessageInfo returnMessage(String code ,String msg,Object data){
        MessageInfo messageInfo= new MessageInfo();
        messageInfo.setCode(code);
        messageInfo.setMsg(msg);
        messageInfo.setData(data);
        return  messageInfo;
    }

    public static MessageInfo returnSuccess(Object data) {
        MessageInfo messageInfo= new MessageInfo();
        messageInfo.setCode(StatusConstants.SUCCESS);
        messageInfo.setMsg("");
        messageInfo.setData(data);
        return  messageInfo;
    }
    /**
     * Object To JsonString
     * @param obj
     * @return
     */
    public static String ObjectToJsonString(Object obj ){
        if(obj == null){
           return null;
        }
        JSONObject josn = (JSONObject) JSONObject.toJSON(obj);
        return  josn.toJSONString();
    }

    public static String getUserIdByToken(){
        String token = "";
        //獲得token
        Object details = SecurityContextHolder.getContext().getAuthentication().getDetails();
        if (details instanceof OAuth2AuthenticationDetails) {
            OAuth2AuthenticationDetails oauthsDetails = (OAuth2AuthenticationDetails) details;
            token = oauthsDetails.getTokenValue();
        }
        try {
            DecodedJWT jwt = JWT.decode(token);
            return  jwt.getSubject();
        } catch (JWTDecodeException exception){
            //Invalid token
            exception.printStackTrace();
        }
        return "";
    }

    /**
     * 获取系统时间
     * @return
     */
    public static Date getSystemDate(){
        Date day =new Date();
        return day;
    }
    /**
     * 获取系统时间1
     * @param pattern 返回时间 格式 默认yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static Date getSystemDate(String pattern){
        Date day =new Date();
      if(isEmpty(pattern)){
          SimpleDateFormat df = new SimpleDateFormat(yyyy_MM_dd_HH_mm_ss);
      }else {
          SimpleDateFormat df = new SimpleDateFormat(pattern);
      }
        return day;
    }

    /**
     * 获取系统时间2
     * @return 格式 默认yyyy-MM-dd HH:mm:ss
     */
    public static String getSystemDateToStr(){
        //创建Calendar对象
        Calendar cal=Calendar.getInstance();
        //用Calendar类提供的方法获取年、月、日、时、分、秒
        int year  =cal.get(Calendar.YEAR);   //年
        int month =cal.get(Calendar.MONTH)+1;  //月  默认是从0开始  即1月获取到的是0
        int day   =cal.get(Calendar.DAY_OF_MONTH);  //日，即一个月中的第几天
        int hour  =cal.get(Calendar.HOUR_OF_DAY);  //小时
        int minute=cal.get(Calendar.MINUTE);   //分
        int second=cal.get(Calendar.SECOND);  //秒
        String date=year+"-"+month+"-"+day+" "+hour+":"+minute+":"+second;
        return date;
    }
    /**
     * 判断字符串是否为空
     * @param string
     * @return
     */
    public static boolean isEmpty(String string){
        boolean flag = false;
        if(string == null ||string.length()<1){
            flag=true;
        }
        return flag;
    }

    /**
     * 字符串转换为 日期格式
     * @param str
     * @return
     */
    public static Date StrToDate(String str,String pattern) {
        SimpleDateFormat format =null;
        Date date = null;
        if(isEmpty(pattern)){
             format = new SimpleDateFormat(yyyy_MM_dd_HH_mm_ss);
        }else{
            format = new SimpleDateFormat(pattern);
        }
        try {
            date = format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }


    /**
     * 字符串转换为 日期格式  yyyy-MM-dd HH-mm-ss
     * @return
     */
    public static Date StrToDate(String str) {
        SimpleDateFormat format =null;
        Date date = null;
        format = new SimpleDateFormat(yyyy_MM_dd_HH_mm_ss);
        try {
            date = format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * date 转换字符串 成日期格式
     * @param date 源日期
     * @param pattern 格式
     * @return
     */

    public static String DateToStr(Date date,String pattern) {
        SimpleDateFormat format =null;
        if(isEmpty(pattern)){
            format = new SimpleDateFormat(yyyy_MM_dd_HH_mm_ss);
        }else{
            format = new SimpleDateFormat(pattern);
        }
        String str = format.format(date);
        return str;
    }


    /**
     * 计算相差天数
     * 计算二个时间间隔天数，保留整数
     * @param startDate
     * @param endDate
     * @return
     */
    public static int daysBetween(Date startDate,Date endDate){
        Date date1 = startDate;
        Date date2 = endDate;
        Calendar cal = Calendar.getInstance();
        cal.setTime(date1);
        long time1 = cal.getTimeInMillis();
        cal.setTime(date2);
        long time2 = cal.getTimeInMillis();
        long between_days=(time2-time1)/(1000*3600*24);
        Integer count = Integer.parseInt(String.valueOf(between_days));
        if(count<1){
            count = 1;
        }
        return count;
    }
    /**
     * 计算相差天数
     * 计算二个时间间隔天数，保留一位小数
     * @param startDate
     * @param endDate
     * @return
     */
    public static String getQuot(Date startDate, Date endDate) {
        String retQuot = "";
        try {
            long timeout = endDate.getTime() - startDate.getTime();
            double quot = 0.0;
            quot = ((double)timeout) / 1000 / 60 / 60 / 24;

            DecimalFormat formater = new DecimalFormat();
            formater.setMaximumFractionDigits(1);
            formater.setGroupingSize(0);
            formater.setRoundingMode(RoundingMode.FLOOR);
            retQuot = formater.format(quot);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retQuot;
    }

    /**
     *  将日期向后延长
     * @param sourceDate 源日期
     * @param number 延长几天
     * @return
     */
    public static Date getAtDateAfter(Date sourceDate, Integer number){
        Date result;
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(sourceDate);
        calendar.add(calendar.DATE,number);
        result =calendar.getTime();
        return  result;
    }

    /**
     * 获取时间 yyyy-MM-dd  转换为固定分秒
     * @param date
     * @param ss
     * @return
     */
    public static Date getToDateSS(Date date,String ss){
        String newDateStr = MySystemUtil.DateToStr(date,yyyy_MM_dd);
        Date _time = MySystemUtil.StrToDate(newDateStr + ss,yyyy_MM_dd_HH_mm_ss);
        return _time;
    }

    /**
     *  判断字符串 是否是纯数字组成
     * @param str
     * @return
     */
    public static boolean isNumerString(String str) {
        return str.matches(regexS);
    }


    /**
     * 时间比较器
     * @param source 比较源
     * @param target 比较目标
     * @param type 日期格式
     * @return  0 表示相同  -1表示 在目标时间之内  1表示在目标时间之外
     * @throws Exception
     */
    public  static int dateCompare(String source, String target, String type)  {
        Integer ret ;
        SimpleDateFormat format = new SimpleDateFormat(type);
        Date sourceDate = null;
        Date targetDate = null;
        try {
            sourceDate = format.parse(source);
            targetDate = format.parse(target);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        ret = sourceDate.compareTo(targetDate);
        return ret;
    }

    /**
     * object To String
     * @param object
     * @return
     */
    public static String valueOf(Object object){
        if(object == null){
            return null;
        }else{
            return String.valueOf(object);
        }
    }

    /**
     * 获取指定日期所在月份开始的时间
     * 时间格式yyyyMMdd
     * @param date 指定日期
     * @return
     */
    public static String getMonthBegin(Date date) {
        SimpleDateFormat aDateFormat=new SimpleDateFormat("yyyy/MM/dd");
        Calendar c = Calendar.getInstance();
        c.setTime(date);

        //设置为1号,当前日期既为本月第一天
        c.set(Calendar.DAY_OF_MONTH, 1);
        //将小时至0
        c.set(Calendar.HOUR_OF_DAY, 0);
        //将分钟至0
        c.set(Calendar.MINUTE, 0);
        //将秒至0
        c.set(Calendar.SECOND,0);
        //将毫秒至0
        c.set(Calendar.MILLISECOND, 0);
        // 获取本月第一天的时间
        return aDateFormat.format(c.getTime());
    }

    /**
     * 获取指定日期所在月份结束的时间
     * 时间格式yyyyMMdd
     * @param date 指定日期
     * @return
     */
    public static String getMonthEnd(Date date) {
        SimpleDateFormat aDateFormat=new SimpleDateFormat("yyyy/MM/dd");
        Calendar c = Calendar.getInstance();
        c.setTime(date);

        //设置为当月最后一天
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        //将小时至23
        c.set(Calendar.HOUR_OF_DAY, 23);
        //将分钟至59
        c.set(Calendar.MINUTE, 59);
        //将秒至59
        c.set(Calendar.SECOND,59);
        //将毫秒至999
        c.set(Calendar.MILLISECOND, 999);
        // 获取本月最后一天的时间
        return aDateFormat.format(c.getTime());
    }

}
