package cn.zucc.edu.course.model;

import java.util.Date;

public class Transferinformation {
	int carid;//车辆编号
	String sellerid;//卖家编号
	String buyerid;//买家编号
	String cartype;//车辆类型
	int displacement;//排量
	Date productionyear;//生产年份
	Date cardtime;//上牌事件
	int travelmileagel;//行驶历程
	String carstate;//车辆状态
	int realprice;//实际价格
	boolean Tdel;
	public int getCarid() {
		return carid;
	}
	public void setCarid(int carid) {
		this.carid = carid;
	}
	public String getSellerid() {
		return sellerid;
	}
	public void setSellerid(String sellerid) {
		this.sellerid = sellerid;
	}
	public String getBuyerid() {
		return buyerid;
	}
	public void setBuyerid(String buyerid) {
		this.buyerid = buyerid;
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
	public int getTravelmileagel() {
		return travelmileagel;
	}
	public void setTravelmileagel(int travelmileagel) {
		this.travelmileagel = travelmileagel;
	}
	public String getCarstate() {
		return carstate;
	}
	public void setCarstate(String carstate) {
		this.carstate = carstate;
	}
	public int getRealprice() {
		return realprice;
	}
	public void setRealprice(int realprice) {
		this.realprice = realprice;
	}
	public boolean isTdel() {
		return Tdel;
	}
	public void setTdel(boolean tdel) {
		Tdel = tdel;
	}

	
}
