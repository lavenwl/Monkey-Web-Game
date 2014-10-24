package com.stang.game.ffd.dao.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.stang.game.ffd.dao.IRoleItemDao;
import com.stang.game.ffd.entity.detail.RoleItemDetail;


public class RoleItemDaoImpl extends EntityDao<RoleItemDetail> implements
		IRoleItemDao {

	public List<RoleItemDetail> findRoleItemsByRoleId(Integer roleId) {
		// TODO Auto-generated method stub
		List<RoleItemDetail> list = new java.util.ArrayList<RoleItemDetail>();

		try {
			Map param = new HashMap();
			param.put("roleId", roleId);
			list = sqlMapperFlight.queryForList("findRoleItemsByRoleId", param);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<RoleItemDetail> findRoleItemsByRoleIds(List id) {
		// TODO Auto-generated method stub
		List<RoleItemDetail> list = null;

		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("ids", id);
			list = sqlMapperFlight.queryForList("findRoleItemsByIds", map);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<RoleItemDetail> findRoleItemsByItemIds(List<Integer> itemIds,
			int playId) {
		List<RoleItemDetail> list = null;

		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("ids", itemIds);
			map.put("roleId", playId);
			list = sqlMapperFlight.queryForList("findRoleItemsByItemIds", map);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}


	public int deleteRoleItem(Map<String, Object> param) {
		// TODO Auto-generated method stub
		int dataCode = 0;
		try {
			sqlMapperFlight.startTransaction();
			dataCode = sqlMapperFlight.delete("deleteRoleItem", param);
			sqlMapperFlight.commitTransaction();
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

	public List<RoleItemDetail> getRoleItems(Map<String, Object> param) {
		List<RoleItemDetail> list = null;
		try {
			list = sqlMapperFlight.queryForList("getRoleItems", param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean insertRoleItem(RoleItemDetail iDetail) {
		boolean bo = false;
		try {
			sqlMapperFlight.startTransaction();
			sqlMapperFlight.insert("insertRoleItemDetail", iDetail);
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

	public int updateRoleItem(RoleItemDetail iDetail) {
		int i = 0;
		try {
			sqlMapperFlight.startTransaction();
			i = sqlMapperFlight.update("updateRoleItemDetail", iDetail);
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

	public int deleteOneItem(Integer itemId) {
		int k = 0;
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("id", itemId);
			sqlMapperFlight.startTransaction();
			k = sqlMapperFlight.delete("deleteRoleItem", param);
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
		return k;
	}

	public boolean deleteRoleItems(List<Integer> list) {
		boolean flag = false;
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("ids", list);
			sqlMapperFlight.startTransaction();
			sqlMapperFlight.delete("batchDeleteRoleItems", map);
			sqlMapperFlight.commitTransaction();
			flag = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				sqlMapperFlight.endTransaction();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return flag;
	}

	public boolean upRoleItems(List<Integer> list, Integer num) {
		/*
		 * boolean flag=false; try { Map<String,Object> map=new HashMap<String,
		 * Object>(); map.put("ids", list); sqlMapperFlight.startTransaction();
		 * 
		 * sqlMapperFlight.commitTransaction(); flag = true; } catch (SQLException e) { //
		 * TODO Auto-generated catch block e.printStackTrace(); }finally{ try {
		 * sqlMapperFlight.endTransaction(); } catch (Exception e) { // TODO: handle
		 * exception e.printStackTrace(); } } return flag;
		 */
		return false;
	}

	public List<RoleItemDetail> findItemsById(Integer id) {
		// TODO Auto-generated method stub
		List<RoleItemDetail> list = new java.util.ArrayList<RoleItemDetail>();

		try {
			Map param = new HashMap();
			param.put("id", id);
			list = sqlMapperFlight.queryForList("findRoleItemsByRoleId", param);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public boolean updateRoleItemNum(Map<String, Object> param) {
		boolean flag = false;
		try {
			sqlMapperFlight.startTransaction();
			sqlMapperFlight.update("updateRoleItemNum", param);
			sqlMapperFlight.commitTransaction();
			flag = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				sqlMapperFlight.endTransaction();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return flag;
	}

	public boolean insertRoleItems(List<RoleItemDetail> insertList) {
		boolean flag = false;
		try {
			sqlMapperFlight.startTransaction();
			sqlMapperFlight.startBatch();
			for (int i = 0; i < insertList.size(); i++) {
				sqlMapperFlight.insert("insertRoleItemDetail", insertList.get(i));
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

	public boolean updateRoleItems(List<RoleItemDetail> updateList) {
		boolean flag = false;
		try {
			sqlMapperFlight.startTransaction();
			sqlMapperFlight.startBatch();
			for (int i = 0; i < updateList.size(); i++) {
				sqlMapperFlight.insert("updateRoleItemDetail", updateList.get(i));
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

	public boolean updateRoleItemDetailNum(List<RoleItemDetail> updateList) {
		boolean flag = false;
		try {
			sqlMapperFlight.startTransaction();
			sqlMapperFlight.startBatch();
			for (int i = 0; i < updateList.size(); i++) {
				sqlMapperFlight.insert("updateRoleItemDetailNum", updateList.get(i));
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

	public int findItemIdById(Map<String, Object> param) {
		List<Integer> ids=null;
		try{
			ids=sqlMapperFlight.queryForList("findItemIdById",param);
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
