package com.stang.game.service;

import java.util.List;

import com.stang.game.entity.detail.ServerDetail;

public interface IServerService extends IBaseService<ServerDetail>{
	public List<ServerDetail> getAllServer();
	public boolean updateServer(ServerDetail server);
}
