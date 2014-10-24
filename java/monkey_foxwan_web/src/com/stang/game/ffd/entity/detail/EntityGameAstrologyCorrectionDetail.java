package com.stang.game.ffd.entity.detail;

public class EntityGameAstrologyCorrectionDetail {
    private int Correction_id;
    private int Correction_lv;//** 修正值的等级
    private float Correction_value; //** 修正值的具体参数
    private int Flag;
	public int getCorrection_id() {
		return Correction_id;
	}
	public void setCorrection_id(int correction_id) {
		Correction_id = correction_id;
	}
	public int getCorrection_lv() {
		return Correction_lv;
	}
	public void setCorrection_lv(int correction_lv) {
		Correction_lv = correction_lv;
	}
	public float getCorrection_value() {
		return Correction_value;
	}
	public void setCorrection_value(float correction_value) {
		Correction_value = correction_value;
	}
	public int getFlag() {
		return Flag;
	}
	public void setFlag(int flag) {
		Flag = flag;
	}
}
