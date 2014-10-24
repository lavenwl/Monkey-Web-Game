package com.stang.game.ffd.service;

import java.util.List;

import com.stang.game.ffd.entity.detail.EntityAreaCountDetail;
import com.stang.game.ffd.entity.detail.EntityGameChatRoleDetail;

public interface IGameChatRoleService extends IBaseService<EntityGameChatRoleDetail> {
	public List<EntityGameChatRoleDetail> getAllInfo();
	/**
	 * 查询当前的大区情况
	 * @return
	 */
	public List<EntityGameChatRoleDetail> getAreaInfo();
}
