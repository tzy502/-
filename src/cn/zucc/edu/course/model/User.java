package cn.zucc.edu.course.model;
//�û�
public class User {
	int userid;//�û�id
	String username;//�û�����	
	String password;//����
	String TEL;//�绰
	String address;//��ַ
	String Email;//����
	int usertype;//�û�����
	int usersex;//�û��Ա�
	int userage;//�û�����
	boolean userdel;//�Ƿ�ɾ��
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTEL() {
		return TEL;
	}
	public void setTEL(String tEL) {
		TEL = tEL;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public int getUsertype() {
		return usertype;
	}
	public void setUsertype(int usertype) {
		this.usertype = usertype;
	}
	public int getUsersex() {
		return usersex;
	}
	public void setUsersex(int usersex) {
		this.usersex = usersex;
	}
	public int getUserage() {
		return userage;
	}
	public void setUserage(int userage) {
		this.userage = userage;
	}
	public boolean isUserdel() {
		return userdel;
	}
	public void setUserdel(boolean userdel) {
		this.userdel = userdel;
	}
}
