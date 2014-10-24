package com.stang.game.ffd.entity.detail;

import java.util.Date;

import com.stang.game.ffd.entity.EntityRoleConsortia;

/**
 * @author jianbo.feng
 * @company 上海三唐信息科技有限公司
 * @description 角色-公会信息  
 */
public class EntityRoleConsortiaDetail implements EntityRoleConsortia {

	private Integer id;		/*序列号*/
	private Integer roleId;	/*角色序列号*/
	private Integer consortiaId;	/*公会序列号*/
	private Integer donateCoinAll;	/*总捐赠金币数目*/
	private Integer donateCoinLately;	/*最近一次捐赠金币数目*/
	private Date donateCoinLatelyTime;	/*最近一次捐赠金币时间*/
	private Integer consortiaPoint;		/*累计公会贡献度/累计公会积分(或经验)*/
	private String nickname;		/*昵称(比如可以设置自己在公会中的昵称为''无敌''之类)*/
	private Date createTime;/*信息录入时间*/
	private Integer flag;	/*信息标识位,默认值为1(-1,删除;0,隐藏/(待批准或申请状态) ;1,正常;2;招募中或被招募中)*/
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public Integer getConsortiaId() {
		return consortiaId;
	}
	public void setConsortiaId(Integer consortiaId) {
		this.consortiaId = consortiaId;
	}
	public Integer getDonateCoinAll() {
		return donateCoinAll;
	}
	public void setDonateCoinAll(Integer donateCoinAll) {
		this.donateCoinAll = donateCoinAll;
	}
	public Integer getDonateCoinLately() {
		return donateCoinLately;
	}
	public void setDonateCoinLately(Integer donateCoinLately) {
		this.donateCoinLately = donateCoinLately;
	}
	public Date getDonateCoinLatelyTime() {
		return donateCoinLatelyTime;
	}
	public void setDonateCoinLatelyTime(Date donateCoinLatelyTime) {
		this.donateCoinLatelyTime = donateCoinLatelyTime;
	}
	public Integer getConsortiaPoint() {
		return consortiaPoint;
	}
	public void setConsortiaPoint(Integer consortiaPoint) {
		this.consortiaPoint = consortiaPoint;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
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
	
	
	
}
