package com.stang.game.dao;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.HostStatusDetail;

public interface IHostStatusDao extends IEntityDao<HostStatusDetail>{
public List<HostStatusDetail> getHostStatus();
public boolean updateHostStatus(Map<String, Object> param);
public boolean updatehd(Map<String, Object> param);
}
