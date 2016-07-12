package cn.zucc.edu.course.control;

import java.util.ArrayList;
import java.util.List;

import cn.zucc.edu.course.DAO.CarbrandDAO;
import cn.zucc.edu.course.model.Carbrand;
import cn.zucc.edu.course.util.BaseException;
import cn.zucc.edu.course.util.DbException;

public class CarBrandManage {
	CarbrandDAO cbDao=new CarbrandDAO();
	public void createCarBrand(String brandname,String brandcountry,String brandintroduction) throws BaseException{	
		Carbrand carbrand=new Carbrand();
		if(brandname==null){
			throw new BaseException("����д����");
		}
		carbrand.setBrandname(brandname);
		if(cbDao.QryCarbrandname(carbrand)!=null){
			throw new BaseException("Ʒ���Ѵ���");
		}		
		if(brandcountry==null){
			throw new BaseException("����д����");
		}
		carbrand.setBrandcountry(brandcountry);
		carbrand.setBrandintroduction(brandintroduction);
		
		cbDao.CreateCarbrand(carbrand);
	}
	public List<Carbrand> loadCarbrand() throws DbException {
		List<Carbrand> totalcabrandr=new ArrayList<Carbrand>();
		totalcabrandr=cbDao.loadCarbrand();
		return totalcabrandr;
	}
	public Carbrand SearchCarBrand(int id) throws DbException{
		Carbrand cb=new Carbrand();
		cb=cbDao.SearchCarbrand(id);
		return cb;
	}
}
