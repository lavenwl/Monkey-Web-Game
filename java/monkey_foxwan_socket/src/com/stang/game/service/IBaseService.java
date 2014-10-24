package com.stang.game.service;

import java.io.Serializable;
import java.util.Map;

import com.stang.game.common.PageProperty;
import com.stang.game.common.Response;

/**
 * @author fei_wei
 * @company 上海三唐信息科技有限公司
 * @description 提供单表数据查询保存的基本方法
 */
public interface IBaseService<T> {

	/**
	 * @method getModel
	 * @param id
	 *            {Serializable} 确定记录唯一标识，供数据库查询
	 * @return {Response}
	 * @description 获取实体对象数据
	 */
	public abstract Response getModel(Serializable id);

	/**
	 * @method getModel
	 * @param param
	 *            {Map} 多条件供数据库查询
	 * @return {Response}
	 * @description 获取实体对象数据
	 */
	public abstract Response getModel(Map param);

	/**
	 * @method listMode
	 * @param parm
	 *            {Map} 多条件供数据库查询
	 * @return {Response}
	 * @description 获取满足条件的所有实体对象
	 */
	public abstract Response listModel(Map param);

	/**
	 * @method update
	 * @param model
	 *            {T} 提供更新的数据,封装在实体类对象
	 * @return {Response}
	 * @description 更新记录
	 */
	public abstract Response update(T model);

	/**
	 * @method insert
	 * @param model
	 *            {T} 提供插入的数据,封装在实体类对象
	 * @return {Response}
	 * @description 插入记录
	 */
	public abstract Response insert(T model);

	/**
	 * @method delete
	 * @param id
	 *            {Serializable} 确定记录的唯一标示，供数据库查询
	 * @return {Response}
	 * @description 删除记录
	 */
	public abstract Response delete(Serializable id);

	/**
	 * @method deleteList
	 * @param ids
	 *            {String} 确定记录的唯一标识组，供数据库查询
	 * @return {Response}
	 * @description 批量删除
	 */
	public abstract Response deleteList(String ids);

	/**
	 * @method getCount
	 * @param pp
	 *            {PageProperty} 封装分页条件信息的类对象,供数据库查询
	 * @return {Response}
	 * @description 获取记录条数
	 */
	public abstract Response getCount(PageProperty pp);

	/**
	 * @method getPageList
	 * @param pp
	 *            {PageProperty} 封装分页条件信息的类对象,供数据库查询
	 * @return {Response}
	 * @description 获取对应记录列表
	 */
	public abstract Response getPageList(PageProperty pp);
}
