package com.stang.game.entity;

public class GameRole implements Cloneable{
	@Override
	public Object clone() throws CloneNotSupportedException {
		// 实现clone方法
		return super.clone();
	}
	//缓存中确定是否更新，插入，删除字段。默认：0；更新：1；插入：2；删除：3.
	private int isUpdate;
	private int jiaqunlingjiang;
	public int getJiaqunlingjiang() {
		return jiaqunlingjiang;
	}

	public void setJiaqunlingjiang(int jiaqunlingjiang) {
		this.jiaqunlingjiang = jiaqunlingjiang;
	}
	private int id;
	private String groupopenid;
	private int groupactive;
	public String getGroupopenid() {
		return groupopenid;
	}

	public void setGroupopenid(String groupopenid) {
		this.groupopenid = groupopenid;
	}

	public int getGroupactive() {
		return groupactive;
	}

	public void setGroupactive(int groupactive) {
		this.groupactive = groupactive;
	}
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
	private String helpstep;
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
	private long onlinetime;
	private String exist;
	private String three;
	private String bylevel;
	private String vipGift;
	private String vipTime;
	private int zhuxianling;
	private String friendlevel;
	private String friendcost;
	private String friendlevelnum;
	private String friendcostnum;
	private String serverId;
	private String activitytype;
	private String isnew;
	private int daycoin;
	private int bmap;
	private int fuben;
	private long btime;
	private long zxtime;
	private int jingji;
	private long jjtime;
	private int jjnum;
	private int jjstatus;
	private int flaunt;
	private int flauntgift;
	private int challenge;
	private int challengegift;
	private int sharedemo;
	private int sharedemogift;
	private int fdshare;
	private int fdsharegift;
	private int allfdgift;
	private String activitygift;
	private int oldfriend;
    private String idsold;
    private String oldfriendgift;
    private int fubentwo;
    private String totem;
    private String buyitem;
    private int fubenthree;
    private String compensate;
    private String qcost;
    private String openmountain;
    private String flushmountain;
    
    private String alchemygift;
    private int temperature;
    private String fundsgift;
    private int fundslevel;
    private int fundsstatu;
    private String seventotal;
    private String aimreward;
    private int getreward;
    private String awakenstatu;
    private int mohun;
    private int mohunboolean;
    private int deskcheck;
    private int stsnum;
    private int stsdnum;
    private String stsfriend;
    private String getcdk;
	private int milluck;//武将幸运度
	private int zillionaireplace;//大富翁棋子位置

	public int getZillionaireplace() {
		return zillionaireplace;
	}

	public void setZillionaireplace(int zillionaireplace) {
		this.zillionaireplace = zillionaireplace;
	}
	
	public int getMilluck() {
		return milluck;
	}

	public void setMilluck(int milluck) {
		this.milluck = milluck;
	}
	public String getGetcdk() {
		return getcdk;
	}

	public void setGetcdk(String getcdk) {
		this.getcdk = getcdk;
	}

	public String getStsfriend() {
		return stsfriend;
	}

	public void setStsfriend(String stsfriend) {
		this.stsfriend = stsfriend;
	}

	public int getStsnum() {
		return stsnum;
	}

	public void setStsnum(int stsnum) {
		this.stsnum = stsnum;
	}

	public int getStsdnum() {
		return stsdnum;
	}

	public void setStsdnum(int stsdnum) {
		this.stsdnum = stsdnum;
	}

	public int getDeskcheck() {
		return deskcheck;
	}

	public void setDeskcheck(int deskcheck) {
		this.deskcheck = deskcheck;
	}

	public int getMohunboolean() {
		return mohunboolean;
	}

	public void setMohunboolean(int mohunboolean) {
		this.mohunboolean = mohunboolean;
	}

	public int getMohun() {
		return mohun;
	}

	public void setMohun(int mohun) {
		this.mohun = mohun;
	}

	public String getAwakenstatu() {
		return awakenstatu;
	}

	public void setAwakenstatu(String awakenstatu) {
		this.awakenstatu = awakenstatu;
	}

