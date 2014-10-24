package com.stang.game.service;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.RoleMilitaryDetail;

public interface IRoleMilitaryService extends IBaseService<RoleMilitaryDetail> {
	public boolean insertRoleMilitary(Map<String, Object> param);

	public boolean updateRoleMilitary(Map<String, Object> param);

	public List<RoleMilitaryDetail> getRoleMilitary(int roleId);

	public List<RoleMilitaryDetail> getRoleMilitarylevel(int id);
	
	public List<RoleMilitaryDetail> getRoleMilitaryByparam(Map<String, Object> param);

	public List<RoleMilitaryDetail> getRoleMilitarytime(int id,int roleid);
	
	public boolean addMilitayExp(Map<String, Object> param);
	
	public boolean  updateRoleMilitarytime(Map<String, Object> param);//更新
	
	public List<RoleMilitaryDetail> getRoleMilitaryBynotType(Map<String, Object> param);//不在队列里
	
	public boolean deleteRoleMilitary(Map<String, Object> param);//解雇武将，删除
	
	public List<RoleMilitaryDetail> getRoleMilitaryByLevel(Map<String, Object> param);
}
