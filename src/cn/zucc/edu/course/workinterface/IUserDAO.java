package cn.zucc.edu.course.workinterface;

import cn.zucc.edu.course.model.User;

//用户接口
public interface IUserDAO {
	public void createuser(User user);//新建用户
	public User SearchUser(int ID);//查找用户
	public void ModifryUser(User user);//修改用户
	public void DelUSer (User user);//删除用户
	public void FreezeUser (User user);//冻结用户
}
