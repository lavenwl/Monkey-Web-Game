package com.stang.game.ffd.service.impl;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.dao.IGameItemsDao;
import com.stang.game.ffd.dao.impl.GameItemsDaoImpl;
import com.stang.game.ffd.entity.detail.EntityGameItemsDetail;
import com.stang.game.ffd.service.IGameItemService;

public class GameItemServiceImpl extends BaseServiceImpl<EntityGameItemsDetail> implements IGameItemService{
	public IGameItemsDao getBaseDao(){
		if(this.baseDao==null){
			baseDao = new GameItemsDaoImpl();
		}
		return (IGameItemsDao)baseDao;
	}

	public List<EntityGameItemsDetail> getAllInfo(Map<String, Object> parm) {
		return getBaseDao().getAllInfo(parm);
	}
	
	public List<EntityGameItemsDetail> findGameItemsById(){
		return this.getBaseDao().findGameItemsById();
	}
	
	public int insertGameItemDetail(EntityGameItemsDetail param){
		return this.getBaseDao().insertGameItemDetail(param);
	}
	
	public List<EntityGameItemsDetail> findGameItemsGiftBag(Map<String,Object> parm){
		return this.getBaseDao().findGameItemsGiftBag(parm);
	}
	public int delGiftBag(Map<String,Object> parm){
		return this.getBaseDao().delGiftBag(parm);
	}

	public String getItemNameById(Map<String, Object> param) {
		return this.getBaseDao().getItemNameById(param);
	}

}
