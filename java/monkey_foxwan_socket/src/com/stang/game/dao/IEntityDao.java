package com.stang.game.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.stang.game.common.PageProperty;

/**
 * @author fei_wei
 * @company 上海三唐信息科技有限公司
 * @description 实体数据处理接口
 */
public interface IEntityDao<T> {

	/**
	 * @method getModel
	 * @param param
	 *            {Map} 参数
	 * @return {T}
	 * @description 得到数据对象
	 */
	public abstract T getModel(Map param);

	/**
	 * @method insert
	 * @param po
	 *            {T} 持久数据对象
	 * @return {int}
	 * @description 创建数据对象
	 */
	public abstract int insert(T po);

	/**
	 * @method update
	 * @param po
	 *            {T} 持久数据对象
	 * @return {int}
	 * @description 修改数据对象
	 */
	public abstract int update(T po);

	/**
	 * @method delete
	 * @param id
	 *            {Serializable} 序列号
	 * @return {int}
	 * @description 删除数据对象
	 */
	public abstract int delete(Serializable id);

	/**
	 * @method findPageList
	 * @param pp
	 *            {PageProperty}
	 * @return {List<T}
	 * @description 得到数据对象列表按分页条件 当pp.getNpageSize=0时返回所有
	 */
	public abstract List<T> findPageList(PageProperty pp);

	/**
	 * @method findCount
	 * @param pp
	 *            {PageProperty}
	 * @return {int}
	 * @description 得到数据数量按分页条件
	 */
	public abstract int findCount(PageProperty pp);

	/**
	 * @method list
	 * @param param
	 *            {Map}
	 * @return {List<T}
	 * @description 根据参数信息得到数据列表
	 */
	public abstract List<T> list(Map param);

	/**
	 * @method deleteList
	 * @param ids
	 *            {String} 序列号组
	 * @return {int}
	 * @description 删除多条数据对象
	 */
	public abstract int deleteList(String ids);
}
