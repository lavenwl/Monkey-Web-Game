package com.stang.game.entity;

public class Gametotem implements Cloneable{
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// 实现clone方法
		return super.clone();
	}
	//������ȷ���Ƿ���£����룬ɾ���ֶΡ�Ĭ�ϣ�0�����£�1�����룺2��ɾ��3.
	private int isUpdate;
	
	private int id;
	private String name;
	private int type;
	private int level;
	private int flag;
	private int quality;
	private String icon;
	private String halo;
	private int isshop;
	private int indexs;
	public int getIndexs() {
		return indexs;
	}
	public void setIndexs(int indexs) {
		this.indexs = indexs;
	}
	public int getIsshop() {
		return isshop;
	}
	public void setIsshop(int isshop) {
		this.isshop = isshop;
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
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public int getQuality() {
		return quality;
	}
	public void setQuality(int quality) {
		this.quality = quality;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getHalo() {
		return halo;
	}
	public void setHalo(String halo) {
		this.halo = halo;
	}
	public int getIsUpdate() {
		return isUpdate;
	}
	public void setIsUpdate(int isUpdate) {
		this.isUpdate = isUpdate;
	} 
}
