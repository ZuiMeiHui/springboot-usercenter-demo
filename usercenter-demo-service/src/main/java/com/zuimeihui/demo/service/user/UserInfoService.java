package com.zuimeihui.demo.service.user;

import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import com.zuimeihui.demo.common.service.BaseResult;
import com.zuimeihui.demo.common.service.BaseService;
import com.zuimeihui.demo.common.utils.MD5Uitl;
import com.zuimeihui.demo.dao.UserInfoMapper;
import com.zuimeihui.demo.dto.UserInfoDTO;
import com.zuimeihui.demo.dto.UserInfoQueryDTO;

/**
 * 用户表，服务层
 * 
 * @ClassName: UserInfoService
 * @Description: TODO
 * @author ZuiMeiHui.com 醉美会
 */
@Service
public class UserInfoService extends BaseService<UserInfoMapper, UserInfoDTO, UserInfoQueryDTO> {

	/**
	 * 保存和更新
	 * 
	 * @Title: save
	 * @Description: TODO
	 * @param @param dto
	 * @param @param userId
	 * @param @param userName 参数
	 * @return void 返回类型
	 * @throws
	 * @author ZuiMeiHui.com 醉美会
	 */
	public void save(UserInfoDTO dto, String userId, String userName) {
		dto.setAdminId(userId);
		dto.setAdminName(userName);
		dto.setTimeUpdate(new Date());
		if (dto.getId() == null) {
			dto.setTimeCreate(new Date());
			dto.setUserFreeze(false);
			dto.setUserDel(false);
			dto.setUserPasswordSalt(RandomStringUtils.randomAlphanumeric(8));
			dto.setUserPassword(MD5Uitl.encode(dto.getUserPassword(), dto.getUserPasswordSalt()));
			mapper.insertSelective(dto);
		} else {
			mapper.updateByPrimaryKeySelective(dto);
		}
	}

	/**
	 * 入参加载
	 */
	@Override
	public UserInfoQueryDTO handleQueryParam(UserInfoQueryDTO queryDTO) {
		return queryDTO;
	}

	/**
	 * 结果集加载
	 */
	@Override
	public UserInfoDTO handleQueryResult(UserInfoDTO dto) {
		return dto;
	}

	/**
	 * 检查保存入参
	 */
	@Override
	public BaseResult<?> checkSaveInput(UserInfoDTO dto) {
		return BaseResult.success();
	}

	/**
	 * 检查删除入参
	 */
	@Override
	public BaseResult<?> checkRemove(Long id) {
		return BaseResult.success();
	}
}
