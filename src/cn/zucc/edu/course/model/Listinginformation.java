package cn.zucc.edu.course.model;

import java.util.Date;

public class Listinginformation {
	int carid;
	String userid;
	String Sellinformation;//������Ϣ
	Date selltime;//����ʱ��
	int realprice;//ʵ���۸�
	int carage;//����
	String transmissiontype;//��������Ϣ
	String cartype;//����
	int seeway;//������ʽ
	boolean Ldel;
	public int getCarid() {
		return carid;
	}
	public void setCarid(int carid) {
		this.carid = carid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getSellinformation() {
		return Sellinformation;
	}
	public void setSellinformation(String sellinformation) {
		Sellinformation = sellinformation;
	}
	public Date getSelltime() {
		return selltime;
	}
	public void setSelltime(Date selltime) {
		this.selltime = selltime;
	}
	public int getRealprice() {
		return realprice;
	}
	public void setRealprice(int realprice) {
		this.realprice = realprice;
	}
	public int getCarage() {
		return carage;
	}
	public void setCarage(int carage) {
		this.carage = carage;
	}
	public String getTransmissiontype() {
		return transmissiontype;
	}
	public void setTransmissiontype(String transmissiontype) {
		this.transmissiontype = transmissiontype;
	}
	public String getCartype() {
		return cartype;
	}
	public void setCartype(String cartype) {
		this.cartype = cartype;
	}
	public int getSeeway() {
		return seeway;
	}
	public void setSeeway(int seeway) {
		this.seeway = seeway;
	}
	public boolean isLdel() {
		return Ldel;
	}
	public void setLdel(boolean ldel) {
		Ldel = ldel;
	}
	
}
