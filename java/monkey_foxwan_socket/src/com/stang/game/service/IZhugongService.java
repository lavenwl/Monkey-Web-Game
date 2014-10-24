package com.stang.game.service;

import java.util.List;

import com.stang.game.entity.detail.ZhugongDetail;


public interface IZhugongService extends IBaseService<ZhugongDetail>{
	public List<ZhugongDetail> getallzhugong();
}
