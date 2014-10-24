package com.stang.game.ffd.entity.detail;

public class GameRaceGiftDetail {
	private Integer raceId;
	private Integer winNum;
	private String winGiftParams;
	private String title;
	private String content;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getRaceId() {
		return raceId;
	}
	public void setRaceId(Integer raceId) {
		this.raceId = raceId;
	}
	public Integer getWinNum() {
		return winNum;
	}
	public void setWinNum(Integer winNum) {
		this.winNum = winNum;
	}
	public String getWinGiftParams() {
		return winGiftParams;
	}
	public void setWinGiftParams(String winGiftParams) {
		this.winGiftParams = winGiftParams;
	}
}
