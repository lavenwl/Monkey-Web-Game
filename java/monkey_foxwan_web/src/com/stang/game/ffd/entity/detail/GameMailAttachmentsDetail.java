package com.stang.game.ffd.entity.detail;
/**
 * @author jianbo.feng
 * @company 上海三唐信息科技有限公司 
 * @description 游戏邮件附件信息
 */
public class GameMailAttachmentsDetail {

	private Integer id;			//邮件附件信息序号
	private Integer mailId;		//邮件序号
	private Integer attType;	//附件类型(0:金币，1：飞机，2：装备;3：战斗型道具;4：Avatar)
	private Integer attResId;	//附件资源序号(如果为金币类型的附件,此字段值为0)
	private Integer attResNum;	//资源的数量
	private Integer flag;		//信息标识位(-1,删除;0,未打开;1,已打开)
	private Integer isBase;		//attResId是否为模型序号（0：否，1：是）
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getMailId() {
		return mailId;
	}
	public void setMailId(Integer mailId) {
		this.mailId = mailId;
	}
	public Integer getAttType() {
		return attType;
	}
	public void setAttType(Integer attType) {
		this.attType = attType;
	}
	public Integer getAttResId() {
		return attResId;
	}
	public void setAttResId(Integer attResId) {
		this.attResId = attResId;
	}
	public Integer getAttResNum() {
		return attResNum;
	}
	public void setAttResNum(Integer attResNum) {
		this.attResNum = attResNum;
	}
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	public Integer getIsBase() {
		return isBase;
	}
	public void setIsBase(Integer isBase) {
		this.isBase = isBase;
	}
}
