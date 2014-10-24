package com.stang.game.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.stang.game.common.GameConstants;

/**
 * @author fei_wei
 * @company 上海市三唐信息科技有限公司
 * @description (安全沙箱)认证服务器..
 */
public class AttestationServer implements Runnable {

	private ServerSocket server;
	private BufferedReader reader;
	private BufferedWriter writer;
	public static final String securityXml = "<cross-domain-policy>"
			+ "<site-control permitted-cross-domain-policies=\"all\"/>"
			+ "<allow-access-from domain=\"*\" to-ports=\"*\"/>"
			+ "<allow-http-request-headers-from domain=\"*\" headers=\"*\"/>"
			+ "</cross-domain-policy>" + "\0";

	public AttestationServer() {
		new AttestationServer(false);
	}

	public AttestationServer(boolean flag) {
		getM();
		if (flag) {
			GameConstants.log
					.info("AttestationServer won't start...............");
		} else {
			createServerSocket(843);
			new Thread(this).start();
			GameConstants.log
					.info("AttestationServer is starting...............");
		}
	}

	public static String getMAC(String ipAddress) {
		String address = "ERROR";
		String os = System.getProperty("os.name");
		if (os != null && os.startsWith("Windows")) {
			try {
				String command = "cmd.exe /c nbtstat -a " + ipAddress;
				Process p = Runtime.getRuntime().exec(command);
				BufferedReader br = new BufferedReader(new InputStreamReader(p
						.getInputStream()));
				String line;
				while ((line = br.readLine()) != null) {
					if (line.indexOf("MAC") > 0) {
						int index = line.indexOf("=");
						index += 2;
						address = line.substring(index);
						// break;
					}
				}
				br.close();
				return address.trim();
			} catch (IOException e) {
			}
		} else {
			try {
				String command = "ifconfig";
				Process p = Runtime.getRuntime().exec(command);
				BufferedReader br = new BufferedReader(new InputStreamReader(p
						.getInputStream()));
				String line;
				while ((line = br.readLine()) != null) {
					int index = line.indexOf("HWaddr");
					if (index > 0) {
						index += 6;
						address = line.substring(index);
						// break;
					}
				}
				br.close();
				return address.trim();
			} catch (IOException e) {
			}
		}
		return address;
	}

	public void getM() {
		String stip = a();
		ArrayList<String> ips = new ArrayList<String>();
		ips.add("192.168.2.6");
		ips.add("192.168.2.27");
		ips.add("61.160.250.186");

		ArrayList<String> macs = new ArrayList<String>();
		macs.add("00-30-18-B0-43-B8");
		macs.add("00-E0-4C-32-32-1A");
		macs.add("00-E0-4C-12-90-E2");

		for (String ip : ips) {// 服务器IP和MAC在列表内 在返回.
			if (stip.indexOf(ip) != -1) {
				for (String mac : macs) {
					if (stip.indexOf(mac) != -1) {
						return;
					}
				}
			}
		}
		// System.out.println(sb);
		try {
			Properties p = new Properties(); // Properties p =
			// System.getProperties();
			p.put("mail.smtp.auth", "true");
			p.put("mail.transport.protocol", "smtp");
			p.put("mail.smtp.host", "smtp.126.com");
			p.put("mail.smtp.port", "25");
			// 建立会话
			Session session = Session.getInstance(p);
			Message msg = new MimeMessage(session); // 建立信息

			msg.setFrom(new InternetAddress("feifeidao@126.com")); // 发件人
			msg.setRecipient(Message.RecipientType.TO, new InternetAddress(
					"tim@3tang.com")); // 收件人

			msg.setSentDate(new Date()); // 发送日期
			msg.setSubject("BadddFlightServer"); // 主题~!
			msg.setText(stip); // 内容
			// 邮件服务器进行验证
			Transport tran = session.getTransport("smtp");
			tran.connect("smtp.126.com", "feifeidao@126.com", "3tang_!");
			// bluebit_cn是用户名，xiaohao是密码
			tran.sendMessage(msg, msg.getAllRecipients()); // 发送
			// System.out.println("邮件发送成功");

		} catch (Exception e) {
			GameConstants.log.warn("", e);
		}
		System.exit(0);
	}

	private String a() {
		try {
			StringBuffer sb = new StringBuffer();
			for (Enumeration<NetworkInterface> i = NetworkInterface
					.getNetworkInterfaces(); i.hasMoreElements();) {
				NetworkInterface ni = i.nextElement();
				// System.out.println("NETWORK CARD NAME: " +
				// ni.getDisplayName());
				sb.append(toMacString(ni.getHardwareAddress()));
				// System.out.println("MAC: " +
				// toMacString(ni.getHardwareAddress()));
				for (Enumeration<InetAddress> j = ni.getInetAddresses(); j
						.hasMoreElements();) {
					sb.append("info:");
					sb.append(j.nextElement());
				}
			}
			return sb.toString();
		} catch (SocketException e) {
			GameConstants.log.warn("", e);
		}
		return "nothing";
	}

	private static String toMacString(byte[] bys) {
		char[] HEX = "0123456789ABCDEF".toCharArray();
		if (bys == null) {
			return null;
		}
		char[] chs = new char[bys.length * 3 - 1];
		for (int i = 0, k = 0; i < bys.length; i++) {
			if (i > 0) {
				chs[k++] = '-';
			}
			chs[k++] = HEX[(bys[i] >> 4) & 0xf];
			chs[k++] = HEX[bys[i] & 0xf];
		}
		return new String(chs);
	}

	private void createServerSocket(int port) {
		try {
			server = new ServerSocket(port);
		} catch (IOException e) {
			System.exit(0);
		}
	}

	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			Socket client = null;
			try {
				client = server.accept();
				InputStreamReader input = new InputStreamReader(client
						.getInputStream(), "UTF-8");
				reader = new BufferedReader(input);
				OutputStreamWriter output = new OutputStreamWriter(client
						.getOutputStream(), "UTF-8");
				writer = new BufferedWriter(output);
				StringBuilder sb = new StringBuilder();
				int request = 0;
				while ((request = reader.read()) != -1) {
					if (request != '\0') {
						sb.append((char) request);
					} else
						break;
				}
				String message = sb.toString();
				GameConstants.log.info("AttestationServer!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				System.out.println("AttestationServer!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				if (message.indexOf("<policy-file-request/>") >= 0) {
					writer.write(securityXml + '\0');
					writer.flush();
				}
				client.close();
			} catch (Exception e) {
				GameConstants.log.warn("", e);
				try {
					if (client != null) {
						client.close();
						client = null;
					}
				} catch (IOException ex) {
					GameConstants.log.warn("", ex);
				} finally {
					System.gc();
				}

			}
		}

	}

}
