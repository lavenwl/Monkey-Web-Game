package com.stang.game.ffd.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.stang.game.ffd.common.GameConstants;
import com.stang.game.ffd.dao.IMemberDao;
import com.stang.game.ffd.entity.detail.MemberDetail;

public class MemberDaoImpl extends EntityDao<MemberDetail> implements IMemberDao {

	public List<MemberDetail> findMembersByIds(List<Integer> ids) {
		// TODO Auto-generated method stub
		List<MemberDetail> members = null;
		try {
			HashMap<String,List<Integer>> param = new HashMap<String,List<Integer>>();
			param.put("ids", ids);
			members = sqlMapper.queryForList("findMembersByIds", param);
		}
		catch(Exception e) {
			
		}
		return members;
	}

	public int updateMemberById(Map<String, Object> param) {
		int i=0;
		try {
			sqlMapper.startTransaction();
			i=sqlMapper.update("updateMemberById", param);
			sqlMapper.commitTransaction();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			try {
				sqlMapper.endTransaction();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return i;
	}
	
	@SuppressWarnings("unchecked")
	public List<MemberDetail> findMembersByIds(Map<String,Object> params) {
		// TODO Auto-generated method stub
		List<MemberDetail> members = null;
		try {
			members = sqlMapperFlight.queryForList("findMembers", params);
		}
		catch(Exception e) {
			
		}
		return members;
	}


}
