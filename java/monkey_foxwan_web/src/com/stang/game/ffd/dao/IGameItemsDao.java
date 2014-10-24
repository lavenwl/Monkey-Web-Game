package com.stang.game.ffd.dao;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.entity.detail.EntityGameItemsDetail;

public interface IGameItemsDao extends IEntityDao<EntityGameItemsDetail> {

		public List<EntityGameItemsDetail> getAllInfo(Map<String,Object> parm);
		public List<EntityGameItemsDetail> findGameItemsById();
		public int insertGameItemDetail(EntityGameItemsDetail param);
		public List<EntityGameItemsDetail> findGameItemsGiftBag(Map<String,Object> parm);
		public int delGiftBag(Map<String,Object> parm);
		public String getItemNameById(Map<String, Object> param);
}
