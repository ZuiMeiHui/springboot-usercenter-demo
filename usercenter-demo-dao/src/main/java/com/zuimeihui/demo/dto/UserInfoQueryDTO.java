package com.zuimeihui.demo.dto;

import java.io.Serializable;
import java.util.Date;

import com.zuimeihui.demo.common.dto.PageCustom;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Tolerate;

/**
 * 用户表queryDTO
 * 
 * @author 醉美会 ZuiMeiHui.com
 * @date 2023-11-12 14:53:24
 */
@Setter
@Getter
@ToString
@Builder
public class UserInfoQueryDTO extends PageCustom implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Tolerate
	public UserInfoQueryDTO() {
		
	}

    private Long id;

	private Date timeCreateBegin;

	private Date timeCreateEnd;

	private Date timeUpdateBegin;

	private Date timeUpdateEnd;

    private String adminId;

    private String adminName;

    private String userName;

    private String userNickname;

    private String userTelphone;

    private String userEmail;

    private Boolean userFreeze;

    private Boolean userDel;

}