package com.stang.game.service;

import java.util.List;

import com.stang.game.entity.detail.DantiaoDetail;

public interface IDantiaoService extends IBaseService<DantiaoDetail>{

	public List<DantiaoDetail> getalldantiao();
}
