package com.zuimeihui.demo.common.dao;

import java.util.List;

import com.zuimeihui.demo.common.dto.PageCustom;

/**
 * 基类Mapper
 * 
 * @ClassName: BaseMapper
 * @Description: TODO
 * @author ZuiMeiHui.com 醉美会
 */
public interface BaseMapper<T, Q extends PageCustom> {

	/**
	 * 新增记录
	 * 
	 * @Title: insertSelective
	 * @Description: TODO
	 * @param @param  record
	 * @param @return 参数
	 * @return Integer 返回类型
	 * @throws
	 * @author ZuiMeiHui.com 醉美会
	 */
	Integer insertSelective(T record);

	/**
	 * 通过主键删除记录
	 * 
	 * @Title: deleteByPrimaryKey
	 * @Description: TODO
	 * @param @param  id
	 * @param @return 参数
	 * @return Integer 返回类型
	 * @throws
	 * @author ZuiMeiHui.com 醉美会
	 */
	Integer deleteByPrimaryKey(Long id);

	/**
	 * 通过主键查询记录
	 * 
	 * @Title: selectByPrimaryKey
	 * @Description: TODO
	 * @param @param  id
	 * @param @return 参数
	 * @return T 返回类型
	 * @throws
	 * @author ZuiMeiHui.com 醉美会
	 */
	T selectByPrimaryKey(Long id);

	/**
	 * 修改记录
	 * 
	 * @Title: updateByPrimaryKeySelective
	 * @Description: TODO
	 * @param @param  record
	 * @param @return 参数
	 * @return Integer 返回类型
	 * @throws
	 * @author ZuiMeiHui.com 醉美会
	 */
	Integer updateByPrimaryKeySelective(T record);

	/**
	 * 修改记录 - 不判断为空条件
	 * 
	 * @Title: updateByPrimaryKey
	 * @Description: TODO
	 * @param @param  record
	 * @param @return 参数
	 * @return Integer 返回类型
	 * @throws
	 * @author ZuiMeiHui.com 醉美会
	 */
	Integer updateByPrimaryKey(T record);

	/**
	 * 记录结果集
	 * 
	 * @Title: selectBy
	 * @Description: TODO
	 * @param @param  queryDTO
	 * @param @return 参数
	 * @return List<T> 返回类型
	 * @throws
	 * @author ZuiMeiHui.com 醉美会
	 */
	List<T> selectBy(Q queryDTO);

	/**
	 * 记录行数
	 * 
	 * @Title: countBy
	 * @Description: TODO
	 * @param @param  queryDTO
	 * @param @return 参数
	 * @return Integer 返回类型
	 * @throws
	 * @author ZuiMeiHui.com 醉美会
	 */
	Integer countBy(Q queryDTO);

	/**
	 * 记录结果集返回一行
	 * 
	 * @Title: uniqueBy
	 * @Description: TODO
	 * @param @param  queryDTO
	 * @param @return 参数
	 * @return T 返回类型
	 * @throws
	 * @author ZuiMeiHui.com 醉美会
	 */
	T uniqueBy(Q queryDTO);
}
