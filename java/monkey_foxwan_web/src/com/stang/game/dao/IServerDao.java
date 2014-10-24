package com.stang.game.dao;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.Server;
import com.stang.game.entity.detail.GameRoleDetail;
import com.stang.game.entity.detail.ServerDetail;

public interface IServerDao extends IEntityDao<ServerDetail> {
	public List<ServerDetail> getAllServer();

	public boolean updateServerDetail(ServerDetail server);
}
