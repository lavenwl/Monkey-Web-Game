package com.stang.game.ffd.service.impl;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.dao.IGameAstrologyCorrectionDao;
import com.stang.game.ffd.dao.impl.GameAstrologyCorrectionDaoImpl;
import com.stang.game.ffd.entity.detail.EntityGameAstrologyCorrectionDetail;
import com.stang.game.ffd.service.IGameAstrologyCorrectionService;

public class GameAstrologyCorrectionServiceImpl extends BaseServiceImpl<EntityGameAstrologyCorrectionDetail> implements IGameAstrologyCorrectionService {
	
	public IGameAstrologyCorrectionDao getBaseDao(){
		if(baseDao==null){
			baseDao = new GameAstrologyCorrectionDaoImpl(); 
		}
		return (IGameAstrologyCorrectionDao)baseDao;
	}
	
	public int addGameAstrologyCorrection(EntityGameAstrologyCorrectionDetail params) {
		// TODO Auto-generated method stub
		return getBaseDao().addGameAstrologyCorrection(params);
	}

	public List<EntityGameAstrologyCorrectionDetail> findGameAstrologyCorrection(
			Map<String, Object> params) {
		// TODO Auto-generated method stub
		return getBaseDao().findGameAstrologyCorrection(params);
	}

	public int updateGameAstrologyCorrection(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return 0;
	}

}
