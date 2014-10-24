package com.stang.game.ffd.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.stang.game.ffd.entity.detail.EntityGameAstrologyCorrectionDetail;
import com.stang.game.ffd.entity.detail.EntityGameAstrologyDetail;
import com.stang.game.ffd.service.IGameAstrologyCorrectionService;
import com.stang.game.ffd.service.IGameAstrologyService;
import com.stang.game.ffd.service.impl.GameAstrologyCorrectionServiceImpl;
import com.stang.game.ffd.service.impl.GameAstrologyServiceImpl;

public class AstrologyAction extends ActionSupport implements
ServletRequestAware  {
	private IGameAstrologyService gameAstrologyService;
	private IGameAstrologyCorrectionService gameAstrologyCorrection;
	private String astrologyName;//** 占星模型数据的名字
	private int astrologyType;//** 占星模型树的类型 攻击 防御 等
	private int astrologyInitial;//** 星魂的初始值
	private int astrologySellPrice;//** 星魂的卖出价格
	private int astrologyQuality;//** 星魂的品质
	private String astrologySrc;//** 资源地址
	private int correction_lv;//** 修正值的等级
	private float correction_value;//** 修正值的数值
	
	
	public IGameAstrologyService getGameAstrologyService(){
		if(gameAstrologyService == null){
			gameAstrologyService = new GameAstrologyServiceImpl();
		}
		return gameAstrologyService;
	}
	
	public IGameAstrologyCorrectionService getGameAstrologyCorrectionService(){
		if(gameAstrologyCorrection == null){
			gameAstrologyCorrection = new GameAstrologyCorrectionServiceImpl();
		}
		return gameAstrologyCorrection;
	}

	//** start 框架接受数
	public String getAstrologyName() {
		return astrologyName;
	}

	public void setAstrologyName(String astrologyName) {
		this.astrologyName = astrologyName;
	}

	public int getAstrologyType() {
		return astrologyType;
	}

	public void setAstrologyType(int astrologyType) {
		this.astrologyType = astrologyType;
	}

	public int getAstrologyInitial() {
		return astrologyInitial;
	}

	public void setAstrologyInitial(int astrologyInitial) {
		this.astrologyInitial = astrologyInitial;
	}

	public int getAstrologySellPrice() {
		return astrologySellPrice;
	}

	public void setAstrologySellPrice(int astrologySellPrice) {
		this.astrologySellPrice = astrologySellPrice;
	}

	public int getAstrologyQuality() {
		return astrologyQuality;
	}

	public void setAstrologyQuality(int astrologyQuality) {
		this.astrologyQuality = astrologyQuality;
	}
	
	public String getAstrologySrc() {
		return astrologySrc;
	}

	public void setAstrologySrc(String astrologySrc) {
		this.astrologySrc = astrologySrc;
	}
	
	public int getCorrection_lv() {
		return correction_lv;
	}

	public void setCorrection_lv(int correction_lv) {
		this.correction_lv = correction_lv;
	}

	public float getCorrection_value() {
		return correction_value;
	}

	public void setCorrection_value(float correction_value) {
		this.correction_value = correction_value;
	}
	
	//** end 框架接受数
	
	private HttpServletRequest request;
	@SuppressWarnings("unused")
	private HttpSession session;
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
		this.session = ServletActionContext.getRequest().getSession();
	}
	
	/**
	 * 添加新的 占星模型数据
	 * @return succ
	 */
	public String  addGameAstrologyAction(){
		/** 
		 * 添加新的的占星模型数据
		 */
		System.out.print(astrologyName+"-"+astrologyType+"-"+astrologyInitial+"-"+astrologySellPrice+"-"+astrologyQuality);
		EntityGameAstrologyDetail egad = new EntityGameAstrologyDetail();
		egad.setAstrology_name(astrologyName);
		egad.setAstrology_initial(astrologyInitial);
		egad.setAstrology_quality(astrologyQuality);
		egad.setAstrology_src(astrologySrc);
		egad.setAstrology_type(astrologyType);
		egad.setAstrology_sellprice(astrologySellPrice);
		this.getGameAstrologyService().addGameAstrology(egad);
		return "succ";
	}
	
	/**
	 * 查询所有的占星的数据
	 * @return succ
	 */
	public String findGameAstrology(){
		Map<String,Object> params = new HashMap<String,Object>();
		List<EntityGameAstrologyDetail> legad =this.getGameAstrologyService().findAllGameAstrology(params);
		request.setAttribute("results", legad);
		return "succ";
	}

	/**
	 * 插入 修正值相关的数据
	 * 
	 */
	public String addGameAstrologyCorrection(){
		EntityGameAstrologyCorrectionDetail params=new EntityGameAstrologyCorrectionDetail();
		params.setCorrection_lv(correction_lv);
		params.setCorrection_value(correction_value);
		this.getGameAstrologyCorrectionService().addGameAstrologyCorrection(params);
		return "succ";
	}
	
	public String findGameAstrologyCorrection(){
		Map<String,Object> params = new HashMap<String,Object>();
		System.out.println("shit");
		List<EntityGameAstrologyCorrectionDetail> legcd=this.getGameAstrologyCorrectionService().findGameAstrologyCorrection(params);
		request.setAttribute("results", legcd);
		return "succ";
	}

}
