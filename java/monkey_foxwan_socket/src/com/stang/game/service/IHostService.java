package com.stang.game.service;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.HostDetail;

public interface IHostService extends IBaseService<HostDetail>{

	public List<HostDetail> findHostByParam(Map<String,Object> param);
	public List<HostDetail> findHostById(int id);
	public List<HostDetail> findAllHost();
}
