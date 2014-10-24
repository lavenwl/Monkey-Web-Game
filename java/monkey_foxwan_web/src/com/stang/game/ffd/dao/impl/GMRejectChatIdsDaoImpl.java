package com.stang.game.ffd.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.stang.game.ffd.dao.IGMRejectChatIdsDao;
import com.stang.game.ffd.entity.detail.GMRejectChatIdsDetail;

public class GMRejectChatIdsDaoImpl extends EntityDao<GMRejectChatIdsDetail>
		implements IGMRejectChatIdsDao {

	public void deleteGMRejectChatIdsDetailById(Integer roleId) {
		try {
			sqlMapper.startTransaction();
			sqlMapper.delete("deleteGMRejectChatIdsDetailById", roleId);
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

	public List<GMRejectChatIdsDetail> getGMRejectChatIdsDetailByParam(
			Map<String, Object> param) {
		List<GMRejectChatIdsDetail> list = null;
		try {
			list = sqlMapper.queryForList("getGMRejectChatIdsDetailByParam",
					param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public void insertGMRejectChatIdsDetail(GMRejectChatIdsDetail gmr) {
		try {
			sqlMapper.startTransaction();
			sqlMapper.insert("insertGMRejectChatIdsDetail", gmr);
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

	public void updateGMRejectChatIdsDetail(GMRejectChatIdsDetail gmr) {
		try {
			sqlMapper.startTransaction();
			sqlMapper.delete("updateGMRejectChatIdsDetail", gmr);
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

	public List<GMRejectChatIdsDetail> getGMRejectChatIdsDetailByTimeAndRoleId(
			int roleId) {
		List<GMRejectChatIdsDetail> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("roleId", roleId);
		try {
			list = sqlMapper.queryForList(
					"getGMRejectChatIdsDetailByTimeAndRoleId", param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<GMRejectChatIdsDetail> getGMRejectChatIdsDetailByRoleNames(
			String[] names) {
		List<GMRejectChatIdsDetail> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("names", names);
		try {
			list = sqlMapper.queryForList(
					"getGMRejectChatIdsDetailByRoleNames", param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public void insertGMRejectChatIdsDetails(
			List<GMRejectChatIdsDetail> igmclidList) {
		try {
			sqlMapper.startTransaction();
			sqlMapper.startBatch();
			for (int i = 0; i < igmclidList.size(); i++) {
				sqlMapper.insert("insertGMRejectChatIdsDetail", igmclidList
						.get(i));
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

	public void updateGMRejectChatIdsDetails(
			List<GMRejectChatIdsDetail> gmrcidList) {
		try {
			sqlMapper.startTransaction();
			sqlMapper.startBatch();
			for (int i = 0; i < gmrcidList.size(); i++) {
				sqlMapper.update("updateGMRejectChatIdsDetail", gmrcidList
						.get(i));
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

	public int getGMRejectChatIdsDetailCount() {
		List<Integer> list = null;
		try {
			list = sqlMapper.queryForList("getGMRejectChatIdsDetailCount");
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (list.size() > 0) {
			return list.get(0);
		} else {
			return 0;
		}
	}

	public List<GMRejectChatIdsDetail> findGMRejectChatIdsByTime(
			Map<String, Object> param) {
		List<GMRejectChatIdsDetail> list = null;
		try {
			list = sqlMapper.queryForList("findGMRejectChatIdsByTime",
					param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
