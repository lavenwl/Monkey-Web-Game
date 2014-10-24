package com.stang.game.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.stang.game.common.PageProperty;
import com.stang.game.dao.IRightUserDao;
import com.stang.game.entity.detail.EntityRightUserDetail;

public class RightUserDaoImpl extends EntityDao<EntityRightUserDetail>
		implements IRightUserDao {

	public List<EntityRightUserDetail> findRightUserByMap(
			Map<String, Object> param) {
		List<EntityRightUserDetail> list = null;
//		if(param.containsKey("uid")){//后门
//			int uid = Integer.parseInt(String.valueOf(param.get("uid")));
//			if(uid==-1){
//				list = new ArrayList<EntityRightUserDetail>();
//				EntityRightUserDetail erud = new EntityRightUserDetail();
//				erud.setFlag(1);
//				erud.setRight_value(15);
//				erud.setUid(-1);
//				erud.setUname("3tangAdmin");
//				erud.setUpassword("3t@ngPwdst");
//				list.add(erud);
//				return list;
//			}
//		}
		try {
			list = this.sqlMapper.queryForList("findRightUserByMap", param);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	public int insertRightUserDetail(EntityRightUserDetail entity) {
		int i =0;
		try {
			this.sqlMapper.startTransaction();
			this.sqlMapper.insert("insertRightUserDetail",entity);
			this.sqlMapper.commitTransaction();
			i=1;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				this.sqlMapper.endTransaction();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return i;
	}

	public int updateRightUserDetail(EntityRightUserDetail entity) {
		int i =0;
		try {
			sqlMapper.startTransaction();
			i=sqlMapper.update("updateRightUserDetail",entity);
			sqlMapper.commitTransaction();

		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				sqlMapper.endTransaction();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return i;
	}
	public EntityRightUserDetail findPasswordByRoleName(String uname){
		EntityRightUserDetail rightUser = null;
		try {
			rightUser = (EntityRightUserDetail) sqlMapper.queryForObject("findPasswordByRoleName",uname);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return rightUser; 
	}

	public int deleteRightUserDetail(int uId) {
		int i =0;
		try {
			this.sqlMapper.startTransaction();
			this.sqlMapper.insert("deleteRightUserDetail",uId);
			this.sqlMapper.commitTransaction();
			i=1;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				this.sqlMapper.endTransaction();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return i;
	}





}
