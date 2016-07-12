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
			throw new BaseException("�ʺ��Ѵ���");
		}
			
		if(userID==null){
			throw new BaseException("����д�ʺ�");
		}
		user.setUserid(userID);
		if(username==null){
			throw new BaseException("����д����");
		}
		user.setUsername(username);
		if(password.equals(password2)==false){
			throw new BaseException("�����������һ��");
		}
		user.setPassword(password);
		if(tel==null){
			throw new BaseException("����д�绰");
		}
		user.setTEL(tel);
		if(address==null){
			throw new BaseException("����д��ַ");
		}
		user.setAddress(address);
		if(email==null){
			throw new BaseException("����д����");
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
			throw new BaseException("����д�ʺ�");
		}
		if(user.getPassword().equals(password)==false){
			throw new BaseException("�������");
		}
		else{
			return true;
		}
			
	}
	
}
