package com.stang.game.ffd.dao;

import java.util.List;
import com.stang.game.ffd.entity.detail.EntityGameChatRoleDetail;

public interface IGameChatRoleDao extends IEntityDao<EntityGameChatRoleDetail> {
	public List<EntityGameChatRoleDetail> getAllInfo();
	
	public List<EntityGameChatRoleDetail> getAreaInfo();
}
