package cn.zucc.edu.course.model;

import java.util.Date;

//��������Ϣ
public class Carbase {
	int carid;//�����
	String userid;
	int cartypeid;//���ͱ��
	int carlineid;//��ϵ���
	String transmissiontype;//��������Ϣ
	String cartype;//����
	int displacement;//����
	int carage;//����
	Date productionyear;//�������
	Date cardtime;//����ʱ��
	int travelmileage;//��ʻ����
	String carcolor;//��ɫ
	int suggestedprice;//����۸�
	int realprice;//ʵ�ʼ۸�
	String carstate;//����״̬
	boolean cardel;//�Ƿ�ɾ��
	boolean caelisting;
	public boolean isCaelisting() {
		return caelisting;
	}
	public void setCaelisting(boolean caelisting) {
		this.caelisting = caelisting;
	}
	public int getCarid() {
		return carid;
	}
	public void setCarid(int carid) {
		this.carid = carid;
	}
	public int getCartypeid() {
		return cartypeid;
	}
	public void setCartypeid(int cartypeid) {
		this.cartypeid = cartypeid;
	}
	public int getCarlineid() {
		return carlineid;
	}
	public void setCarlineid(int carlineid) {
		this.carlineid = carlineid;
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
	public int getDisplacement() {
		return displacement;
	}
	public void setDisplacement(int displacement) {
		this.displacement = displacement;
	}
	public int getCarage() {
		return carage;
	}
	public void setCarage(int carage) {
		this.carage = carage;
	}
	public Date getProductionyear() {
		return productionyear;
	}
	public void setProductionyear(Date productionyear) {
		this.productionyear = productionyear;
	}
	public Date getCardtime() {
		return cardtime;
	}
	public void setCardtime(Date cardtime) {
		this.cardtime = cardtime;
	}
	public int getTravelmileage() {
		return travelmileage;
	}
	public void setTravelmileage(int travelmileage) {
		this.travelmileage = travelmileage;
	}
	public String getCarcolor() {
		return carcolor;
	}
	public void setCarcolor(String carcolor) {
		this.carcolor = carcolor;
	}
	public int getSuggestedprice() {
		return suggestedprice;
	}
	public void setSuggestedprice(int suggestedprice) {
		this.suggestedprice = suggestedprice;
	}
	public int getRealprice() {
		return realprice;
	}
	public void setRealprice(int realprice) {
		this.realprice = realprice;
	}
	public String getCarstate() {
		return carstate;
	}
	public void setCarstate(String carstate) {
		this.carstate = carstate;
	}
	public boolean isCardel() {
		return cardel;
	}
	public void setCardel(boolean cardel) {
		this.cardel = cardel;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
}
