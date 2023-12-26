package com.zuimeihui.demo.pojo;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class UserInfo implements Serializable {
	
    private static final long serialVersionUID = 1L;

    private Long id;

    private Date timeCreate;

    private Date timeUpdate;

    private String adminId;

    private String adminName;

    private String userName;

    private String userPassword;
    
    private String userPasswordSalt;

    private String userNickname;

    private String userTelphone;

    private String userEmail;

    private String userRemark;

    private Boolean userFreeze;

    private Boolean userDel;

}