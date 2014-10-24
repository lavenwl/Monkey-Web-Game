package com.stang.game.service;

import java.util.List;

import com.stang.game.entity.detail.GameEquipDetail;

public interface IGameEquipService extends IBaseService<GameEquipDetail> {
	public List<GameEquipDetail> getGameEquip();

	public List<GameEquipDetail> getGameEquipById(int id);
	
	public List<GameEquipDetail> getGameEquipByEid(int eid);

}
