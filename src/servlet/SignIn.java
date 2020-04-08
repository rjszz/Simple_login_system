package servlet;

import dao.UserDao;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

@WebServlet("/SignIn")
public class SignIn extends HttpServlet{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException,ServletException
    {
        this.doPost(httpServletRequest,httpServletResponse);
    }

	@Override
	protected void doPost(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws IOException, ServletException
    {
		httpServletRequest.setCharacterEncoding("utf-8");
        httpServletResponse.setCharacterEncoding("utf-8");
        httpServletResponse.setContentType("text/json;charset=utf-8");//设置相应类型为html,编码为utf-8
        String reqMessage, respMessage;
		JSONArray reqObject = null;
		JSONArray respObject = null;
		String name="";
		String password="";
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
			 name=reqObject.getJSONObject(0).getString("username");
			 password=reqObject.getJSONObject(0).getString("password");
			System.out.println(name);
			System.out.println(password);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			UserDao userDao=new UserDao();
			if(!userDao.RowExist(name))
			{
				respObject= new JSONArray().put(new JSONObject().put("resultcode","3")); //信息码3 用户名不存在
			}
			else if(!userDao.UserExist(name, password))
	        {
				respObject= new JSONArray().put(new JSONObject().put("resultcode","2")); //信息码2 密码错误
	        }
			else {
				respObject= new JSONArray().put(new JSONObject().put("resultcode","0")); //信息码0，正确
			}
			
			respMessage = respObject == null ? "" : respObject.toString();
			System.out.println("返回报文:" + respMessage);
			PrintWriter pw = httpServletResponse.getWriter();
			pw.write(respMessage);
			pw.flush();
			pw.close();
		}
//        String name = httpServletRequest.getParameter("name");
//        String password = httpServletRequest.getParameter("password");
//        String streamIn = ReadStream.read(new BufferedInputStream(httpServletRequest.getInputStream()));
//        String streamIn = new String(readInputStream(httpServletRequest.getInputStream()), "UTF-8");
//        UserDao userDao=new UserDao();     
    }
}
