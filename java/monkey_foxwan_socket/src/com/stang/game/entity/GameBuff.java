package com.stang.game.entity;

public class GameBuff implements Cloneable{
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// 实现clone方法
		return super.clone();
	}
	//缓存中确定是否更新，插入，删除字段。默认：0；更新：1；插入：2；删除：3.
	private int isUpdate;
	
	private int id;
	private String name; 
	private String buffDip;
	private int type;
	private int buffAtktime;
	private long buffKeeptime;
	private int atkperson;
	private int bufftype;
	private int bufftime;
	private int flag;
	private int buffobj;
	private int speed;
	private int attack;
	private int health;
	private int miss;
	private int baoji;
	
	public int getBufftype() {
		return bufftype;
	}
	public void setBufftype(int bufftype) {
		this.bufftype = bufftype;
	}
	public int getBufftime() {
		return bufftime;
	}
	public void setBufftime(int bufftime) {
		this.bufftime = bufftime;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
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
	public String getBuffDip() {
		return buffDip;
	}
	public void setBuffDip(String buffDip) {
		this.buffDip = buffDip;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}

	public int getBuffAtktime() {
		return buffAtktime;
	}
	public void setBuffAtktime(int buffAtktime) {
		this.buffAtktime = buffAtktime;
	}
	public long getBuffKeeptime() {
		return buffKeeptime;
	}
	public void setBuffKeeptime(long buffKeeptime) {
		this.buffKeeptime = buffKeeptime;
	}
	public int getAtkperson() {
		return atkperson;
	}
	public void setAtkperson(int atkperson) {
		this.atkperson = atkperson;
	}
	public int getBuffobj() {
		return buffobj;
	}
	public void setBuffobj(int buffobj) {
		this.buffobj = buffobj;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getAttack() {
		return attack;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getMiss() {
		return miss;
	}
	public void setMiss(int miss) {
		this.miss = miss;
	}
	public int getBaoji() {
		return baoji;
	}
	public void setBaoji(int baoji) {
		this.baoji = baoji;
	}
	public int getIsUpdate() {
		return isUpdate;
	}
	public void setIsUpdate(int isUpdate) {
		this.isUpdate = isUpdate;
	}
	 
}
