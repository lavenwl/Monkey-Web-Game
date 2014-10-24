package com.stang.game.ffd.service;

import com.stang.game.ffd.entity.detail.AutoIdDetail;

public interface IAutoIdService extends IBaseService<AutoIdDetail> {

	/**
	 * @method findKeyValueByTableName 
	 * @param tableName {String} 表名
	 * @return {Integer}
	 * @description 根据表名查询该表当前的主键值
	 */
	public Integer fingKeyValueByTableName(String tableName);
	
	/**
	 * @method updateKeyValueByTableName
	 * @param tableName {String} 表名
	 * @param keyValue {int} 主键值
	 * @return {boolean}
	 * @description 根据表名更新主键值
	 */
//	public boolean updateKeyValueByTableName(String tableName,int keyValue);
	
	/**
	 * @method updateKeyValueAddOneByTableName
	 * @param tableName {String} 表名
	 * @return {int}
	 * @description 根据表名更新主键值(自动加1) 
	 */
	public int updateKeyValueAddOneByTableName(String tableName);
	
	/**
	 * @method updateAutoIdDetail 
	 * @param model {AutoIdDetail}
	 * @return {boolean}
	 * @description 更新自动增长主键信息
	 */
//	public boolean updateAutoIdDetail(AutoIdDetail model);
}
