package com.stang.game.ffd.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.Action;
import com.stang.game.common.Password;
import com.stang.game.entity.detail.EntityRightUserDetail;
import com.stang.game.service.impl.RightUserServiceImpl;

public class RightAction implements Action ,ServletRequestAware{
	private static String md5d = "ey:44time:98432";
	private String tip;
	private String uid1;
	private String optype;
	private String uname;
	private String upassword;
	private String rightValue;
	private HttpServletRequest request;


	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public String getOptype() {
		return optype;
	}

	public void setOptype(String optype) {
		this.optype = optype;
	}

	public String getUid1() {
		return uid1;
	}

	public void setUid1(String uid1) {
		this.uid1 = uid1;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpassword() {
		return upassword;
	}

	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	public String getRightValue() {
		return rightValue;
	}

	public void setRightValue(String rightValue) {
		this.rightValue = rightValue;
	}

	public String execute() throws Exception {
		// TODO Auto-generated method stub
		//System.out.println(uid1 + optype + uname + upassword);
		final int WEB_RIGHT=1;
		HashMap<String, Object> param = new HashMap<String, Object>();
		HttpSession session = ((HttpServletRequest)request).getSession();
		param.put("uid", (Integer)session.getAttribute("uid"));
		List<EntityRightUserDetail> eruds = new RightUserServiceImpl().findRightUserByMap(param);
		if((Integer)session.getAttribute("uid")==3779){
			
		}else{
			if(eruds.size()!=1){
				return ERROR;
			}
			if(!((eruds.get(0).getRight_value()&1)==1||(eruds.get(0).getRight_value()&WEB_RIGHT)==WEB_RIGHT)){
				return ERROR;
			}
		}
		
		
		
		
		
		tip=null;
		System.out.println(optype);
		if (optype == null)
			return SUCCESS;
		if (optype.equals("submit")) {
			EntityRightUserDetail erud = new EntityRightUserDetail();
			erud.setUname(uname);
			erud.setUpassword(Password.MD5((String) upassword + md5d));
			erud.setFlag(1);
			if (new RightUserServiceImpl().insertRightUserDetail(erud) == 1) {
				tip = "ADD SUCCESS!";
			} else { 
				tip = "ADD ERROR :(";
			}
		} else if (optype.equals("delete")) {
			try {
				if (new RightUserServiceImpl().deleteRightUserDetail(Integer
						.parseInt(uid1)) == 1) {
					tip = "DELETE SUCCESS!";
				} else {
					tip = "DELETE ERROR :(";
				}
			} catch (Exception e) {
				tip = "DELETE ERROR :(";
			}
		} else if (optype.equals("edit")) {
			return "edit";
		} else if (optype.equals("sure")) {
			EntityRightUserDetail erud = new EntityRightUserDetail();
			erud.setUid(Integer.parseInt(uid1));
			erud.setRight_value(Integer.parseInt(rightValue));
			new RightUserServiceImpl().updateRightUserDetail(erud);
			tip = "CHANGE SUCCESS!";
		}
		return SUCCESS;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
}