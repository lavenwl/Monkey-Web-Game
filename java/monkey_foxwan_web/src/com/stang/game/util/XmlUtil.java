package com.stang.game.util;

import java.io.FileWriter;
import java.net.URL;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import com.stang.game.common.GameConstants;

/**
 * @author fei_wei
 * @company 上海三唐信息科技有限公司
 * @description Xml文件处理
 */
public class XmlUtil {

	/* 文件路径 */
	private String filePath = "";

	/* XML解析器 */
	private SAXReader reader = null;

	/* 文档对象 */
	private Document document = null;

	/**
	 * @method XmlUtil
	 * @param filePath
	 *            {String} 文件路径
	 * @description 根据文件路径初始化
	 */
	public XmlUtil(String filePath) {
		this.filePath = filePath;
		if (reader == null) {
			reader = new SAXReader();
		}
		try {
			URL path = Thread.currentThread().getContextClassLoader()
					.getResource(this.filePath);
			document = reader.read(path.toString());
		} catch (DocumentException e) {
			GameConstants.log.warn("", e);
		}
	}

	/**
	 * @method getDocument
	 * @return {Document}
	 * @description 得到文档对象
	 */
	public Document getDocument() {
		return this.document;
	}

	/**
	 * @method getRootElement
	 * @return {Element}
	 * @description 得到根节点
	 */
	public Element getRootElement() {
		return document.getRootElement();
	}

	/**
	 * @method getChildrensByElement
	 * @param element
	 *            {Element} 节点对象
	 * @param childElementName
	 *            {String} 子节点(Tag Name)名字
	 * @return {List<Element>}
	 * @description 根据节点获得所有子节点
	 */
	public List<Element> getChildrensByElement(Element element,
			String childElementName) {
		List eleList = element.elements(childElementName);
		List<Element> elements = null;
		if (!eleList.isEmpty()) {
			elements = (List<Element>) eleList;
		}
		eleList = null;
		return elements;
	}

	/**
	 * @method save
	 * @param encoding
	 *            {String} 编码格式,默认为"GB2312"
	 * @return 根据编码格式保存XML[由于使用'UTF-8'处理中文会有问题,故建议使用'GB2312'处理中文]
	 */
	public boolean save(String encoding) {
		boolean saveFlag = false;

		try {
			if (encoding == null || encoding.trim().equals("")) {
				encoding = "GB2312";
			}
			OutputFormat format = OutputFormat.createPrettyPrint();
			format.setEncoding(encoding);
			XMLWriter writer = new XMLWriter(new FileWriter(filePath), format);
			writer.write(document);
			writer.close();
			saveFlag = true;
		} catch (Exception e) {

		}

		return saveFlag;
	}

}
