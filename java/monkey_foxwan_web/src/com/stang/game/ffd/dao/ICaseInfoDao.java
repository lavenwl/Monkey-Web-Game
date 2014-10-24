package com.stang.game.ffd.dao;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.entity.detail.EntityCaseInfoDetail;

public interface ICaseInfoDao extends IEntityDao<EntityCaseInfoDetail> {
	public void addCaseInfo(Map<String,Object> param);
	public List<EntityCaseInfoDetail> findAll(Map<String,Object> param);
	public List<EntityCaseInfoDetail> findAllForTime(Map<String,Object> param);
	public void updateCaseInfo(Map<String,Object> param);
	public int searchCount(Map<String,Object> param);
}
