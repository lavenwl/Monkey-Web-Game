package org.apache.jsp.server1;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class in_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");

	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String roleId = (String) session.getAttribute("roleId");
	String p = (String) session.getAttribute("p");
	String openid = (String) session.getAttribute("openid");
	String time = (String) session.getAttribute("time");
	String isadult = (String) session.getAttribute("isadult");
	String flag = (String) session.getAttribute("flag");
	String serverId = (String) session.getAttribute("serverId");
	String serverIp = (String) session.getAttribute("serverIp");
	//String serverId = "1";
	boolean isNew = Boolean.valueOf(String.valueOf(session.getAttribute("isNew")));
	//String pid = (String) session.getAttribute("pid");
	int requestGiftBack = 0;

      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<base href=\"");
      out.print(basePath);
      out.write("\">\r\n");
      out.write("\t\t<title>颠倒西游</title>\r\n");
      out.write("\t\t<link href=\"index3.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\t\t<script type=\"text/javascript\">\r\n");
      out.write("\t\tvar d1=\"");
      out.print(openid);
      out.write("\";\r\n");
      out.write("\t\tvar d5=\"");
      out.print(roleId);
      out.write("\";\r\n");
      out.write("\t\tvar d6=\"");
      out.print(serverId);
      out.write("\";\r\n");
      out.write("\t\tvar d7=\"");
      out.print(serverIp);
      out.write("\";\r\n");
      out.write("\t\tvar d8=\"");
      out.print(p);
      out.write("\";\r\n");
      out.write("\t\tvar isNew=\"");
      out.print(isNew);
      out.write("\";\r\n");
      out.write("\t\tvar requestGiftBack=\"");
      out.print(requestGiftBack);
      out.write("\";\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t\t<script type=\"text/javascript\">\r\n");
      out.write("\t\tfunction mul_servers(){\r\n");
      out.write("\t\tvar openid = \"");
      out.print(openid);
      out.write("\";\r\n");
      out.write("\t\tvar tmp = document.createElement(\"form\");\r\n");
      out.write("\t\tvar action=\"./Server?openid=");
      out.print(openid);
      out.write("&serverId=");
      out.print(serverId);
      out.write("\"\r\n");
      out.write("\t\t     tmp.action = action;\r\n");
      out.write("\t\t     tmp.method = \"post\";\r\n");
      out.write("\t\t     document.body.appendChild(tmp);\r\n");
      out.write("\t\t     tmp.submit();\r\n");
      out.write("\t\t     return tmp;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<script type=\"text/JavaScript\" src=\"server1/js/jquery-1.4.3.js\"></script>\r\n");
      out.write("\t\t<!-- <script type=\"text/JavaScript\" src=\"server1/js/injs.js\"></script> -->\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"server1/js/qq.js\" charset=\"utf-8\"></script>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body style=\"background-image:url(http://cdn.ddxy.foxwan.com/fwRes//notice/beijing.jpg); background-repeat:no-repeat; background-color: black;background-position: center; background-position:top;\" >\r\n");
      out.write("\t\t<div id=\"all_top\" style=\"position: relative;height: 150px;\">\r\n");
      out.write("\t\t\t<!-- <div style=\"position: absolute;\">\r\n");
      out.write("\t\t\t<a target=\"blank_\" onclick=\"token()\" > <img\r\n");
      out.write("\t\t\t\t\tsrc=\"img/huangzuan.png\" border=\"0\" style=\"margin-left: 790px;margin-top: 40px;\"/> </a>\r\n");
      out.write("\t\t\t</div> -->\r\n");
      out.write("\t\t\t<div>\r\n");
      out.write("\t\t\t<a target=\"blank_\" href='http://apiport.foxwan.com/redirect/pay?game=ddxy&sid=");
      out.print(serverId);
      out.write("&uname=");
      out.print(openid);
      out.write("'> <img\r\n");
      out.write("\t\t\t\t\tsrc=\"img/buycoin.png\" border=\"0\" style=\"margin-left: 290px;margin-top: 90px;\"/> </a>\r\n");
      out.write("\t\t\t<!-- <a href='javascript:void(0)' onclick='invite()'><img\r\n");
      out.write("\t\t\t\t\tsrc=\"img/friend.png\" border=\"0\" /> </a> -->\r\n");
      out.write("\t\t\t<a target=\"blank_\" href='http://ddxy.foxwan.com/'> <img\r\n");
      out.write("\t\t\t\t\tsrc=\"img/luntan.png\" border=\"0\" /> </a>\r\n");
      out.write("\t\t\t<!--<a target=\"blank_\" onclick=\"token()\" href='http://bbs.open.qq.com/thread-3315330-1-1.html'> <img\r\n");
      out.write("\t\t\t\t\tsrc=\"img/youxizhensuo.png\" border=\"0\" /> </a>\t-->\t\r\n");
      out.write("\t\t\t<!--<a target=\"blank_\" onclick=\"getGroupFriends()\"> <img\r\n");
      out.write("\t\t\t\t\tsrc=\"img/soucangyouxi.png\" border=\"0\" /> </a> -->\r\n");
      out.write("\t\t\t<!--<a href=\"download.jsp\"><img\r\n");
      out.write("\t\t\t\t\tsrc=\"img/baocunzhuomian.png\" border=\"0\" /></a>-->\r\n");
      out.write("\t\t\t<!--<a target=\"blank_\" onclick=\"toDesktop('www.baidu.com','baidu')\"> <img\r\n");
      out.write("\t\t\t\t\tsrc=\"img/baocunzhuomian.png\" border=\"0\" /> </a>-->\r\n");
      out.write("\t\t\t<!--<a target=\"blank_\" onclick=\"mul_servers()\"> <img\r\n");
      out.write("\t\t\t\t\tsrc=\"img/huangzuan.png\" border=\"0\" /> </a> -->\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div style=\"position: relative; width: 950px; border: 0px solid #000; margin: 0 auto; overflow: hidden;\">\r\n");
      out.write("\t\t\t<div style=\"height:600px; float:left;  width: 950px;\">\r\n");
      out.write("\t\t\t<table id=\"t\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t<object classid=\"clsid:D27CDB6E-AE6D-11cf-96B8-444553540000\"\r\n");
      out.write("\t\t\t\t\t\t\tcodebase=\"http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0\"\r\n");
      out.write("\t\t\t\t\t\t\twidth=\"950\" height=\"600\" id=\"FlashID\" align=\"middle\">\r\n");
      out.write("\t\t\t\t\t\t\t");
