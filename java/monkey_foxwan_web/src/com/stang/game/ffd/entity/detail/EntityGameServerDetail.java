package com.stang.game.ffd.entity.detail;

import java.util.Date;

/**
 * @author jianbo.feng
 * @company 上海三唐信息科技有限公司
 * @description 游戏服务器信息  
 */
public class EntityGameServerDetail {

	private Integer id;		/*序列号*/
	private String serverName;	/*服务器名称*/
	private String serverHost;	/*服务器主机IP地址*/
	private String serverPort;	/*服务器端口*/
	private Integer serverType;	/*服务器类型(1:双线;2:网通;3:电信;4:移动)默认值:1*/
	private String serverKey;	/*服务器访问KEY*/
	private Integer maxPlayerNum;	/*最大玩家数量*/
	private Integer maintainCycle;	/*维护时间*/
	private Date createTime;	/*信息录入时间*/
	private Integer flag;		/*信息标识位,默认值为1(-1,删除;0,隐藏;1,正常;)*/
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getServerName() {
		return serverName;
	}
	public void setServerName(String serverName) {
		this.serverName = serverName;
	}
	public String getServerHost() {
		return serverHost;
	}
	public void setServerHost(String serverHost) {
		this.serverHost = serverHost;
	}
	public String getServerPort() {
		return serverPort;
	}
	public void setServerPort(String serverPort) {
		this.serverPort = serverPort;
	}
	public Integer getServerType() {
		return serverType;
	}
	public void setServerType(Integer serverType) {
		this.serverType = serverType;
	}
	public String getServerKey() {
		return serverKey;
	}
	public void setServerKey(String serverKey) {
		this.serverKey = serverKey;
	}
	public Integer getMaxPlayerNum() {
		return maxPlayerNum;
	}
	public void setMaxPlayerNum(Integer maxPlayerNum) {
		this.maxPlayerNum = maxPlayerNum;
	}
	public Integer getMaintainCycle() {
		return maintainCycle;
	}
	public void setMaintainCycle(Integer maintainCycle) {
		this.maintainCycle = maintainCycle;
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
