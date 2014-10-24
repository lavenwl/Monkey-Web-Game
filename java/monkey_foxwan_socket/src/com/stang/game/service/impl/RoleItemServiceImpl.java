package com.stang.game.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.stang.game.cache.CacheRoleItem;
import com.stang.game.dao.IRoleItemDao;
import com.stang.game.dao.impl.RoleItemDaoImpl;
import com.stang.game.entity.detail.RoleItemDetail;
import com.stang.game.service.IRoleItemService;

/**
 * @author jianbo.feng
 * @company 上海三唐信息科技有限公司
 * @description 角色道具信息
 */
public class RoleItemServiceImpl extends BaseServiceImpl<RoleItemDetail>
		implements IRoleItemService {

	private static CacheRoleItem cacheRoleItem = null;
	private static CacheRoleItem getCacheRoleItem(){
		if(cacheRoleItem == null){
			cacheRoleItem = new CacheRoleItem();
		}
		return cacheRoleItem;
	}
	
	protected IRoleItemDao getBaseDao() {
		if (baseDao == null) {
			baseDao = new RoleItemDaoImpl();
		}
		return (IRoleItemDao) baseDao;
	}

	@Override
	public boolean addRoleItemNum(Map<String, Object> param) {
		return getCacheRoleItem().addRoleItemNum(param);
//		return getBaseDao().addRoleItemNum(param);
	}

	@Override
	public List<RoleItemDetail> findRoleItemsByRoleId(int roleId) {
		//System.out.println("RoleItemServiceImpl.findRoleItemByRoleId()执行了根据roleid数据库中查询道具！");
		Map<String, Object> rlt = new HashMap<String, Object>();
		rlt.put("roleid", roleId);
		return getCacheRoleItem().getRoleItem(rlt);
		//return getBaseDao().findRoleItemsByRoleId(roleId);
	}

	@Override
	public List<RoleItemDetail> getRoleItem(Map<String, Object> param) {
		//System.out.println("ROleItemServiceImpl.getRoleItem():param:" + param.toString());
//		Object id = param.get("id");
//		if(null != id){
//			return getCacheRoleItem().findRoleItemById(Integer.valueOf(String.valueOf(id)));
//		}else{
//			return getBaseDao().getRoleItem(param);
//		}
		return getCacheRoleItem().getRoleItem(param);
	}

	@Override
	public boolean insertRoleItem(RoleItemDetail detail) {
		return getCacheRoleItem().insertRoleItem(detail);
//		return getBaseDao().insertRoleItem(detail);
	}

	@Override
	public boolean sbRoleItemNum(Map<String, Object> param) {
		return getCacheRoleItem().sbRoleItemNum(param);
//		Object id = param.get("id");
//		int num = Integer.valueOf(String.valueOf(param.get("num")));
//		if(null != id){
//			System.out.println("RoleItemServiceImpl.sbRoleItemNum()选择性执行：缓存！    存在数据不同步问题！！");
//			return getCacheRoleItem().sbRoleItemNum(Long.valueOf(String.valueOf(id)), num);
//		}else{
//			System.out.println("RoleItemServiceImpl.sbRoleItemNum()选择性执行：数据库！  存在数据不同步问题！！");
//			return getBaseDao().sbRoleItemNum(param);
//		}
	}

	@Override
	public boolean delRoleItem(Map<String, Object> param) {
		return getCacheRoleItem().delRoleItem(param);
//		Object id = param.get("id");
//		if(null != id){
//			System.out.println("RoleItemServiceImpl.delRoleItem()选择性执行：缓存！    存在数据不同步问题！！");
//			return getCacheRoleItem().delRoleItem(Long.valueOf(String.valueOf(id)));
//		}else{
//			System.out.println("RoleItemServiceImpl.delRoleItem()选择性执行：数据库 ！  存在数据不同步问题！！");
//			return getBaseDao().delRoleItem(param);
//		}
	}

	@Override
	public List<RoleItemDetail> findRoleItemsById(int id) {
		return getCacheRoleItem().findRoleItemById(id);
//		return getBaseDao().findRoleItemsById(id);
	}

	@Override
	public List<RoleItemDetail> getRoleItemByitem(Map<String, Object> param) {
		//System.out.println("RoleItemServiceImpl.getRoleItemByitem()执行了数据库中查询道具！"+param);
		//return getBaseDao().getRoleItemByitem(param);
		return getCacheRoleItem().getRoleItemByitem(param);
	}

	@Override
	public boolean subRoleItem(Map<String, Object> param) {
		return getCacheRoleItem().sbRoleItemNum(param);
//		return getBaseDao().subRoleItem(param);
	}

	@Override
	public List<RoleItemDetail> getRoleItemByNum(Map<String, Object> param) {
		//System.out.println("RoleItemServiceImpl.getRoleItemByNum()执行了数据库中查询道具！");
		//return getCacheRoleItem().getRoleItemByNum(param);
		return getBaseDao().getRoleItemByNum(param);
	}

	@Override
	public boolean updateRoleItemByParams(Map<String, Object> param) {
		return getCacheRoleItem().updateRoleItemByParams(param);
//		return getBaseDao().updateRoleItemByParams(param);
	}

	@Override
	public boolean UpdateItemCache(List<RoleItemDetail> list) {
		System.out.println("RoleItemServiceImpl.UpdateItemCache()绝对不会被打印出来！！！！");
		return getBaseDao().UpdateItemCache(list);
	}

	@Override
	public List<RoleItemDetail> findAllRoleItem() {
		// TODO Auto-generated method stub
		return getBaseDao().findAllRoleItem();
	}

	@Override
	public void updateRoleItems(RoleItemDetail roleItemDetail) {
		// TODO Auto-generated method stub
		getCacheRoleItem().updateRoleItem(roleItemDetail);
	}

}