if(!serverId.equals("666")){
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<param name=\"movie\" id=\"myout\" value=\"out.swf?");
      out.print(Math.random());
      out.write("\" />\r\n");
      out.write("\t\t\t\t\t\t\t");
}else{
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t<param name=\"movie\" id=\"myout\" value=\"out_beta.swf?");
      out.print(Math.random());
      out.write("\" />\r\n");
      out.write("\t\t\t\t\t\t\t");
}
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<param name=\"quality\" value=\"high\" />\r\n");
      out.write("\t\t\t\t\t\t\t<param name=\"wmode\" value=\"transparent\" />\r\n");
      out.write("\t\t\t\t\t\t\t<param name=\"swfversion\" value=\"11.0\" />\r\n");
      out.write("\t\t\t\t\t\t\t<param name=\"expressinstall\" value=\"");
      out.print(basePath);
      out.write("server1/Scripts/expressInstall.swf\" />\r\n");
      out.write("\t\t\t\t\t\t\t<param name=\"allowNetworking\" value=\"all\" />\r\n");
      out.write("\t\t\t\t\t\t\t<param name=\"AllowScriptAccess\" value=\"always\" />\r\n");
      out.write("\t\t\t\t\t\t\t<param name=\"allowFullScreen\" value=\"true\" />\r\n");
      out.write("\t\t\t\t\t\t\t");
if(!serverId.equals("666")){
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<embed src=\"out.swf?");
      out.print(Math.random());
      out.write("\" name=\"FlashID\" id=\"FlashID2\" quality=\"high\"\r\n");
      out.write("\t\t\t\t\t\t\t\tallowScriptAccess=\"always\" swLiveConnect=\"true\"\r\n");
      out.write("\t\t\t\t\t\t\t\tpluginspage=\"http://www.macromedia.com/go/getflashplayer\"\r\n");
      out.write("\t\t\t\t\t\t\t\ttype=\"application/x-shockwave-flash\" width=\"950\" height=\"600\">\r\n");
      out.write("\t\t\t\t\t\t\t</embed>\r\n");
      out.write("\t\t\t\t\t\t\t");
}else{
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<embed src=\"out_beta.swf?");
      out.print(Math.random());
      out.write("\" name=\"FlashID\" id=\"FlashID2\" quality=\"high\"\r\n");
      out.write("\t\t\t\t\t\t\t\tallowScriptAccess=\"always\" swLiveConnect=\"true\"\r\n");
      out.write("\t\t\t\t\t\t\t\tpluginspage=\"http://www.macromedia.com/go/getflashplayer\"\r\n");
      out.write("\t\t\t\t\t\t\t\ttype=\"application/x-shockwave-flash\" width=\"950\" height=\"600\">\r\n");
      out.write("\t\t\t\t\t\t\t</embed>\r\n");
      out.write("\t\t\t\t\t\t\t");
}
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t</object>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div id=\"all_foot\"\r\n");
      out.write("\t\t\tstyle=\"position: relative; background: url('img/banner3.jpg'); height: 250px\">\r\n");
      out.write("\t\t\t<div style=\"height:250px;\"></div>\r\n");
      out.write("\t\t\t<div id=\"foot\">\r\n");
      out.write("\t\t\t<div style=\"position: relative; text-align:center;\"><font size=\"2px\">人物ID:");
      out.print(roleId );
      out.write("    OPENID:");
      out.print(openid );
      out.write("     所在服务器：");
      out.print(serverId );
      out.write("区</font></div>\r\n");
      out.write("\t\t\t<!-- <p>&nbsp&nbsp声明：《颠倒西游》应用是\"泰州三唐信息技术有限公司\"提供。</p>  -->\r\n");
      out.write("\t\t\t<p>&nbsp&nbsp如需帮助，请到【<a href=\"http://ddxy.foxwan.com/\" target=\"_blank\">论坛</a>】提交问题或加qq群：171674530，会有专业的客服人员为您解答问题。</p>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else log(t.getMessage(), t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
