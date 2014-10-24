package com.stang.game.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.stang.game.common.GameConstants;
import com.stang.game.dao.IChallengeRecordDao;
import com.stang.game.entity.detail.ChallengeRecordDetail;

public class ChallengeRecordDaoImpl extends EntityDao<ChallengeRecordDetail> 
implements IChallengeRecordDao{

	@Override
	public List<ChallengeRecordDetail> findBychallengetime(
			Map<String, Object> param) {
		List<ChallengeRecordDetail> list=null;
		try {
			list = sqlMapper.queryForList("findBychallengetime", param);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	
	}

	@Override
	public boolean insertChallengerecord(Map<String, Object> param) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.insert("insertChallengerecord",param);
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
	public List<ChallengeRecordDetail> findallchallenge(
			Map<String, Object> param) {
		List<ChallengeRecordDetail> list=null;
		try {
			list = sqlMapper.queryForList("findallchallenge", param);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	
	}

	@Override
	public boolean updateChallenge(Map<String, Object> param) {
		boolean flag = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.update("updateChallenge", param);
			sqlMapper.commitTransaction();
			flag=true;
		} catch (Exception e) {
			GameConstants.log.warn("", e);
		} finally {
			try {
				sqlMapper.endTransaction();
			} catch (SQLException e) {
				GameConstants.log.warn("", e);
			}
		}
		return flag;
	}

	@Override
	public List<ChallengeRecordDetail> findallchallengetwo(
			Map<String, Object> param) {
		List<ChallengeRecordDetail> list=null;
		try {
			list = sqlMapper.queryForList("findallchallengetwo", param);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	
	}

	@Override
	public boolean insertChallengeRecords(
			List<ChallengeRecordDetail> challengerecords) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.insert("insertChallengerecords",challengerecords);
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
	public List<ChallengeRecordDetail> findallchallengeId(
			Map<String, Object> param) {
		List<ChallengeRecordDetail> list=null;
		try {
			list = sqlMapper.queryForList("findallchallengeId", param);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	
	}

	@Override
	public List<ChallengeRecordDetail> findAllChallengeRecord() {
		List<ChallengeRecordDetail> list=null;
		try {
			list = sqlMapper.queryForList("findAllChallengeRecord");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	
	}

	@Override
	public boolean insertChallengeRecord(ChallengeRecordDetail challengeRecordDetail) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.insert("insertChallengerecordtwo",challengeRecordDetail);
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
	public boolean updateChallengeRecord(ChallengeRecordDetail challengeRecordDetail) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.insert("updateChallengetwo",challengeRecordDetail);
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
