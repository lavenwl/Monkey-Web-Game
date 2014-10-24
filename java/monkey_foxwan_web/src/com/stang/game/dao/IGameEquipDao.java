package com.stang.game.dao;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.GameEquipDetail;

public interface IGameEquipDao extends IEntityDao<GameEquipDetail> {
	public List<GameEquipDetail> getGameEquip();

	public List<GameEquipDetail> getGameEquipById(int id);
	
	public List<GameEquipDetail> getGameEquipByEid(int eid);
	
	
	
	
	
	
	public boolean insertGameequip(GameEquipDetail model);
	public boolean updateGameequip(Map<String, Object> param);
	public List<GameEquipDetail> findAllEquip(Map<String,Object> param);
	public List<GameEquipDetail> findGameEquipByid(int id);
}
