package com.qq.open;

/**
 * 定义错误码。
 * 
 * @version 3.0.0
 * @since jdk1.5
 * @author open.qq.com
 * @copyright © 2012, Tencent Corporation. All rights reserved.
 * @History: 3.0.0 | nemozhang | 2012-03-21 12:01:05 | initialization
 * 
 */

public class ErrorCode {

	// 序列化UID
	private static final long serialVersionUID = -1679458253208555786L;

	/**
	 * 必填参数为空。
	 */
	public final static int PARAMETER_EMPTY = 2001;

	/**
	 * 必填参数无效。
	 */
	public final static int PARAMETER_INVALID = 2002;

	/**
	 * 服务器响应数据无效。
	 */
	public final static int RESPONSE_DATA_INVALID = 2003;

	/**
	 * 生成签名失败。
	 */
	public final static int MAKE_SIGNATURE_ERROR = 2004;

	/**
	 * 网络错误。
	 */
	public final static int NETWORK_ERROR = 3000;
}
