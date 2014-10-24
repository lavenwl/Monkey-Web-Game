package com.stang.game.ffd.service;

import java.util.List;

import com.stang.game.ffd.entity.detail.EntityCheckNoviceDetail;

public interface ICheckNoviceService extends IBaseService<EntityCheckNoviceDetail>{
	public List<EntityCheckNoviceDetail> searchNovice();
}
