package com.zuimeihui.demo.common.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zuimeihui.demo.common.constants.Constants;
import com.zuimeihui.demo.common.enums.BaseResultEnum;

import lombok.experimental.Accessors;

/**
 * 通用接口，返回结果集
 * 
 * @author 醉美会 ZuiMeiHui.com
 * @date 2023-11-12 11:03:36
 */
@Accessors(chain = true)
public class BaseResult<T> extends ApiResult<T> {

	private static final long serialVersionUID = 1L;

	private BaseResult(Integer code, String message, T data) {
		super(code, message, data);
	}

	/**
	 * 返回成功数据 （status 200）
	 * 
	 * @param <T>
	 * @param data
	 * @return
	 */
	public static <T> BaseResult<T> success(T data) {
		return new BaseResult<T>(BaseResultEnum.SUCCESS.getCode(), BaseResultEnum.SUCCESS.getValue(), data);
	}

	/**
	 * 返回成功数据 （status 200）
	 * 
	 * @param <T>
	 * @param msg
	 * @param data
	 * @return
	 */
	public static <T> BaseResult<T> success(String msg, T data) {
		return new BaseResult<T>(BaseResultEnum.SUCCESS.getCode(), msg != null ? msg.toString() : BaseResultEnum.SUCCESS.getValue(), data);
	}

	/**
	 * 返回成功数据 （status 200）
	 * 
	 * @return
	 */
	public static BaseResult<?> success() {
		return success(null);
	}

	/**
	 * 返回错误数据（status 500）
	 * 
	 * @param <T>
	 * @param msg
	 * @return
	 */
	public static <T> BaseResult<T> fail(String msg) {
		return new BaseResult<T>(BaseResultEnum.FAIL.getCode(), msg != null ? msg.toString() : BaseResultEnum.FAIL.getValue(), null);
	}

	/**
	 * 自定义返回错误数据
	 * 
	 * @param <T>
	 * @param code
	 * @param messsage
	 * @return
	 */
	public static <T> BaseResult<T> fail(Integer code, String message) {
		return new BaseResult<T>(code, message, null);
	}

	/**
	 * 自定义返回错误数据
	 * 
	 * @param <T>
	 * @param type
	 * @param message
	 * @return
	 */
	public static <T> BaseResult<T> fail(BaseResultEnum type, String message) {
		String s = StringUtils.isBlank(message) ? message : type.getValue() + "," + message;
		return new BaseResult<T>(type.getCode(), s, null);
	}

	/**
	 * 自定义返回错误数据
	 * 
	 * @param <T>
	 * @param code
	 * @param message
	 * @param data
	 * @return
	 */
	public static <T> BaseResult<T> fail(Integer code, String message, T data) {
		return new BaseResult<T>(code, message, data);
	}

	/**
	 * 是否成功
	 */
	@JsonIgnore
	@Override
	public Boolean isSuccess() {
		return super.isSuccess();
	}

	/**
	 * 是否失败
	 */
	@JsonIgnore
	@Override
	public Boolean isFail() {
		return super.isFail();
	}

	/**
	 * 分页
	 * 
	 * @param pageMap
	 * @param list
	 * @return
	 */
	public static BaseResult<?> successPage(Map<String, ?> pageMap, List<?> list) {
		if (list == null) {
			list = Collections.emptyList();
		}
		Integer page = (Integer) pageMap.get("page");
		Integer pageSize = (Integer) pageMap.get("pageSize");
		if (page == null) {
			page = 1;
		}
		if (pageSize == null) {
			pageSize = Constants.PAGE_SIZE;
		}
		Integer begin = (page - 1) * pageSize;
		Integer end = page * pageSize - 1;
		List<?> dataList = null;
		if (list.size() <= 0 || list.size() < begin) {
			dataList = Collections.emptyList();
		} else if (begin < list.size() && list.size() <= end) {
			dataList = list.subList(begin, list.size());
		} else {
			dataList = list.subList(begin, end);
		}
		Map<String, Object> pageInfo = new HashMap<String, Object>();
		pageInfo.put("page", 0);
		pageInfo.put("pageSize", pageSize);
		pageInfo.put("total", list.size());
		pageInfo.put("pageCount", list.size() / pageSize);
		Map<String, Object> resultData = new HashMap<String, Object>();
		resultData.put("list", dataList);
		resultData.put("pageInfo", pageInfo);
		return success(resultData);
	}

}
