<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <script src="http://libs.baidu.com/jquery/1.9.1/jquery.js"></script>
<title>数据库操作</title>
</head>
<body>
 
  <table border=0 style="width:100%;height:100%">
   <tr><td align="center" valign="middle">
   <form action="JServlet?method=add" method="post"  onsubmit="return personcheck()" >
    <table border="1" cellpadding="5" width="400">
       <tr >
         <th width=500>数据库表插入信息</th>
        </tr>
      
      <tr>
         <td>username &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  <input type="text"  id="personname"  name="personname"    placeholder="请输入用户名"/>      </td>
        </tr> 
        
      <tr>
         <td>password &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
           <input type="text"  name="pass"  id="pass" placeholder="请输入密码"> </td>
       </tr>
       
       
      <tr>
        <td>email &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  <input type="text" name="email"  id="email"placeholder="请输入邮箱"></td>
      </tr>
      
      <tr>
        <td align="center" valign="middle"> <button type="submit">插入</button></td>
        </tr>
                       
     </table> 
    </form>

       
    </td> </tr>
    
     <tr ><td height="50"></td></tr>
     
    <tr><td align="center" valign="middle">
    <form action="JServlet?method=del" method="post"  onsubmit="return usercheck()">
    <table border="2" cellpadding="5" width="400">
      
      <tr><th>数据库删除信息</th></tr>
      
      <tr>
         <td>username &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  <input type="text" name="username" id="username"  placeholder="请输入用户名"></td>
        </tr> 
      
      <tr>
        <td align="center" valign="middle"> <button type="submit">删除</button></td>
       </tr>
       
      </table>
    </form>
     
     <a href="JServlet?method=list"><center><font size="3">查看数据库数据</font></center></a>
    </td> </tr>
    </table>  
     
     <script type="text/javascript">
        function personcheck(){
        	var personname = $("#personname");
        	var pass=$("#pass");
        	//alert(tmp.val());
        	// var personname=document.getElementById("personname");
        	 //var name=document.getElementById("name");
        	 //var age=document.getElementById("age");
        	 //var tele=document.getElementById("tele");
        	 //alert(personname.vaule);
        	 
        	 if(personname.val()==''){
        		 alert("插入错误:username不能为空!");
        		 personname.focus();
        	 return false;
        	 }
        	// <td align="center" valign="middle"> <button type="submit">插入</button></td>  
        	 if(pass.val()==''){
        		 alert("插入错误:密码不能为空!");
        		 pass.focus();
        		 return false;
        	 }
        } 	 
        	
        
        function usercheck(){
        	var username = $("#username");
        	 if(username.val()==''){
        		 alert("删除错误:username不能为空!");
        	 return false;
        	 }
        }
 
   </script>     
</body>
</html>