	public int getGetreward() {
		return getreward;
	}

	public void setGetreward(int getreward) {
		this.getreward = getreward;
	}

	public String getAimreward() {
		return aimreward;
	}

	public void setAimreward(String aimreward) {
		this.aimreward = aimreward;
	}

	public String getSeventotal() {
		return seventotal;
	}

	public void setSeventotal(String seventotal) {
		this.seventotal = seventotal;
	}

	public int getFundsstatu() {
		return fundsstatu;
	}

	public void setFundsstatu(int fundsstatu) {
		this.fundsstatu = fundsstatu;
	}

	public String getFundsgift() {
		return fundsgift;
	}

	public void setFundsgift(String fundsgift) {
		this.fundsgift = fundsgift;
	}

	public int getFundslevel() {
		return fundslevel;
	}

	public void setFundslevel(int fundslevel) {
		this.fundslevel = fundslevel;
	}

	public String getAlchemygift() {
		return alchemygift;
	}

	public void setAlchemygift(String alchemygift) {
		this.alchemygift = alchemygift;
	}

	public int getTemperature() {
		return temperature;
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}

	public String getFlushmountain() {
		return flushmountain;
	}

	public void setFlushmountain(String flushmountain) {
		this.flushmountain = flushmountain;
	}

	public String getOpenmountain() {
		return openmountain;
	}

	public void setOpenmountain(String openmountain) {
		this.openmountain = openmountain;
	}

	public String getQcost() {
		return qcost;
	}

	public void setQcost(String qcost) {
		this.qcost = qcost;
	}

	public String getCompensate() {
		return compensate;
	}

	public void setCompensate(String compensate) {
		this.compensate = compensate;
	}

	public int getFubenthree() {
		return fubenthree;
	}

	public void setFubenthree(int fubenthree) {
		this.fubenthree = fubenthree;
	}

	public String getBuyitem() {
		return buyitem;
	}

	public void setBuyitem(String buyitem) {
		this.buyitem = buyitem;
	}

	public String getTotem() {
		return totem;
	}

	public void setTotem(String totem) {
		this.totem = totem;
	}

	public int getFubentwo() {
		return fubentwo;
	}

	public void setFubentwo(int fubentwo) {
		this.fubentwo = fubentwo;
	}

	public String getOldfriendgift() {
		return oldfriendgift;
	}

	public void setOldfriendgift(String oldfriendgift) {
		this.oldfriendgift = oldfriendgift;
	}

	public String getIdsold() {
		return idsold;
	}

	public void setIdsold(String idsold) {
		this.idsold = idsold;
	}

	public int getOldfriend() {
		return oldfriend;
	}

	public void setOldfriend(int oldfriend) {
		this.oldfriend = oldfriend;
	}

	public String getActivitygift() {
		return activitygift;
	}

	public void setActivitygift(String activitygift) {
		this.activitygift = activitygift;
	}

	public int getAllfdgift() {
		return allfdgift;
	}

	public void setAllfdgift(int allfdgift) {
		this.allfdgift = allfdgift;
	}

	public int getFlaunt() {
		return flaunt;
	}

	public void setFlaunt(int flaunt) {
		this.flaunt = flaunt;
	}

	public int getFlauntgift() {
		return flauntgift;
	}

	public void setFlauntgift(int flauntgift) {
		this.flauntgift = flauntgift;
	}

	public int getChallenge() {
		return challenge;
	}

	public void setChallenge(int challenge) {
		this.challenge = challenge;
	}

	public int getChallengegift() {
		return challengegift;
	}

	public void setChallengegift(int challengegift) {
		this.challengegift = challengegift;
	}

	public int getSharedemo() {
		return sharedemo;
	}

	public void setSharedemo(int sharedemo) {
		this.sharedemo = sharedemo;
	}

	public int getSharedemogift() {
		return sharedemogift;
	}

	public void setSharedemogift(int sharedemogift) {
		this.sharedemogift = sharedemogift;
	}

