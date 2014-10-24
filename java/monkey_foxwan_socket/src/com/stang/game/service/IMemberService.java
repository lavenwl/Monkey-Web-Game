package com.stang.game.service;

import java.util.List;

import com.stang.game.entity.detail.GameRoleDetail;
import com.stang.game.entity.detail.MemberDetail;

public interface IMemberService extends IBaseService<MemberDetail>{
	public List<MemberDetail> findAllMember();
	public List<MemberDetail> findMemberByOpenid(String openid);
	
	public List<MemberDetail> findMemberByid(int id);
	
	public boolean insertMember(MemberDetail model);
}
