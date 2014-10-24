package com.stang.game.ffd.entity.detail;

public class GameRaceBattleDetail {
	private Integer id;
	private Integer raceId;
	private String teams1;
	private String teams2;
	private Integer win;
	private Integer num;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getRaceId() {
		return raceId;
	}
	public void setRaceId(Integer raceId) {
		this.raceId = raceId;
	}
	public String getTeams1() {
		return teams1;
	}
	public void setTeams1(String teams1) {
		this.teams1 = teams1;
	}
	public String getTeams2() {
		return teams2;
	}
	public void setTeams2(String teams2) {
		this.teams2 = teams2;
	}
	public Integer getWin() {
		return win;
	}
	public void setWin(Integer win) {
		this.win = win;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	
}
