package cn.zucc.edu.course.workinterface;

import cn.zucc.edu.course.model.User;

//�û��ӿ�
public interface IUserDAO {
	public void createuser(User user);//�½��û�
	public User SearchUser(int ID);//�����û�
	public void ModifryUser(User user);//�޸��û�
	public void DelUSer (User user);//ɾ���û�
	public void FreezeUser (User user);//�����û�
}
