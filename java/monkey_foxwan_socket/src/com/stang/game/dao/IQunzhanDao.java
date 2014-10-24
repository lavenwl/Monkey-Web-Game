package com.stang.game.dao;

import java.util.List;

import com.stang.game.entity.detail.QunzhanDetail;

public interface IQunzhanDao extends IEntityDao<QunzhanDetail>{
	public List<QunzhanDetail> getallqunzhan();
}
