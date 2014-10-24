package org.apache.jsp.WEB_002dINF;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.stang.game.service.impl.RightValueServiceImpl;
import com.stang.game.service.impl.RightUserServiceImpl;
import java.util.*;
import com.stang.game.entity.detail.*;

public final class right_005fvalue_005fmanager_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=UTF-8");
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("\t\t<title>Insert title here</title>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body>\r\n");
      out.write("\t\t");

			HashMap param = new HashMap<String, Object>();
			param.put("uid", request.getParameter("uid1"));

			int rightValue = 0;
			List<EntityRightUserDetail> rusl = new RightUserServiceImpl()
					.findRightUserByMap(param);
			if (rusl.size() != 0) {
				EntityRightUserDetail erud = rusl.get(0);
				rightValue = erud.getRight_value();
			}
			List<EntityRightValueDetail> ervdList = new RightValueServiceImpl()
					.findRightValueByMap(new HashMap<String, Object>());
		
      out.write("\r\n");
      out.write("\t\t<table>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t权限描述\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t有\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t无\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t");

				int i = 0;
				for (EntityRightValueDetail ervd : ervdList) {
			
      out.write("\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t");
      out.print(ervd.getRight_context());
      out.write("\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t<input type=\"radio\" name=\"right");
      out.print(i);
      out.write("\"\r\n");
      out.write("\t\t\t\t\t\tvalue=");
      out.print(ervd.getRight_value());
      out.write("\r\n");
      out.write("\t\t\t\t\t\t");
      out.print(((ervd.getRight_value() & rightValue) > 0 ? "checked=checked"
										: ""));
      out.write("></input>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t<input type=\"radio\" name=\"right");
      out.print(i++);
      out.write("\" value=0\r\n");
      out.write("\t\t\t\t\t\t");
      out.print(((ervd.getRight_value() & rightValue) == 0 ? "checked=checked"
										: ""));
      out.write("></input>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t");

			}
			
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td colspan=\"2\">\r\n");
      out.write("\t\t\t\t\t<center>\r\n");
      out.write("\t\t\t\t\t\t<form action=\"right.action\" method=\"post\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"submit\" name=\"optype\" value=\"sure\" onclick=\"sure()\"></input>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"hidden\" id=\"rightValue\" name=\"rightValue\" />\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"hidden\" id=\"uid1\" name=\"uid1\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${uid1}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t</center>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t<script>\r\n");
      out.write("\t\tfunction sure(){\r\n");
      out.write("\t\t\tvar size = ");
      out.print(i);
      out.write(";\r\n");
      out.write("\t\t\tvar a=0;\r\n");
      out.write("\t\t\tfor(i=0;i<size;i++){\r\n");
      out.write("\t\t\t\tif(document.getElementsByName(\"right\"+i)[0].checked){\r\n");
      out.write("\t\t\t\t\ta=a|document.getElementsByName(\"right\"+i)[0].value;\r\n");
      out.write("\t\t\t\t}else\r\n");
      out.write("\t\t\t\t{\r\n");
      out.write("\t\t\t\t\ta=a|document.getElementsByName(\"right\"+i)[1].value;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tdocument.getElementById(\"rightValue\").value=a;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t</script>\r\n");
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
