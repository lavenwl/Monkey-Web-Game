package com.stang.game.ffd.entity.detail;

public class EntityCaseInfoDetail {
	private int id;
	private int lag_type;
	private String lag_info;
	private String lag_time;
	private int flag;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getLag_type() {
		return lag_type;
	}
	public void setLag_type(int lag_type) {
		this.lag_type = lag_type;
	}
	public String getLag_info() {
		return lag_info;
	}
	public void setLag_info(String lag_info) {
		this.lag_info = lag_info;
	}
	public String getLag_time() {
		return lag_time;
	}
	public void setLag_time(String lag_time) {
		this.lag_time = lag_time;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
}
