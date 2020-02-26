package com.example.demo4.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.util.Date;

/**
 * entity是對數據進行的設置
 * 可以加上@TableName(數據庫名稱)
 * @TableId(type = IdType.AUTO)
 * */
@Data
public class HelloEntity {
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
