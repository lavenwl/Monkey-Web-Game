package com.stang.game.entity;

import java.util.Date;

/**
 * @author fei_wei
 * @company 上海三唐信息科技有限公司
 * @description 自动化主键ID值
 */
public class AutoId implements Cloneable{
	@Override
	public Object clone() throws CloneNotSupportedException {
		// 实现clone方法
		return super.clone();
	}
	//缓存中确定是否更新，插入，删除字段。默认：0；更新：1；插入：2；删除：3.
	private int isUpdate;
	
	private Integer id; /* 主键，自动增长 */
	private String tableName; /* 表名 */
	private String keyName; /* 主键名 */
	private Integer keyValue; /* 主键值 */
	private Date createTime; /* 信息录入时间 */
	private Integer flag; /* 信息标识位(-1,删除;0,隐藏;1,正常;) */

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getKeyName() {
		return keyName;
	}

	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}

	public Integer getKeyValue() {
		return keyValue;
	}

	public void setKeyValue(Integer keyValue) {
		this.keyValue = keyValue;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public int getIsUpdate() {
		return isUpdate;
	}

	public void setIsUpdate(int isUpdate) {
		this.isUpdate = isUpdate;
	}

}
