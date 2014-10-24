package com.stang.game.ffd.dao;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.entity.detail.GameMailDetail;


public interface IGameMailDao extends IEntityDao<GameMailDetail> {

	/**
	 * @method updateGameMailIsOpen
	 * @param id {Integer} 游戏邮件序号
	 * @return {boolean} 
	 * @description (根据邮件序号)打开邮件
	 */
	public boolean updateGameMailIsOpen(Integer id);
	
	/**
	 * @method deleteGameMailById
	 * @param id {Integer} 游戏邮件序号
	 * @return {boolean} 
	 * @description 根据邮件序号删除邮件
	 */
	public boolean deleteGameMailById(Integer id);
	
	/**
	 * @method batchDeleteGameMails
	 * @param ids {List<Integer>} 游戏邮件序号组
	 * @return {boolean} 
	 * @description (根据邮件序号组)批量删除邮件
	 */
	public boolean batchDeleteGameMails(List<Integer> ids);
	
	/**
	 * @method getGameMailDetailById
	 * @param id {Integer} 邮件序号
	 * @return {GameMailDetail} 
	 * @description 根据邮件序号获得邮件信息
	 */
	public GameMailDetail getGameMailDetailById(Integer id);
	
	/**
	 * @method findGameMailDetailByParam
	 * @param param {Map<String,Object>} 
	 * @return {List<GameMailDetail>}
	 * @description 根据参数信息获得(游戏)邮件信息列表
	 */
	public List<GameMailDetail> findGameMailDetailByParam(Map<String,Object> param);
	
	/**
	 * 
	 * @param mId
	 * @return
	 * @description 更新邮件为已付费
	 */
	public int updateGameMailIsGold(Integer mId);
	
	/**
	 * 
	 * @param param
	 * @return
	 * @description 获得段时间的数据（系统用）
	 */
	public List<GameMailDetail> getGameMailsByTime(Map<String, Object> param);
}
