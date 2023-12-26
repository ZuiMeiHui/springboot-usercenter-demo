package com.zuimeihui.demo.common.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.zuimeihui.demo.common.dao.BaseMapper;
import com.zuimeihui.demo.common.dto.PageCustom;
import com.zuimeihui.demo.common.pojo.PageBean;

/**
 * BaseService
 * 
 * @author 醉美会 ZuiMeiHui.com
 * @date 2023-11-12 10:27:20
 */
public abstract class BaseService<M extends BaseMapper<T, Q>, T, Q extends PageCustom> {

	@Autowired
	protected M mapper;

	/**
	 * 通过主键查询记录
	 * 
	 * @param id
	 * @return
	 */
	public T get(Long id) {
		return handleQueryResult(mapper.selectByPrimaryKey(id), null);
	}

	/**
	 * 通过主键删除记录
	 * 
	 * @param id
	 */
	public void remove(Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	/**
	 * 通过条件分页查询
	 * 
	 * @param queryDTO
	 * @return
	 */
	public PageBean<T> selectPageBy(Q queryDTO) {
		queryDTO.setIsPage(true);
		handleQueryParam(queryDTO);
		return new PageBean<T>(handleQueryResult(mapper.selectBy(queryDTO)), mapper.countBy(queryDTO));
	}

	/**
	 * 通过条件查询
	 * 
	 * @param queryDTO
	 * @return
	 */
	public List<T> selectBy(Q queryDTO) {
		queryDTO.setIsPage(false);
		return handleQueryResult(mapper.selectBy(queryDTO));
	}

	/**
	 * 通过条件获取但行记录
	 * 
	 * @param queryDTO
	 * @return
	 */
	public T uniqueBy(Q queryDTO) {
		queryDTO.setIsPage(false);
		handleQueryParam(queryDTO);
		return handleQueryResult(mapper.uniqueBy(queryDTO));
	}

	/**
	 * 查询前的入参处理
	 * 
	 * @param queryDTO
	 * @return
	 */
	public Q handleQueryParam(Q queryDTO) {
		return queryDTO;
	}

	/**
	 * 单条查询后的结果集处理
	 * 
	 * @param dto
	 * @return
	 */
	public T handleQueryResult(T dto) {
		return handleQueryResult(dto);
	}

	/**
	 * 单条查询后的结果集处理
	 * 
	 * @param dto
	 * @return
	 */
	public T handleQueryResult(T dto, Boolean isList) {
		return dto;
	}

	/**
	 * 多条查询后的结果集处理
	 * 
	 * @param dto
	 * @return
	 */
	public List<T> handleQueryResult(List<T> dtos) {
		for (T dto : dtos) {
			handleQueryResult(dto, true);
		}
		return dtos;
	}

	/**
	 * 新增数据参数校验
	 * 
	 * @param dto
	 * @return
	 */
	public BaseResult<?> checkSaveInput(T dto) {
		return BaseResult.success();
	}

	/**
	 * 删除数据参数校验
	 * 
	 * @param id
	 * @return
	 */
	public BaseResult<?> checkRemove(Long id) {
		return BaseResult.success();
	}
}
