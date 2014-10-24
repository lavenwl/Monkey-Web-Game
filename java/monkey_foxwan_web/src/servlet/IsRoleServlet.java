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
import entity.Money;

public class IsRoleServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		DBConnectionManager dbp = DBConnectionManager.getInstance();
		Connection co = dbp.getConnection("server1");
		try {
			Statement st = co.createStatement();
			ResultSet rs = null;
			rs = st
					.executeQuery("select count(id) from game_role  WHERE id = '"
							+ id + "' ");
			List<Money> list = new ArrayList<Money>();
			Money d;
			while (rs.next()) {
				d = new Money();
				d.setRoleId(rs.getInt(1));
				d.setMoney(0);
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
