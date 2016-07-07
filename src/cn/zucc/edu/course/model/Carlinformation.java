package cn.zucc.edu.course.model;
//车系信息
//car 车 l系列 information信息
public class Carlinformation {
	int carlineid;//
	int brandid;
	String carlinename;
	String brand;
	String carlineintro;
	boolean carlinedel;
	public int getCarlineid() {
		return carlineid;
	}
	public void setCarlineid(int carlineid) {
		this.carlineid = carlineid;
	}
	public int getBrandid() {
		return brandid;
	}
	public void setBrandid(int brandid) {
		this.brandid = brandid;
	}
	public String getCarlinename() {
		return carlinename;
	}
	public void setCarlinename(String carlinename) {
		this.carlinename = carlinename;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getCarlineintro() {
		return carlineintro;
	}
	public void setCarlineintro(String carlineintro) {
		this.carlineintro = carlineintro;
	}
	public boolean isCarlinedel() {
		return carlinedel;
	}
	public void setCarlinedel(boolean carlinedel) {
		this.carlinedel = carlinedel;
	} 
}
