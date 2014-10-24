package com.stang.game.entity;

public class GameMilitary implements Cloneable{
	@Override
	public Object clone() throws CloneNotSupportedException {
		// 实现clone方法
		return super.clone();
	}
	//缓存中确定是否更新，插入，删除字段。默认：0；更新：1；插入：2；删除：3.
	private int isUpdate;
	
	private int id;
	private String name;
	private String desc;
	private int pingzhi;
	private int pztype;
	private int type;
	private int gongji;
	private int gongsu;
	private int fanwei;
	private int gjiacheng;
	private int xljiacheng;
	private int xueliang;
	private int level;
	private int art;
	private int arts;
	private int art1;
	private int art2;
	private int art3;
	private int art4;
	private int flag;
	private int isshow;
	private int iscompose;
	private int isaddcompose;
	private String needcompose;
	private int composeid;
	private int bagj;
	private int bags;
	private int baxl;
	private int batype;
    private int gjjc;
    private int xljc;
    private int gmpz;
    private int gmfw;
    private String describe;
    private int mohunprice;
    private int mohunchange;
    private int mohunboolean;
    private int mjchance;
    private String heti;
    public String getHeti() {
		return heti;
	}

	public void setHeti(String heti) {
		this.heti = heti;
	}
	private int ismaterial;
    private String source;




	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}



	public int getIsmaterial() {
		return ismaterial;
	}

	public void setIsmaterial(int ismaterial) {
		this.ismaterial = ismaterial;
	}

	public int getMjchance() {
		return mjchance;
	}

	public void setMjchance(int mjchance) {
		this.mjchance = mjchance;
	}

	public String getDescribe() {
		return describe;
	}

	public int getMohunprice() {
		return mohunprice;
	}

	public void setMohunprice(int mohunprice) {
		this.mohunprice = mohunprice;
	}

	public int getMohunchange() {
		return mohunchange;
	}

	public void setMohunchange(int mohunchange) {
		this.mohunchange = mohunchange;
	}

	public int getMohunboolean() {
		return mohunboolean;
	}

	public void setMohunboolean(int mohunboolean) {
		this.mohunboolean = mohunboolean;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public int getGmfw() {
		return gmfw;
	}

	public void setGmfw(int gmfw) {
		this.gmfw = gmfw;
	}

	public int getGjjc() {
		return gjjc;
	}

	public void setGjjc(int gjjc) {
		this.gjjc = gjjc;
	}

	public int getXljc() {
		return xljc;
	}

	public void setXljc(int xljc) {
		this.xljc = xljc;
	}

	public int getGmpz() {
		return gmpz;
	}

	public void setGmpz(int gmpz) {
		this.gmpz = gmpz;
	}

	public int getBatype() {
		return batype;
	}

	public void setBatype(int batype) {
		this.batype = batype;
	}

	public int getBagj() {
		return bagj;
	}

	public void setBagj(int bagj) {
		this.bagj = bagj;
	}

	public int getBags() {
		return bags;
	}

	public void setBags(int bags) {
		this.bags = bags;
	}

	public int getBaxl() {
		return baxl;
	}

	public void setBaxl(int baxl) {
		this.baxl = baxl;
	}

	public int getIscompose() {
		return iscompose;
	}

	public void setIscompose(int iscompose) {
		this.iscompose = iscompose;
	}

	public int getIsaddcompose() {
		return isaddcompose;
	}

	public void setIsaddcompose(int isaddcompose) {
		this.isaddcompose = isaddcompose;
	}

	public String getNeedcompose() {
		return needcompose;
	}

	public void setNeedcompose(String needcompose) {
		this.needcompose = needcompose;
	}

	public int getComposeid() {
		return composeid;
	}

	public void setComposeid(int composeid) {
		this.composeid = composeid;
	}

	public int getIsshow() {
		return isshow;
	}

	public void setIsshow(int isshow) {
		this.isshow = isshow;
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

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getPingzhi() {
		return pingzhi;
	}

	public void setPingzhi(int pingzhi) {
		this.pingzhi = pingzhi;
	}

	public int getPztype() {
		return pztype;
	}

	public void setPztype(int pztype) {
		this.pztype = pztype;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getGongji() {
		return gongji;
	}

	public void setGongji(int gongji) {
		this.gongji = gongji;
	}

	public int getGongsu() {
		return gongsu;
	}

	public void setGongsu(int gongsu) {
		this.gongsu = gongsu;
	}

	public int getFanwei() {
		return fanwei;
	}

	public void setFanwei(int fanwei) {
		this.fanwei = fanwei;
	}

	public int getGjiacheng() {
		return gjiacheng;
	}

	public void setGjiacheng(int gjiacheng) {
		this.gjiacheng = gjiacheng;
	}

	public int getXljiacheng() {
		return xljiacheng;
	}

	public void setXljiacheng(int xljiacheng) {
		this.xljiacheng = xljiacheng;
	}

	public int getXueliang() {
		return xueliang;
	}

	public void setXueliang(int xueliang) {
		this.xueliang = xueliang;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getArt() {
		return art;
	}

	public void setArt(int art) {
		this.art = art;
	}

	public int getArts() {
		return arts;
	}

	public void setArts(int arts) {
		this.arts = arts;
	}

	public int getArt1() {
		return art1;
	}

	public void setArt1(int art1) {
		this.art1 = art1;
	}

	public int getArt2() {
		return art2;
	}

	public void setArt2(int art2) {
		this.art2 = art2;
	}

	public int getArt3() {
		return art3;
	}

	public void setArt3(int art3) {
		this.art3 = art3;
	}

	public int getArt4() {
		return art4;
	}

	public void setArt4(int art4) {
		this.art4 = art4;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public int getIsUpdate() {
		return isUpdate;
	}

	public void setIsUpdate(int isUpdate) {
		this.isUpdate = isUpdate;
	}

}
