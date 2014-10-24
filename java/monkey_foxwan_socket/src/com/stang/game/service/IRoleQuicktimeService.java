package com.stang.game.service;

import java.util.List;
import java.util.Map;


import com.stang.game.entity.detail.RoleQuicktimeDetail;

public interface IRoleQuicktimeService extends IBaseService<RoleQuicktimeDetail>{
	public List<RoleQuicktimeDetail> findAllRolequicktime();
	public boolean updateQuicktime(Map<String, Object> param);
	public List<RoleQuicktimeDetail> getQuicktime(Map<String, Object> param);
	public boolean insertRolequicktime(RoleQuicktimeDetail detail);
	public void updateQuicktime(RoleQuicktimeDetail roleQuicktimeDetail);
}
