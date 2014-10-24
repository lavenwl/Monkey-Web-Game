package com.stang.game.ffd.entity.detail;

import java.util.Date;

public class GMRejectIpsDetail {
	private Integer id;
	private String startIp;
	private String endIp;
	private Long startIpNum;
	private Long endIpNum;
	private Date startTime;
	private Date overTime;
	private Integer flag;

	public void setStartIpNum(Long startIpNum) {
		this.startIpNum = startIpNum;
	}

	public void setEndIpNum(Long endIpNum) {
		this.endIpNum = endIpNum;
	}

	public String getStartIp() {
		return startIp;
	}

	public void setStartIp(String startIp) {
		this.startIp = startIp;
	}

	public String getEndIp() {
		return endIp;
	}

	public void setEndIp(String endIp) {
		this.endIp = endIp;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getOverTime() {
		return overTime;
	}

	public void setOverTime(Date overTime) {
		this.overTime = overTime;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public Long getStartIpNum() {
		return startIpNum;
	}

	public Long getEndIpNum() {
		return endIpNum;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
