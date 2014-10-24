package com.stang.game.entity;

import java.util.Date;

/**
 * @author fei_wei
 * @company 上海三唐信息科技有限公司
 * @description 自动化主键ID值
 */
public class Statetostate implements Cloneable{
	@Override
	public Object clone() throws CloneNotSupportedException {
		// 实现clone方法
		return super.clone();
	}
	//缓存中确定是否更新，插入，删除字段。默认：0；更新：1；插入：2；删除：3.
	private int isUpdate;
	
	
	private Integer id; /* 主键，自动增长 */
	private Integer source; /* 触发者roleid */
	private Integer receiver; /*接收者roleid */
	private Integer type; /*数据类型(1:request数据；2freegift数据)*/
	private Integer itemid; /*礼品的id */
	private String describe; /* 描述语言 */
	private Integer statue;//数据处理状态（0：未处理数据；1：接受处理；2：拒绝处理）
	private long time;//数据产生时间
	private Integer flag;//数据是否可用(1：可用；0：不可用）


	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSource() {
		return source;
	}

	public void setSource(Integer source) {
		this.source = source;
	}

	public Integer getReceiver() {
		return receiver;
	}

	public void setReceiver(Integer receiver) {
		this.receiver = receiver;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getItemid() {
		return itemid;
	}

	public void setItemid(Integer itemid) {
		this.itemid = itemid;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public Integer getStatue() {
		return statue;
	}

	public void setStatue(Integer statue) {
		this.statue = statue;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public int getIsUpdate() {
		return isUpdate;
	}

	public void setIsUpdate(int isUpdate) {
		this.isUpdate = isUpdate;
	}
	public String toString(){
		return "\nid:" + this.id + " statue:" + this.statue + " time:" + this.time;
	}
}
