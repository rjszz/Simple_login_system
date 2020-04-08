<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>数据库表展示</title>
</head>
<body>
  
	<center><b ><font size="6">数据表Users信息：</font> </b></center>
	<br>
 <table border=0 style="width:100%;height:100%">
   <tr><td align="center" valign="middle">
	<table border="1" cellpadding="5" width="400">
     <tr>
	  <th >username</th>
	  <th >password</th>
	  <th>email</th>
	  </tr>
	  
	  <c:forEach items="${requestScope.user}" var="oneuser">
	    <tr><td>${oneuser.getusername() }</td>  <td>${oneuser.getpass() }</td>    <td>${oneuser.getemail() }</td></tr>
	  </c:forEach>
	  
	  </table>
	  </td>
	  </tr>
   
   </table>
  <a href="main.jsp"><center><font size="3">返回操作界面</font></center></a>
</body>
</html>