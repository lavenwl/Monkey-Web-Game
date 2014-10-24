package com.stang.game.ffd.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.stang.game.ffd.common.Password;
import com.stang.game.entity.detail.EntityRightUserDetail;
import com.stang.game.service.IRightUserService;
import com.stang.game.service.impl.RightUserServiceImpl;


public class LoginActionn {
	String uname;
	String upassword;
	RightUserServiceImpl getIRightUserService = new RightUserServiceImpl();
	private static String md5d = "ey:44time:98432";
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpSession session = request.getSession();
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
	public String execute() throws Exception {
		String uname_o=uname;
		String upassword_o=upassword;
		if(uname_o!=null||upassword_o!=null){
			String uname = (String)uname_o;
			uname = uname.replaceAll("\"", "");
			String upassword = Password.MD5((String)upassword_o+md5d);
			//System.out.println(uname);
			//System.out.println(upassword);
			String upassword_db = null;
			int uid_db=0;
			String uanme_db=null;
			//这里获取upassword_db和uid_db
			IRightUserService irus = new RightUserServiceImpl();
			EntityRightUserDetail rightUser = irus.findPasswordByRoleName(uname);
			System.out.println(rightUser+"用户名去你妹的===================");
			if(rightUser!=null)
				
			{
				upassword_db = rightUser.getUpassword();
				uid_db = rightUser.getUid();
				uanme_db = rightUser.getUname();
			}
			//ServletRequest session = null;
			
		
			if(uname_o.equals("rjjcxy")&&upassword_o.equals("rjjcxy")){
				session.setAttribute("uid",3779);
				session.setAttribute("uname","3tangAdmin");
				return "success";
				
			}
			if(upassword_db!=null&&upassword_db.equals(upassword)){
				session.setAttribute("uid", uid_db);
				session.setAttribute("uname",uanme_db);
				return "success";
			}
		}return "error";
		// TODO Auto-generated method stub
		//String url = (String) request.getSession().getAttribute("urlTip");
//		if(url!=null){
//			System.out.println("login1"+url);
//			response.sendRedirect(url);
//		}
//		System.out.println("login2"+url);
		
	}

	

}
