package com.stang.game.ffd.entity.detail;

import com.stang.game.ffd.entity.EntityCaseDateEx;

public class EntityCaseDateExDetail implements EntityCaseDateEx {
	protected String case_time;
	protected String table_name;
	public String getCase_time() {
		return case_time;
	}
	public void setCase_time(String case_time) {
		this.case_time = case_time;
	}
	public String getTable_name() {
		return table_name;
	}
	public void setTable_name(String table_name) {
		this.table_name = table_name;
	}
}
