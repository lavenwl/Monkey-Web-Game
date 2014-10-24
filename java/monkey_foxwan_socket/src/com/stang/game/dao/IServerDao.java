package com.stang.game.dao;

import java.util.List;

import com.stang.game.entity.detail.ServerDetail;

public interface IServerDao extends IEntityDao<ServerDetail>{
	public List<ServerDetail> getAllServer();
	public List<ServerDetail> getAllNewServer();
	public List<ServerDetail> getnamebyid(int id);
	public void updateServer(ServerDetail server);
}
