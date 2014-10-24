package com.stang.game.dao;

import java.util.List;

import com.stang.game.entity.detail.DantiaoDetail;
public interface IDantiaoDao extends IEntityDao<DantiaoDetail>{

	public List<DantiaoDetail> getalldantiao();
	
}
