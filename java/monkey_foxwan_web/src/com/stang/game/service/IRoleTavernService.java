package com.stang.game.service;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.RoleMilitaryDetail;
import com.stang.game.entity.detail.RoleTavernDetail;

public interface IRoleTavernService extends IBaseService<RoleTavernDetail> {
	public boolean insertRoleTavern(Map<String, Object> param);

	public boolean updateRoleTavern(Map<String, Object> param);

	public List<RoleTavernDetail> getRoleTavern(int roleId);
}
