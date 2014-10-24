package com.stang.game.dao;

import java.util.List;

import com.stang.game.entity.detail.SendgiftlogDetail;

public interface SendgiftlogDao extends IEntityDao<SendgiftlogDetail>{
	public boolean insertsendgift(SendgiftlogDetail model);
	
	public List<SendgiftlogDetail> getAllsfg();
}
