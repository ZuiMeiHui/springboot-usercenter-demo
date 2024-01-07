package com.zuimeihui.demo.dao;

import org.apache.ibatis.annotations.Mapper;

import com.zuimeihui.demo.common.dao.BaseMapper;
import com.zuimeihui.demo.dto.UserInfoDTO;
import com.zuimeihui.demo.dto.UserInfoQueryDTO;

/**
 * 登陆用户表Mapper
 * 
 * @ClassName: UserInfoMapper
 * @Description: TODO
 * @author ZuiMeiHui.com 醉美会
 */
@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfoDTO, UserInfoQueryDTO> {

}