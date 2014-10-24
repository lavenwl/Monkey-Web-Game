package com.stang.game.service;

import java.util.List;

import com.stang.game.entity.detail.SendgiftlogDetail;

public interface SendgiftlogService extends IBaseService<SendgiftlogDetail>{
	public boolean insertsendgift(SendgiftlogDetail model);
	public List<SendgiftlogDetail> getAllsfg();
	
	
}
