package com.stang.game.entity;

public class GameMission implements Cloneable{
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// 实现clone方法
		return super.clone();
	}
	//缓存中确定是否更新，插入，删除字段。默认：0；更新：1；插入：2；删除：3.
	private int isUpdate;
	
	private int id;
	private String name;
	private String artdesc;
	private String goal;
	private String jiangli;
	private int flag;
	private int mapid;
	
	public int getMapid() {
		return mapid;
	}
	public void setMapid(int mapid) {
		this.mapid = mapid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getArtdesc() {
		return artdesc;
	}
	public void setArtdesc(String artdesc) {
		this.artdesc = artdesc;
	}
	public String getGoal() {
		return goal;
	}
	public void setGoal(String goal) {
		this.goal = goal;
	}
	public String getJiangli() {
		return jiangli;
	}
	public void setJiangli(String jiangli) {
		this.jiangli = jiangli;
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
