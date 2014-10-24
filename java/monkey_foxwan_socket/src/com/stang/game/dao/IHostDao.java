package com.stang.game.dao;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.HostDetail;
import com.stang.game.entity.detail.RoleChallengeDetail;

public interface IHostDao extends IEntityDao<HostDetail>{

	public List<HostDetail> findHostByParam(Map<String,Object> param);
	public List<HostDetail> findHostById(int id);
	public List<HostDetail> findAllHost();
}
