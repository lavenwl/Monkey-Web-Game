package com.stang.game.dao;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.GametotemDetail;

public interface IGametotemDao extends IEntityDao<GametotemDetail> {
	public List<GametotemDetail> getGametotem();
	public List<GametotemDetail> getGametotembyid(int id);
	public List<GametotemDetail> getGametotembyparam(Map<String, Object> param);

}
