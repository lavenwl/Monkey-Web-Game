package servlet;

import java.io.IOException;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stang.game.ffd.client.Client;
import com.stang.game.ffd.controller.SendGiftAction;

import dbconn.DBConnectionManager;

public class DeskCheck extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("......................DeskCheck    " + request.getParameter("openid"));
		String dataTime = String.valueOf(System.currentTimeMillis() / 1000);
		String memberUsername = request.getParameter("openid");
	}
}
