package com.stang.game.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.stang.game.common.GameConstants;
import com.stang.game.dao.IRoleChallengeDao;
import com.stang.game.entity.detail.RoleChallengeDetail;
import com.stang.game.entity.detail.RoleEquipDetail;

public class RoleChallengeDaoImpl extends EntityDao<RoleChallengeDetail> implements IRoleChallengeDao{
	
	@Override
	public boolean insertRoleChallenge(Map<String, Object> param) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.insert("insertRoleChallenge",param);
			sqlMapper.commitTransaction();
			isSuccess = true;
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}finally{
			try {
				sqlMapper.endTransaction();
			} catch (SQLException e) {
				GameConstants.log.warn("", e);
			}
		}
		return isSuccess;
	}

	@Override
	public boolean updateRoleChallenge(Map<String, Object> param) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.update("updateRoleChallenge", param);
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
	public List<RoleChallengeDetail> findRoleChallengeById(
			Map<String, Object> param) {
		List<RoleChallengeDetail> list = null;
		try {
			list = sqlMapper.queryForList("findRoleChallengeById", param);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	@Override
	public List<RoleChallengeDetail> findRoleChallengeById2(
			Map<String, Object> param) {
		List<RoleChallengeDetail> list = null;
		try {
			list = sqlMapper.queryForList("findRoleChallengeById2", param);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	@Override
	public List<RoleChallengeDetail> findAllRoleChallenge() {
		List<RoleChallengeDetail> list = null;
		try {
			list = sqlMapper.queryForList("findAllRoleChallenge");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}
	@Override
	public boolean insertRoleChallenge(RoleChallengeDetail roleChallengeDetail) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.insert("insertRoleChallengetwo",roleChallengeDetail);
			sqlMapper.commitTransaction();
			isSuccess = true;
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}finally{
			try {
				sqlMapper.endTransaction();
			} catch (SQLException e) {
				GameConstants.log.warn("", e);
			}
		}
		return isSuccess;
	}

	@Override
	public boolean updateRoleChallenge(RoleChallengeDetail model) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.insert("updateRoleChallengetwo", model);
			sqlMapper.commitTransaction();
			isSuccess = true;
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}finally{
			try {
				sqlMapper.endTransaction();
			} catch (SQLException e) {
				GameConstants.log.warn("", e);
			}
		}
		return isSuccess;
	}

}
