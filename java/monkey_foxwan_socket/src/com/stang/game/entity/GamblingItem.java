package com.stang.game.entity;

public class GamblingItem implements Cloneable{
	@Override
	public Object clone() throws CloneNotSupportedException {
		// 实现clone方法
		return super.clone();
	}
	//缓存中确定是否更新，插入，删除字段。默认：0；更新：1；插入：2；删除：3.
	private int isUpdate;
	
	// 抽奖系统所有物品信息
	private Integer id;/* 序列号 */
	private Integer mId/* 模型ID */;
	private Integer typeId;/* 主类型 */
	private Integer cost;/* 费用 */
	private Integer isRare;/* 是否是稀有 */
	private Integer rareNum;/* 每日稀有数量 */
	private Integer rareNumNow;/* 当前剩余稀有数量 */
	private Integer flag;
	private Integer isShow;/* 是否显示 */
	private Integer type;/* 初级 高级 中级 */

	public Integer getIsShow() {
		return isShow;
	}

	public void setIsShow(Integer isShow) {
		this.isShow = isShow;
	}

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

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

	public Integer getIsRare() {
		return isRare;
	}

	public void setIsRare(Integer isRare) {
		this.isRare = isRare;
	}

	public Integer getRareNum() {
		return rareNum;
	}

	public void setRareNum(Integer rareNum) {
		this.rareNum = rareNum;
	}

	public Integer getRareNumNow() {
		return rareNumNow;
	}

	public void setRareNumNow(Integer rareNumNow) {
		this.rareNumNow = rareNumNow;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public int getIsUpdate() {
		return isUpdate;
	}

	public void setIsUpdate(int isUpdate) {
		this.isUpdate = isUpdate;
	}

}
