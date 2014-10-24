package com.stang.game.ffd.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.stang.game.ffd.dao.IGameMailDao;
import com.stang.game.ffd.entity.detail.GameMailDetail;


public class GameMailDaoImpl extends EntityDao<GameMailDetail> implements IGameMailDao {

	public boolean batchDeleteGameMails(List<Integer> ids) {
		// TODO Auto-generated method stub
		boolean isSuccess = false;
		
		try {
			Map<String,Object> param = new HashMap<String,Object>();
			param.put("ids", ids);
			sqlMapperFlight.startTransaction();
			sqlMapperFlight.delete("batchDeleteGameMails", param);
			sqlMapperFlight.commitTransaction();
			isSuccess = true;
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
		
		return isSuccess;
	}

	public boolean deleteGameMailById(Integer id) {
		// TODO Auto-generated method stub
		boolean isSuccess = false;
		
		try {
			Map<String,Object> param = new HashMap<String,Object>();
			param.put("id", id);
			sqlMapperFlight.startTransaction();
			sqlMapperFlight.delete("deleteGameMailById", param);
			sqlMapperFlight.commitTransaction();
			isSuccess = true;
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
		
		return isSuccess;
	}

	public boolean updateGameMailIsOpen(Integer id) {
		// TODO Auto-generated method stub
		boolean isSuccess = false;
		
		try {
			Map<String,Object> param = new HashMap<String,Object>();
			param.put("id", id);
			sqlMapperFlight.startTransaction();
			sqlMapperFlight.update("updateGameMailIsOpen", param);
			sqlMapperFlight.commitTransaction();
			isSuccess = true;
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
		
		return isSuccess;
	}

	public List<GameMailDetail> findGameMailDetailByParam(
			Map<String, Object> param) {
		// TODO Auto-generated method stub
		List<GameMailDetail> mails = new ArrayList<GameMailDetail>();
		
		try {
			mails = sqlMapperFlight.queryForList("getGameMailDetail", param);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return mails;
	}

	public GameMailDetail getGameMailDetailById(Integer id) {
		// TODO Auto-generated method stub
		GameMailDetail mail = null;
		
		try {
			Map<String,Object> param = new HashMap<String,Object>();
			param.put("id", id);
			List<GameMailDetail> list = sqlMapperFlight.queryForList("getGameMailDetail", param);
			if(!list.isEmpty()) {
				mail = list.get(0);
			}
			list = null;
			param = null;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return mail;
	}
	
	public int updateGameMailIsGold(Integer mId){
		int k = 0;
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("id", mId);
			sqlMapperFlight.startTransaction();
			k = sqlMapperFlight.update("updateGameMailIsGold", param);
			sqlMapperFlight.commitTransaction();
			param = null;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally{
			try {
				sqlMapper.endTransaction();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return k;
	}
	
	public List<GameMailDetail> getGameMailsByTime(Map<String, Object> param){
		List<GameMailDetail> list = null;
		try {
			list = sqlMapperFlight.queryForList("getGameMailsByTime", param);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	

}
