package com.stang.game.common;

import java.nio.ByteBuffer;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.CumulativeProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;

import com.stang.game.server.AttestationServer;
import com.stang.game.util.ZLibUtils;

/**
 * @author fei_wei
 * @company 上海三唐信息科技有限公司
 * @description 解码器 已经过测试，粘包少包的解决方案
 * @version 2.0
 */
public class AMF3Decoder extends CumulativeProtocolDecoder {

	// private final Amf3Input amf3in;
	public final static byte[] instance843Flag = ("<policy-file-request/>"
			+ "\0").getBytes();

	public AMF3Decoder() {
	}

	public boolean doDecode(IoSession ioSession, IoBuffer in,
			ProtocolDecoderOutput out) throws Exception {
		// System.out.println("dec__" + ++dec);
		int start = in.position();
		int t3 = 0;
		// while (true) {
		if (!in.hasRemaining()) {
			in.position(start);
			return false;
		}
		t3 = in.get();
//		 System.out.println("AMF3Decoder:flag:"+t3);
//		 GameConstants.log.warn("AMF3Decoder:flag:"+t3);
		if (t3 == 't') {// 腾讯防火墙包头协议
			try {
				while (true) {
					t3 = in.get();
					if (t3 == '\r' && in.get() == '\n' && in.get() == '\r'
							&& in.get() == '\n') {
						return true;
					}
				}
			} catch (Exception e) {
				GameConstants.log.error("解析tgw 包长不够:"
						+ ioSession.getRemoteAddress());
				in.position(start);
				return false;
			}
		} else if (t3 == '<') {// 60
			GameConstants.log.warn("as3安全验证接收（" + System.currentTimeMillis() + "）：内容:"+"AMF3Decoder:flag:"+t3);
			try {
				for (byte i = 1; i < instance843Flag.length; i++) {
					int c = (int) in.get();
					if (c != instance843Flag[i]) {
						GameConstants.log.error("被攻击1 ip:"
								+ ioSession.getRemoteAddress() + "无效字符为" + c);
						ioSession.close(true);
						while (in.hasRemaining()) {
							in.get();
						}
						return true;
					}
				}
			} catch (Exception e) {
				GameConstants.log.error("解析crossdomain 包长不够:"
						+ ioSession.getRemoteAddress());
				in.position(start);
				return false;
			}
			ioSession.write(instance843Flag);
			return true;
		} else if (t3 == 31) {// 战斗中央服务器通信协议
		} else if (t3 != 32) {
			GameConstants.log.error("被攻击2 ip:" + ioSession.getRemoteAddress());
			ioSession.close(true);
		}
		// }
		byte[] b = new byte[4];
		for (int i = 0; i < 4; i++) {
			if (!in.hasRemaining()) {
				in.position(start);
				return false;
			}
			b[i] = in.get();
		}
		if (!in.hasRemaining()) {
			in.position(start);
			return false;
		}
		int key = in.get();

		int len = byte2int(b) - 1;
		byte[] sb = new byte[len];

		for (int i = 0; i < len; i++) {
			if (!in.hasRemaining()) {
				in.position(start);
				return false;
			}
			sb[i] = in.get();
		}

		for (int i = 0; i < len; i++) {
			sb[i] = (byte) (sb[i] ^ key);
		}
		sb = ZLibUtils.decompress(sb);
		out.write(sb);
		return true;
	}

	public static int byte2int(byte[] b) {
		return ByteBuffer.wrap(b).getInt();
	}
}
