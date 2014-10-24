package com.stang.game.ffd.common;

import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoder;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;


import flex.messaging.io.SerializationContext;
import flex.messaging.io.amf.Amf3Output;

/**
 * @author jianbo.feng
 * @company 上海三唐信息科技有限公司
 * @description AMF3编码器
 */
public class AMF3Encoder implements ProtocolEncoder {

//	private final SerializationContext context = new SerializationContext();
//	private final ThreadLocal<Amf3Output> tdl = new ThreadLocal<Amf3Output>();
//
//	public AMF3Encoder() {
//		// TODO Auto-generated constructor stub		
//		//amf3out = new Amf3Output(context);
//	}
//	
//
//	private Amf3Output getAMF3out(){
//		 if(tdl.get()==null){
//			 tdl.set(new Amf3Output(context));
//		 }
//		
//		return tdl.get();
//	}
	/**
	 * @method disposse
	 * @param session {IoSession} 
	 * @return {void}
	 * @description 输出流关闭
	 */
	public void dispose(IoSession session) throws Exception {

	}

	/**
	 * @method encode
	 * @param session {IoSession} 
	 * @param message {Object}
	 * @param out {ProtocolEncoderOutput}
	 * @throws {Exception}
	 * @return {void}
	 * @description 编码
	 */
	public void encode(IoSession session, Object message,
			ProtocolEncoderOutput out) throws Exception {
		IoBuffer buffer;
		
		// TODO Auto-generated method stub
		//System.out.println(":::"+Thread.activeCount()+":"+clq.size());
//		Amf3Output amf3out = getAMF3out();
//		ByteArrayOutputStream stream = new ByteArrayOutputStream();
//		amf3out.reset();
//		amf3out.setOutputStream(stream);
//		amf3out.writeObject(message);
//		amf3out.flush();
        byte[] _bytes = (byte[])message;
		byte bytes[] = ZLibUtils.compress(_bytes);
		byte bt[]=Password.byteConversionAscii(bytes);
		int len = bt.length;
		buffer = IoBuffer.allocate(len, false).setAutoExpand(true);
		buffer.put((byte)32);
		buffer.putInt(len);
		buffer.put(bt);
		buffer.flip();
		out.write(buffer);
		buffer.free();
		out.flush();
//		amf3out.close();
//		stream.close();
	}
}
