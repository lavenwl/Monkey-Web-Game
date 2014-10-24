package com.stang.game.dao;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.GameJingjiFinal;
import com.stang.game.entity.GameJingjiStatic;
import com.stang.game.entity.detail.GameJingjiFinalDetail;
import com.stang.game.entity.detail.GameJingjiStaticDetail;

public interface IGameJingjiFinalDao extends IEntityDao<GameJingjiFinalDetail>{
	List<GameJingjiFinalDetail> findAllGameJingji();

	boolean createGameJingjiFinal();

	boolean dropGameJingjiFinal();

	boolean alterzhugong();

	boolean dropzhugong();

	boolean createzhugong();

	List<GameJingjiFinalDetail> getGameJingjiByLimit(Map<String, Object> param);

	List<GameJingjiFinalDetail> getGameJingjiByServerid(
			Map<String, Object> param);

}
