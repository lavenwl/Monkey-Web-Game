package com.stang.game.service;

import java.util.List;

import com.stang.game.entity.detail.GameVipDetail;

public interface IGameVipService extends IBaseService<GameVipDetail> {
	public List<GameVipDetail> allGameVips();

	public List<GameVipDetail> getGameVipByLe(int level);
	
	public List<GameVipDetail> getGameVipByAllvipRmb(int vipRmb);
}
