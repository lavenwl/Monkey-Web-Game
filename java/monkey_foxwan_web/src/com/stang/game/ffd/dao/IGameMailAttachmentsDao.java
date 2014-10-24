package com.stang.game.ffd.dao;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.entity.detail.GameMailAttachmentsDetail;

public interface IGameMailAttachmentsDao extends IEntityDao<GameMailAttachmentsDetail> {

	/**
	 * @method updateGameMailAttIsOpen
	 * @param id {Integer} (游戏)邮件附件序号 
	 * @return {boolean}
	 * @description 打开(游戏邮件)附件
	 */
	public boolean updateGameMailAttIsOpen(Integer id);
	
	/**
	 * @method deleteGameMailAttById
	 * @param id {Integer} 游戏邮件附件序号
	 * @return {boolean} 
	 * @description 根据邮件附件序号删除邮件附件
	 */
	public boolean deleteGameMailAttById(Integer id);
	
	/**
	 * @method deleteGameMailAttsByMailId
	 * @param mailId {Integer} 邮件序号
	 * @return {boolean}
	 * @description 根据邮件序号删除邮件附件 
	 */
	public boolean deleteGameMailAttsByMailId(Integer mailId);
	
	/**
	 * @method batchDeleteGameMailAtts
	 * @param ids {List<Integer>} 游戏邮件附件序号组
	 * @return {boolean} 
	 * @description (根据邮件附件序号组)批量删除邮件附件
	 */
	public boolean batchDeleteGameMailAtts(List<Integer> ids);
	
	/**
	 * @method batchDeleteGameMailAttsByMailIds
	 * @param ids {List<Integer>} 游戏邮件序号组
	 * @return {boolean} 
	 * @description 根据邮件序号组批量删除邮件附件
	 */
	public boolean batchDeleteGameMailAttsByMailIds(List<Integer> ids);
	
	/**
	 * @method getGameMailAttachmentsDetail
	 * @param id {Integer} 游戏邮件附件序号
	 * @return {GameMailAttachmentsDetail} 
	 * @description 根据附件序号获取附件信息
	 */
	public GameMailAttachmentsDetail getGameMailAttachmentsDetailById(Integer id);
	
	/**
	 * @method findGameMailAttachmentsDetailByParam
	 * @param param {Map<String,Object>} 参数信息
	 * @return {List<GameMailAttachmentsDetail>} 
	 * @description 根据参数信息获取游戏邮件信息列表
	 */
	public List<GameMailAttachmentsDetail> findGameMailAttachmentsDetailByParam(Map<String,Object> param);

	/**
	 * @method getGameMailAttsByMailIds
	 * @param ids {List<Integer>} 邮件序号组
	 * @return {List<GameMailAttachmentsDetail>} 
	 * @description 根据邮件序号组获取邮件附件信息列表
	 */
	public List<GameMailAttachmentsDetail> getGameMailAttsByMailIds(List<Integer> ids);
	
	/**
	 * 
	 * @param param
	 * @return
	 * @description 全参数查询
	 */
	public List<GameMailAttachmentsDetail> getGameMailAttachmentsByParam(Map<String, Object> param);
} 
