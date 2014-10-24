package com.stang.game.ffd.dao.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.stang.game.ffd.dao.IGMRejectLoginIdsDao;
import com.stang.game.ffd.entity.detail.GMRejectLoginIdsDetail;


public class GMRejectLoginIdsDaoImpl extends EntityDao<GMRejectLoginIdsDetail>
		implements IGMRejectLoginIdsDao {

	public void deleteGMRejectLoginIdsDetailById(Integer roleId) {
		try {
			sqlMapper.startTransaction();
			sqlMapper.delete("deleteGMRejectLoginIdsDetailById", roleId);
			sqlMapper.commitTransaction();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				sqlMapper.endTransaction();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

	public List<GMRejectLoginIdsDetail> getGMRejectLoginIdsDetailByParam(
			Map<String, Object> param) {
		List<GMRejectLoginIdsDetail> list = null;
		try {
			list = sqlMapper.queryForList("getGMRejectLoginIdsDetailByParam", param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public void insertGMRejectLoginIdsDetail(GMRejectLoginIdsDetail gmr) {
		try {
			sqlMapper.startTransaction();
			sqlMapper.insert("insertGMRejectLoginIdsDetail", gmr);
			sqlMapper.commitTransaction();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				sqlMapper.endTransaction();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void updateGMRejectLoginIdsDetail(GMRejectLoginIdsDetail gmr) {
		try {
			sqlMapper.startTransaction();
			sqlMapper.delete("updateGMRejectLoginIdsDetail", gmr);
			sqlMapper.commitTransaction();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				sqlMapper.endTransaction();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}


	public List<GMRejectLoginIdsDetail> getGMRejectLoginIdsDetailByRoleNames(
			String[] names) {
		List<GMRejectLoginIdsDetail> list = null;
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("names", names);
		try {
			list = sqlMapper.queryForList("getGMRejectLoginIdsDetailByRoleNames", param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public void insertGMRejectLoginIdsDetails(
			List<GMRejectLoginIdsDetail> igmrlidList) {
		try {
			sqlMapper.startTransaction();
			sqlMapper.startBatch();
			for (int i = 0; i < igmrlidList.size(); i++) {
				sqlMapper.insert("insertGMRejectLoginIdsDetail", igmrlidList.get(i));
			}
			sqlMapper.executeBatch();
			sqlMapper.commitTransaction();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				sqlMapper.endTransaction();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void updateGMRejectLoginIdsDetails(
			List<GMRejectLoginIdsDetail> igmrlidList) {
		try {
			sqlMapper.startTransaction();
			sqlMapper.startBatch();
			for (int i = 0; i < igmrlidList.size(); i++) {
				sqlMapper.update("updateGMRejectLoginIdsDetail", igmrlidList.get(i));
			}
			sqlMapper.executeBatch();
			sqlMapper.commitTransaction();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				sqlMapper.endTransaction();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	public List<GMRejectLoginIdsDetail> getGMRejectLoginIdsDetailByTimeAndRoleId(
			int roleId) {
			List<GMRejectLoginIdsDetail> list = null;
			Map<String,Object> param = new HashMap<String, Object>();
			param.put("roleId", roleId);
			try {
				list = sqlMapper.queryForList("getGMRejectLoginIdsDetailByTimeAndRoleId", param);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
	}

	public int getGMRejectLoginIdsDetailCount() {
		List<Integer> list = null;
		try {
			list = sqlMapper.queryForList("getGMRejectLoginIdsDetailCount");
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (list.size() > 0) {
			return list.get(0);
		} else {
			return 0;
		}
	}

	public List<GMRejectLoginIdsDetail> findGMRejectLoginIdsDetailByTime(
			Map<String, Object> param) {
		List<GMRejectLoginIdsDetail> list = null;
		try {
			list = sqlMapper.queryForList("findGMRejectLoginIdsDetailByTime", param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
