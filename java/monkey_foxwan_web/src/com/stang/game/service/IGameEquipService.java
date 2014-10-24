package com.stang.game.service;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.GameEquipDetail;

public interface IGameEquipService extends IBaseService<GameEquipDetail> {
	public List<GameEquipDetail> getGameEquip();

	public List<GameEquipDetail> getGameEquipById(int id);
	
	public List<GameEquipDetail> getGameEquipByEid(int eid);
	
	
	
	
	
	
	
	
	public boolean insertGameequip(GameEquipDetail model);
	public boolean updateGameequip(Map<String, Object> param);
	public List<GameEquipDetail> findAllEquip(Map<String,Object> param);
	public List<GameEquipDetail> findGameEquipByid(int id);

}
