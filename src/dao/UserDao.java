package dao;
import java.util.List;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
//import com.sun.corba.se.pept.transport.Connection;

import entity.User;
import util.SQLManager;

public class UserDao {
		

	private Connection connection=null;
	private PreparedStatement pstmt = null;

	
	//to insert a row
	public boolean insert(String username,String pass,String email) {
		boolean insertsucceed=true;
		try {
			//connection= (Connection) user.getConnection();
			System.out.print("come in");
			connection=(Connection) SQLManager.getConnection();
			System.out.print("come out");
			System.out.println(username);
			System.out.println(pass);
			System.out.println(email);
			if(username.equals("") || pass.equals("")) 	return false;
			String sql="insert into Users values(?,?,?)";
			pstmt=((java.sql.Connection) connection).prepareStatement(sql);
			pstmt.setString(1,username);
			pstmt.setString(2,pass);
			pstmt.setString(3,email);
			pstmt.executeUpdate();
			System.out.println("final");
			insertsucceed=true;
		}catch(Exception e) {
			insertsucceed=false;
			//throw new RuntimeException(e);
		}finally {
			SQLManager.closeStatement(pstmt);
		}
		return insertsucceed;
	}
	
	//to del a row
	public boolean del(String username) {
		boolean delsucceed=true;
		try {
			connection= (Connection) SQLManager.getConnection();
			String sql="delete from Users where username = ? ";
			pstmt=((java.sql.Connection) connection).prepareStatement(sql);
			pstmt.setString(1,username);
			pstmt.executeUpdate();
			 delsucceed=true;
		}catch(Exception e) {
			 delsucceed=false;
			//throw new RuntimeException(e);
		}finally {
			SQLManager.closeStatement(pstmt);
		}
		return delsucceed;
	}
	
	//get the table and return a list
	public List<User> gettable(){
		String sql="select * from Users";
		ResultSet res=null;
		List<User> list=new ArrayList<>();
		connection= (Connection) SQLManager.getConnection();
		User user=null;
		try {
			pstmt=((java.sql.Connection) connection).prepareStatement(sql);
			res=pstmt.executeQuery();
			while(res.next()) {
				String username=res.getString("username");
				String pass=res.getString("pass");
				String email=res.getString("email");
				System.out.println(username);
				System.out.println(pass);
				System.out.println(email);
				user=new User(username,pass,email);
				list.add(user);
			}
		}catch(SQLException e) {
			System.out.println("Return the table failed!");
		}finally {
			SQLManager.closeStatement(pstmt);
			SQLManager.closeResultSet(res);
		}
		return list;
	}
   
	
	public boolean RowExist(String username) {
		 int num=0;
		 ResultSet result=null;
		 try {
			 connection= (Connection) SQLManager.getConnection();
			 String sql="select 1 from Users where username = ? limit 1";
			 pstmt=((java.sql.Connection) connection).prepareStatement(sql);
			 pstmt.setString(1,username);
			 result=pstmt.executeQuery();
			 result.last();
		     num=result.getRow();
		 }catch(SQLException e){
			 
		 }finally {
			 SQLManager.closeStatement(pstmt);
				SQLManager.closeResultSet(result);
		 }
		 if(num>0) return true;
		 else return false;
	 }
	
	public int emailcorrect(String username,String email)
	{

		 ResultSet result=null;
		 try {
			 connection= (Connection) SQLManager.getConnection();
			 String sql="select * from Users where username = ?";
			 pstmt=((java.sql.Connection) connection).prepareStatement(sql);
			 pstmt.setString(1,username);
			 result=pstmt.executeQuery();
			 //System.out.print("00000000000");
			 while(result.next())
			 {
				 String exitEmail=result.getString("email");
				 System.out.println(exitEmail);
				 System.out.println(email);
				 if(exitEmail.equals("")) return 0;
				 if(!exitEmail.equals(email)) {System.out.print("email error!"); return 1;}
			 }
		 }catch(SQLException e){
			 
		 }finally {
			 SQLManager.closeStatement(pstmt);
				SQLManager.closeResultSet(result);
		 }

		  return 2;
	}
	
	public boolean UserExist(String username,String pass)
	{

		 ResultSet result=null;
		 try {
			 connection= (Connection) SQLManager.getConnection();
			 String sql="select * from Users where username = ?";
			 pstmt=((java.sql.Connection) connection).prepareStatement(sql);
			 pstmt.setString(1,username);
			 result=pstmt.executeQuery();
			 //System.out.print("00000000000");
			 while(result.next())
			 {
				 String password=result.getString("pass");
				 System.out.println(password);
				 System.out.println(pass);
				 if(password.equals(pass)) {System.out.print("User Exit!"); return true;}
			 }
		 }catch(SQLException e){
			 
		 }finally {
			 SQLManager.closeStatement(pstmt);
				SQLManager.closeResultSet(result);
		 }

		  return false;
		
	}

}
