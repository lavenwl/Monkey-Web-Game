package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import dbconn.DBConnectionManager;
import entity.School;

public class HchoolServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String type = request.getParameter("type");
		type = java.net.URLDecoder.decode(type, "utf-8");
		int t = Integer.parseInt(request.getParameter("t"));
		DBConnectionManager dbp = DBConnectionManager.getInstance();
		Connection co = dbp.getConnection("server2");
		try {
			Statement st = co.createStatement();
			String a = "";
			ResultSet qu = st
					.executeQuery("select CITY_ID  from t_city where PROVINCE_ID =(select CITY_ID from t_city where CITY_NAME = '"
							+ type + "' limit 1)");
			if (qu.next()) {
				a = qu.getString(1);
			}
			qu.close();
			ResultSet q = st
					.executeQuery("select CITY_ID  from t_city where PROVINCE_ID ='"
							+ a + "'");
			if (q.next()) {
				a = q.getString(1);
			}
			q.close();
			ResultSet rs = null;
			rs = st
					.executeQuery("select SCHOOL_TYPE,SCHOOL_NAME from t_school where SCHOOL_TYPE ='"
							+ t + "' and CITY_ID = '" + a + "'");
			List<School> list = new ArrayList<School>();
			School d;
			while (rs.next()) {
				d = new School();
				d.setCityId(rs.getString(1));
				d.setSchooName(rs.getString(2));
				list.add(d);
				d = null;
			}
			JSONArray obj = JSONArray.fromObject(list);
			out.println(obj.toString());
			rs.close();
			st.close();
			co.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		out.close();
	}
}
