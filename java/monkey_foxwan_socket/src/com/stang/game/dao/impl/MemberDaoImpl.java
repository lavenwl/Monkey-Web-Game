package com.stang.game.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.stang.game.common.GameConstants;
import com.stang.game.dao.IMemberDao;
import com.stang.game.entity.detail.GameMapDetail;
import com.stang.game.entity.detail.GameRoleDetail;
import com.stang.game.entity.detail.MemberDetail;

public class MemberDaoImpl extends EntityDao<MemberDetail> implements IMemberDao{

	@Override
	public List<MemberDetail> findMemberByOpenid(String openid) {
		List<MemberDetail> list = null;
		try {
			list = sqlMapper.queryForList("findMemberByOpenid", openid);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	@Override
	public List<MemberDetail> findMemberByid(int id) {
		List<MemberDetail> list = null;
		try {
			list = sqlMapper.queryForList("findMemberByid", id);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}
	
	@Override
	public boolean insertMember(MemberDetail model) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.insert("insertMember", model);
			sqlMapper.commitTransaction();
			isSuccess = true;
		} catch (Exception e) {
			GameConstants.log.warn("", e);
		} finally {
			try {
				sqlMapper.endTransaction();
			} catch (SQLException e) {
				GameConstants.log.warn("", e);
			}
		}
		return isSuccess;
	}

	@Override
	public boolean updateMember(MemberDetail model) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.update("updateMember", model);
			sqlMapper.commitTransaction();
			isSuccess = true;
		} catch (Exception e) {
			GameConstants.log.warn("", e);
		} finally {
			try {
				sqlMapper.endTransaction();
			} catch (SQLException e) {
				GameConstants.log.warn("", e);
			}
		}
		return isSuccess;
	}
	
	@Override
	public List<MemberDetail> findAllMember() {
		List<MemberDetail> list = null;
		try {
			list = sqlMapper.queryForList("findAllMember");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

}
