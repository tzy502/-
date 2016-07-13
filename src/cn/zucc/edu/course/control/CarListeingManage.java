package cn.zucc.edu.course.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.zucc.edu.course.DAO.ListinginformationDAO;
import cn.zucc.edu.course.model.Carbase;
import cn.zucc.edu.course.model.Carlinformation;
import cn.zucc.edu.course.model.Listinginformation;
import cn.zucc.edu.course.util.DbException;

public class CarListeingManage {
	ListinginformationDAO lfd=new ListinginformationDAO();
	CarBaseManage cbm=new CarBaseManage();
	
	public void createcarlisteing(int carid,String userid,String Sellinformation,Date selltime, int realprice,
			int carage,String transmissiontype,String cartype,int seeway,Carbase car) throws DbException{
		Listinginformation lf=new Listinginformation();
		lf.setCarid(carid);
		lf.setUserid(userid);
		lf.setSellinformation(Sellinformation);
		lf.setSelltime(selltime);
		lf.setRealprice(realprice);
		lf.setCarage(carage);
		lf.setTransmissiontype(transmissiontype);
		lf.setCartype(cartype);
		lf.setSeeway(seeway);
		lfd.Createistinginformation(lf);
		cbm.listingCar(car);
	}
	public List<Listinginformation> Loadistinginformation() throws DbException {
		List<Listinginformation> total=new ArrayList<Listinginformation>();
		total=lfd.Loadistinginformation();
		System.out.println(total.size());
		return total;
		
	}
}
