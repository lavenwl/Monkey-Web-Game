package com.stang.game.service;

import java.util.List;

import com.stang.game.entity.detail.GameAvatarDetail;

/**
 * @author jianbo.feng
 * @company 上海三唐信息科技有限公司
 * @description 游戏装饰信息逻辑处理接口
 */
public interface IGameAvatarService extends IBaseService<GameAvatarDetail> {
	public List<GameAvatarDetail> findAllGameAvatar();
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

	public GameAvatarDetail getGameAvatarDetail(int id);

}
