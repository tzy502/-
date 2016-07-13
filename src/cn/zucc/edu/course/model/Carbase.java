package cn.zucc.edu.course.model;

import java.util.Date;

//车基本信息
public class Carbase {
	int carid;//车编号
	String userid;
	int cartypeid;//车型编号
	int carlineid;//车系编号
	String transmissiontype;//变速箱信息
	String cartype;//车型
	int displacement;//排量
	int carage;//车龄
	Date productionyear;//生产年份
	Date cardtime;//上牌时间
	int travelmileage;//行驶历程
	String carcolor;//颜色
	int suggestedprice;//建议价格
	int realprice;//实际价格
	String carstate;//车辆状态
	boolean cardel;//是否删除
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
