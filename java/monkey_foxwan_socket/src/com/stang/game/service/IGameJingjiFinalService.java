package com.stang.game.service;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.GameJingjiFinal;
import com.stang.game.entity.GameJingjiStatic;
import com.stang.game.entity.detail.GameJingjiFinalDetail;
import com.stang.game.entity.detail.GameJingjiStaticDetail;

public interface IGameJingjiFinalService extends IBaseService<GameJingjiFinalDetail>{
	public boolean dropGameJingjiFinal();
	public boolean createGameJingjiFinal();
	public boolean dropzhugong();
	public boolean createzhugong();
	public boolean alterzhugong();
	public List<GameJingjiFinalDetail> getGameJingjiByLimit(
			Map<String, Object> param);
	public List<GameJingjiFinalDetail> getGameJingjiByServerid(
			Map<String, Object> param);
	
	List<GameJingjiFinalDetail> findAllGameJingji();
}
