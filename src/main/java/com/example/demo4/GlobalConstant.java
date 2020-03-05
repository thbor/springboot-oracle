package com.example.demo4;

/**
 * @ClassName GlobalConstant
 * @Description TODO
 * @Author DONG LIU C3006018
 * @Since 2019/7/29 下午 01:39
 * @Version 1.0
 * @member {int} SocketIoPort socketIo 监听端口
 * @member {int} SocketIoInterval socketIo 消息间隔
 * @member {int} SocketIoTimeout socketIo 超时时间
 **/

public class GlobalConstant {
    public static String ApiVersion = "1.1";
    public static String AuthBaseUrl = "http://10.244.231.103:8080/openid/";
    public static String ClientId = "1a9357ca-163c-44e9-a5f1-ed1ed2b9fa6d";
    public static String SecretKey = "APly5gaArpTLl0E5jiqnfRDhJd8XS7NfwzDt0lfnSsnWyAau6UgMVs-HO2JBRh-vNstWC3EbTia0SCLh2_-LbOY";
    public static String redirect_uri = "http://10.244.231.80:8080/agv/";

    public static final int socketIoPort = 8089;
    public static final int socketIoInterval = 60000;
    public static final int socketIoTimeout = 180000;
}
