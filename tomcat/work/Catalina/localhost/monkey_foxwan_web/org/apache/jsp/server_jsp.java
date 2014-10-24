package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import com.stang.game.entity.detail.ServerDetail;

public final class server_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("     \r\n");
      out.write("     \r\n");
      out.write("     \r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");

	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String pf = (String) session.getAttribute("pf");
	String openid = (String) session.getAttribute("openid");
	String openkey = (String) session.getAttribute("openkey");
	String pfkey = (String) session.getAttribute("pfkey");
	String success = (String) session.getAttribute("success");
	String serverid = (String) session.getAttribute("serverId");
	Map<String, Object> map =  (HashMap<String, Object>)session.getAttribute("servermap");
	List<ServerDetail> serverlist = (List<ServerDetail>)map.get("serverlist");
	List<ServerDetail> roleServerlist = (List<ServerDetail>)map.get("roleServerlist");
	int serverlistsize = serverlist.size();
	int roleServerlistsize = roleServerlist.size();
	boolean isNew = Boolean.valueOf(String.valueOf(session.getAttribute("isNew")));
	//String pid = (String) session.getAttribute("pid");

      out.write("\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta name=\"Copyright\" content=\"Tencent\" />\r\n");
      out.write("<meta name=\"Description\" content=\"腾讯,社区,开放平台\" />\r\n");
      out.write("<meta name=\"Keywords\" content=\"腾讯社区开放平台、开放平台、腾讯社区\" />\r\n");
      out.write("<title>网页游戏、社交游戏专区 - 腾讯游戏</title>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/html/css/selectarea.css\"  charset=\"gb2312\"/>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"http://openwebgame.qq.com/style_manage/GetStyleData.php?iAppId=100673142&action=custom&datatype=css\"/>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" charset=\"gb2312\">\r\n");
      out.write("var iAppId = \"100719210\";\r\n");
      out.write("</script>\r\n");
      out.write("<style>\r\n");
      out.write("/*add by filedwu*/\r\n");
      out.write("/*.wy_serList li{ position:static}*/\r\n");
      out.write("/*add by filedwu*/\r\n");
      out.write("#theServiceList{padding:18px;width:700px;border:#660099 1px solid;height:425px; overflow:hidden;overflow-y:auto; position:relative;}\r\n");
      out.write("/*.wy_serverT { border:#d5ba94 1px solid;}\r\n");
      out.write(".wy_serverT div { background:#eedbad; color:#70502c}*/\r\n");
      out.write(".wy_serverT .wy_lastLogin { color:#70502c}\r\n");
      out.write(".serSortstag { color:#70502c; font-size:12px; line-height:22px; width:100%; text-align:left; font-weight:bold}\r\n");
      out.write(".txidnt { text-indent:11px; margin-bottom:4px}\r\n");
      out.write(".servrlishad {}\r\n");
      out.write("/*.wy_serverT { position:static}*/\r\n");
      out.write("\r\n");
      out.write(".wy_banner {display:none}\r\n");
      out.write(".wy_lastLogin{display:none}\r\n");
      out.write(".wlop_area{display:none}\r\n");
      out.write(".wlop_area_tab{display:none}\r\n");
      out.write(".display_checkbox {margin:0px 0px 0px 0px}\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("<script type=\"text/javascript\" src=\"http://tajs.qq.com/stats?sId=22050343\" charset=\"UTF-8\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("function loginNew(appid,serverid,serverip,str ){\r\n");
      out.write("var openid = '");
      out.print(openid);
      out.write("';\r\n");
      out.write("var openkey ='");
      out.print(openkey);
      out.write("';\r\n");
      out.write("var pf = '");
      out.print(pf);
      out.write("';\r\n");
      out.write("var pfkey = '");
      out.print(pfkey);
      out.write("';\r\n");
      out.write("var success = '");
      out.print(success);
      out.write("';\r\n");
      out.write("var serverId = serverid;\r\n");
      out.write("var serverIp = serverip;\r\n");
      out.write("var tmp = document.createElement(\"form\");\r\n");
      out.write("var action=\"./Loading?openid=");
      out.print(openid);
      out.write("&pf=");
      out.print(pf);
      out.write("&openkey=");
      out.print(openkey);
      out.write("&pfkey=");
      out.print(pfkey);
      out.write("&serverId=\" + serverId + \"&serverIp=\" + serverIp + \"&success=");
      out.print(success);
      out.write("\"\r\n");
      out.write("     tmp.action = action;\r\n");
      out.write("     tmp.method = \"post\";\r\n");
      out.write("     document.body.appendChild(tmp);\r\n");
      out.write("     tmp.submit();\r\n");
      out.write("     return tmp;\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<div class=\"w717\">\r\n");
      out.write("    <div class=\"wy_name s_sp\"><b class=\"fl mt6 wy_favicon\"></b><h3 class=\"fl stroke\">应用ID:100719210</h3></div>\r\n");
      out.write("    <div class=\"wy_box s_bd\">\r\n");
      out.write("        <div class=\"wy_fastinfo c\"><ul class=\"wy_notice\"><li><i class=\"wyico1 wy_ico\"></i><em id=\"notice\"> 恭喜本应用隆重发布</em></li></ul><p class=\"wy_like fr\"><!--iframe src=\"http://open.qzone.qq.com/like?url=http%3A%2F%2Fuser.qzone.qq.com%2F706290408&width=400&height=30&type=button_num\" allowtransparency=\"true\" scrolling=\"no\" border=\"0\" frameborder=\"0\" style=\"width:160px;height:30px;border:none;overflow:hidden;\"></iframe--></p><p class=\"fr\"><!--a href=\"#\" class=\"wy_wb fl c\"><i class=\"wyico2 wy_ico fl\"></i><b class=\"fl\">寻侠</b></a><a href=\"#\" class=\"fl txt_a1 plr5\">立即收听</a--></p></div>\r\n");
      out.write("        <div class=\"wy_navbox mb10\"><ul class=\"c\"><li><a  class=\"wyNav wycur s_sp\">选择服务器</a></li><!--li><a href=\"#\" class=\"wyNav s_sp\">邀请好友</a></li><li><a href=\"#\" class=\"wyNav s_sp\">游戏介绍</a></li><li><a href=\"#\" class=\"wyNav s_sp\">进入官网</a></li><li><a href=\"#\" class=\"wyNav s_sp\">游戏充值</a></li><li><a href=\"#\" class=\"wyNav s_sp\">论坛</a></li--></ul></div>\r\n");
      out.write("        <div class=\"wy_banner bd_b mb10\"><p class=\"wy_banner_pic\"></p></div>\r\n");
      out.write("        <!--推荐\\最近服务器列表-->\r\n");
      out.write("        <div id=\"zjdl\">\r\n");
      out.write("            <div class=\"wy_serverT\"><div><h4>推荐服务器</h4><a href=\"#\" class=\"wy_lastLogin\"><span onclick=\"\">点击查看所有服务器</span></a></div></div>\r\n");
      out.write("            <div class=\"wy_recommend\">\r\n");
      out.write("                <div class=\"wy_recommend_btn\">\r\n");
      out.write("                \t ");
int l = serverlist.size();
                	 if(l!=0){
             for(int i = 0; i < l; i++){
             ServerDetail server = serverlist.get(i);
             if(server.getStatue_on()==1){
             if(server.getStatue_tui()==1){
             i=l;
      out.write("\r\n");
      out.write("                     <a href=\"javascript:loginNew(100673142,");
      out.print( server.getId());
      out.write(',');
      out.write('\'');
      out.print( server.getIp());
      out.write("','release');\">\r\n");
      out.write("                        <em>");
      out.print(server.getName() );
      out.write("</em>\r\n");
      out.write("                    \t<span>进入游戏</span>                    \r\n");
      out.write("                     </a>\r\n");
      out.write("                \r\n");
      out.write("             ");
 }}}} 
      out.write("\r\n");
      out.write("                \r\n");
      out.write("                       <!--  <a href=\"javascript:loginNew(100673142,1,'release');\">\r\n");
      out.write("                        <em>一线一区   观音寺</em>\r\n");
      out.write("                        <span>进入游戏</span></a> -->\r\n");
      out.write("            </div>                \r\n");
      out.write("            <div class=\"wy_serStatus\">\r\n");
      out.write("                    <p>我们根据您使用的网络环境为您推荐左侧服务器</p>\r\n");
      out.write("                    <i class=\"wy_ico_b wy_ico\"></i><b>繁忙</b><i class=\"wy_ico_c wy_ico\"></i><b>拥挤</b><i class=\"wy_ico_o wy_ico\"></i><b>畅通</b><i class=\"wy_ico_m wy_ico\"></i><b>维护</b>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <!--<div class=\"tabMenu\">\r\n");
      out.write("             <ul class=\"c\"><li><strong>推荐服务器</strong></li></ul>\r\n");
      out.write("             </div>\r\n");
      out.write("            -->\r\n");
      out.write("            <div class=\"tabCnt zjtj_server\">\r\n");
      out.write("                <ul class=\"wy_serList zltj_server c\">\r\n");
      out.write("                ");
 l = serverlist.size();
                if(l!=0){
             for(int i = 0; i < l; i++){
             ServerDetail server = serverlist.get(i);
             if(server.getStatue_on()==1){
             if(server.getStatue_tui()==1){
             i=l;
      out.write("\r\n");
      out.write("             \t<li>");
if(server.getStatue_mag()==4){ 
      out.write("\r\n");
      out.write("             \t\t<a href=\"javascript:alert('很抱歉，服务器处于停机状态，无法进入！');\">\r\n");
      out.write("                    ");
}else{ 
      out.write("\r\n");
      out.write("                     <a href=\"javascript:loginNew(100673142,");
      out.print( server.getId());
      out.write(',');
      out.write('\'');
      out.print( server.getIp());
      out.write("','release');\">\r\n");
      out.write("                    ");
} 
      out.write("\r\n");
      out.write("                        <em class=\"fl\">");
      out.print(server.getName() );
      out.write("</em>\r\n");
      out.write("                        ");
if(server.getStatue_mag()==1){ 
      out.write("\r\n");
      out.write("                   \t\t\t<b class=\"wy_ico_b wy_ico\"></b>  \r\n");
      out.write("                    \t");
}else if(server.getStatue_mag()==2){ 
      out.write("\r\n");
      out.write("                    \t\t<b class=\"wy_ico_c wy_ico\"></b>\r\n");
      out.write("                    \t");
}else if(server.getStatue_mag()==3){ 
      out.write("\r\n");
      out.write("                    \t\t<b class=\"wy_ico_o wy_ico\"></b> \r\n");
      out.write("                    \t");
}else if(server.getStatue_mag()==4){ 
      out.write("\r\n");
      out.write("                  \t\t\t<b class=\"wy_ico_m wy_ico\"></b>\r\n");
      out.write("                    \t");
} 
      out.write("\r\n");
      out.write("                    \t");
if(server.getStatue_xin()==1){ 
      out.write("\r\n");
      out.write("                   \t\t\t<b class=\"wy_ico_new wy_ico\"></b>  \r\n");
      out.write("                    \t");
} 
      out.write("\r\n");
      out.write("                    \t");
if(server.getStatue_tui()==1){ 
      out.write("\r\n");
      out.write("                   \t\t\t<b class=\"wy_ico_j wy_ico\"></b>\r\n");
      out.write("                    \t");
} 
      out.write("                     \r\n");
      out.write("                     </a>\r\n");
      out.write("                </li>\r\n");
      out.write("             ");
 }}} }
      out.write("\r\n");
      out.write("               <!--  <li>\r\n");
      out.write("        \t\t\t<a href=\"javascript:loginNew(100673142,1,'release');\">\r\n");
      out.write("            \t\t\t<em class=\"fl\">一线一区   观音寺</em>\r\n");
      out.write("            \t\t\t<b class=\"wy_ico_o wy_ico\"></b>            \r\n");
      out.write("            \t\t\t<b class=\"wy_ico_new wy_ico\"></b>\r\n");
      out.write("            \t\t\t<b class=\"wy_ico_j wy_ico\"></b>        \r\n");
      out.write("            \t\t</a>\r\n");
      out.write("    \t\t\t</li> -->\r\n");
      out.write("            \t</ul>            \r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"tabbox_x c\">\r\n");
      out.write("                <div class=\"wy_serverT\"><div><h4>最近登录服务器</h4></div></div>\r\n");
      out.write("                <div class=\"tabMenu\">\r\n");
      out.write("                    <ul class=\"c\">\r\n");
      out.write("                        <li id=\"dlnav0\" onClick=\"settab('dlnav',0,2)\" class=\"hover\"><b>上次登录</b></li>\r\n");
      out.write("                        <li id=\"dlnav1\" onClick=\"settab('dlnav',1,2)\"><b>我的服务器</b></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </div>\r\n");
      out.write("     <div class=\"tabCnt\">\r\n");
      out.write("        <div id=\"con_dlnav_0\">\r\n");
      out.write("          <ul class=\"wy_serList zjdl_list c\">\r\n");
      out.write("          \t");

          	if(roleServerlist.size()!=0){
             for(int i = 0; i < 1; i++){
             ServerDetail server = roleServerlist.get(i);
             if(server.getStatue_on()==1){
      out.write("\r\n");
      out.write("             \t<li>");
if(server.getStatue_mag()==4){ 
      out.write("\r\n");
      out.write("             \t\t<a href=\"javascript:alert('很抱歉，服务器处于停机状态，无法进入！');\">\r\n");
      out.write("                    ");
}else{ 
      out.write("\r\n");
      out.write("                     <a href=\"javascript:loginNew(100673142,");
      out.print( server.getId());
      out.write(',');
      out.write('\'');
      out.print( server.getIp());
      out.write("','release');\">\r\n");
      out.write("                    ");
} 
      out.write("\r\n");
      out.write("                        <em class=\"fl\">");
      out.print(server.getName() );
      out.write("</em>\r\n");
      out.write("                        ");
if(server.getStatue_mag()==1){ 
      out.write("\r\n");
      out.write("                   \t\t\t<b class=\"wy_ico_b wy_ico\"></b>  \r\n");
      out.write("                    \t");
}else if(server.getStatue_mag()==2){ 
      out.write("\r\n");
      out.write("                    \t\t<b class=\"wy_ico_c wy_ico\"></b>\r\n");
      out.write("                    \t");
}else if(server.getStatue_mag()==3){ 
      out.write("\r\n");
      out.write("                    \t\t<b class=\"wy_ico_o wy_ico\"></b> \r\n");
      out.write("                    \t");
}else if(server.getStatue_mag()==4){ 
      out.write("\r\n");
      out.write("                  \t\t\t<b class=\"wy_ico_m wy_ico\"></b>\r\n");
      out.write("                    \t");
} 
      out.write("\r\n");
      out.write("                    \t");
if(server.getStatue_xin()==1){ 
      out.write("\r\n");
      out.write("                   \t\t\t<b class=\"wy_ico_new wy_ico\"></b>  \r\n");
      out.write("                    \t");
} 
      out.write("\r\n");
      out.write("                    \t");
if(server.getStatue_tui()==1){ 
      out.write("\r\n");
      out.write("                   \t\t\t<b class=\"wy_ico_j wy_ico\"></b>\r\n");
      out.write("                    \t");
} 
      out.write("                     \r\n");
      out.write("                     </a>\r\n");
      out.write("                     <span class=\"time\">");
      out.print(server.getTime());
      out.write("</span>\r\n");
      out.write("                </li>\r\n");
      out.write("             ");
 }}} 
      out.write("\r\n");
      out.write("           <!--  <li>\r\n");
      out.write("        \t\t<a href=\"javascript:loginNew(100673142,2,'release');\">\r\n");
      out.write("           \t\t \t<em class=\"fl\">一线二区   黑风洞</em>\r\n");
      out.write("            \t\t<b class=\"wy_ico_o wy_ico\"></b>                    \r\n");
      out.write("            \t</a>\r\n");
      out.write("        \t\t<span class=\"time\">2013年08月26日 19:38</span>\r\n");
      out.write("    \t\t</li>-->\r\n");
      out.write("        </ul>\r\n");
      out.write("         </div>\r\n");
      out.write("         <div id=\"con_dlnav_1\" style=\"display:none\">\r\n");
      out.write("            <ul class=\"wy_serList zjdl_list c\">\r\n");
      out.write("            \t ");
 l = roleServerlist.size();
            	 if(l>5){
            	 l=5;}
            	 if(l!=0){
             for(int i = 0; i < l; i++){
             ServerDetail server = roleServerlist.get(i);
             if(server.getStatue_on()==1){
      out.write("\r\n");
      out.write("             \t<li>");
if(server.getStatue_mag()==4){ 
      out.write("\r\n");
      out.write("             \t\t<a href=\"javascript:alert('很抱歉，服务器处于停机状态，无法进入！');\">\r\n");
      out.write("                    ");
}else{ 
      out.write("\r\n");
      out.write("                     <a href=\"javascript:loginNew(100673142,");
      out.print( server.getId());
      out.write(',');
      out.write('\'');
      out.print( server.getIp());
      out.write("','release');\">\r\n");
      out.write("                    ");
} 
      out.write("\r\n");
      out.write("                        <em class=\"fl\">");
      out.print(server.getName() );
      out.write("</em>\r\n");
      out.write("                        ");
if(server.getStatue_mag()==1){ 
      out.write("\r\n");
      out.write("                   \t\t\t<b class=\"wy_ico_b wy_ico\"></b>  \r\n");
      out.write("                    \t");
}else if(server.getStatue_mag()==2){ 
      out.write("\r\n");
      out.write("                    \t\t<b class=\"wy_ico_c wy_ico\"></b>\r\n");
      out.write("                    \t");
}else if(server.getStatue_mag()==3){ 
      out.write("\r\n");
      out.write("                    \t\t<b class=\"wy_ico_o wy_ico\"></b> \r\n");
      out.write("                    \t");
}else if(server.getStatue_mag()==4){ 
      out.write("\r\n");
      out.write("                  \t\t\t<b class=\"wy_ico_m wy_ico\"></b>\r\n");
      out.write("                    \t");
} 
      out.write("\r\n");
      out.write("                    \t");
if(server.getStatue_xin()==1){ 
      out.write("\r\n");
      out.write("                   \t\t\t<b class=\"wy_ico_new wy_ico\"></b>  \r\n");
      out.write("                    \t");
} 
      out.write("\r\n");
      out.write("                    \t");
if(server.getStatue_tui()==1){ 
      out.write("\r\n");
      out.write("                   \t\t\t<b class=\"wy_ico_j wy_ico\"></b>\r\n");
      out.write("                    \t");
} 
      out.write("                     \r\n");
      out.write("                     </a>\r\n");
      out.write("                     <span class=\"time\">");
      out.print(server.getTime());
      out.write("</span>\r\n");
      out.write("                </li>\r\n");
      out.write("             ");
 }} }
      out.write("\r\n");
      out.write("            \t<!--<li>\r\n");
      out.write("        \t\t\t<a href=\"javascript:loginNew(100673142,1,'release');\">\r\n");
      out.write("            \t\t\t<em class=\"fl\">一线一区   观音寺</em>\r\n");
      out.write("            \t\t\t<b class=\"wy_ico_o wy_ico\"></b>                    </a>\r\n");
      out.write("        \t\t\t\t<span class=\"time\">2013年08月26日 19:38</span>\r\n");
      out.write("    \t\t\t</li>\r\n");
      out.write("                <li>\r\n");
      out.write("        \t\t\t<a href=\"javascript:loginNew(100673142,2,'release');\">\r\n");
      out.write("            \t\t\t<em class=\"fl\">一线一区   黑风洞</em>\r\n");
      out.write("            \t\t\t<b class=\"wy_ico_o wy_ico\"></b>                    </a>\r\n");
      out.write("        \t\t\t\t<span class=\"time\">2013年08月26日 19:36</span>\r\n");
      out.write("    \t\t\t</li>-->\r\n");
      out.write("        </ul>\r\n");
      out.write("                        <div style=\"padding:10px;float:right;\">本栏目最多显示5个我最近登录过的服务器</div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!--推荐\\最近服务器列表End-->\r\n");
      out.write("        <!--所有服务器列表-->\r\n");
      out.write("        <div id=\"sevlist\">\r\n");
      out.write("            <div class=\"wy_serverT\"><div><h4 id=\"font1\">所有服务器</h4>\r\n");
      out.write("                    <a href=\"#\" class=\"wy_lastLogin zjdl\"><span onclick=\"zjdllist()\">返回首页</span></a></div></div>\r\n");
      out.write("<div class=\"tabbox_x c\">\r\n");
      out.write("    <!--div class=\"wy_serStatus\"><i class=\"wy_ico_b wy_ico\"></i><b>繁忙</b><i class=\"wy_ico_c wy_ico\"></i><b>拥挤</b><i class=\"wy_ico_o wy_ico\"></i><b>畅通</b><i class=\"wy_ico_m wy_ico\"></i><b>维护</b></div-->\r\n");
      out.write("    <div class=\"tabMenu\">\r\n");
      out.write("        <ul class=\"c\">\r\n");
      out.write("                                                <li id=\"daqu0\" onclick=\"settabcls('daqu',0,1)\" class=\"hover\" >颠倒西游</li>\r\n");
      out.write("                                            </ul>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"tabCnt\">\r\n");
      out.write("        <div id=\"con_daqu_0\" >\r\n");
      out.write("             <ul class=\"wy_serList c\">\r\n");
      out.write("             ");
 l = serverlist.size();
             if(l!=0){
             for(int i = 0; i < l; i++){
             ServerDetail server = serverlist.get(i);
             if(server.getStatue_on()==1){
      out.write("\r\n");
      out.write("             \t<li>");
if(server.getStatue_mag()==4){ 
      out.write("\r\n");
      out.write("             \t\t<a href=\"javascript:alert('很抱歉，服务器处于停机状态，无法进入！');\">\r\n");
      out.write("                    ");
}else{ 
      out.write("\r\n");
      out.write("                     <a href=\"javascript:loginNew(100673142,");
      out.print( server.getId());
      out.write(',');
      out.write('\'');
      out.print( server.getIp());
      out.write("','release');\">\r\n");
      out.write("                    ");
} 
      out.write("\r\n");
      out.write("                        <em class=\"fl\">");
      out.print(server.getName() );
      out.write("</em>\r\n");
      out.write("                        ");
if(server.getStatue_mag()==1){ 
      out.write("\r\n");
      out.write("                   \t\t\t<b class=\"wy_ico_b wy_ico\"></b>  \r\n");
      out.write("                    \t");
}else if(server.getStatue_mag()==2){ 
      out.write("\r\n");
      out.write("                    \t\t<b class=\"wy_ico_c wy_ico\"></b>\r\n");
      out.write("                    \t");
}else if(server.getStatue_mag()==3){ 
      out.write("\r\n");
      out.write("                    \t\t<b class=\"wy_ico_o wy_ico\"></b> \r\n");
      out.write("                    \t");
}else if(server.getStatue_mag()==4){ 
      out.write("\r\n");
      out.write("                  \t\t\t<b class=\"wy_ico_m wy_ico\"></b>\r\n");
      out.write("                    \t");
} 
      out.write("\r\n");
      out.write("                    \t");
if(server.getStatue_xin()==1){ 
      out.write("\r\n");
      out.write("                   \t\t\t<b class=\"wy_ico_new wy_ico\"></b>  \r\n");
      out.write("                    \t");
} 
      out.write("\r\n");
      out.write("                    \t");
if(server.getStatue_tui()==1){ 
      out.write("\r\n");
      out.write("                   \t\t\t<b class=\"wy_ico_j wy_ico\"></b>\r\n");
      out.write("                    \t");
} 
      out.write("                     \r\n");
      out.write("                     </a>\r\n");
      out.write("                </li>\r\n");
      out.write("             ");
 }}} 
      out.write("\r\n");
      out.write("               <!--  <li>\r\n");
      out.write("                    <a href=\"javascript:loginNew(100673142,1,'release');\">\r\n");
      out.write("                        <em class=\"fl\">一线一区   观音寺</em>\r\n");
      out.write("                        <b class=\"wy_ico_o wy_ico\"></b>                        \r\n");
      out.write("                        <b class=\"wy_ico_new wy_ico\"></b>\r\n");
      out.write("                        <b class=\"wy_ico_j wy_ico\"></b>                    \r\n");
      out.write("                     </a>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li>\r\n");
      out.write("                \t<a href=\"javascript:alert('很抱歉，服务器处于停机状态，无法进入！');\">\r\n");
      out.write("                \t\t<em class=\"fl\">五服</em><b class=\"wy_ico_m wy_ico\"></b>\r\n");
      out.write("                \t</a>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li>\r\n");
      out.write("                \t<a href=\"javascript:alert('很抱歉，服务器处于停机状态，无法进入！');\">\r\n");
      out.write("                \t\t<em class=\"fl\">六服</em>\r\n");
      out.write("                \t\t<b class=\"wy_ico_m wy_ico\"></b>\r\n");
      out.write("                \t</a>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li>\r\n");
      out.write("                \t<a href=\"javascript:alert('很抱歉，服务器处于停机状态，无法进入！');\">\r\n");
      out.write("                \t\t<em class=\"fl\">九服</em><b class=\"wy_ico_m wy_ico\"></b>\r\n");
      out.write("                \t</a>\r\n");
      out.write("                </li> -->\r\n");
      out.write("              \r\n");
      out.write("            </ul>\r\n");
      out.write("        </div>\r\n");
      out.write("                                <em id=\"sFrom\" style=\"display:none\">qzone</em>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>       \r\n");
      out.write(" </div>\r\n");
      out.write("        <!--所有服务器列表End-->\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("<script type=\"text/javascript\" src=\"http://openwebgame.qq.com/html/js/loginmanagerv2.js?onlyCookie=1\" charset=\"gb2312\"></script>\r\n");
      out.write("<script type=\"text/javascript\" charset=\"utf-8\" src=\"http://qzonestyle.gtimg.cn/open/fusion/fullscreen.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("//用于最近登录和所有服务器间切换\r\n");
      out.write("function serlist()\r\n");
      out.write("{\r\n");
      out.write("\tdocument.getElementById(\"sevlist\").style.display=\"block\";\r\n");
      out.write("\tdocument.getElementById(\"zjdl\").style.display=\"none\";\r\n");
      out.write("}\r\n");
      out.write("function zjdllist()\r\n");
      out.write("{\r\n");
      out.write("\tdocument.getElementById(\"zjdl\").style.display=\"block\";\r\n");
      out.write("\tdocument.getElementById(\"sevlist\").style.display=\"none\";\r\n");
      out.write("}\r\n");
      out.write("//用于切换大区的class变化\r\n");
      out.write("function settab(name,cursel,n){\r\n");
      out.write("\tfor(i=0;i<n;i++){\r\n");
      out.write("\t\tvar menu=document.getElementById(name+i);\r\n");
      out.write("\t\tvar con=document.getElementById(\"con_\"+name+\"_\"+i);\r\n");
      out.write("\t\tmenu.className=i==cursel?\"hover\":\"\";\r\n");
      out.write("\t\tcon.style.display=i==cursel?\"block\":\"none\"; \r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("function changeTab(id) {\r\n");
      out.write("       var i=0;\r\n");
      out.write("       var total = 0;\r\n");
      out.write("                   total = 1;\r\n");
      out.write("       \r\n");
      out.write("       for( i=0; i<=total; i++ ){\r\n");
      out.write("          var daqu = \"daqu_\"+i;\r\n");
      out.write("          var area_server = \"area_\"+i;\r\n");
      out.write("          $(\"#\"+daqu).attr(\"class\",\"\");\r\n");
      out.write("          $(\"#\"+area_server).css('display','none');\r\n");
      out.write("       }\r\n");
      out.write("       select_daqu = \"daqu_\"+id;\r\n");
      out.write("       select_area_server = \"area_\"+id;\r\n");
      out.write("       $(\"#\"+select_daqu).attr(\"class\",\"hover\");\r\n");
      out.write("       $(\"#\"+select_area_server).css('display','block');\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"http://ossweb-img.qq.com/images/js/jquery/jquery-1.5.1.min.js\" charset=\"gb2312\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"http://ossweb-img.qq.com/images/js/basic.js\" charset=\"gb2312\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/html/js/fajax-min.js\" charset=\"gb2312\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/html/js/CommWebGameSelect.js\"></script>\r\n");
      out.write("</body>\r\n");
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
