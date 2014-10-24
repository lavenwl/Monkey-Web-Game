package com.stang.game.ffd.service;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.entity.detail.EntityGameAvatarDetail;
public interface IGameAvatarService extends IBaseService<EntityGameAvatarDetail> {
	
		public List<EntityGameAvatarDetail> getAllInfo(Map<String,Object> parm);
		
		public String getAvatarNameById(Map<String, Object> param);
}
