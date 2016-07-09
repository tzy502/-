package cn.zucc.edu.course.workinterface;

import java.util.List;

import cn.zucc.edu.course.model.Carbase;
import cn.zucc.edu.course.model.Carbrand;
import cn.zucc.edu.course.util.DbException;

//汽车品牌接口
public interface ICarbrandDAO {
	public void CreateCarbrand(Carbrand carbrand)throws DbException;
	public void ModifryCarbrand(Carbrand carbrand)throws DbException;
	public Carbrand SearchCarbrand(int id)throws DbException;
	public List<Carbrand> loadCarbrand()throws DbException;
	public List<Carbrand> QryCarbrand(Carbrand carbrand)throws DbException;
	public void DelCarbrand (Carbrand carbrand)throws DbException;
	
}
