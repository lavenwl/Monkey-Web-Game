package com.stang.game.ffd.entity.detail;

import java.util.Date;

/**
 * @author jianbo.feng
 * @company 上海三唐信息科技有限公司 
 * @description 游戏邮件信息
 */
public class GameMailDetail {

	private Integer id;			//序列号
	private String mailTitle;	//邮件标题
	private String mailContent;	//邮件文字内容
	private Integer sender;		//发送者序号
	private Integer receiver;	//接受者序号
	private Integer fee;		//费用(由收件人付费,即从收件人所拥有金钱中扣除)
	private Date sendTime;		//发送时间
	private Date openTime;		//打开时间
	private Integer flag;		//信息标识位(-1,删除;0,未打开;1,已打开;)
	private Integer isGold;		//费用是否为金币(0,金钱/点卷;1,金币),默认值1,已收取费用 ：3
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMailTitle() {
		return mailTitle;
	}
	public void setMailTitle(String mailTitle) {
		this.mailTitle = mailTitle;
	}
	public String getMailContent() {
		return mailContent;
	}
	public void setMailContent(String mailContent) {
		this.mailContent = mailContent;
	}
	public Integer getSender() {
		return sender;
	}
	public void setSender(Integer sender) {
		this.sender = sender;
	}
	public Integer getReceiver() {
		return receiver;
	}
	public void setReceiver(Integer receiver) {
		this.receiver = receiver;
	}
	public Integer getFee() {
		return fee;
	}
	public void setFee(Integer fee) {
		this.fee = fee;
	}
	public Date getSendTime() {
		return sendTime;
	}
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}
	public Date getOpenTime() {
		return openTime;
	}
	public void setOpenTime(Date openTime) {
		this.openTime = openTime;
	}
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	public Integer getIsGold() {
		return isGold;
	}
	public void setIsGold(Integer isGold) {
		this.isGold = isGold;
	}
}
