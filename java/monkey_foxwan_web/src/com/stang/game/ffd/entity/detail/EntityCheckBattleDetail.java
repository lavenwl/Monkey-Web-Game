package com.stang.game.ffd.entity.detail;

public class EntityCheckBattleDetail {
	private String datetime;//时间
	private int roomNum;//房间号
	private int roomType;//房间类型 1自由组队 2撮合 3pve
	private int battleType;//战斗类型 战斗类型，游击战传1，非游击战传2
	private long startTime;//开始时间
	private long endTime;//结束时间
	private int playerCount;//玩家数量
	private int mapId;//地图编号
	private String teamA;//A队伍
	private String teamB;//b队伍
	private String winTeam;//获胜队伍
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	public int getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}
	public int getRoomType() {
		return roomType;
	}
	public void setRoomType(int roomType) {
		this.roomType = roomType;
	}
	public int getBattleType() {
		return battleType;
	}
	public void setBattleType(int battleType) {
		this.battleType = battleType;
	}
	public long getStartTime() {
		return startTime;
	}
	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}
	public long getEndTime() {
		return endTime;
	}
	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}
	public int getPlayerCount() {
		return playerCount;
	}
	public void setPlayerCount(int playerCount) {
		this.playerCount = playerCount;
	}
	public int getMapId() {
		return mapId;
	}
	public void setMapId(int mapId) {
		this.mapId = mapId;
	}
	public String getTeamA() {
		return teamA;
	}
	public void setTeamA(String teamA) {
		this.teamA = teamA;
	}
	public String getTeamB() {
		return teamB;
	}
	public void setTeamB(String teamB) {
		this.teamB = teamB;
	}
	public String getWinTeam() {
		return winTeam;
	}
	public void setWinTeam(String winTeam) {
		this.winTeam = winTeam;
	}
	
}
