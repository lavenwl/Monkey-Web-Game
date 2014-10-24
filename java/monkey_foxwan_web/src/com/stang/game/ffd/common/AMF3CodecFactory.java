package com.stang.game.ffd.common;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;

/**
 * @author jianbo.feng
 * @company 上海三唐信息科技有限公司
 * @description AMF3编解码工厂类
 */
public class AMF3CodecFactory implements ProtocolCodecFactory {
	private ProtocolEncoder encoder;
    private ProtocolDecoder decoder;

	public AMF3CodecFactory() {
		// TODO Auto-generated constructor stub
		 encoder = new AMF3Encoder();
         decoder = new AMF3Decoder();
	}

	public ProtocolDecoder getDecoder(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		return decoder;
	}

	public ProtocolEncoder getEncoder(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		return encoder;
	}

}
