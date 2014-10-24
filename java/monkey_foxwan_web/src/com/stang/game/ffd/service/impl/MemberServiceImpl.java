package com.stang.game.ffd.service.impl;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.dao.IMemberDao;
import com.stang.game.ffd.dao.impl.MemberDaoImpl;
import com.stang.game.ffd.entity.detail.MemberDetail;
import com.stang.game.ffd.service.IMemberService;

/**
 * @author jianbo.feng 
 * @company 上海三唐信息科技有限公司
 * @description 会员信息逻辑处理
 */
public class MemberServiceImpl extends BaseServiceImpl<MemberDetail> implements IMemberService {

	protected IMemberDao getBaseDao() {
		if(baseDao == null) {
			baseDao = new MemberDaoImpl();
		}
		return (IMemberDao)baseDao;
	}

	public List<MemberDetail> findMembersByIds(List<Integer> ids) {
		// TODO Auto-generated method stub
		return getBaseDao().findMembersByIds(ids);
	}

	public int updateMemberById(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return getBaseDao().updateMemberById(param);
	}
	
	
}
