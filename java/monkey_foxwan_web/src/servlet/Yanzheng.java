package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbconn.DBConnectionManager;

public class Yanzheng extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String serverId = request.getParameter("serverid");
		String memberUsername = request.getParameter("username");
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
		int id = 0;;
		try {
			id = checkUser(memberUsername,serverId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(id==0){
			id=-1;
		}else{
			id = 1;
		}
		if(serverId==null||memberUsername==null){
			id=-2;
		}
		String ss = String.valueOf(id);
		out.write(ss);
			//	response.sendRedirect("./yanzheng.jsp?yanzheng="+id+"");
	}

	private int checkUser(String memberUsername, String serverId) throws SQLException {
		DBConnectionManager dbp = DBConnectionManager.getInstance();
		Connection co = dbp.getConnection("server");
		Statement st = null;
		int id = 0;
		try {
			st = co.createStatement();
			ResultSet rs = st.executeQuery("select id from member where member_username = '"+memberUsername+"' and  serverid = '" + serverId + "'");
			while(rs.next()){
				id = rs.getInt(1);
			}
			co.close();
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		dbp.freeConnection("server", co);
		return id;
	}
}
