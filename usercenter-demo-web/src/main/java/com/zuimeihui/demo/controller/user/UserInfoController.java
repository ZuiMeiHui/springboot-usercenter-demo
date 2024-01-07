package com.zuimeihui.demo.controller.user;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
 * 用户控制层
 * 
 * @ClassName: UserInfoController
 * @Description: TODO
 * @author ZuiMeiHui.com 醉美会
 */
@RestController
@RequestMapping("/user-info")
public class UserInfoController {

	@Autowired
	private UserInfoService UserInfoService;

	/**
	 * 用户列表-带分页
	 * 
	 * @Title: listPage
	 * @Description: TODO
	 * @param @param  userId
	 * @param @param  userName
	 * @param @param  queryDTO
	 * @param @return 参数
	 * @return BaseResult<?> 返回类型
	 * @throws
	 * @author ZuiMeiHui.com 醉美会
	 */
	@PostMapping({ "/list/page" })
	public BaseResult<?> listPage(@RequestParam(value = Constants.USER_ID_KEY, required = false) String userId,
			@RequestParam(value = Constants.USER_NAME_KEY, required = false) String userName,
			@RequestBody UserInfoQueryDTO queryDTO) {
		queryDTO.setFields("id");
		queryDTO.setOrder("desc");
		PageBean<UserInfoDTO> UserInfoDTOs = UserInfoService.selectPageBy(queryDTO);
		return BaseResult.success(UserInfoDTOs);
	}

	/**
	 * 用户列表-不带分页
	 * 
	 * @Title: list
	 * @Description: TODO
	 * @param @param  userId
	 * @param @param  userName
	 * @param @param  queryDTO
	 * @param @return 参数
	 * @return BaseResult<?> 返回类型
	 * @throws
	 * @author ZuiMeiHui.com 醉美会
	 */
	@PostMapping({ "/list" })
	public BaseResult<?> list(@RequestParam(value = Constants.USER_ID_KEY, required = false) String userId,
			@RequestParam(value = Constants.USER_NAME_KEY, required = false) String userName,
			@RequestBody UserInfoQueryDTO queryDTO) {
		queryDTO.setFields("id");
		queryDTO.setOrder("desc");
		List<UserInfoDTO> UserInfoDTOs = UserInfoService.selectBy(queryDTO);
		return BaseResult.success(UserInfoDTOs);
	}

	/**
	 * 注册用户
	 * 
	 * @Title: add
	 * @Description: TODO
	 * @param @param  userId
	 * @param @param  userName
	 * @param @param  dto
	 * @param @return 参数
	 * @return BaseResult<?> 返回类型
	 * @throws
	 * @author ZuiMeiHui.com 醉美会
	 */
	@PostMapping({ "/add" })
	public BaseResult<?> add(@RequestParam(value = Constants.USER_ID_KEY, required = false) String userId,
			@RequestParam(value = Constants.USER_NAME_KEY, required = false) String userName,
			@RequestBody UserInfoDTO dto) {
		UserInfoService.save(dto, userId, userName);
		return BaseResult.success(dto.getId());
	}

	/**
	 * 编辑用户
	 * 
	 * @Title: edit
	 * @Description: TODO
	 * @param @param  userId
	 * @param @param  userName
	 * @param @param  dto
	 * @param @param  id
	 * @param @return 参数
	 * @return BaseResult<?> 返回类型
	 * @throws
	 * @author ZuiMeiHui.com 醉美会
	 */
	@PutMapping({ "/{id}/edit" })
	public BaseResult<?> edit(@RequestParam(value = Constants.USER_ID_KEY, required = false) String userId,
			@RequestParam(value = Constants.USER_NAME_KEY, required = false) String userName,
			@RequestBody UserInfoDTO dto, @PathVariable("id") Long id) {
		dto.setId(id);
		if (StringUtils.isNotBlank(dto.getUserPassword())) {
			dto.setUserPasswordSalt(RandomStringUtils.randomAlphanumeric(8));
			dto.setUserPassword(MD5Uitl.encode(dto.getUserPassword(), dto.getUserPasswordSalt()));
		}
		UserInfoService.save(dto, userId, userName);
		return BaseResult.success(dto.getId());
	}

	/**
	 * 用户详情
	 * 
	 * @Title: detail
	 * @Description: TODO
	 * @param @param  userId
	 * @param @param  userName
	 * @param @param  id
	 * @param @return 参数
	 * @return BaseResult<?> 返回类型
	 * @throws
	 * @author ZuiMeiHui.com 醉美会
	 */
	@GetMapping({ "/{id}/detail" })
	public BaseResult<?> detail(@RequestParam(value = Constants.USER_ID_KEY, required = false) String userId,
			@RequestParam(value = Constants.USER_NAME_KEY, required = false) String userName,
			@PathVariable("id") Long id) {
		UserInfoDTO UserInfoDTO = UserInfoService.get(id);
		return BaseResult.success(UserInfoDTO);
	}

}
