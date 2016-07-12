package cn.zucc.edu.course.control;

import java.util.Date;

import cn.zucc.edu.course.DAO.CarbaseDAO;
import cn.zucc.edu.course.model.Carbase;
import cn.zucc.edu.course.util.BusinessException;
import cn.zucc.edu.course.util.DbException;

public class CarBaseManage {
	CarbaseDAO cbd=new CarbaseDAO();
	public void createcar(int cartypeid,int carlineid,String transmissiontype,String cartype,int displacement,int carage,int productionyear,Date cardtime,int travelmileage,String carcolor,int suggestedprice,int realprice,String carstate) throws BusinessException, DbException{
		Carbase car=new Carbase();
		car.setCartypeid(cartypeid);
		car.setCarlineid(carlineid);
		if(transmissiontype==null||transmissiontype.equals("")){
			throw new BusinessException("����д����������");	
		}
		car.setTransmissiontype(transmissiontype);
		car.setCartype(cartype);
		if(displacement<=-1){
			throw new BusinessException("����д����");
		}
		
		if(carage<=-1){
			throw new BusinessException("����д����");
		}
		car.setCarage(carage);
		car.setDisplacement(displacement);
		Date product=new Date();
		product.setYear(productionyear-1900);
		product.setMonth(1);
		product.setDate(1);
		if(productionyear<=-1){
			throw new BusinessException("����д����ʱ��");
		}	
		car.setProductionyear(product);
		car.setCardtime(cardtime);
		
		if(travelmileage<=-1){
			throw new BusinessException("����д���");
		}	
		car.setTravelmileage(travelmileage);
		if(carcolor==null){
			throw new BusinessException("����д��ɫ");
		}	
		car.setCarcolor(carcolor);
		if(suggestedprice<=-1){
			throw new BusinessException("����д����۸�");
		}	
		car.setSuggestedprice(suggestedprice);
		if(realprice<=-1){
			throw new BusinessException("����дʵ�ʼ۸�");
		}	
		car.setRealprice(realprice);
		car.setCarstate(carstate);
		cbd.CreateCar(car);
	}
}
