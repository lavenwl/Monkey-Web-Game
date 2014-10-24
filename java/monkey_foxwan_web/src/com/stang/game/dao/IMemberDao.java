package com.stang.game.dao;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.GameMapDetail;
import com.stang.game.entity.detail.MemberDetail;

public interface IMemberDao extends IEntityDao<MemberDetail>{

	public List<MemberDetail> findMemberByOpenid(String openid);
	public List<MemberDetail> findMemberByParam(Map<String,Object> param);
	
	public List<MemberDetail> findMemberByid(int id);
}
