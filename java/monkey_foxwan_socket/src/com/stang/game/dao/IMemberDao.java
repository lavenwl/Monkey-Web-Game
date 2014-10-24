package com.stang.game.dao;

import java.util.List;

import com.stang.game.entity.detail.GameMapDetail;
import com.stang.game.entity.detail.GameRoleDetail;
import com.stang.game.entity.detail.MemberDetail;

public interface IMemberDao extends IEntityDao<MemberDetail>{

	public List<MemberDetail> findMemberByOpenid(String openid);
	
	public List<MemberDetail> findAllMember();
	public List<MemberDetail> findMemberByid(int id);
	public boolean updateMember(MemberDetail model);
	public boolean insertMember(MemberDetail model);
}
