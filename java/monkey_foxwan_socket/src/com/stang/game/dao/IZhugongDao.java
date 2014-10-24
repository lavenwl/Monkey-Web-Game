package com.stang.game.dao;

import java.util.List;

import com.stang.game.entity.detail.ZhugongDetail;


public interface IZhugongDao extends IEntityDao<ZhugongDetail>{
	public List<ZhugongDetail> getallzhugong();
}
