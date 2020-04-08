package servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import dao.UserDao;

/**
 * Servlet implementation class change_pass
 */
@WebServlet("/change_pass")
public class change_pass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
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
			reqObject = new JSONArray(reqMessage);
			username=reqObject.getJSONObject(0).getString("username");
			 password=reqObject.getJSONObject(0).getString("password");
			 email=reqObject.getJSONObject(0).getString("email");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			UserDao userDao=new UserDao();
			int flag=0;
			if(!userDao.RowExist(username))
	        {
				respObject= new JSONArray().put(new JSONObject().put("resultcode","3"));   //信息码为3，表示用户名不存在
	        	//httpServletResponse.sendError(204,"query failed.");//设置204错误码与出错信息
	        }
			
			else if((flag=userDao.emailcorrect(username, email)) != 2)
			{
				if(flag==0) {
					respObject= new JSONArray().put(new JSONObject().put("resultcode","4"));  //信息码4，邮箱不存在
				}
				else {
					respObject= new JSONArray().put(new JSONObject().put("resultcode","5"));  //信息码5 邮箱不正确
				}
				
			}
	
			else {
				userDao.del(username);
				userDao.insert(username, password, email);
				respObject= new JSONArray().put(new JSONObject().put("resultcode","0")); //信息码0，正确
			}
			respMessage = respObject == null ? "" : respObject.toString();
			System.out.println("返回报文:" + respMessage);
			PrintWriter pw = httpServletResponse.getWriter();
			pw.write(respMessage);
			pw.flush();
			pw.close();
		}
	}

}
