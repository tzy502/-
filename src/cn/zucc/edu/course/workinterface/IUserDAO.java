package cn.zucc.edu.course.workinterface;

import cn.zucc.edu.course.model.User;
import cn.zucc.edu.course.util.DbException;

//�û��ӿ�
public interface IUserDAO {
	public void createuser(User user)throws DbException;//�½��û�
	public User SearchUser(int ID)throws DbException;//�����û�
	public void ModifryUser(User user)throws DbException;//�޸��û�
	public void DelUSer (User user)throws DbException;//ɾ���û�
}
