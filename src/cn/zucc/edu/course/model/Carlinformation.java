package cn.zucc.edu.course.model;
//��ϵ��Ϣ
//car �� lϵ�� information��Ϣ
public class Carlinformation {
	int carlineid;//��ϵ���
	int brandid;//Ʒ�Ʊ��
	String carlinename;//��ϵ����
	String brand;//����Ʒ��
	String carlineintro;//��ϵ����
	boolean carlinedel;//�Ƿ�ɾ��
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
