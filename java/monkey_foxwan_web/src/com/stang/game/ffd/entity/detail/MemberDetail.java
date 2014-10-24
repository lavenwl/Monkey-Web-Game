package com.stang.game.ffd.entity.detail;

/**
 * @author jianbo.feng
 * @company 上海三唐信息科技有限公司
 * @description 会员信息  
 */
public class MemberDetail {

	private Integer id;			/*序列号*/
	private String memberName;	/*会员姓名*/
	private String memberPassword;	/*会员密码(MD5加密)*/
	private String memberPasswordOrig;/*会员原始密码*/
	private Integer memberSex;		/*会员性别*/
	private String memberEmail;		/*会员邮箱(唯一,用于密码找回)*/
	private String memberIdCard;	/*身份证号码*/
	private Integer flag;		/*信息标识位,默认值为1(-1,删除;0,隐藏;1,正常;)*/
	private Integer fatigue;    /*是否防沉迷 0/yes,1/no*/
	private String memberTrueName;
	private String crateTime;
	public String getMemberTrueName() {
		return memberTrueName;
	}
	public void setMemberTrueName(String memberTrueName) {
		this.memberTrueName = memberTrueName;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberPassword() {
		return memberPassword;
	}
	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}
	public String getMemberPasswordOrig() {
		return memberPasswordOrig;
	}
	public void setMemberPasswordOrig(String memberPasswordOrig) {
		this.memberPasswordOrig = memberPasswordOrig;
	}
	public Integer getMemberSex() {
		return memberSex;
	}
	public void setMemberSex(Integer memberSex) {
		this.memberSex = memberSex;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public String getMemberIdCard() {
		return memberIdCard;
	}
	public void setMemberIdCard(String memberIdCard) {
		this.memberIdCard = memberIdCard;
	}
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	public Integer getFatigue() {
		return fatigue;
	}
	public void setFatigue(Integer fatigue) {
		this.fatigue = fatigue;
	}
	public String getCrateTime() {
		return crateTime;
	}
	public void setCrateTime(String crateTime) {
		this.crateTime = crateTime;
	}
	
	
}
