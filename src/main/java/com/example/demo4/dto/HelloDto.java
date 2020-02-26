package com.example.demo4.dto;


import lombok.Data;

import java.util.Date;
@Data
public class HelloDto {
    /*夾位ID*/
    private String crampingid;
    /*機種ID*/
    private String modelid;
    /*夾位名*/
    private String campingame;
    /*創建時間*/
    private Date createdata;
    /*結束時間*/
    private Date enddate;
    /*是否可用,0無效，1有效*/
    private int isvalid;
    /*C/T值，加工每片所需時間,單位秒s*/
    private int idealct;



}
