<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>信息反馈</title>
</head>
<body>
<%
      
        // Object message = request.getAttribute("message");
         //if(message!=null && !"".equals(message)){
     %>
  <center><b ><font size="6">数据库操作结果：</font> </b></center>
   <br>
   <center>${requestScope.message}</center>
   <br>
   <a href="main.jsp"><center><font size="3">返回操作界面</font></center></a>
   <a href="JServlet?method=list"><center><font size="3">查看数据库数据</font></center></a>
</body>
</html>