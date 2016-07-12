package cn.zucc.edu.course.control;


import cn.zucc.edu.course.DAO.UserDAO;
import cn.zucc.edu.course.model.User;
import cn.zucc.edu.course.util.BaseException;
import cn.zucc.edu.course.util.DbException;

public class UserManager {
	UserDAO userdao=new UserDAO();

	public void createUesr(String userID,String username,String password,String password2,String tel,String address,String email,int usertype,int sex,int age) throws BaseException,DbException{
		User user=new User();
		if(userdao.SearchUser(userID)!=null){
			throw new BaseException("帐号已存在");
		}
			
		if(userID==null){
			throw new BaseException("必须写帐号");
		}
		user.setUserid(userID);
		if(username==null){
			throw new BaseException("必须写名字");
		}
		user.setUsername(username);
		if(password.equals(password2)==false){
			throw new BaseException("两次密码必须一样");
		}
		user.setPassword(password);
		if(tel==null){
			throw new BaseException("必须写电话");
		}
		user.setTEL(tel);
		if(address==null){
			throw new BaseException("必须写地址");
		}
		user.setAddress(address);
		if(email==null){
			throw new BaseException("必须写邮箱");
		}
		user.setEmail(email);
		user.setUsersex(sex);
		user.setUserage(age);
		user.setUsertype(usertype);
		userdao.createuser(user);		
	}
	public boolean loginuser(String userid,String password) throws BaseException{
		User user=new User();
		user=userdao.SearchUser(userid);
		if(userid==null){
			throw new BaseException("必须写帐号");
		}
		if(user.getPassword().equals(password)==false){
			throw new BaseException("密码错误");
		}
		else{
			return true;
		}
			
	}
	
}
