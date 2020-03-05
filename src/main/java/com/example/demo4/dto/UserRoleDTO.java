package com.example.demo4.dto;

import lombok.Data;

/**
 * @ClassName UserRoleDTO
 * @Description TODO
 * @Author DONG LIU C3006018
 * @Since 2019/9/2 19:37
 * @Version 1.0
 **/


@Data
public class UserRoleDTO {

    private String userId; //工號
    private String powerId;//權限ID
    private String powerRole;//權限   eg： 換刀申請，超級管理員

}

