package cn.zucc.edu.course.control;

import java.util.ArrayList;
import java.util.List;

import cn.zucc.edu.course.DAO.CarinformationDAO;
import cn.zucc.edu.course.model.Carbrand;
import cn.zucc.edu.course.model.Carlinformation;
import cn.zucc.edu.course.util.BusinessException;
import cn.zucc.edu.course.util.DbException;

public class CarLineManager {
	CarinformationDAO CLD=new CarinformationDAO();
	public void createCarLine(String carlinename,int brandid,String carlineintro,String brand) throws BusinessException, DbException{
		Carlinformation cl=new Carlinformation();
		if(carlinename==null)
			throw new BusinessException("±ØÐëÐ´Ãû×Ö");		
		cl.setCarlinename(carlinename);		
		cl.setBrandid(brandid);
		cl.setCarlineintro(carlineintro);
		cl.setBrand(brand);
		CLD.CreateCar(cl);
	}
	public List<Carlinformation> LoadCar() throws DbException {
		List<Carlinformation> total=new ArrayList<Carlinformation>();
		total=CLD.LoadCar();
		return total;
	}
	public List<Carlinformation> SearchCarlinebycarband(int id) throws DbException {
		Carlinformation cl=new Carlinformation();
		cl.setBrandid(id);
		List<Carlinformation> total=new ArrayList<Carlinformation>();
		total=CLD.QryCar(cl);
		
		return total;

		
	}
}
