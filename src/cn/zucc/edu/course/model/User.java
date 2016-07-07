package cn.zucc.edu.course.model;
//用户
public class User {
	int userid;//用户id
	String username;//用户名字	
	String password;//密码
	String TEL;//电话
	String address;//地址
	String Email;//邮箱
	int usertype;//用户类型
	int usersex;//用户性别
	int userage;//用户年龄
	boolean userdel;//是否删除
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
