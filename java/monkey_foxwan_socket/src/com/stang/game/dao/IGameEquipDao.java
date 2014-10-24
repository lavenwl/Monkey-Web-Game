package com.stang.game.dao;

import java.util.List;

import com.stang.game.entity.detail.GameEquipDetail;

public interface IGameEquipDao extends IEntityDao<GameEquipDetail> {
	public List<GameEquipDetail> getGameEquip();

	public List<GameEquipDetail> getGameEquipById(int id);
	
	public List<GameEquipDetail> getGameEquipByEid(int eid);
}
