package com.stang.game.dao;

import java.util.List;

import com.stang.game.entity.detail.GameAvatarDetail;

public interface IGameAvatarDao extends IEntityDao<GameAvatarDetail> {

	/**
	 * @method allGameAvatars
	 * @return {List<GameAvatarDetail>}
	 * @description 获得所有(游戏)装饰信息
	 */
	public List<GameAvatarDetail> allGameAvatars();

	/**
	 * @method findGameAvatarsByIds
	 * @param ids
	 *            {List<Integer>}
	 * @return {List<GameAvatarDetail>}
	 * @description 根据序列组获得游戏装饰信息
	 */
	public List<GameAvatarDetail> findGameAvatarsByIds(List<Integer> ids);

	/**
	 * 
	 * @param id
	 * @return
	 * @description 根据id获得avatar信息
	 */
	public GameAvatarDetail getGameAvatarDetail(int id);

}
