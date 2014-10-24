package com.stang.game.service.impl;

import java.util.List;

import com.stang.game.cache.CacheMember;
import com.stang.game.dao.IMemberDao;
import com.stang.game.dao.impl.MemberDaoImpl;
import com.stang.game.entity.detail.GameRoleDetail;
import com.stang.game.entity.detail.MemberDetail;
import com.stang.game.service.IMemberService;

public class MemberServiceImpl extends BaseServiceImpl<MemberDetail> implements IMemberService{
 CacheMember cm0;
 private CacheMember cm(){
	 if(cm0==null){
		 cm0=new CacheMember();
	 }
	return cm0;
	 
 }
	protected IMemberDao getBaseDao() {
		if (baseDao == null) {
			baseDao = new MemberDaoImpl();
		}
		return (IMemberDao) baseDao;
	}
	
	@Override
	public List<MemberDetail> findMemberByOpenid(String openid) {
		return getBaseDao().findMemberByOpenid(openid);
		//return cm().findMemberByOpenid(openid);
	}

	@Override
	public boolean insertMember(MemberDetail model) {
		return getBaseDao().insertMember(model);
		//return cm().insertMember(model);
	}
	
	@Override
	public List<MemberDetail> findMemberByid(int id) {
		return getBaseDao().findMemberByid(id);
		//return cm().findMemberByid(id);
	}

	@Override
	public List<MemberDetail> findAllMember() {
		// TODO Auto-generated method stub
		return getBaseDao().findAllMember();
	}

}
