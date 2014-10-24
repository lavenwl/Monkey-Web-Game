package com.stang.game.service.impl;

import java.util.List;
import java.util.Map;

import com.stang.game.dao.IMemberDao;
import com.stang.game.dao.impl.MemberDaoImpl;
import com.stang.game.entity.detail.MemberDetail;
import com.stang.game.service.IMemberService;

public class MemberServiceImpl extends BaseServiceImpl<MemberDetail> implements IMemberService{

	protected IMemberDao getBaseDao() {
		if (baseDao == null) {
			baseDao = new MemberDaoImpl();
		}
		return (IMemberDao) baseDao;
	}
	
	public List<MemberDetail> findMemberByOpenid(String openid) {
		return getBaseDao().findMemberByOpenid(openid);
	}

	public List<MemberDetail> findMemberByid(int id) {
		return getBaseDao().findMemberByid(id);
	}

	public List<MemberDetail> findMemberByParam(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return getBaseDao().findMemberByParam(param);
	}

}
