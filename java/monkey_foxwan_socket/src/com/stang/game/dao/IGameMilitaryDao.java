package com.stang.game.dao;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.GameMilitaryDetail;

public interface IGameMilitaryDao extends IEntityDao<GameMilitaryDetail> {
	public List<GameMilitaryDetail> getGameMilitary();

	public List<GameMilitaryDetail> getGameMilitaryByBz(int pinzhi);

	public List<GameMilitaryDetail> getGameMilitaryBymid(int mid);
	public List<GameMilitaryDetail> getGameMilitaryBymid2(int mid);
	public List<GameMilitaryDetail> getGameMilitaryByparam(Map<String, Object> param);
	public List<GameMilitaryDetail> getManyTableSelect(int mid);
	public List<GameMilitaryDetail> getManyTableSelect2(int mid);
	public List<GameMilitaryDetail> getMilitaryPinzhi(int mid);
}
