package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.stang.game.entity.detail.HostStatusDetail;
import com.stang.game.entity.detail.ServerDetail;
import java.util.List;
import com.stang.game.service.IHostStatusService;
import com.stang.game.service.impl.HostStatusServiceImpl;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
 
		String message = null;
		List<HostStatusDetail> hoststatus=new HostStatusServiceImpl().getHostStatus();
		for(int j = 0; j < 5; j++){
			if(!hoststatus.equals(null)){
				break;
			}
		}
		int size=hoststatus.size();
		
		for(int i=0;i<size;i++){
			int id0=hoststatus.get(i).getId();
			if(id0==1){
				message=hoststatus.get(i).getMessage();
			}
		}  
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<html>\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<title>临时维护</title>\r\n");
      out.write("\t\t<link href=\"index3.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\t\t<script type=\"text/JavaScript\" src=\"server1/js/jquery-1.4.3.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"server1/js/qq.js\" charset=\"utf-8\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body>\r\n");
      out.write("\t\t<div id=\"all_top\" style=\"position: relative;height: 150px;\">\r\n");
      out.write("\t\t\t<!-- <div style=\"position: absolute;\">\r\n");
      out.write("\t\t\t<a target=\"blank_\" onclick=\"token()\" > <img\r\n");
      out.write("\t\t\t\t\tsrc=\"img/huangzuan.png\" border=\"0\" style=\"margin-left: 790px;margin-top: 40px;\"/> </a>\r\n");
      out.write("\t\t\t</div> -->\r\n");
      out.write("\t\t\t<div>\r\n");
      out.write("\t\t\t<a target=\"blank_\" href='http://ddxy.foxwan.com/'> <img\r\n");
      out.write("\t\t\t\t\tsrc=\"img/luntan.png\" border=\"0\" style=\"margin-left: 290px;margin-top: 90px;\"/> </a>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div style=\"position: relative; width: 950px; border: 0px solid #000; margin: 0 auto; overflow: hidden;\">\r\n");
      out.write("\t\t\t<div style=\"height:600px; float:left;  width: 950px;\">\r\n");
      out.write("\t\t\t<table id=\"t\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<div id=\"linshi\"> \r\n");
      out.write("\t\t\t\t\t\t\t<div style=\"height:145px;\"></div>\r\n");
      out.write("\t\t\t\t\t\t\t<div id=\"tishi\">\r\n");
      out.write("\t\t\t\t\t\t\t<div>&nbsp&nbsp");
out.print(message);
      out.write("</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div id=\"all_foot\"\r\n");
      out.write("\t\t\tstyle=\"position: relative; background: url('img/banner3.jpg'); height: 250px\">\r\n");
      out.write("\t\t\t<div style=\"height:250px;\"></div>\r\n");
      out.write("\t\t\t<div id=\"foot\">\r\n");
      out.write("\t\t\t<!-- <p>&nbsp&nbsp声明：《颠倒西游》应用是\"泰州三唐信息技术有限公司\"提供，若您的游戏玩不了，请使用【<a href=\"http://bbs.open.qq.com/thread-3315330-1-1.html\" target=\"_blank\">游戏诊所</a>】。</p> -->\r\n");
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
