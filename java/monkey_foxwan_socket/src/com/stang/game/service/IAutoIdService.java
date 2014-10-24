package com.stang.game.service;

import java.util.List;

import com.stang.game.entity.detail.AutoIdDetail;

public interface IAutoIdService extends IBaseService<AutoIdDetail> {
	public List<AutoIdDetail> findAllAutoId();
	/**
	 * @method findKeyValueByTableName
	 * @param tableName
	 *            {String} 表名
	 * @return {Integer}
	 * @description 根据表名查询该表当前的主键值
	 */
	public Integer fingKeyValueByTableName(String tableName);
	public int updateAutoIdGamechart(int id);
	public int updateByTableName(String tableName);

	/**
	 * @method updateKeyValueByTableName
	 * @param tableName
	 *            {String} 表名
	 * @param keyValue
	 *            {int} 主键值
	 * @return {boolean}
	 * @description 根据表名更新主键值
	 */
	public boolean updateKeyValueByTableName(String tableName, int keyValue);

	/**
	 * @method updateKeyValueAddOneByTableName
	 * @param tableName
	 *            {String} 表名
	 * @return {int}
	 * @description 根据表名更新主键值(自动加1)
	 */
	public int updateKeyValueAddOneByTableName(String tableName);

	/**
	 * @method updateAutoIdDetail
	 * @param model
	 *            {AutoIdDetail}
	 * @return {boolean}
	 * @description 更新自动增长主键信息
	 */
	public boolean updateAutoIdDetail(AutoIdDetail model);
}
