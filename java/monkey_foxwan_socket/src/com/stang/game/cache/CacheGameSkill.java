package com.stang.game.cache;

import com.stang.game.entity.GameEquip;
import com.stang.game.entity.GameSkill;
import com.stang.game.entity.detail.*;

import java.util.*;
/**
 * 具体对象的缓存类
 * @author Laven Wang
 *
 */
public class CacheGameSkill {
	//缓存类操作的缓存对象(key:id, value:ActivityDetail)
	private static Map<Integer, GameSkillDetail>  gameSkills = null;
	//静态初始化方法
	public CacheGameSkill(){
		if(gameSkills == null)
			gameSkills = GlobalDatat.cacheGameSkillDetails;
	}
	public List<GameSkillDetail> getGameSkillById(int id) {
		// TODO Auto-generated method stub
		List<GameSkillDetail> gameSkillDetailList=new ArrayList<GameSkillDetail>();
		gameSkillDetailList.add(gameSkills.get(id));
		return gameSkillDetailList;
	}


}
