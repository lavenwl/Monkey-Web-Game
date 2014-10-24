package com.stang.game.ffd.entity.detail;

import com.stang.game.ffd.entity.EntityCaseType;

public class EntityCaseTypeDetail implements EntityCaseType {
	protected int type_id;
	protected String type_desc;
	public int getType_id() {
		return type_id;
	}
	public void setType_id(int type_id) {
		this.type_id = type_id;
	}
	public String getType_desc() {
		return type_desc;
	}
	public void setType_desc(String type_desc) {
		this.type_desc = type_desc;
	}
}
