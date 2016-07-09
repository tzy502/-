package cn.zucc.edu.course.workinterface;

import java.util.List;

import cn.zucc.edu.course.model.Carlinformation;
import cn.zucc.edu.course.model.Cartype;
import cn.zucc.edu.course.util.DbException;

//车辆类型接口
public interface ICartypeDAO {
	public void CreateCar(Cartype cartype)throws DbException;
	public void ModifryCar(Cartype cartype)throws DbException;
	public Cartype SearchCarId(int id)throws DbException;
	public List<Cartype> QryCar(Cartype cartype)throws DbException;
	public List<Cartype> LoadCar()throws DbException;
	public void DelCar(Cartype cartype)throws DbException;
}
