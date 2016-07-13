package cn.zucc.edu.course.DAO;

import java.util.List;

import cn.zucc.edu.course.model.Carbrand;
import cn.zucc.edu.course.workinterface.ICarbrandDAO;

import cn.zucc.edu.course.util.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import cn.zucc.edu.course.model.Carbase;
import cn.zucc.edu.course.util.DBUtil;
import cn.zucc.edu.course.util.DbException;
import cn.zucc.edu.course.workinterface.ICarbaseDAO;

public class CarbrandDAO implements ICarbrandDAO {

	@Override
	public void CreateCarbrand(Carbrand carbrand) throws DbException {
		// TODO Auto-generated method stub
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="INSERT INTO [Course].[dbo].[carbrand]"
					+ "([brandname],[brandcountry],[brandintroduction],[branddel])"
					+ "VALUES(?,?,?,?)";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, carbrand.getBrandname());
			pst.setString(2, carbrand.getBrandcountry());
			pst.setString(3, carbrand.getBrandintroduction());
			pst.setInt(4, 0);	
			pst.execute();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(e);
		}
		finally{
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();

				}

		}
	}

	@Override
	public void ModifryCarbrand(Carbrand carbrand) throws DbException {
		// TODO Auto-generated method stub
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="UPDATE [Course].[dbo].[carbrand]"
					+ "SET[brandname] = ?,[brandcountry] = ?,[brandintroduction] = ?,[branddel] = ?"
					+ " WHERE [brandid] = ?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, carbrand.getBrandname());
			pst.setString(2, carbrand.getBrandcountry());
			pst.setString(3, carbrand.getBrandintroduction());
			if(carbrand.isBranddel()==true)
				pst.setInt(4, 1);
			else
				pst.setInt(4, 0);
			pst.execute();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(e);
		}
		finally{
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();

				}

		}
	}

	@Override
	public Carbrand SearchCarbrand(int id) throws DbException {
		// TODO Auto-generated method stub
		Connection conn=null;
		Carbrand carbrand=new Carbrand();
		try {
			conn=DBUtil.getConnection();
			String sql="SELECT [brandid],[brandname],[brandcountry],[brandintroduction],[branddel]"
					+ "FROM [Course].[dbo].[carbrand]"
					+ "where [brandid]=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, id);
			java.sql.ResultSet rs=pst.executeQuery();

			carbrand.setBrandid(id);
			carbrand.setBrandname(rs.getString(2));
			carbrand.setBrandcountry(rs.getString(3));
			carbrand.setBrandintroduction(rs.getString(4));
			int del=rs.getInt(5);
			if(del==0)
				carbrand.setBranddel(false);
			else
				carbrand.setBranddel(true);
			rs.close();
			pst.execute();
			pst.close();
			return carbrand;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(e);
		}
		finally{
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();

				}

		}
		
	}

	@Override
	public List<Carbrand> loadCarbrand() throws DbException {
		// TODO Auto-generated method stub
		List<Carbrand> totalcabrandr=new ArrayList<Carbrand>();
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="SELECT [brandid],[brandname],[brandcountry],[brandintroduction],[branddel]"
					+ "  FROM [Course].[dbo].[carbrand]";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			java.sql.ResultSet rs=pst.executeQuery();
//			if(!rs.next()) 
//				return null;
			while (rs.next()){
				Carbrand carbrand=new Carbrand();
				carbrand.setBrandid(rs.getInt(1));
				carbrand.setBrandname(rs.getString(2));
				carbrand.setBrandcountry(rs.getString(3));
				carbrand.setBrandintroduction(rs.getString(4));
				int del=rs.getInt(5);
				if(del==0)
					carbrand.setBranddel(false);
				else
					carbrand.setBranddel(true);
				totalcabrandr.add(carbrand);
			}					
			rs.close();
			pst.execute();
			pst.close();
			return totalcabrandr;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(e);
		}
		finally{
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();

				}

		}
	}

	@Override
	public List<Carbrand> QryCarbrandname(Carbrand carbrand1) throws DbException {
		List<Carbrand> totalcabrandr=new ArrayList<Carbrand>();
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="SELECT [brandname],[brandcountry],[brandintroduction],[branddel]"
					+ "  FROM [Course].[dbo].[carbrand]"
					+ "where [brandname] like ?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, carbrand1.getBrandname());
			java.sql.ResultSet rs=pst.executeQuery();
			if(!rs.next()) 
				return null;
			while (rs.next()){
				Carbrand carbrand=new Carbrand();
				carbrand.setBrandname(rs.getString(2));
				carbrand.setBrandcountry(rs.getString(3));
				carbrand.setBrandintroduction(rs.getString(4));
				int del=rs.getInt(5);
				if(del==0)
					carbrand.setBranddel(false);
				else
					carbrand.setBranddel(true);
				totalcabrandr.add(carbrand);
			}					
			rs.close();
			pst.execute();
			pst.close();
			return totalcabrandr;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(e);
		}
		finally{
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();

				}

		}
	}

	@Override
	public void DelCarbrand(Carbrand carbrand) throws DbException {
		// TODO Auto-generated method stub
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="UPDATE [Course].[dbo].[carbrand]"
					+ " SET [branddel] = 1"
					+ "where [brandid]=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, carbrand.getBrandid());
			pst.execute();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(e);
		}
		finally{
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();

				}

		}
	}


}
