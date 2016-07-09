package cn.zucc.edu.course.workinterface;

import java.util.List;

import cn.zucc.edu.course.model.Carbase;
import cn.zucc.edu.course.model.Carlinformation;
import cn.zucc.edu.course.util.DbException;

//��ϵ��Ϣ�ӿ�
public interface ICarlinformationDAO {
	public void CreateCar(Carlinformation carlinformation)throws DbException;
	public void ModifryCar(Carlinformation carlinformation)throws DbException;
	public Carlinformation SearchCarId(int id)throws DbException;
	public List<Carlinformation> QryCar(Carlinformation carlinformation)throws DbException;
	public List<Carlinformation> LoadCar()throws DbException;
	public void DelCar(Carlinformation carlinformation)throws DbException;
}
