package com.stang.game.dao;

import java.util.List;

import com.stang.game.entity.detail.GameRoleDetail;
import com.stang.game.entity.detail.GameVipDetail;

public interface IGameVipDao extends IEntityDao<GameVipDetail> {
	public List<GameVipDetail> allGameVips();

	public List<GameVipDetail> getGameVipByLe(int level);
	
	public List<GameVipDetail> getGameVipByAllvipRmb(int vipRmb);
}
