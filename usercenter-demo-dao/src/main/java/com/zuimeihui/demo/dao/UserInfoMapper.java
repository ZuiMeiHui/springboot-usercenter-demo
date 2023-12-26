package com.zuimeihui.demo.dao;

import org.apache.ibatis.annotations.Mapper;

import com.zuimeihui.demo.common.dao.BaseMapper;
import com.zuimeihui.demo.dto.UserInfoDTO;
import com.zuimeihui.demo.dto.UserInfoQueryDTO;

@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfoDTO, UserInfoQueryDTO> {

}