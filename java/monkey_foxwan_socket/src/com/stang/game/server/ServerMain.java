
package com.stang.game.server;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;
import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.executor.ExecutorFilter;
import org.apache.mina.filter.keepalive.KeepAliveFilter;
import org.apache.mina.filter.keepalive.KeepAliveMessageFactory;
import org.apache.mina.filter.keepalive.KeepAliveRequestTimeoutHandler;
import org.apache.mina.transport.socket.SocketAcceptor;
import org.apache.mina.transport.socket.SocketSessionConfig;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

import com.stang.game.common.AMF3CodecFactory;
import com.stang.game.common.GameConstants;

/**
 * @author fei_weieek
 * @company 上海三唐信息科技有限公司
 * @description    服务器启动程序
 * @preserve
 */
public class ServerMain {
	static Logger log = GameConstants.log;
	/**
	 * @param args
	 * @preserve
	 * 
	 */
	public static void main(String[] args) throws Exception {
		/* 接收器 */
		SocketAcceptor acceptor = new NioSocketAcceptor(Runtime.getRuntime()
				.availableProcessors() + 1);
		acceptor.setReuseAddress(true);
		((SocketSessionConfig) acceptor.getSessionConfig())
				.setReceiveBufferSize(8192);

		/* 添加过滤器 */
		DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
		chain.addLast("amf3", new ProtocolCodecFilter(new AMF3CodecFactory()));
		chain.addLast("threadPool", new ExecutorFilter(Executors.newFixedThreadPool(300)));

		KeepAliveFilter keepAliveFilter = new KeepAliveFilter(new KeepAliveMessageImpl());
		// 心跳包 防止一段时间不通信 路由器主动断开连接
		keepAliveFilter.setForwardEvent(false);
		keepAliveFilter.setRequestInterval(58);
		keepAliveFilter.setRequestTimeout(10);
		keepAliveFilter.setRequestTimeoutHandler(KeepAliveRequestTimeoutHandler.NOOP);
		// chain.addLast("KeepAlive", keepAliveFilter);

		
		// 添加处理器
		acceptor.setHandler(new ServerHandler());
		acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 500);// 设置空闲状态的等待时间为10秒
		acceptor.setReuseAddress(true);// 设置的是主服务监听的端口可以重用
		acceptor.getSessionConfig().setReuseAddress(true);// 设置每一个非主监听连接的端口可以重用
		acceptor.setBacklog(7000);// 设置主服务监听端口的监听队列的最大值，再新的连接来将被服务器拒绝
		/* 绑定端口 */
		int bindPort = 8008;
		log.info("Server is startting...");
		acceptor.bind(new InetSocketAddress(bindPort));
		log.info("Server is listing on = " + bindPort);
		
		
//		while (true) {
//            try {
//                Thread.sleep(5000);
//                System.out.println("最大内存" + Runtime.getRuntime().maxMemory()/1024/1024+"M");
//                System.out.println("已用内存" + Runtime.getRuntime().totalMemory()/1024/1024+"M");
//                System.out.println("可用内存" + Runtime.getRuntime().freeMemory()/1024/1024+"M");
//                System.out.println("------------------------------------");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//             
//        }
	}

	static class KeepAliveMessageImpl implements KeepAliveMessageFactory {
		private static final byte[] KAMSG_REQ = "##$$".getBytes();
		private static final byte[] KAMSG_REP = "$$##".getBytes();

		public Object getRequest(IoSession session) {
			return KAMSG_REQ;
		}

		public Object getResponse(IoSession session, Object request) {
			return KAMSG_REP;
		}

		public boolean isRequest(IoSession session, Object message) {
			return KAMSG_REQ.equals(message);
		}

		public boolean isResponse(IoSession session, Object message) {
			return KAMSG_REP.equals(message);
		}
	}
}
