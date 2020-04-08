package entity;



public class User {


	private String username;
	private String pass;
	private String email;
	

	public User(String username,String pass,String email) {
		this.username=username;
		this.pass=pass;
		this.email=email;
	}
	
	public void setusername(String username) {
		this.username=username;
	}
	
	public void setemail(String email) {
		this.email=email;
	}
	
	public void setpass(String pass) {
		this.pass=pass;
	}
	
	public String getusername() {
		return this.username;
	}
	
	public String getpass() {
		return this.pass;
	}
	
	public String getemail() {
		return this.email;
	}
}	


