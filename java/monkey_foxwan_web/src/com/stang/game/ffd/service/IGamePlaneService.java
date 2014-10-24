package com.stang.game.ffd.service;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.entity.detail.EntityGamePlaneDetail;

public interface IGamePlaneService extends IBaseService<EntityGamePlaneDetail> {

	public List<EntityGamePlaneDetail> getAllInfo(Map<String, Object> parm);

	public String getPlaneNameById(Map<String, Object> param);
}
