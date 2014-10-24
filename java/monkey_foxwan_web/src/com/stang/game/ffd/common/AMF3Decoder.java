package com.stang.game.ffd.common;

import java.nio.ByteBuffer;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.CumulativeProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;


/**
 * @author Sunset Shen
 * @company 上海三唐信息科技有限公司
 * @description 解码器 已经过测试，粘包少包的解决方案
 * @version 2.0
 */
public class AMF3Decoder extends CumulativeProtocolDecoder {

//	private final Amf3Input amf3in;
	public final static byte[] instance843Flag = ("<policy-file-request/>"+"\0").getBytes();
	public AMF3Decoder() {
//		amf3in = new Amf3Input(context);
	}

//	int dec = 0;
//	int dec_ = 0;

	public boolean doDecode(IoSession ioSession, IoBuffer in,
			ProtocolDecoderOutput out) throws Exception {
//		System.out.println("dec__" + ++dec);

		int start = in.position();
		int t3 = 0;
		//while (true) {
			if (!in.hasRemaining()) {
				in.position(start);
				return false;
			}
//			t1 = t2;
//			t2 = t3;
			t3 = in.get();
//			System.out.println("flag:"+t3);

		//}
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
