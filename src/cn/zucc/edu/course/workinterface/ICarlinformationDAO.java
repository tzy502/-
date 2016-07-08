package cn.zucc.edu.course.workinterface;

import java.util.List;

import cn.zucc.edu.course.model.Carbase;
import cn.zucc.edu.course.model.Carlinformation;

//车系信息接口
public interface ICarlinformationDAO {
	public void CreateCar(Carlinformation carlinformation);
	public void ModifryCar(Carlinformation carlinformation);
	public Carlinformation SearchCarId(int id);
	public List<Carlinformation> QryCar(Carlinformation carlinformation);
	public List<Carlinformation> LoadCar();
	public void DelCar(Carlinformation carlinformation);
}
