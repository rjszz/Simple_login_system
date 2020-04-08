package util;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mchange.v2.c3p0.ComboPooledDataSource;




public class SQLManager {
	
	private static ComboPooledDataSource dataSource=new ComboPooledDataSource("service");
	
	public static Connection getConnection() {
	    try {
	    	return dataSource.getConnection();
	    }catch(SQLException e) {
	    	System.out.println("Connect failed!");
	    }
	    return null;
	}
	
	public  static void closeStatement(Statement stmt) {
	     	if(stmt!=null) {
	     		try {
	     			stmt.close();
	     		}catch(SQLException e) {
	     			System.out.println("close statement failed!");
	     		}
	     	}
	}
	
	public static void closeResultSet(ResultSet res) {
	       if(res!=null) {
	    	   try {
	    		   res.close();
	    	   }catch(SQLException e) {
	    		   System.out.println("close resultset failed!");
	    	   }
	       }
	}

//	public SQLManager(){
//		try {
//			InputStream in=new BufferedInputStream(new FileInputStream("src/mysql.properties"));
//			 prop.load(in);
//			 url=prop.getProperty("url");
//			 name=prop.getProperty("name");
//			 username=prop.getProperty("username");
//			 password=prop.getProperty("password");
//			 databasename=prop.getProperty("databasename");
//			Class.forName(name);
//			connection=DriverManager.getConnection(url,username,password);
//			preparedStatement=connection.prepareStatement("select * from "+databasename);
//		}catch(Exception e) {
//			//e.printStackTrace();
//			System.out.println("connect failed");
//		}
//	}
//	
//	
//	//To judge whether a table exists
//	
//	public int tableExist(String sql) throws SQLException {
//		 int num=0;	     
//	     try {
//	    //	 ResultSet result=null;
//		    // result=this.preparedStatement.executeQuery("select * from "+tableName);
//	    	 res=this.preparedStatement.executeQuery(sql);
//	    	 res.last();
//		     num=res.getRow();
//	     }catch(Exception e) {
//	    	 num=-1;
//	     }
//	     return num;
//	}
//	
//	//Get the name of tables in a database
//	public ResultSet getTablesName()
//	{
//	//	ResultSet res=null;
//		try {
//			
//			res=this.preparedStatement.executeQuery("show tables");
//		}catch(Exception e) {
//			System.out.println("For failure");
//		}
//		
//		return res;
//	}
//	//Creat a table
//	public void creat_table(String sql) throws SQLException {
//		try {
//			//this.preparedStatement.executeUpdate("create table "+tablename+header);
//			this.preparedStatement.executeUpdate(sql);
//			System.out.println("table create successful！");
//		}catch(Exception e) {
//			//System.out.println(this.validateTableNameExist("users"));
//			System.out.println("This table has existed！");
//		}
//		System.out.printf("\n");
//		
//	}
//	
//	
//	// Get a table
//	public ResultSet getTable(String sql) throws SQLException{
//		//ResultSet res=null;
//	//	res=this.preparedStatement.executeQuery("select * from "+tablename);
//		res=this.preparedStatement.executeQuery(sql);
//		return res;
//	}
//	
//	//Delete a table
//	public void delTable(String sql) throws SQLException {
//		try {  //this table  exists
//			//this.preparedStatement.executeUpdate("drop table "+tablename);
//			this.preparedStatement.executeUpdate(sql);
//		}
//		catch(Exception e) {
//			System.out.println("This table dosn't exist");
//		}
//		System.out.printf("\n");
//	}
//	//To judge whether a row exists
//	public int RowExist(String sql) throws SQLException{   
//		int num=0;
//	//	ResultSet result=null;
//		//result=this.preparedStatement.executeQuery("select username from "+tablename+" where username='"+username+"'");
//		res=this.preparedStatement.executeQuery(sql);
//		res.last();
//		num=res.getRow();
//		return num;
//	}
//	
//	
//	//add a row
//	public void insertRow(String sql) {
//	try {
//	//	this.preparedStatement.executeUpdate("insert into "+tablename+" values"+values);
//		this.preparedStatement.executeUpdate(sql);
//		System.out.println("insert a row successuful");
//	}catch(Exception e){
//		System.out.println("Add failure!Primary key conflict exists.");
//	}
//	System.out.printf("\n");
//	}
//	
//	//delete a row
//	public void delRow(String sql) {
//	 try {
//			//System.out.println("delete from "+tablename+" where "+keyname+" = '"+value+"'");
//			//this.preparedStatement.executeUpdate("delete from "+tablename+" where "+keyname+" = '"+value+"'");
//		 this.preparedStatement.executeUpdate(sql);
//			System.out.println("delete a row successful");
//	 }catch(Exception e) {
//		 System.out.println("Delete failure!This row may don't exist in this table");
//	 }
//	 System.out.printf("\n");	
//	}
//	
//	//delete rows that begins whit 'test'
//	public void del_regexp(String tablename,String keyname,String value) throws SQLException
//	{
//	try {
//		this.preparedStatement.executeUpdate("delete from "+tablename+" where "+keyname+" regexp '"+value+"'");
//	}catch(Exception e){
//		System.out.println("Delete failure!Those rows may don't exist in this table");
//	}
//	System.out.println("\n");	
//	}
//
//	
//	public void close() {
//		try {
//			if(this.res!=null) this.res.close();
//			this.preparedStatement.close();
//			this.connection.close();
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
	


}