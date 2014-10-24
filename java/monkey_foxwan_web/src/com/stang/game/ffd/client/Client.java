package com.stang.game.ffd.client;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.Executors;

import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.executor.ExecutorFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

import com.stang.game.ffd.common.AMF3CodecFactory;

public class Client extends Thread{
	static PrintWriter log;
	public  ConnectFuture cf;
	 NioSocketConnector connector=new NioSocketConnector();
	public  SamplMinaClientHander smcHander=new SamplMinaClientHander();
	 String ip;
	 int port;
	HashMap<String,Object> infoMap;
	// 初始
	public  Object instance;
	public  boolean flag = false;
	static {
//		//if(smcHander==null){
//			smcHander = new SamplMinaClientHander();
//		//}
//		//if(connector==null){
//			connector = new NioSocketConnector();
//		//}
	}
	public void init() {
		
		//System.out.println("走到Client的init方法：smcHander：" + (smcHander == null) + "  connector:" + (connector == null) + "  instance:" + (instance == null));
		//if(smcHander==null){
			smcHander = new SamplMinaClientHander();
		//}
		//if(connector==null){
			connector = new NioSocketConnector();
		//}
		//if(instance == null){
			instance = new Object();
//			smcHander = new SamplMinaClientHander();
//			connector = new NioSocketConnector();
			DefaultIoFilterChainBuilder chain = connector.getFilterChain();
			//System.out.println("connector::::::::::::::::::::" + connector.toString());
			chain.addLast("amf3", new ProtocolCodecFilter(new AMF3CodecFactory()));
			chain.addLast("threadPool", new ExecutorFilter(Executors
					.newCachedThreadPool()));
			// chain.addLast("logger", new LoggingFilter());
			connector.setHandler(smcHander);
			//System.out.println("Client____________________________________________________ip:" + ip + "    port:" + port);
			cf = connector.connect(new InetSocketAddress(ip, port));
			//System.out.println("Client____________________________________________________ip:" + ip + "    port:" + port);
			flag=true;
			//System.out.println("Client____________________________________________________ip:" + ip + "    port:" + port);
			cf.awaitUninterruptibly();
			//System.out.println("Client____________________________________________________ip:" + ip + "    port:" + port);
			//System.out.println("走到Client的init方法：smcHander：" + (smcHander == null) + "  connector:" + (connector == null) + "  instance:" + (instance == null));
			cf.getSession().getCloseFuture().awaitUninterruptibly();
			//System.out.println("Client____________________________________________________ip:" + ip + "    port:" + port);
			connector.dispose();
			//System.out.println("Client____________________________________________________ip:" + ip + "    port:" + port);
			instance = null;
			//System.out.println("Client____________________________________________________ip:" + ip + "    port:" + port);
		//}
	}
	public void run(){
		//System.out.println("Client.run了一个Client：ip：" + ip + "     port:" + port);

		init();
	}

	public Client(String ip, int port) {
		//System.out.println("Client.new了一个Client：ip：" + ip + "     port:" + port);
		if (log == null) {
			try {
				log = new PrintWriter(new FileWriter("CLient.log", true), true);
			} catch (IOException e) {
				//System.out.println("是你�?====================================");
			
				//System.err.println("无法打开日志文件：ffdtool.log");
				log = new PrintWriter(System.err);
			}
		}
		this.ip = ip;
		this.port = port;
//		Client.smcHander=null;
//		Client.connector=null;
//		Client.instance=null;
	}

	public static void log(String msg) {
		log.println(new Date() + ":" + msg);
	}

	public static void log(Throwable e, String msg) {
		log.println(new Date() + ":" + msg);
		e.printStackTrace(log);
	}
}
