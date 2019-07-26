package com.gwg.shiro.web.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserVo implements Serializable{

    /**
     * 用户id
     */
    private String userCode;

    /**
     * 员工姓名
     */
    private String username;

}
