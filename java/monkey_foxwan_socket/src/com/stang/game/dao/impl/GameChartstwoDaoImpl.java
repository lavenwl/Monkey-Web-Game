package com.stang.game.dao.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.stang.game.common.GameConstants;
import com.stang.game.dao.IGameChartstwoDao;
import com.stang.game.entity.detail.GameChartsDetail;
import com.stang.game.entity.detail.GameChartstwoDetail;

public class GameChartstwoDaoImpl extends 
EntityDao<GameChartstwoDetail> implements IGameChartstwoDao{

	public boolean insertGameChartstwo(Map<String, Object> param) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.insert("insertGameChartstwo",param);
			sqlMapper.commitTransaction();
			isSuccess = true;
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}finally{
			try {
				sqlMapper.endTransaction();
			} catch (SQLException e) {
				GameConstants.log.warn("", e);
			}
		}
		return isSuccess;
	
	}

	@Override
	public List<GameChartstwoDetail> findByDTtwo(Map<String, Object> param) {
		
		List<GameChartstwoDetail> list=null;
		try {
			list = sqlMapper.queryForList("findByDTtwo", param);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	
	}

	@Override
	public List<GameChartstwoDetail> findByNumtwo(Map<String, Object> param) {
		
		List<GameChartstwoDetail> list=null;
		try {
			list = sqlMapper.queryForList("findByNumtwo", param);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
		
	}

	@Override
	public List<GameChartstwoDetail> findByQZtwo(Map<String, Object> param) {
		List<GameChartstwoDetail> list=null;
		try {
			list = sqlMapper.queryForList("findByQZtwo", param);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	public boolean insertGameChartsthree(List<GameChartsDetail> param) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.insert("insertGameChartsthree",param);
			sqlMapper.commitTransaction();
			isSuccess = true;
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}finally{
			try {
				sqlMapper.endTransaction();
			} catch (SQLException e) {
				GameConstants.log.warn("", e);
			}
		}
		return isSuccess;
	}

	@Override
	public boolean deletegamechart() {

		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.delete("deletegamechart");
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
	public boolean deletegamechartone() {

		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.delete("deletegamechartone");
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
	public boolean insertGameChartstwot(List<GameChartstwoDetail> param) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.insert("insertGameChartstwo",param);
			sqlMapper.commitTransaction();
			isSuccess = true;
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}finally{
			try {
				sqlMapper.endTransaction();
			} catch (SQLException e) {
				GameConstants.log.warn("", e);
			}
		}
		return isSuccess;
	
	
	}

	@Override
	public void createdantiaob() {
		
		try {sqlMapper.queryForList("createdantiaob");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
	
	}

	@Override
	public void dropdantiao() {

		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.delete("dropdantiao");
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
	
	
	}

	@Override
	public void dropzhugong() {

		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.delete("dropzhugong");
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
	
	
	}

	@Override
	public void createzhugongb() {
		
		try {sqlMapper.queryForList("createzhugongb");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
	
	}

	@Override
	public boolean xgzdsxf() {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.update("xgzdsxf");
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
	public boolean xgzdsxo() {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.update("xgzdsxo");
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
	public boolean xgzdsxt() {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.update("xgzdsxt");
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
	public void createqz() {
		
		try {sqlMapper.queryForList("createqz");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
	
	}

	@Override
	public void dropqz() {

		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.delete("dropqz");
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
	
	
	}

	@Override
	public boolean xgczsqz() {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.update("xgczsqz");
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
	public boolean xgczsqzt() {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.update("xgczsqzt");
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
	public boolean call_proc_add(int i) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("serverid", i);
		boolean isSuccess = false;
		try { // 开启事务   
			sqlMapper.startTransaction();
			sqlMapper.insert("callproc", map);
			sqlMapper.commitTransaction();
			isSuccess = true;
		} catch (SQLException e1) {
			e1.printStackTrace();
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
	public List<GameChartstwoDetail> findAllGameChartstwo() {
		
		List<GameChartstwoDetail> list=null;
		try {
			list = sqlMapper.queryForList("findAllGameChartstwo");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	
	}

}
