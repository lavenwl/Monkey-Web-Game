package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t\tfunction check(){\r\n");
      out.write("\t\t\t\tif(document.getElementById(\"memberUsername\").value==\"\"){\r\n");
      out.write("\t\t\t\t\talert(\"ç¨æ·åä¸ºç©ºææ ¼å¼éè¯¯\");\r\n");
      out.write("\t\t\t\t\treturn false;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\tif(document.getElementById(\"memberPassword\").value==\"\"){\r\n");
      out.write("\t\t\t\t\talert(\"å¯ç ä¸è½ä¸ºç©º\");\r\n");
      out.write("\t\t\t\t\treturn false;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\tif(document.getElementById(\"memberPassword\").value!=\"\"\r\n");
      out.write("\t\t\t\t\t&&document.getElementById(\"memberUsername\").value!=\"\"){\r\n");
      out.write("\t\t\t\t\t return true;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t  \r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t\t<title>æ¬¢è¿æ¥å°é¢ åè¥¿æ¸¸</title>\r\n");
      out.write("\t\t<link href=\"index2.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body onselectstart=\"return false\">\r\n");
      out.write("\t\t<div class=\"wrapper\">\r\n");
      out.write("\t\t\t<div class=\"content\">\r\n");
      out.write("\t\t\t\t<form name=\"loading\" action=\"./Loadingtohomejsp\" method=\"post\">\r\n");
      out.write("\t\t\t\t\t<input id=\"memberUsername\" type=\"text\" name=\"memberUsername\"\r\n");
      out.write("\t\t\t\t\t\t\" />\r\n");
      out.write("\t\t\t\t\t<p></p>\r\n");
      out.write("\t\t\t\t\t<input id=\"memberPassword\" type=\"password\" name=\"memberPassword\"\r\n");
      out.write("\t\t\t\t\t\t />\r\n");
      out.write("\t\t\t\t\t<input id=\"tijiao\" type=\"submit\" onclick=\"return check()\"\r\n");
      out.write("\t\t\t\t\t\tclass=\"denglu\" onMouseOver=\"this.className='denglu2'\"\r\n");
      out.write("\t\t\t\t\t\tonMouseOut=\"this.className='denglu'\" />\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"warmtips\">\r\n");
      out.write("\t\t\t\t<p style=\"\">\r\n");
      out.write("\t\t\t\t\tå£°æï¼ãé¢ åè¥¿æ¸¸ãåºç¨æ¯\"ä¸æµ·ä¸åä¿¡æ¯ç§ææéå¬å¸\"æä¾ï¼è¥æ¨çæ¸¸æç©ä¸äºï¼è¯·ä½¿ç¨\r\n");
      out.write("\t\t\t\t\t<a id=\"link_doctor onclick=\"showguanjia()\">ãæ¸¸æè¯æã</a>\r\n");
      out.write("\t\t\t\t\t<br />\r\n");
      out.write("\t\t\t\t\tå¦éå¸®å©ï¼è¯·èç³»æä»¬\r\n");
      out.write("\t\t\t\t\t<a onclick=\"showguanjia()\">ãå®¢æå¹³å°ã</a>æèå°\r\n");
      out.write("\t\t\t\t\t<a onclick=\"showguanjia()\">ãè®ºåã</a>æäº¤é®é¢æèç³»å®¢æçµè¯ï¼---ï¼ä¼æä¸ä¸çå®¢æäººåä¸ºæ¨è§£ç­é®é¢ã\r\n");
      out.write("\t\t\t\t</p>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</body>\r\n");
      out.write("</html>\r\n");
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
