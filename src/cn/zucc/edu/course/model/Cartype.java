package cn.zucc.edu.course.model;
///��������
public class Cartype {
	int cartypeid;//�������ͱ��
	String cartypename;//��������
	String cartypeintroduce;//���ͽ���
	String cartypeuse;//������;
	boolean cartypedel;//����ɾ��
	public int getCartypeid() {
		return cartypeid;
	}
	public void setCartypeid(int cartypeid) {
		this.cartypeid = cartypeid;
	}
	public String getCartypename() {
		return cartypename;
	}
	public void setCartypename(String cartypename) {
		this.cartypename = cartypename;
	}
	public String getCartypeintroduce() {
		return cartypeintroduce;
	}
	public void setCartypeintroduce(String cartypeintroduce) {
		this.cartypeintroduce = cartypeintroduce;
	}
	public String getCartypeuse() {
		return cartypeuse;
	}
	public void setCartypeuse(String cartypeuse) {
		this.cartypeuse = cartypeuse;
	}
	public boolean isCartypedel() {
		return cartypedel;
	}
	public void setCartypedel(boolean cartypedel) {
		this.cartypedel = cartypedel;
	}
	
}
