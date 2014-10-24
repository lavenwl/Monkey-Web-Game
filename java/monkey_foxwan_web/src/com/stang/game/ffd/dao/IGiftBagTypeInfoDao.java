/*
 * @author guk
 * @Description  礼包类型编辑
 * */

package com.stang.game.ffd.dao;
import java.util.List;

import com.stang.game.ffd.entity.detail.EntityGiftBagTypeInfoDetail;

public interface IGiftBagTypeInfoDao extends IEntityDao<EntityGiftBagTypeInfoDetail> {
	/**
	 * 增加新的礼包类别
	 * @param 礼包名字
	 * @return true or false
	 */
	public boolean AddGiftBagType(EntityGiftBagTypeInfoDetail param);
	/**
	 * 修改当前的礼包的名称
	 * @param param
	 * @return
	 */
	public boolean EditGiftBagType(EntityGiftBagTypeInfoDetail param);
	/**
	 * 查询所有的信息，当然是不包括删除的
	 * @return
	 */
	public List<EntityGiftBagTypeInfoDetail> findGiftBagType(EntityGiftBagTypeInfoDetail param);
	/**
	 * 查询所有的数据
	 * @return
	 */
	public List<EntityGiftBagTypeInfoDetail> findGiftBagType();
	/**
	 * 根据名字来查询数据库中是否有相同的名称的信息
	 * @param param
	 * @return
	 */
	public  List<EntityGiftBagTypeInfoDetail> findGiftBagTypeByName(EntityGiftBagTypeInfoDetail param);
	
	public int editGiftBagTypeByFlag(EntityGiftBagTypeInfoDetail param);
	
	public void editetest();
	/**
	 * 查询所有的信息。包含被删除的信息
	 * @return
	 */
	public List<EntityGiftBagTypeInfoDetail> findGiftAll();
	
}
