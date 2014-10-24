package com.stang.game.service;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.EntityRightUserDetail;

public interface IRightUserService extends IBaseService<EntityRightUserDetail> {
	public List<EntityRightUserDetail> findRightUserByMap(Map<String,Object> param);
	public int updateRightUserDetail(EntityRightUserDetail entity);
	public int insertRightUserDetail(EntityRightUserDetail entity);
	public EntityRightUserDetail findPasswordByRoleName(String uname);
	public int deleteRightUserDetail(int uId);
}
