package com.zuimeihui.demo.controller.user;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zuimeihui.demo.common.constants.Constants;
import com.zuimeihui.demo.common.pojo.PageBean;
import com.zuimeihui.demo.common.service.BaseResult;
import com.zuimeihui.demo.common.utils.MD5Uitl;
import com.zuimeihui.demo.dto.UserInfoDTO;
import com.zuimeihui.demo.dto.UserInfoQueryDTO;
import com.zuimeihui.demo.service.user.UserInfoService;

/**
 * UserInfoController
 * 
 * @author 醉美会 ZuiMeiHui.com
 * @date 2023-11-12 20:49:53
 */
@RestController
@RequestMapping("/user-info")
public class UserInfoController {

	@Autowired
	private UserInfoService UserInfoService;

	/**
	 * 列表-带分页
	 * 
	 * @param queryDTO
	 * @return
	 */
	@PostMapping({ "/list/page" })
	public BaseResult<?> listPage(
			@RequestParam(value= Constants.USER_ID_KEY, required = false) String userId,
			@RequestParam(value= Constants.USER_NAME_KEY, required = false) String userName,
			@RequestBody UserInfoQueryDTO queryDTO) {
		queryDTO.setFields("id");
		queryDTO.setOrder("desc");
		PageBean<UserInfoDTO> UserInfoDTOs = UserInfoService.selectPageBy(queryDTO);
		return BaseResult.success(UserInfoDTOs);
	}

	/**
	 * 列表-不带分页
	 * 
	 * @param queryDTO
	 * @return
	 */
	@PostMapping({ "/list" })
	public BaseResult<?> list(
			@RequestParam(value= Constants.USER_ID_KEY, required = false) String userId,
			@RequestParam(value= Constants.USER_NAME_KEY, required = false) String userName,
			@RequestBody UserInfoQueryDTO queryDTO) {
		queryDTO.setFields("id");
		queryDTO.setOrder("desc");
		List<UserInfoDTO> UserInfoDTOs = UserInfoService.selectBy(queryDTO);
		return BaseResult.success(UserInfoDTOs);
	}

	/**
	 * 新增
	 * 
	 * @param dto
	 * @return
	 */
	@PostMapping({ "/add" })
	public BaseResult<?> add(
			@RequestParam(value= Constants.USER_ID_KEY, required = false) String userId,
			@RequestParam(value= Constants.USER_NAME_KEY, required = false) String userName,
			@RequestBody UserInfoDTO dto) {
		UserInfoService.save(dto, userId, userName);
		return BaseResult.success(dto.getId());
	}

	/**
	 * 编辑
	 * 
	 * @param dto
	 * @param id
	 * @return
	 */
	@PutMapping({ "/{id}/edit" })
	public BaseResult<?> edit(
			@RequestParam(value= Constants.USER_ID_KEY, required = false) String userId,
			@RequestParam(value= Constants.USER_NAME_KEY, required = false) String userName,
			@RequestBody UserInfoDTO dto, 
			@PathVariable("id") Long id) {
		dto.setId(id);
		if (StringUtils.isNotBlank(dto.getUserPassword())) {
			dto.setUserPasswordSalt(RandomStringUtils.randomAlphanumeric(8));
			dto.setUserPassword(MD5Uitl.encode(dto.getUserPassword(), dto.getUserPasswordSalt()));
		}
		UserInfoService.save(dto, userId, userName);
		return BaseResult.success(dto.getId());
	}

	/**
	 * 详情
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping({ "/{id}/detail" })
	public BaseResult<?> detail(
			@RequestParam(value= Constants.USER_ID_KEY, required = false) String userId,
			@RequestParam(value= Constants.USER_NAME_KEY, required = false) String userName,
			@PathVariable("id") Long id) {
		UserInfoDTO UserInfoDTO = UserInfoService.get(id);
		return BaseResult.success(UserInfoDTO);
	}

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping({ "/{id}/delete" })
	public BaseResult<?> delete(
			@RequestParam(value= Constants.USER_ID_KEY, required = false) String userId,
			@RequestParam(value= Constants.USER_NAME_KEY, required = false) String userName,
			@PathVariable("id") Long id) {
		UserInfoService.remove(id);
		return BaseResult.success(id);
	}
}
