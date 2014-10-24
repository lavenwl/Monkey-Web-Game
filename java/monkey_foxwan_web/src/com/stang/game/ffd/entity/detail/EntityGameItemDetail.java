package com.stang.game.ffd.entity.detail;

public class EntityGameItemDetail {
	protected String date;//时间
	protected int rmbItem;	//rmb销售次数
	protected int intensify;	//强化次数
	protected int synthesis;	//合成次数
	protected int synthesisItem;	//合成物品
	public int getRmbItem() {
		return rmbItem;
	}
	public void setRmbItem(int rmbItem) {
		this.rmbItem = rmbItem;
	}
	public int getIntensify() {
		return intensify;
	}
	public void setIntensify(int intensify) {
		this.intensify = intensify;
	}
	public int getSynthesis() {
		return synthesis;
	}
	public void setSynthesis(int synthesis) {
		this.synthesis = synthesis;
	}
	public int getSynthesisItem() {
		return synthesisItem;
	}
	public void setSynthesisItem(int synthesisItem) {
		this.synthesisItem = synthesisItem;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}
