package com.stang.game.ffd.service;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.entity.detail.EntityGameItemsDetail;

public interface IGameItemService extends IBaseService<EntityGameItemsDetail> {
	public List<EntityGameItemsDetail> getAllInfo(Map<String,Object> parm);
	public List<EntityGameItemsDetail> findGameItemsById();
	public int insertGameItemDetail(EntityGameItemsDetail param);
	public List<EntityGameItemsDetail> findGameItemsGiftBag(Map<String,Object> parm);
	public int delGiftBag(Map<String,Object> parm);
	public String getItemNameById(Map<String, Object> param);
}
