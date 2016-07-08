package cn.zucc.edu.course.workinterface;

import java.util.List;

import cn.zucc.edu.course.model.Carlinformation;
import cn.zucc.edu.course.model.Cartype;

//车辆类型接口
public interface ICartypeDAO {
	public void CreateCar(Cartype cartype);
	public void ModifryCar(Cartype cartype);
	public Cartype SearchCarId(int id);
	public List<Cartype> QryCar(Cartype cartype);
	public List<Cartype> LoadCar();
	public void DelCar(Cartype cartype);
}
