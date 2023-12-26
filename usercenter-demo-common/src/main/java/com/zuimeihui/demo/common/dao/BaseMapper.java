package com.zuimeihui.demo.common.dao;

import java.util.List;

import com.zuimeihui.demo.common.dto.PageCustom;

/**
 * BaseMapper
 * 
 * @author 醉美会 ZuiMeiHui.com
 * @date 2023-11-12 10:10:50
 */
public interface BaseMapper<T, Q extends PageCustom> {

	/**
	 * 新增记录
	 * 
	 * @param record
	 * @return
	 */
	Integer insertSelective(T record);

	/**
	 * 通过主键删除记录
	 * 
	 * @param id
	 * @return
	 */
	Integer deleteByPrimaryKey(Long id);

	/**
	 * 通过主键查询记录
	 * 
	 * @param id
	 * @return
	 */
	T selectByPrimaryKey(Long id);

	/**
	 * 修改记录
	 * 
	 * @param record
	 * @return
	 */
	Integer updateByPrimaryKeySelective(T record);

	/**
	 * 修改记录 - 不判断为空条件
	 * 
	 * @param record
	 * @return
	 */
	Integer updateByPrimaryKey(T record);

	/**
	 * 记录结果集
	 * 
	 * @param queryDTO
	 * @return
	 */
	List<T> selectBy(Q queryDTO);

	/**
	 * 记录行数
	 * 
	 * @param ueryDTO
	 * @return
	 */
	Integer countBy(Q queryDTO);

	/**
	 * 记录结果集返回一行
	 * 
	 * @param queryDTO
	 * @return
	 */
	T uniqueBy(Q queryDTO);
}
