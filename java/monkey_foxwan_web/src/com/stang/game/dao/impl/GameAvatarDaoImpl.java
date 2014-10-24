package com.stang.game.dao.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.stang.game.common.GameConstants;
import com.stang.game.dao.IGameAvatarDao;
import com.stang.game.entity.detail.GameAvatarDetail;

public class GameAvatarDaoImpl extends EntityDao<GameAvatarDetail> implements
		IGameAvatarDao {

	public List<GameAvatarDetail> findGameAvatarsByIds(List<Integer> ids) {
		// TODO Auto-generated method stub
		List<GameAvatarDetail> avatars = null;
		try {
			HashMap<String, List<Integer>> param = new HashMap<String, List<Integer>>();
			param.put("ids", ids);
			avatars = sqlMapper.queryForList("findGameAvatarsByIds", param);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			GameConstants.log.warn("", e);
		}
		return avatars;
	}

	public List<GameAvatarDetail> allGameAvatars() {
		// TODO Auto-generated method stub
		List<GameAvatarDetail> avatars = null;

		try {
			avatars = sqlMapper.queryForList("allGameAvatars");
		} catch (Exception e) {
			GameConstants.log.warn("", e);
		}
		return avatars;
	}

	public GameAvatarDetail getGameAvatarDetail(int id) {
		List<GameAvatarDetail> list = null;
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("id", id);
			list = sqlMapper.queryForList("getGameAvatarDetail", param);
		} catch (Exception e) {
			// TODO: handle exception
			GameConstants.log.warn("", e);
		}
		return list.get(0);
	}

}
