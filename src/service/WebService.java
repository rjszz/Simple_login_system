package service;
import entity.User;
import dao.UserDao;

import java.util.List;


public class WebService {
	
	private UserDao user= new UserDao();
	
	public boolean user_add(User oneuser) {
		String username=oneuser.getusername();
		String pass=oneuser.getpass();
		String email=oneuser.getemail();
		boolean flag=user.insert(username, pass,email);
		return flag;
	}
	
	public boolean user_del(User oneuser) {
		String username=oneuser.getusername();
		String pass=oneuser.getpass();
//		System.out.print(pass);
		user.UserExist(username, pass);
		if(!user.RowExist(username)) return false;
		boolean flag=user.del(username);
		return flag;
	}
	
	public List<User> get_user(){
		List<User> list=user.gettable();
		return list;
	}
}
