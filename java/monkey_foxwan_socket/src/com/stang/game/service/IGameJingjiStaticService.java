package com.stang.game.service;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.GameJingjiStatic;
import com.stang.game.entity.detail.GameJingjiStaticDetail;

public interface IGameJingjiStaticService extends IBaseService<GameJingjiStaticDetail>{

public boolean insertGameJingji(Map<String,Object> param);
public List<GameJingjiStaticDetail> findAllGameJingjiStatic();
	public List<GameJingjiStaticDetail> getGameJingjiByServerid(Map<String,Object> param);
	
	public List<GameJingjiStaticDetail> getGameJingjiMax(Map<String,Object> param);
	public List<GameJingjiStaticDetail> getGameJingjiByServeridtwo(Map<String,Object> param);
	
	public boolean updateGameJingjiByParams(Map<String,Object> param);
	
	public boolean addGameJingjiIndexes(Map<String,Object> param);
	
	public List<GameJingjiStaticDetail> getGameJingjiByLimit(Map<String,Object> param);
	
	public List<GameJingjiStaticDetail> getGameJingjiByIndexes(Map<String,Object> param);
	public List<GameJingjiStaticDetail> getGameJingjiByIndexestwo(Map<String,Object> param);


}
