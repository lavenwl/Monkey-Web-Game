package com.stang.game.dao;

import java.util.List;

import com.stang.game.entity.detail.GameEInsDetail;
public interface IGameEInsDao extends IEntityDao<GameEInsDetail> {
	
	  public List<GameEInsDetail> getGameEIns();
		
		public List<GameEInsDetail> getGameEInsById(int id);

}
