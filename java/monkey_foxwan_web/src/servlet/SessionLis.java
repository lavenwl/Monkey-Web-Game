package servlet;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionLis implements HttpSessionListener {

	public void sessionCreated(HttpSessionEvent arg0) {
	}

	public void sessionDestroyed(HttpSessionEvent arg0) {
		String pid = (String.valueOf(arg0.getSession().getAttribute("pid")));
		System.out.println("删除PID" + pid + "的pid");
	}

}
