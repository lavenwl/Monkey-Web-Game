package com.stang.game.ffd.dao;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.dao.IEntityDao;
import com.stang.game.ffd.entity.detail.RoleSiteInfoDetail;

public interface IRoleSiteInfoDao extends IEntityDao<RoleSiteInfoDetail> {

	public int deleteRoleSiteInfoDetail(int id);

	public List<RoleSiteInfoDetail> getRoleSiteInfoDetail(Map<String, Object> map);

	public 	int insertRoleSiteInfo(int id);

	public int updateRoleSiteInfoDetail(RoleSiteInfoDetail mm);

	public int insertRoleSiteInfoDetail(RoleSiteInfoDetail rsid);

	public void deleteRoleSiteInfo();

}
