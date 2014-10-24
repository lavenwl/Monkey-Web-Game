package com.stang.game.ffd.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.stang.game.ffd.dao.IRolePlaneDao;
import com.stang.game.ffd.entity.detail.RolePlaneDetail;


public class RolePlaneDaoImpl extends EntityDao<RolePlaneDetail> implements
		IRolePlaneDao {

	public List<RolePlaneDetail> findRolePlanesByRoleId(Integer roleId) {
		// TODO Auto-generated method stub
		List<RolePlaneDetail> list = null;

		try {
			Map param = new HashMap();
			param.put("roleId", roleId);
			list = sqlMapperFlight.queryForList("findRolePlanesByRoleId", param);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public int batchDeleteRolePlanes(List<Integer> ids) {
		// TODO Auto-generated method stub
		int dataCode = 0;

		try {
			sqlMapperFlight.startTransaction();
			HashMap param = new HashMap();
			param.put("ids", ids);
			sqlMapperFlight.delete("batchDeleteRolePlanes", param);
			sqlMapperFlight.commitTransaction();
			dataCode = 1;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				sqlMapperFlight.endTransaction();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return dataCode;
	}

	public List<RolePlaneDetail> findRolePlanesByRoleIds(List<Integer> roleIds) {
		// TODO Auto-generated method stub
		List<RolePlaneDetail> list = null;

		try {
			Map param = new HashMap();
			param.put("roleIds", roleIds);
			list = sqlMapperFlight.queryForList("findRolePlanesByRoleIds", param);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<RolePlaneDetail> findUsingRolePlanesByRoleId(Integer roleId) {
		// TODO Auto-generated method stub
		List<RolePlaneDetail> list = null;

		try {
			Map param = new HashMap();
			param.put("roleId", roleId);
			list = sqlMapperFlight.queryForList("findUsingRolePlanesByRoleId", param);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public RolePlaneDetail findRolePlaneByRoleAndPlaneId(Integer roleId,
			Integer planeId) {
		// TODO Auto-generated method stub
		RolePlaneDetail rp = null;

		try {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("roleId", roleId);
			param.put("planeId", planeId);
			List<RolePlaneDetail> list = sqlMapperFlight.queryForList(
					"findRolePlanesByRoleId", param);
			if (!list.isEmpty()) {
				rp = list.get(0);
			}
			list = null;
			param = null;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return rp;
	}

	public List<RolePlaneDetail> getRolePlanes(Map<String, Object> param) {
		List<RolePlaneDetail> list = null;
		try {
			list = sqlMapperFlight.queryForList("getRolePlanes", param);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	public boolean insertRolePlane(RolePlaneDetail rpDetail) {
		boolean bo = false;
		try {
			sqlMapperFlight.startTransaction();
			sqlMapperFlight.insert("insertRolePlaneDetail", rpDetail);
			sqlMapperFlight.commitTransaction();
			bo = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				sqlMapperFlight.endTransaction();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return bo;
	}

	public int deleteRolePlane(Map<String, Object> param) {
		int i = 0;
		try {
			sqlMapperFlight.startTransaction();
			i = sqlMapperFlight.delete("deleteRolePlane", param);
			sqlMapperFlight.commitTransaction();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				sqlMapperFlight.endTransaction();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return i;
	}

	public int updateRolePlaneById(RolePlaneDetail rp) {
		int i = 0;
		try {
			sqlMapperFlight.startTransaction();
			i = sqlMapperFlight.update("updateRolePlaneDetail", rp);
			sqlMapperFlight.commitTransaction();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				sqlMapperFlight.endTransaction();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return i;
	}

	public int updateRolePlaneByRoleId(RolePlaneDetail rp) {
		int i = 0;
		try {
			sqlMapperFlight.startTransaction();
			i = sqlMapperFlight.update("updateRolePlaneByRoleId", rp);
			sqlMapperFlight.commitTransaction();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				sqlMapperFlight.endTransaction();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return i;
	}

	public int updateRolePlaneDetailByRoleIdAndPlaneId(Map<String, Object> param) {
		int i = 0;
		try {
			sqlMapperFlight.startTransaction();
			i = sqlMapperFlight.update("updateRolePlaneDetailByRoleIdAndPlaneId",
					param);
			sqlMapperFlight.commitTransaction();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				sqlMapperFlight.endTransaction();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return i;
	}

	public List<RolePlaneDetail> topRolePlanes(Map<String, Object> param) {
		List<RolePlaneDetail> list = null;
		try {
			list = sqlMapperFlight.queryForList("topRolePlane", param);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	public int updateRolePlaneByPackageId(Map<String, Object> param) {
		int i = 0;
		try {
			sqlMapperFlight.startTransaction();
			i = sqlMapperFlight.update("updateRolePlaneByPackageId", param);
			sqlMapperFlight.commitTransaction();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				sqlMapperFlight.endTransaction();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return i;
	}

	public boolean insertRolePlanes(List<RolePlaneDetail> planeList) {
		boolean flag = false;
		try {
			sqlMapperFlight.startTransaction();
			sqlMapperFlight.startBatch();
			for (int i = 0; i < planeList.size(); i++) {
				sqlMapperFlight.insert("insertRolePlaneDetail", planeList.get(i));
			}
			sqlMapperFlight.executeBatch();
			sqlMapperFlight.commitTransaction();
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				sqlMapperFlight.endTransaction();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flag;
	}

	public int findPlaneIdById(Map<String, Object> param) {
		List<Integer> ids=null;
		try{
			ids=sqlMapperFlight.queryForList("findPlaneIdById",param);
			if(ids.size()>0){
				return ids.get(0);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}

}
