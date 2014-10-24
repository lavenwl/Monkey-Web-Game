package com.stang.game.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.stang.game.common.GameConstants;
import com.stang.game.dao.IGameJingjiStaticDao;
import com.stang.game.entity.detail.GameJingjiStaticDetail;

public class GameJingjiStaticDaoImpl extends EntityDao<GameJingjiStaticDetail> implements IGameJingjiStaticDao{

	@Override
	public boolean insertGameJingji(Map<String, Object> param) {
		System.out.println("GameJingjiStaticDao insertGameJingji:" + param.toString());
		boolean bo = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.insert("insertGameJingji", param);
			sqlMapper.commitTransaction();
			bo = true;
		} catch (SQLException e) {
			GameConstants.log.warn("",e);
		}finally{
			try {
				sqlMapper.endTransaction();
			} catch (SQLException e) {
				GameConstants.log.warn("",e);
			}
		}
		return bo;
	}
	
	@Override
	public List<GameJingjiStaticDetail> getGameJingjiByServerid(
			Map<String, Object> param) {
		List<GameJingjiStaticDetail> list = null;
		try {
			list = sqlMapper.queryForList("getGameJingjiByServerid", param);
		} catch (SQLException e) {
			GameConstants.log.warn("",e);
		}
		return list;
	}

	@Override
	public List<GameJingjiStaticDetail> getGameJingjiMax(Map<String, Object> param) {
		List<GameJingjiStaticDetail> list = null;
		try {
			list = sqlMapper.queryForList("getGameJingjiMax", param);
		} catch (SQLException e) {
			GameConstants.log.warn("",e);
		}
		return list;
	}

	@Override
	public boolean updateGameJingjiByParams(Map<String, Object> param) {
		boolean bo = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.update("updateGameJingjiByParams", param);
			sqlMapper.commitTransaction();
			bo = true;
		} catch (SQLException e) {
			GameConstants.log.warn("",e);
		}finally{
			try {
				sqlMapper.endTransaction();
			} catch (SQLException e) {
				GameConstants.log.warn("",e);
			}
		}
		
		return bo;
	}

	@Override
	public boolean addGameJingjiIndexes(Map<String, Object> param) {
		System.out.println("GameJIngjistatic, addGameJingjiIndex:" + param.toString());
		boolean bo = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.update("addGameJingjiIndexes", param);
			sqlMapper.commitTransaction();
			bo = true;
		} catch (SQLException e) {
			GameConstants.log.warn("",e);
		}finally{
			try {
				sqlMapper.endTransaction();
			} catch (SQLException e) {
				GameConstants.log.warn("",e);
			}
		}
		
		return bo;
	}

	@Override
	public List<GameJingjiStaticDetail> getGameJingjiByLimit(
			Map<String, Object> param) {
		List<GameJingjiStaticDetail> list = null;
		try {
			list = sqlMapper.queryForList("getGameJingjiByLimit",param);
		} catch (SQLException e) {
			GameConstants.log.warn("",e);
		}
		return list;
	}

	@Override
	public List<GameJingjiStaticDetail> getGameJingjiByIndexes(
			Map<String, Object> param) {
		List<GameJingjiStaticDetail> list = null;
		try {
			list = sqlMapper.queryForList("getGameJingjiByIndexes",param);
		} catch (SQLException e) {
			GameConstants.log.warn("",e);
		}
		return list;
	}

	@Override
	public List<GameJingjiStaticDetail> getGameJingjiByServeridtwo(
			Map<String, Object> param) {
		List<GameJingjiStaticDetail> list = null;
		try {
			list = sqlMapper.queryForList("getGameJingjiByServeridtwo", param);
		} catch (SQLException e) {
			GameConstants.log.warn("",e);
		}
		return list;
	}

	@Override
	public List<GameJingjiStaticDetail> getGameJingjiByIndexestwo(
			Map<String, Object> param) {
		List<GameJingjiStaticDetail> list = null;
		try {
			list = sqlMapper.queryForList("getGameJingjiByIndexestwo",param);
		} catch (SQLException e) {
			GameConstants.log.warn("",e);
		}
		return list;
	}

	@Override
	public List<GameJingjiStaticDetail> findAllGameJingjiStatic() {
		List<GameJingjiStaticDetail> list = null;
		try {
			list = sqlMapper.queryForList("findAllGameJingjiStatic");
		} catch (SQLException e) {
			GameConstants.log.warn("",e);
		}
		return list;
	}



}
