package com.stang.game.dao;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.AutoIdDetail;

public interface IAutoIdDao extends IEntityDao<AutoIdDetail> {
	public List<AutoIdDetail> findAllAutoId();
	public boolean insertAutoId(AutoIdDetail autoIdDetail);
	public boolean updateAutoId(AutoIdDetail autoIdDetail);
	/**
	 * @method findKeyValueByTableName
	 * @param tableName
	 *            {String} 表名
	 * @return {Integer}
	 * @description 根据表名查询该表当前的主键值
	 */
	public Integer fingKeyValueByTableName(String tableName);
	
	public int updateAutoIdGamechart(int id);
	/**
	 * @method updateKeyValueByTableName
	 * @param tableName
	 *            {String} 表名
	 * @param keyValue
	 *            {int} 主键值
	 * @return {int}
	 * @description 根据表名更新主键值
	 */
	public int updateKeyValueByTableName(String tableName, int keyValue);

	/**
	 * @method updateKeyValueAddOneByTableName
	 * @param tableName
	 *            {String} 表名
	 * @return {int}
	 * @description 根据表名更新主键值(自动加1)
	 */
	public int updateKeyValueAddOneByTableName(String tableName);

	public int updateByTableName(String tableName);

	/**
	 * @method getAutoIdDetalByProperty
	 * @param param
	 *            {Map<String,Object>}
	 * @return {AutoIdDetail}
	 * @description 根据属性查询信息
	 */
	public AutoIdDetail getAutoIdDetalByProperty(Map<String, Object> param);
}
