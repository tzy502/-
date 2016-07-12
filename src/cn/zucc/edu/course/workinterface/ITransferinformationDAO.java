package cn.zucc.edu.course.workinterface;

import java.util.List;

import cn.zucc.edu.course.model.Transferinformation;
import cn.zucc.edu.course.util.DbException;

//过户信息忌口
public interface ITransferinformationDAO {
		public void CreateTransferinformation(Transferinformation car)throws DbException;
		public void ModifryTransferinformation(Transferinformation car)throws DbException;
		public Transferinformation SearchTransferinformation(int carid,String sellerid,String buyerid)throws DbException;
		public List<Transferinformation> QryTransferinformation(Transferinformation car)throws DbException;
		public List<Transferinformation> LoadTransferinformation()throws DbException;
		public void DelTransferinformation(Transferinformation car)throws DbException;
}
