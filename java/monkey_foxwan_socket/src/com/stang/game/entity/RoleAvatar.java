package com.stang.game.entity;

/**
 * @author jianbo.feng
 * @company 上海三唐信息科技有限公司
 * @description 角色-装饰品(所拥有)关系信息{在商城里面买的装饰，是已经'鉴定'过的}
 */
public class RoleAvatar implements Cloneable{
	@Override
	public Object clone() throws CloneNotSupportedException {
		// 实现clone方法
		return super.clone();
	}
	//缓存中确定是否更新，插入，删除字段。默认：0；更新：1；插入：2；删除：3.
	private int isUpdate;
	
	private int id; /* 序列号 */
	private int roleid; /* 角色序列号 */
	private int avatarid; /* 装饰序列号(对应GameAvatar序列号) */
	private int isused; /* 是否已使用(0,否;1,是;) */
	private int level;
	private int address; /* 位置(3帽子-hat；1服装 2 鞋子) */
	private int flag;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	public int getAvatarid() {
		return avatarid;
	}

	public void setAvatarid(int avatarid) {
		this.avatarid = avatarid;
	}

	public int getIsused() {
		return isused;
	}

	public void setIsused(int isused) {
		this.isused = isused;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getAddress() {
		return address;
	}

	public void setAddress(int address) {
		this.address = address;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public int getIsUpdate() {
		return isUpdate;
	}

	public void setIsUpdate(int isUpdate) {
		this.isUpdate = isUpdate;
	}

}
