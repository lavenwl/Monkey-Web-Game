package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.alibaba.fastjson.JSON;
import com.qq.open.OpensnsException;

import dbconn.DBConnectionManager;
import entity.Huangzuan;

public class NewName extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String serverId = request.getParameter("serverId");
		String name = request.getParameter("name");
		int num = 0;
			response.setContentType("text/html;charset=UTF-8");
			//黄钻，更新数据库
			DBConnectionManager dbp = DBConnectionManager.getInstance();
			Connection co = dbp.getConnection("server" + serverId);
			Statement st = null;
			try {
				st = co.createStatement();
					ResultSet rs = st.executeQuery("select id from game_role where name = "+"'" + name + "'");
					if(rs.next()){
						num = 1;
					}
				st.close();
				co.close();
				dbp.freeConnection("server" + serverId, co);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
				String Num = String.valueOf(num);
				//把参数传给socket
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				List list = new ArrayList();
				Huangzuan h = new Huangzuan();
				h.setName(Num);
				list.add(h);
				JSONArray obj = JSONArray.fromObject(list);
				out.println(obj.toString());
				out.close();
			}
}
}

