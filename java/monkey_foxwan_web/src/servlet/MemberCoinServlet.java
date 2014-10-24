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

public class MemberCoinServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String user = request.getParameter("user");
		int coin = Integer.parseInt(request.getParameter("coin"));
		int id = Integer.parseInt(request.getParameter("id"));
		DBConnectionManager dbp = DBConnectionManager.getInstance();
		Connection co = dbp.getConnection("server1");
		try {
			Statement st = co.createStatement();
			int money = 0;
			List<Money> list = new ArrayList<Money>();
			ResultSet rs = st
					.executeQuery("select coinbuy from member  WHERE member_username = '"
							+ user + "' ");
			if (rs.next()) {
				if (rs.getInt(1) != coin) {
					money = coin - rs.getInt(1);
					st.execute("UPDATE member SET coinbuy = coinbuy + '"
							+ money + "' WHERE member_username = '" + user
							+ "'");
					st.execute("UPDATE game_role SET rolemoney = rolemoney + '"
							+ money + "' WHERE ID = '" + id + "'");
				}
			}
			rs.close();
			if (money != 0) {
				ResultSet s = st
						.executeQuery("select rolemoney from game_role  WHERE ID = '"
								+ id + "'");
				if (s.next()) {
					money = s.getInt(1);
					Money d = new Money();
					d.setRoleId(id);
					d.setMoney(money);
					System.out.println(money);
					list.add(d);
					d = null;
				}
				s.close();
			} else {
				Money d = new Money();
				d.setRoleId(id);
				d.setMoney(money);
				System.out.println(money);
				list.add(d);
				d = null;
			}
			JSONArray obj = JSONArray.fromObject(list);
			out.println(obj.toString());

			st.close();
			co.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		out.close();
	}

}