	public int getFdshare() {
		return fdshare;
	}

	public void setFdshare(int fdshare) {
		this.fdshare = fdshare;
	}

	public int getFdsharegift() {
		return fdsharegift;
	}

	public void setFdsharegift(int fdsharegift) {
		this.fdsharegift = fdsharegift;
	}

	public int getJjstatus() {
		return jjstatus;
	}

	public void setJjstatus(int jjstatus) {
		this.jjstatus = jjstatus;
	}

	public int getJjnum() {
		return jjnum;
	}

	public void setJjnum(int jjnum) {
		this.jjnum = jjnum;
	}

	public long getBtime() {
		return btime;
	}

	public void setBtime(long btime) {
		this.btime = btime;
	}

	public int getFuben() {
		return fuben;
	}

	public void setFuben(int fuben) {
		this.fuben = fuben;
	}

	public int getBmap() {
		return bmap;
	}

	public void setBmap(int bmap) {
		this.bmap = bmap;
	}

	public int getDaycoin() {
		return daycoin;
	}

	public void setDaycoin(int daycoin) {
		this.daycoin = daycoin;
	}
	
	public String getFriendlevelnum() {
		return friendlevelnum;
	}
	public void setFriendlevelnum(String friendlevelnum) {
		this.friendlevelnum = friendlevelnum;
	}
	public String getFriendcostnum() {
		return friendcostnum;
	}
	public void setFriendcostnum(String friendcostnum) {
		this.friendcostnum = friendcostnum;
	}

	public String getFriendlevel() {
		return friendlevel;
	}
	public void setFriendlevel(String friendlevel) {
		this.friendlevel = friendlevel;
	}
	public String getFriendcost() {
		return friendcost;
	}
	public void setFriendcost(String friendcost) {
		this.friendcost = friendcost;
	}

	public String getServerId() {
		return serverId;
	}

	public void setServerId(String serverId) {
		this.serverId = serverId;
	}

	public String getVipGift() {
		return vipGift;
	}

	public void setVipGift(String vipGift) {
		this.vipGift = vipGift;
	}

	public String getVipTime() {
		return vipTime;
	}

	public void setVipTime(String vipTime) {
		this.vipTime = vipTime;
	}

	public int getZhuxianling() {
		return zhuxianling;
	}

	public void setZhuxianling(int zhuxianling) {
		this.zhuxianling = zhuxianling;
	}

	public String getBylevel() {
		return bylevel;
	}

	public void setBylevel(String bylevel) {
		this.bylevel = bylevel;
	}

	public String getThree() {
		return three;
	}

	public void setThree(String three) {
		this.three = three;
	}

	public String getExist() {
		return exist;
	}

	public void setExist(String exist) {
		this.exist = exist;
	}

	public long getOnlinetime() {
		return onlinetime;
	}

	public void setOnlinetime(long onlinetime) {
		this.onlinetime = onlinetime;
	}

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

	

	public int getRoleline() {
		return roleline;
	}

	public void setRoleline(int roleline) {
		this.roleline = roleline;
	}

	

	public String getHelpstep() {
		return helpstep;
	}

	public void setHelpstep(String helpstep) {
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

	public String getActivitytype() {
		return activitytype;
	}

	public void setActivitytype(String activitytype) {
		this.activitytype = activitytype;
	}

	public String getIsnew() {
		return isnew;
	}

	public void setIsnew(String isnew) {
		this.isnew = isnew;
	}

	public long getZxtime() {
		return zxtime;
	}

	public void setZxtime(long zxtime) {
		this.zxtime = zxtime;
	}

	public int getJingji() {
		return jingji;
	}

	public void setJingji(int jingji) {
		this.jingji = jingji;
	}

	public long getJjtime() {
		return jjtime;
	}

	public void setJjtime(long jjtime) {
		this.jjtime = jjtime;
	}

	public int getIsUpdate() {
		return isUpdate;
	}

	public void setIsUpdate(int isUpdate) {
		this.isUpdate = isUpdate;
	}


}
