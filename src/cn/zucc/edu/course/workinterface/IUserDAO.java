package cn.zucc.edu.course.workinterface;

import cn.zucc.edu.course.model.User;
import cn.zucc.edu.course.util.DbException;

//用户接口
public interface IUserDAO {
	public void createuser(User user)throws DbException;//新建用户
	public User SearchUser(int ID)throws DbException;//查找用户
	public void ModifryUser(User user)throws DbException;//修改用户
	public void DelUSer (User user)throws DbException;//删除用户
}
