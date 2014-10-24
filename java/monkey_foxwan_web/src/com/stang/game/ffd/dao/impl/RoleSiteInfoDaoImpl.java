package com.stang.game.ffd.dao.impl;



import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.stang.game.ffd.dao.IRoleSiteInfoDao;
import com.stang.game.ffd.dao.impl.EntityDao;
import com.stang.game.ffd.entity.detail.RoleSiteInfoDetail;

public class RoleSiteInfoDaoImpl extends EntityDao<RoleSiteInfoDetail>
		implements IRoleSiteInfoDao {

	public int deleteRoleSiteInfoDetail(int id) {
		int flag=0;
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("role_id", id);
		try {
			sqlMapper.startTransaction();
			sqlMapper.delete("deleteRoleSiteInfoDetail",map);
			sqlMapper.commitTransaction();
			flag=1;
		} catch (Exception e) {
			try {
				sqlMapper.endTransaction();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			try {
				sqlMapper.endTransaction();
			} catch (SQLException e) {
				//GameConstants.log.warn("", e);
			}
		}
		return flag;
	}
	

	public List<RoleSiteInfoDetail> getRoleSiteInfoDetail(
			Map<String, Object> map) {
		List<RoleSiteInfoDetail> list = null;
		try {
			sqlMapperFlight.startTransaction();
			list = sqlMapperFlight.queryForList("getRoleSiteInfoDetail",map);
			sqlMapperFlight.commitTransaction();
			
		} catch (Exception e) {
			try {
				sqlMapperFlight.endTransaction();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				sqlMapperFlight.endTransaction();
			} catch (SQLException e) {
				//GameConstants.log.warn("", e);
			}
		}
		return list;
	}
	public int insertRoleSiteInfo(int id) {
		int flag=0;
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("role_id", id);
		try {
			sqlMapper.startTransaction();
			sqlMapper.insert("insertRoleSiteInfo",map);
			sqlMapper.commitTransaction();
			flag=1;
		} catch (Exception e) {
			try {
				sqlMapper.endTransaction();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			try {
				sqlMapper.endTransaction();
			} catch (SQLException e) {
				//GameConstants.log.warn("", e);
			}
		}
		return flag;
	}

	public int updateRoleSiteInfoDetail(RoleSiteInfoDetail mm) {
		int num=0;
		try {
			sqlMapper.startTransaction();
			num=sqlMapper.update("updateRoleSiteInfoDetail",mm);
			sqlMapper.commitTransaction();
			
		} catch (Exception e) {
			try {
				sqlMapper.endTransaction();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			try {
				sqlMapper.endTransaction();
			} catch (SQLException e) {
				//GameConstants.log.warn("", e);
			}
		}
		return num;
	}


	public int insertRoleSiteInfoDetail(RoleSiteInfoDetail rsid) {
		int flag=0;

		try {
			sqlMapper.startTransaction();
			sqlMapper.insert("insertRoleSiteInfoDetail",rsid);
			sqlMapper.commitTransaction();
			flag=1;
		} catch (Exception e) {
			try {
				sqlMapper.endTransaction();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			try {
				sqlMapper.endTransaction();
			} catch (SQLException e) {
				//GameConstants.log.warn("", e);
			}
		}
		return flag;
	}
	public void deleteRoleSiteInfo() {
		try {
			sqlMapper.startTransaction();
			sqlMapper.delete("deleteRoleSiteInfoDetailAll");
			sqlMapper.commitTransaction();
		} catch (Exception e) {
			try {
				sqlMapper.endTransaction();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			try {
				sqlMapper.endTransaction();
			} catch (SQLException e) {
				//GameConstants.log.warn("", e);
			}
		}
	}




}
