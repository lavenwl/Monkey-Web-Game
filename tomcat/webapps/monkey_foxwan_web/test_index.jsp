<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<SCRIPT LANGUAGE="JavaScript" SRC="common/js/Calendar4.js"></SCRIPT>
<script type="text/javascript">
function aa(){
	var obj = -[1,] ? 'yes' : 'no';
	alert(obj);
}
</script>
</head>
<body>
<s:form action="admin/checkDay.action" method="post" enctype ="multipart/form-data" >
<div>
          起始时间：<input type="text" name="stime1" id="stime1" onclick="aa()" readonly="readonly" />
          结束时间：<input type="text" name="stime2" id="stime2" onclick="MyCalendar.SetDate(this)" readonly="readonly" />
        </div>
        	<input type="submit" value="查询" name="addnewsdone" />
        </s:form>
</body>
</html>