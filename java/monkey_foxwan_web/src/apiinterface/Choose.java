package apiinterface;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import net.sf.json.JSONArray;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.qq.open.CompassApi;

import dbconn.DBConnectionManager;
/**
 * 切换停服页面
 * @author Administrator
 *
 */
public class Choose extends ActionSupport{

	public String execute() throws Exception{
		
		DBConnectionManager dbp = DBConnectionManager.getInstance();
		Connection co = dbp.getConnection("server1");
		Statement st = null;
		int status = 1;
		try {
			st = co.createStatement();
			ResultSet rs = st.executeQuery("select * from host_status where id =1");
			String message = "";
			while(rs.next()){
				message = rs.getString("message");
				status = rs.getInt("status");
			}
			rs.close();
			st.close();
		ServletActionContext.getRequest().setAttribute("message", message);
		ServletActionContext.getRequest().setAttribute("status", status);
//			ActionContext.getContext().getSession().put("message", message);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "linshi";
		
	}
}
