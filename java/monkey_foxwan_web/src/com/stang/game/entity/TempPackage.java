package com.stang.game.entity;

public class TempPackage {

	private Integer id;/* 序列号 */
	private Integer mId;/* 模型Id */
	private Integer typeId;/* 主类型 */
	private Integer pId;/* 玩家id */
	private Integer flag;/* 标识 */
	private Integer num;
	private long time;

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMId() {
		return mId;
	}

	public void setMId(Integer id) {
		mId = id;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public Integer getPId() {
		return pId;
	}

	public void setPId(Integer id) {
		pId = id;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

}
