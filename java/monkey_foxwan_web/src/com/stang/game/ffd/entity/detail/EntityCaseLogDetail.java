package com.stang.game.ffd.entity.detail;

import com.stang.game.ffd.entity.EntityCaseLog;
import java.sql.Timestamp;

public class EntityCaseLogDetail implements EntityCaseLog {
	protected int id;
	protected int server_id;
	protected int user_id;
	protected Timestamp case_time;
	protected int case_id;
	protected String case_ex_desc;
	protected int flag;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getServer_id() {
		return server_id;
	}
	public void setServer_id(int server_id) {
		this.server_id = server_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public Timestamp getCase_time() {
		return case_time;
	}
	public void setCase_time(Timestamp case_time) {
		this.case_time = case_time;
	}
	public int getCase_id() {
		return case_id;
	}
	public void setCase_id(int case_id) {
		this.case_id = case_id;
	}
	public String getCase_ex_desc() {
		return case_ex_desc;
	}
	public void setCase_ex_desc(String case_ex_desc) {
		this.case_ex_desc = case_ex_desc;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
}
