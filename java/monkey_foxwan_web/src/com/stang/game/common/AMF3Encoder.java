package com.stang.game.common;

import java.nio.charset.Charset;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoder;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;

import com.stang.game.util.ZLibUtils;

/**
 * @author fei_wei
 * @company 上海三唐信息科技有限公司
 * @description AMF3编码器
 */
public class AMF3Encoder implements ProtocolEncoder {
	/**
	 * @method disposse
	 * @param session
	 *            {IoSession}
	 * @return {void}
	 * @description 输出流关闭
	 */
	public void dispose(IoSession session) throws Exception {

	}

	/**
	 * @method encode
	 * @param session
	 *            {IoSession}
	 * @param message
	 *            {Object}
	 * @param out
	 *            {ProtocolEncoderOutput}
	 * @throws {Exception}
	 * @return {void}
	 * @description 编码
	 */
	public void encode(IoSession session, Object message,
			ProtocolEncoderOutput out) throws Exception {
		IoBuffer buffer;

		if (message.equals(AMF3Decoder.instance843Flag)) {}
		byte[] _bytes = (byte[]) message;
		byte bytes[] = ZLibUtils.compress(_bytes);
		byte bt[] = Password.byteConversionAscii(bytes);
		int len = bt.length;
		buffer = IoBuffer.allocate(len + 5, false).setAutoExpand(true);
		buffer.put((byte) 32);
		buffer.putInt(len);
		buffer.put(bt);
		buffer.flip();
		out.write(buffer);
		buffer.free();
		out.flush();

	}
}
