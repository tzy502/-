package cn.zucc.edu.course.control;

import java.util.ArrayList;
import java.util.List;

import cn.zucc.edu.course.DAO.CarTypeDAO;
import cn.zucc.edu.course.model.Cartype;
import cn.zucc.edu.course.util.BusinessException;
import cn.zucc.edu.course.util.DbException;

public class CarTypeManage {
	CarTypeDAO ctd=new CarTypeDAO();
	public void createManage(String name,String introduct,String use) throws BusinessException, DbException{
		if(name==null){
			throw new BusinessException("必须写类型名字");	
		}
		if(use==null||use.equals("")){
			throw new BusinessException("必须写用途");
		}
		Cartype ct=new Cartype();
		ct.setCartypename(name);
		ct.setCartypeintroduce(introduct);
		ct.setCartypeuse(use);
		ctd.CreateCar(ct);
	}
	public List<Cartype> LoadCar() throws DbException {
		List<Cartype> total=new ArrayList<Cartype>();
		total=ctd.LoadCar();
		System.out.println(1);
		return total;
	}
	
}
