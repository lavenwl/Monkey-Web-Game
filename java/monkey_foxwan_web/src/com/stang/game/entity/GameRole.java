package com.stang.game.entity;

public class GameRole {
	private int id;
	private String name;
	private int level;
	private int exp;
	private int coin;
	private int yin;
	private int placeid;
	private int mapid;
	private int gongxun;
	private int flag;
	private int needexp;
	private int vip;
	private int junling;// 开始游戏，增加军令字段
	private long jltime;
	private long tasktime;// 用户登录的时间
	private String state;
	private String stateseven;
	private long refertime;
	private String supsign;
	private String daynumstate;
	private int coinspend;
	private int mapid2;
	private int placeid2;
	private int signjl;
	private long nowtime;
	private int num;// 妖牌数量
	private int day;// 零点更新使用妖牌数量0
	private int challengenum;
	private long challengetime;
	private int integral;
	private int helpstep;
	private int roleline;
	private int huangzuan;
	private String huangzuaninfo;
	private int invite;
	private String ids;
	private String yesterday;
	private String today;
	private int live;
	private int huangzuangift;
	private String friends;
	private int vips;
	private int imposenum;
	private int share;

	public int getShare() {
		return share;
	}

	public void setShare(int share) {
		this.share = share;
	}

	public int getImposenum() {
		return imposenum;
	}

	public void setImposenum(int imposenum) {
		this.imposenum = imposenum;
	}

	public int getVips() {
		return vips;
	}

	public void setVips(int vips) {
		this.vips = vips;
	}

	public String getFriends() {
		return friends;
	}

	public void setFriends(String friends) {
		this.friends = friends;
	}

	public int getHuangzuangift() {
		return huangzuangift;
	}

	public void setHuangzuangift(int huangzuangift) {
		this.huangzuangift = huangzuangift;
	}

	public int getLive() {
		return live;
	}

	public void setLive(int live) {
		this.live = live;
	}

	public String getHuangzuaninfo() {
		return huangzuaninfo;
	}

	public void setHuangzuaninfo(String huangzuaninfo) {
		this.huangzuaninfo = huangzuaninfo;
	}

	public int getHuangzuan() {
		return huangzuan;
	}

	public void setHuangzuan(int huangzuan) {
		this.huangzuan = huangzuan;
	}

	public int getHelpstep() {
		return helpstep;
	}

	public int getRoleline() {
		return roleline;
	}

	public void setRoleline(int roleline) {
		this.roleline = roleline;
	}

	public void setHelpstep(int helpstep) {
		this.helpstep = helpstep;
	}

	public int getIntegral() {
		return integral;
	}

	public void setIntegral(int integral) {
		this.integral = integral;
	}

	public int getChallengenum() {
		return challengenum;
	}

	public void setChallengenum(int challengenum) {
		this.challengenum = challengenum;
	}

	public long getChallengetime() {
		return challengetime;
	}

	public void setChallengetime(long challengetime) {
		this.challengetime = challengetime;
	}

	public long getNowtime() {
		return nowtime;
	}

	public void setNowtime(long nowtime) {
		this.nowtime = nowtime;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getSignjl() {
		return signjl;
	}

	public void setSignjl(int signjl) {
		this.signjl = signjl;
	}

	public int getMapid2() {
		return mapid2;
	}

	public void setMapid2(int mapid2) {
		this.mapid2 = mapid2;
	}

	public int getPlaceid2() {
		return placeid2;
	}

	public void setPlaceid2(int placeid2) {
		this.placeid2 = placeid2;
	}

	public String getSupsign() {
		return supsign;
	}

	public void setSupsign(String supsign) {
		this.supsign = supsign;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public long getJltime() {
		return jltime;
	}

	public void setJltime(long jltime) {
		this.jltime = jltime;
	}

	public int getJunling() {
		return junling;
	}

	public void setJunling(int junling) {
		this.junling = junling;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public int getCoin() {
		return coin;
	}

	public void setCoin(int coin) {
		this.coin = coin;
	}

	public int getYin() {
		return yin;
	}

	public void setYin(int yin) {
		this.yin = yin;
	}

	public int getGongxun() {
		return gongxun;
	}

	public void setGongxun(int gongxun) {
		this.gongxun = gongxun;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public int getPlaceid() {
		return placeid;
	}

	public void setPlaceid(int placeid) {
		this.placeid = placeid;
	}

	public int getMapid() {
		return mapid;
	}

	public void setMapid(int mapid) {
		this.mapid = mapid;
	}

	public int getNeedexp() {
		return needexp;
	}

	public void setNeedexp(int needexp) {
		this.needexp = needexp;
	}

	public int getVip() {
		return vip;
	}

	public void setVip(int vip) {
		this.vip = vip;
	}

	public long getTasktime() {
		return tasktime;
	}

	public void setTasktime(long tasktime) {
		this.tasktime = tasktime;
	}

	public String getStateseven() {
		return stateseven;
	}

	public void setStateseven(String stateseven) {
		this.stateseven = stateseven;
	}

	public String getDaynumstate() {
		return daynumstate;
	}

	public void setDaynumstate(String daynumstate) {
		this.daynumstate = daynumstate;
	}

	public long getRefertime() {
		return refertime;
	}

	public void setRefertime(long refertime) {
		this.refertime = refertime;
	}

	public int getCoinspend() {
		return coinspend;
	}

	public void setCoinspend(int coinspend) {
		this.coinspend = coinspend;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public String getYesterday() {
		return yesterday;
	}

	public void setYesterday(String yesterday) {
		this.yesterday = yesterday;
	}

	public String getToday() {
		return today;
	}

	public void setToday(String today) {
		this.today = today;
	}

	public int getInvite() {
		return invite;
	}

	public void setInvite(int invite) {
		this.invite = invite;
	}


}
