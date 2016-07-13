package cn.zucc.edu.course.workinterface;

import java.util.List;

import cn.zucc.edu.course.model.Carbase;
import cn.zucc.edu.course.util.DbException;

//����������Ϣ�ӿ�
public interface ICarbaseDAO {
	public void CreateCar(Carbase car)throws DbException;
	public void ModifryCar(Carbase car)throws DbException;
	public Carbase SearchCarId(int id)throws DbException;
	public List<Carbase> QryCarbyuserid(Carbase car)throws DbException;
	public List<Carbase> LoadCar()throws DbException;
	public void DelCar(Carbase car)throws DbException;
	public void listingCar(Carbase car)throws DbException;
}
