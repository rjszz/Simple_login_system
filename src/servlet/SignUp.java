package servlet;

import dao.UserDao;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Servlet implementation class SignUp
 */
@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws IOException,ServletException
    {
        this.doPost(httpServletRequest,httpServletResponse);
    }


    protected void doPost(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws IOException,ServletException
    {
    	httpServletRequest.setCharacterEncoding("utf-8");
        httpServletResponse.setCharacterEncoding("utf-8");
        httpServletResponse.setContentType("text/json;charset=utf-8");//设置相应类型为html,编码为utf-8
        String reqMessage, respMessage;
		JSONArray reqObject = null;
		JSONArray respObject = null;
		String username="";
		String password="";
		String email="";
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(httpServletRequest.getInputStream(), "UTF-8"));
			StringBuffer sb = new StringBuffer("");
			String temp;
			while ((temp = br.readLine()) != null) {
				sb.append(temp);
			}
			br.close();
			reqMessage = sb.toString();
			System.out.println(reqMessage);
			reqObject = new JSONArray(reqMessage);
			username=reqObject.getJSONObject(0).getString("username");
			 password=reqObject.getJSONObject(0).getString("password");
			 email=reqObject.getJSONObject(0).getString("email");
			 System.out.println(username);
			 System.out.println(password);
			 System.out.println(email);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			UserDao userDao=new UserDao();
			
			if(!userDao.insert(username, password,email))
	        {
				respObject= new JSONArray().put(new JSONObject().put("resultcode","1"));  //信息码1 用户名已存在
	        	//httpServletResponse.sendError(204,"query failed.");//设置204错误码与出错信息
	        }
			else
			{
				respObject= new JSONArray().put(new JSONObject().put("resultcode","0"));  //信息码0，正确
			}
			respMessage = respObject == null ? "" : respObject.toString();
			System.out.println("返回报文:" + respMessage);
			PrintWriter pw = httpServletResponse.getWriter();
			pw.write(respMessage);
			pw.flush();
			pw.close();
		}
//    	 httpServletRequest.setCharacterEncoding("utf-8");
//         httpServletResponse.setCharacterEncoding("utf-8");//设定编码防止中文乱码
//         httpServletResponse.setContentType("text/plain;charset=utf-8");//设置相应类型为html,编码为utf-8
//
//         String username = httpServletRequest.getParameter("name");//根据name获取参数
//         String password = httpServletRequest.getParameter("password");//根据password获取参数
//         String email="";
//         UserDao userDao=new UserDao();
//         if(!userDao.insert(username, password,email))
//         {
//        	 httpServletResponse.sendError(204,"用户名已存在！");//设置204错误码与出错信息
//         }
    	}

}
