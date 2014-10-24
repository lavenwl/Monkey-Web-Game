package com.stang.game.service;

import java.util.List;

import com.stang.game.entity.detail.QunzhanDetail;

public interface IQunzhanService extends IBaseService<QunzhanDetail>{
	public List<QunzhanDetail> getallqunzhan();
}
