package com.stang.game.ffd.dao.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.stang.game.ffd.dao.IRoleAvatarDao;
import com.stang.game.ffd.entity.detail.RoleAvatarDetail;


public class RoleAvatarDaoImpl extends EntityDao<RoleAvatarDetail> implements IRoleAvatarDao {

	public List<RoleAvatarDetail> findRoleAvatarsByRoleId(Integer roleId) {
		// TODO Auto-generated method stub
		List<RoleAvatarDetail> list = null;
		try {
			Map param = new HashMap();
			param.put("roleId", roleId);
			list = (List<RoleAvatarDetail>)sqlMapperFlight.queryForList("findRoleAvatarsByRoleId", param);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public int updateRoleAvatarNotusedStatusByRoleId(Integer roleId) {
		// TODO Auto-generated method stub
		int dataCode = 0;
		
		try {
			sqlMapperFlight.startTransaction();
			HashMap param = new HashMap();
			param.put("roleId", roleId);
			sqlMapperFlight.insert("updateRoleAvatarNotusedStatusByRoleId", param);
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

	public int updateRoleAvatarUsedStatusByRoleIdAndIds(Integer roleId,
			List<Integer> ids) {
		// TODO Auto-generated method stub
		int dataCode = 0;
		
		try {
			sqlMapperFlight.startTransaction();
			HashMap param = new HashMap();
			param.put("roleId", roleId);
			param.put("ids", ids);
			sqlMapperFlight.insert("updateRoleAvatarUsedStatusByRoleIdAndIds", param);
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

	public RoleAvatarDetail getRoleAvatarDetail(Map<String, Object> param) {
		// TODO Auto-generated method stub
		RoleAvatarDetail model = null;
		try {
			List<RoleAvatarDetail> list = sqlMapperFlight.queryForList("getRoleAvatarDetail", param);
			if(list != null) {
				if(!list.isEmpty()) {
					model = list.get(0);
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return model;
	}

	public List<RoleAvatarDetail> findUsingRoleAvatarsByRoleId(Integer roleId) {
		// TODO Auto-generated method stub
		List<RoleAvatarDetail> list = null;
		
		try {
			Map param = new HashMap();
			param.put("roleId", roleId);
			list = sqlMapperFlight.queryForList("findUsingRoleAvatarsByRoleId", param);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public List<RoleAvatarDetail> getRoleAvatars(Map<String, Object> param){
		List<RoleAvatarDetail> list=null;
		try{
			list=sqlMapperFlight.queryForList("getRoleAvatarDetail",param);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean insertRoleAvatar(RoleAvatarDetail aDetail){
		boolean bo=false;
		try {
			sqlMapperFlight.startTransaction();
			sqlMapperFlight.insert("insertRoleAvatarDetail", aDetail);
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
	
	public int deleteRoleAvatar(Map<String, Object> param){
		int i=0;
		try {
			sqlMapperFlight.startTransaction();
			i=sqlMapperFlight.delete("deleteRoleAvatar", param);
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

	public boolean updateRoleAvatarNotusedStatusById(Integer id, Integer roleId) {
		// TODO Auto-generated method stub
		boolean bo=false;
		try {
			Map<String,Object> param = new HashMap<String,Object>();
			param.put("id", id);
			param.put("roleId", roleId);
			sqlMapperFlight.startTransaction();
			sqlMapperFlight.update("updateRoleAvatarNotusedStatusById", param);
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

	public boolean updateRoleAvatarUsedStatusById(Integer id, Integer roleId) {
		// TODO Auto-generated method stub
		boolean bo=false;
		try {
			Map<String,Object> param = new HashMap<String,Object>();
			param.put("id", id);
			param.put("roleId", roleId);
			sqlMapperFlight.startTransaction();
			sqlMapperFlight.update("updateRoleAvatarUsedStatusById", param);
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
	
	public int updateRoleAvatarById(RoleAvatarDetail ra){
		int i=0;
		try {
			sqlMapperFlight.startTransaction();
			i=sqlMapperFlight.update("updateRoleAvatarDetail", ra);
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
	
	public int updateRoleAvatarIsNotUsedByAddress(Map<String, Object> param){
		int k = 0;
		try {
			sqlMapperFlight.startTransaction();
			k = sqlMapperFlight.update("updateRoleAvatarIsNotUsedByAddress", param);
			sqlMapperFlight.commitTransaction();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally{
			try {
				sqlMapperFlight.endTransaction();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return k;
	}

	public int findAvatarIdById(Map<String, Object> param) {
		List<Integer> ids=null;
		try{
			ids=sqlMapperFlight.queryForList("findAvatarIdById",param);
			if(ids.size()>0){
				return ids.get(0);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}
	

//	public List<RoleAvatarFullDetail> findFullRoleAvatarsByRoleId(Integer roleId) {
//		// TODO Auto-generated method stub
//		
//		List<RoleAvatarFullDetail> list = null;
//		try {
//			Map param = new HashMap();
//			param.put("roleId", roleId);
//			list = (List<RoleAvatarFullDetail>)sqlMapperFlight.queryForList("findFullRoleAvatarsByRoleId", param);
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
//		
//		return list;
//	}

}
