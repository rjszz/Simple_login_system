package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

import service.WebService;
import entity.User;

/**
 * Servlet implementation class Jservlet
 */
@WebServlet("/JServlet")
public class Jservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   WebService service=new WebService();
   
   protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   req.setCharacterEncoding("utf-8");
       String method = req.getParameter("method");
       
       if("add".equals(method)) {
    	   add(req,resp);
       } else if("del".equals(method)){
    	   del(req,resp);
       }else if("list".equals(method)) {
		   list(req,resp);
	   }
   }
   
   private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   req.setCharacterEncoding("utf-8");
	   String username=req.getParameter("personname");
	   String pass=req.getParameter("pass");
	   String email=req.getParameter("email");
		System.out.println(username);
		System.out.println(pass);
		System.out.println(email);
		   User user=new User(username,pass,email);
		   service.user_add(user);

	   req.setAttribute("message", "成功插入"+username);
       req.getRequestDispatcher("feedback.jsp").forward(req,resp);
   }
   
   private void del(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   req.setCharacterEncoding("utf-8");
	   
	   String username=req.getParameter("username");
	   User user=new User(username,"888888","");
	   
	   if(service.user_del(user)) {
		  
		   req.setAttribute("message", "成功删除"+username);
	       req.getRequestDispatcher("feedback.jsp").forward(req,resp);
	   }else {
		   req.setAttribute("message", "删除"+username+"失败,信息库不存在该用户");
           req.getRequestDispatcher("feedback.jsp").forward(req,resp);
	   }
   }
   
   private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
	   req.setCharacterEncoding("utf-8");
	   List<User> user_list=service.get_user();
	   
	   req.setAttribute("user", user_list);
	   req.getRequestDispatcher("list.jsp").forward(req,resp);
   }

}
