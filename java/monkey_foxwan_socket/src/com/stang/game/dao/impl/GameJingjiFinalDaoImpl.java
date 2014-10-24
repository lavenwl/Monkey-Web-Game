package com.stang.game.dao.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.stang.game.common.GameConstants;
import com.stang.game.dao.IGameJingjiFinalDao;
import com.stang.game.dao.IGameJingjiStaticDao;
import com.stang.game.entity.GameJingjiFinal;
import com.stang.game.entity.GameJingjiStatic;
import com.stang.game.entity.detail.GameJingjiFinalDetail;
import com.stang.game.entity.detail.GameJingjiStaticDetail;
import com.stang.game.entity.detail.GameRoleDetail;

public class GameJingjiFinalDaoImpl extends EntityDao<GameJingjiFinalDetail> implements IGameJingjiFinalDao{

	@Override
//	public boolean createGameJingjiFinal() {
//		boolean isSuccess = false;
//		try {
//			sqlMapper.queryForList("createGameJingjiFinal");
//			isSuccess = true;
//		} catch (SQLException e) {
//			e.printStackTrace();
//			GameConstants.log.warn("", e);
//		}
//		return isSuccess;
//	}
	
	
	public boolean createGameJingjiFinal() {
		Map<String, Object> map = new HashMap<String, Object>();
		//System.out.println("GameJingjiFinalDaoImpl:createGameJingjiFinal:执行了！");
		map.put("serverid", 1);
		boolean isSuccess = false;
		try { // 开启事务   
			sqlMapper.startTransaction();
			sqlMapper.insert("createGameJingjiFinalb", map);
			sqlMapper.commitTransaction();
			isSuccess = true;
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			try {
				sqlMapper.endTransaction();
			} catch (Exception e) {
				GameConstants.log.warn("", e);
			}
		}     
		return isSuccess;
	}
	
	
	@Override
	public boolean createzhugong() {
		boolean isSuccess = false;
		try {
			sqlMapper.queryForList("createzhugong");
			isSuccess = true;
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return isSuccess;
	}

	@Override
	public boolean dropGameJingjiFinal() {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.delete("dropGameJingjiFinal");
			sqlMapper.commitTransaction();
			isSuccess = true;
		} catch (Exception e) {
			GameConstants.log.warn("", e);
		} finally {
			try {
				sqlMapper.endTransaction();
			} catch (SQLException e) {
				GameConstants.log.warn("", e);
			}
		}
		return isSuccess;
	}

	@Override
	public boolean dropzhugong() {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.delete("dropzhugong1");
			sqlMapper.commitTransaction();
			isSuccess = true;
		} catch (Exception e) {
			GameConstants.log.warn("", e);
		} finally {
			try {
				sqlMapper.endTransaction();
			} catch (SQLException e) {
				GameConstants.log.warn("", e);
			}
		}
		return isSuccess;
	}
	
	@Override
	public boolean alterzhugong() {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.update("alterzhugong");
			sqlMapper.commitTransaction();
			isSuccess = true;
		} catch (Exception e) {
			GameConstants.log.warn("", e);
		} finally {
			try {
				sqlMapper.endTransaction();
			} catch (SQLException e) {
				GameConstants.log.warn("", e);
			}
		}
		return isSuccess;
	}

	@Override
	public List<GameJingjiFinalDetail> getGameJingjiByLimit(
			Map<String, Object> param) {
		List<GameJingjiFinalDetail> list = null;
		try {
			list = sqlMapper.queryForList("getGameJingjiByLimit1",param);
		} catch (SQLException e) {
			GameConstants.log.warn("",e);
		}
		return list;
	}

	@Override
	public List<GameJingjiFinalDetail> getGameJingjiByServerid(
			Map<String, Object> param) {
		List<GameJingjiFinalDetail> list = null;
		try {
			list = sqlMapper.queryForList("getGameJingjiByServerid1", param);
		} catch (SQLException e) {
			GameConstants.log.warn("",e);
		}
		return list;
	}

	@Override
	public List<GameJingjiFinalDetail> findAllGameJingji() {
		List<GameJingjiFinalDetail> list = null;
		try {
			list = sqlMapper.queryForList("findAllGameJingji");
		} catch (SQLException e) {
			GameConstants.log.warn("",e);
		}
		return list;
	}
	

}
