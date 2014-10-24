package com.stang.game.ffd.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.stang.game.ffd.dao.IRoleEquipDao;
import com.stang.game.ffd.entity.detail.RoleEquipDetail;
import com.sun.org.apache.regexp.internal.REUtil;

public class RoleEquipDaoImpl extends EntityDao<RoleEquipDetail> implements IRoleEquipDao {

	public List<RoleEquipDetail> findRoleEquipsByRoleId(Integer roleId) {
		// TODO Auto-generated method stub
		List<RoleEquipDetail> list = null;
		
		try {
			Map param = new HashMap();
			param.put("roleId", roleId);
			list = sqlMapperFlight.queryForList("findRoleEquipsByRoleId", param);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public int batchDeleteRoleEquips(List<Integer> ids) {
		// TODO Auto-generated method stub
		int dataCode = 0;
		
		try {
			sqlMapperFlight.startTransaction();
			HashMap param = new HashMap();
			param.put("ids", ids);
			sqlMapperFlight.delete("batchDeleteRoleEquips", param);
			sqlMapperFlight.commitTransaction();
			dataCode = 1;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				sqlMapperFlight.endTransaction();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return dataCode;
	}
	
	public List<RoleEquipDetail> getRoleEquips(Map<String, Object> param){
		List<RoleEquipDetail> list=null;
		try {
			list=sqlMapperFlight.queryForList("getRoleEquips",param);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean insertRoleEquip(RoleEquipDetail eDetail){
		boolean bo=false;
		try {
			sqlMapperFlight.startTransaction();
			sqlMapperFlight.insert("insertRoleEquipDetail", eDetail);
			sqlMapperFlight.commitTransaction();
			bo=true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			try {
				sqlMapperFlight.endTransaction();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return bo;
	}
	
	public int deleteRoleEquip(Map<String, Object> param){
		int i=0;
		try {
			sqlMapperFlight.startTransaction();
			i=sqlMapperFlight.delete("deleteRoleEquip", param);
			sqlMapperFlight.commitTransaction();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			try {
				sqlMapperFlight.endTransaction();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return i;
	}
	
	public int updateRoleEquipById(RoleEquipDetail re){
		int i=0;
		try {
			sqlMapperFlight.startTransaction();
			i=sqlMapperFlight.update("updateRoleEquipDetail", re);
			sqlMapperFlight.commitTransaction();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			try {
				sqlMapperFlight.endTransaction();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return i;
	}
	
	public List<RoleEquipDetail> findRoleEquipById(Integer id){
		List<RoleEquipDetail> list=null;
		try {
			Map<String, Object> param=new HashMap<String, Object>();
			param.put("id", id);
			param.put("flag", 1);
			list=sqlMapperFlight.queryForList("getRoleEquips",param);
			param = null;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	public List<RoleEquipDetail> findUsingRoleEquipsByRoleId(Integer roleId) {
		// TODO Auto-generated method stub
		List<RoleEquipDetail> list = new ArrayList<RoleEquipDetail>();
		
		try {
			Map<String,Object> param = new HashMap<String,Object>();
			param.put("roleId", roleId);
			list = sqlMapperFlight.queryForList("findUsingRoleEquipsByRoleId", param);
			param = null;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public boolean updateRoleEquip(Map param) {
		boolean flag=false;
		try {
			sqlMapperFlight.startTransaction();
			sqlMapperFlight.update("updateRoleEquip", param);
			sqlMapperFlight.commitTransaction();
			flag=true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			try {
				sqlMapperFlight.endTransaction();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return flag;
	}

	public int updateRoleEquipDetailByRoleIdAndEquipId(Map<String, Object> param) {
		int i=0;
		try {
			sqlMapperFlight.startTransaction();
			i=sqlMapperFlight.update("updateRoleEquipDetailByRoleIdAndEquipId", param);
			sqlMapperFlight.commitTransaction();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			try {
				sqlMapperFlight.endTransaction();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return i;
	}

	public int updateRoleEquipDetailByPackageId(Map<String, Object> param) {
		int i=0;
		try {
			sqlMapperFlight.startTransaction();
			i=sqlMapperFlight.update("updateRoleEquipDetailByPackageId", param);
			sqlMapperFlight.commitTransaction();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			try {
				sqlMapperFlight.endTransaction();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return i;
	}

	public int updateRoleUseingEquipsDetailByPlaneId(int id) {
		Map<String,Integer> map = new HashMap<String, Integer>();
		map.put("planeId", id);
		int i=0;
		try {
			sqlMapperFlight.startTransaction();
			i=sqlMapperFlight.update("updateRoleUseingEquipsDetailByPlaneId", map);
			sqlMapperFlight.commitTransaction();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			try {
				sqlMapperFlight.endTransaction();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return i;
	}

	public boolean insertRoleEquips(List<RoleEquipDetail> equipList) {
		boolean flag = false;
		try{
			sqlMapperFlight.startTransaction();
			sqlMapperFlight.startBatch();
			for(int i=0;i<equipList.size();i++){
				sqlMapperFlight.insert("insertRoleEquipDetail",equipList.get(i));
			}
			sqlMapperFlight.executeBatch();
			sqlMapperFlight.commitTransaction();
			flag = true;
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				sqlMapperFlight.endTransaction();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flag;
	}

	public int findEquipIdById(Map<String, Object> param) {
			List<Integer> ids = null;
		try {
			ids = sqlMapperFlight.queryForList("findEquipIdById", param);
			if (ids.size() > 0) {
				return ids.get(0);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}


}
