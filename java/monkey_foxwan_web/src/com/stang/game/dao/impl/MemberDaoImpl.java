package com.stang.game.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.stang.game.common.GameConstants;
import com.stang.game.dao.IMemberDao;
import com.stang.game.entity.detail.GameMapDetail;
import com.stang.game.entity.detail.MemberDetail;

public class MemberDaoImpl extends EntityDao<MemberDetail> implements IMemberDao{

	public List<MemberDetail> findMemberByOpenid(String openid) {
		List<MemberDetail> list = null;
		try {
			list = sqlMapper.queryForList("findMemberByOpenid", openid);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	public List<MemberDetail> findMemberByid(int id) {
		List<MemberDetail> list = null;
		try {
			list = sqlMapper.queryForList("findMemberByid", id);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	public List<MemberDetail> findMemberByParam(Map<String, Object> param) {
		List<MemberDetail> list = null;
		try {
			list = sqlMapper.queryForList("findMemberByParam", param);
			System.out.println(param+"=========param=======");
			System.out.println(list.get(0)+"===========list.get(0)==========");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

}
