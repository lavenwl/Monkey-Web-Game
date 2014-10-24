package com.stang.game.ffd.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.stang.game.ffd.common.PageProperty;
import com.stang.game.ffd.dao.IGMRejectIpsDao;
import com.stang.game.ffd.dao.impl.EntityDao;
import com.stang.game.ffd.entity.detail.GMRejectChatIdsDetail;
import com.stang.game.ffd.entity.detail.GMRejectIpsDetail;

public class GMRejectIpsDaoImpl extends EntityDao<GMRejectIpsDetail> implements
		IGMRejectIpsDao {

	public void deleteGMRejectIpsDetail(Map<String, Object> param) {
		try {
			sqlMapper.startTransaction();
			sqlMapper.delete("deleteGMRejectIpsDetail", param);
			sqlMapper.commitTransaction();

		} catch (Exception e) {
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

	public List<GMRejectIpsDetail> findGMRejectIpsDetailByParam(
			Map<String, Object> param) {
		List<GMRejectIpsDetail> list = null;
		try {
			list = sqlMapper
					.queryForList("findGMRejectIpsDetailByParam", param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public void insertGMRejectIpsDetail(GMRejectIpsDetail grid) {
		try {
			sqlMapper.startTransaction();
			sqlMapper.insert("insertGMRejectIpsDetail", grid);
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

	public void updateGMRejectIpsDetail(Map<String, Object> param) {
		try {
			sqlMapper.startTransaction();
			sqlMapper.delete("updateGMRejectIpsDetail", param);
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

	public int getGMRejectIpsCount() {
		List<Integer> list = null;
		try {
			list = sqlMapper.queryForList("getGMRejectIpsCount");
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (list.size() > 0) {
			return list.get(0);
		} else {
			return 0;
		}
	}

	public List<GMRejectIpsDetail> findGMRejectIpsDetailByTime(
			Map<String, Object> param) {
		List<GMRejectIpsDetail> list = null;
		try {
			list = sqlMapper
					.queryForList("findGMRejectIpsDetailByTime", param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
