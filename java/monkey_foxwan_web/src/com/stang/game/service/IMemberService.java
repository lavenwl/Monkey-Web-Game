package com.stang.game.service;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.MemberDetail;

public interface IMemberService extends IBaseService<MemberDetail>{

	public List<MemberDetail> findMemberByOpenid(String openid);
	public List<MemberDetail> findMemberByParam(Map<String,Object> param);
	public List<MemberDetail> findMemberByid(int id);
}
