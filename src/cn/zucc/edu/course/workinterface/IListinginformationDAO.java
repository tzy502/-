package cn.zucc.edu.course.workinterface;

import java.util.List;

import cn.zucc.edu.course.model.Carbase;
import cn.zucc.edu.course.model.Listinginformation;
import cn.zucc.edu.course.util.DbException;

//挂牌信息接口
public interface IListinginformationDAO {
	public void Createistinginformation(Listinginformation car)throws DbException;
	public void Modifrytinginformation(Listinginformation car)throws DbException;
	public Listinginformation Searchistinginformation(int carid,String userid)throws DbException;
	public List<Listinginformation> Qryistinginformation(Listinginformation car)throws DbException;
	public List<Listinginformation> Loadistinginformation()throws DbException;
	public void Delistinginformation(Listinginformation car)throws DbException;
}
