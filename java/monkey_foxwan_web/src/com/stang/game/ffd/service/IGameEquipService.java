package com.stang.game.ffd.service;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.entity.detail.EntityGameEquipDetail;

public interface IGameEquipService extends IBaseService<EntityGameEquipDetail> {	
		public List<EntityGameEquipDetail> getAllInfo(Map<String,Object> parm);
		public String getEquipNameById(Map<String, Object> param);
}
