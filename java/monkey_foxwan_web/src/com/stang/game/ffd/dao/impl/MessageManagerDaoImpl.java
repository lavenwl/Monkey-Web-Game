package com.stang.game.ffd.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.stang.game.ffd.common.PageProperty;
import com.stang.game.ffd.dao.IMessageManagerDao;
import com.stang.game.ffd.entity.detail.EntityRightUserDetail;
import com.stang.game.ffd.entity.detail.MessageManagerDetail;

public class MessageManagerDaoImpl extends EntityDao<MessageManagerDetail>
		implements IMessageManagerDao {


	public int insertMessageManagerDetail(MessageManagerDetail entity) {
		int i =0;
		try {
			this.sqlMapper.startTransaction();
			this.sqlMapper.insert("insertMessageManagerDetail",entity);
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
	public int updateMessageManagerDetailByIDs(List<Integer> ids) {
		int i =0;
		try {
			Map<String,Object> param = new HashMap<String,Object>();
			param.put("ids", ids);
			i = sqlMapper.update("updateMessageManagerDetailByIDs", param);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	public int updateMessageManagerDetail(MessageManagerDetail entity) {
		int i =0;
		try {
			sqlMapper.startTransaction();
			i=sqlMapper.update("updateMessageManagerDetail",entity);
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

	public List<MessageManagerDetail> findMessageManagerByTime(Date endTime) {
		List<MessageManagerDetail> list = null;
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("endTime", endTime);
		try {
			list = this.sqlMapper.queryForList("findMessageManagerByTime", map);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	public List<MessageManagerDetail> findMessageManagerByFlag(int flag) {
		List<MessageManagerDetail> list = null;
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("flag", flag);
		try {
			list = this.sqlMapper.queryForList("findMessageManagerByFlag", map);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}
	public List<MessageManagerDetail> findMessageManagerByFlagOrderByOpTime() {
		List<MessageManagerDetail> list = null;

		try {
			list = this.sqlMapper.queryForList("findMessageManagerByFlagOrderByOpTime");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}



}
