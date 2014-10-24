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
import entity.Shi;

public class SUuServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String type = request.getParameter("type");
		type = java.net.URLDecoder.decode(type, "utf-8");
		DBConnectionManager dbp = DBConnectionManager.getInstance();
		Connection co = dbp.getConnection("server2");

		try {
			String a = type;
			Statement st = co.createStatement();
			ResultSet shi = st
					.executeQuery("select CITY_ID from t_city where PROVINCE_ID =(select CITY_ID from t_city where CITY_NAME = '"
							+ type + "' limit 1)");
			if (shi.next()) {
				a = shi.getString(1);
			}
			shi.close();
			ResultSet rs = st
					.executeQuery("select CITY_ID ,CITY_NAME from t_city where PROVINCE_ID = '"
							+ a + "'");
			List<Shi> list = new ArrayList<Shi>();
			Shi d;
			while (rs.next()) {
				d = new Shi();
				d.setCityId(rs.getString(1));
				d.setCityName(rs.getString(2));
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
