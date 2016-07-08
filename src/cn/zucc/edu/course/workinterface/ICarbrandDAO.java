package cn.zucc.edu.course.workinterface;

import java.util.List;

import cn.zucc.edu.course.model.Carbase;
import cn.zucc.edu.course.model.Carbrand;

//汽车品牌接口
public interface ICarbrandDAO {
	public void CreateCarbrand(Carbrand carbrand);
	public void ModifryCarbrand(Carbrand carbrand);
	public Carbrand SearchCarbrand(int id);
	public List<Carbrand> loadCarbrand();
	public List<Carbrand> QryCarbrand(Carbrand carbrand);
	public void DelCarbrand (Carbrand carbrand);
	
}
