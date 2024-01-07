package com.zuimeihui.demo.common.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.zuimeihui.demo.common.dao.BaseMapper;
import com.zuimeihui.demo.common.dto.PageCustom;
import com.zuimeihui.demo.common.pojo.PageBean;

/**
 * 基础服务层
 * 
 * @ClassName: BaseService
 * @Description: TODO
 * @author ZuiMeiHui.com 醉美会
 */
public abstract class BaseService<M extends BaseMapper<T, Q>, T, Q extends PageCustom> {

	@Autowired
	protected M mapper;

	/**
	 * 通过主键查询记录
	 * 
	 * @Title: get
	 * @Description: TODO
	 * @param @param  id
	 * @param @return 参数
	 * @return T 返回类型
	 * @throws
	 * @author ZuiMeiHui.com 醉美会
	 */
	public T get(Long id) {
		return handleQueryResult(mapper.selectByPrimaryKey(id), null);
	}

	/**
	 * 通过主键删除记录
	 * 
	 * @Title: remove
	 * @Description: TODO
	 * @param @param id 参数
	 * @return void 返回类型
	 * @throws
	 * @author ZuiMeiHui.com 醉美会
	 */
	public void remove(Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	/**
	 * 通过条件分页查询
	 * 
	 * @Title: selectPageBy
	 * @Description: TODO
	 * @param @param  queryDTO
	 * @param @return 参数
	 * @return PageBean<T> 返回类型
	 * @throws
	 * @author ZuiMeiHui.com 醉美会
	 */
	public PageBean<T> selectPageBy(Q queryDTO) {
		queryDTO.setIsPage(true);
		handleQueryParam(queryDTO);
		return new PageBean<T>(handleQueryResult(mapper.selectBy(queryDTO)), mapper.countBy(queryDTO));
	}

	/**
	 * 通过条件查询
	 * 
	 * @Title: selectBy
	 * @Description: TODO
	 * @param @param  queryDTO
	 * @param @return 参数
	 * @return List<T> 返回类型
	 * @throws
	 * @author ZuiMeiHui.com 醉美会
	 */
	public List<T> selectBy(Q queryDTO) {
		queryDTO.setIsPage(false);
		return handleQueryResult(mapper.selectBy(queryDTO));
	}

	/**
	 * 通过条件获取一行记录
	 * 
	 * @Title: uniqueBy
	 * @Description: TODO
	 * @param @param  queryDTO
	 * @param @return 参数
	 * @return T 返回类型
	 * @throws
	 * @author ZuiMeiHui.com 醉美会
	 */
	public T uniqueBy(Q queryDTO) {
		queryDTO.setIsPage(false);
		handleQueryParam(queryDTO);
		return handleQueryResult(mapper.uniqueBy(queryDTO));
	}

	/**
	 * 查询前的入参处理
	 * 
	 * @Title: handleQueryParam
	 * @Description: TODO
	 * @param @param  queryDTO
	 * @param @return 参数
	 * @return Q 返回类型
	 * @throws
	 * @author ZuiMeiHui.com 醉美会
	 */
	public Q handleQueryParam(Q queryDTO) {
		return queryDTO;
	}

	/**
	 * 单条查询后的结果集处理
	 * 
	 * @Title: handleQueryResult
	 * @Description: TODO
	 * @param @param  dto
	 * @param @return 参数
	 * @return T 返回类型
	 * @throws
	 * @author ZuiMeiHui.com 醉美会
	 */
	public T handleQueryResult(T dto) {
		return handleQueryResult(dto);
	}

	/**
	 * 单条查询后的结果集处理
	 * 
	 * @Title: handleQueryResult
	 * @Description: TODO
	 * @param @param  dto
	 * @param @param  isList
	 * @param @return 参数
	 * @return T 返回类型
	 * @throws
	 * @author ZuiMeiHui.com 醉美会
	 */
	public T handleQueryResult(T dto, Boolean isList) {
		return dto;
	}

	/**
	 * 多条查询后的结果集处理
	 * 
	 * @Title: handleQueryResult
	 * @Description: TODO
	 * @param @param  dtos
	 * @param @return 参数
	 * @return List<T> 返回类型
	 * @throws
	 * @author ZuiMeiHui.com 醉美会
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
	 * @Title: checkSaveInput
	 * @Description: TODO
	 * @param @param  dto
	 * @param @return 参数
	 * @return BaseResult<?> 返回类型
	 * @throws
	 * @author ZuiMeiHui.com 醉美会
	 */
	public BaseResult<?> checkSaveInput(T dto) {
		return BaseResult.success();
	}

	/**
	 * 删除数据参数校验
	 * 
	 * @Title: checkRemove
	 * @Description: TODO
	 * @param @param  id
	 * @param @return 参数
	 * @return BaseResult<?> 返回类型
	 * @throws
	 * @author ZuiMeiHui.com 醉美会
	 */
	public BaseResult<?> checkRemove(Long id) {
		return BaseResult.success();
	}
}
