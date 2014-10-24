package com.stang.game.service;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.GameEPropertyDetail;
public interface IGameEPropertyService extends IBaseService<GameEPropertyDetail> {
	
	public List<GameEPropertyDetail> getGameEProperty();
	
	public List<GameEPropertyDetail> getGameEPropertyById(int id);
	
	//根据type和quality品质得到强化会得到的血量，速度等
	public List<GameEPropertyDetail> getGameEPropertyBytypequality(Map<String, Object> param);
	

}
