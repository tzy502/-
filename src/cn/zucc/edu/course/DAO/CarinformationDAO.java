package cn.zucc.edu.course.DAO;
//³µÏµ
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.zucc.edu.course.model.Carlinformation;
import cn.zucc.edu.course.util.DBUtil;
import cn.zucc.edu.course.util.DbException;
import cn.zucc.edu.course.workinterface.ICarlinformationDAO;

public class CarinformationDAO implements ICarlinformationDAO {

	@Override
	public void CreateCar(Carlinformation carlinformation) throws DbException {
		// TODO Auto-generated method stub
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="INSERT INTO [Course].[dbo].[carinformation]"
					+ "([brandid],[carlinename],[brand],[carlineintro],[carlinedel])"
					+ "VALUES(?,?,?,?,?)";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1,carlinformation.getBrandid());
			pst.setString(2, carlinformation.getCarlinename());
			pst.setString(3, carlinformation.getBrand());
			pst.setString(4, carlinformation.getCarlineintro());
			pst.setInt(5, 0);


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
	public void ModifryCar(Carlinformation carlinformation) throws DbException {
		// TODO Auto-generated method stub
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="UPDATE [Course].[dbo].[carinformation]"
					+ "   SET [brandid] =?,[carlinename] =?,[brand] = ?,[carlineintro] = ?,[carlinedel] = ?"
					+ " WHERE [carlineid] = ?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1,carlinformation.getBrandid() );
			pst.setString(2,carlinformation.getCarlinename());
			pst.setString(3, carlinformation.getBrand());
			pst.setString(4,carlinformation.getCarlineintro());
			if(carlinformation.isCarlinedel()==true)
				pst.setInt(5, 1);
			else
				pst.setInt(5, 0);

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
	public Carlinformation SearchCarId(int id) throws DbException {
		// TODO Auto-generated method stub
		Carlinformation carlinformation =new Carlinformation();
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="SELECT [carlineid],[brandid],[carlinename] ,[brand],[carlineintro],[carlinedel]"
					+ "  FROM [Course].[dbo].[carinformation]"
					+ "where [carlineid]=?";
					
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, id);
			java.sql.ResultSet rs=pst.executeQuery();
			if(rs.next()){
				carlinformation.setCarlineid(rs.getInt(1));		
				carlinformation.setBrandid(rs.getInt(2));
				carlinformation.setCarlinename(rs.getString(3));			
				carlinformation.setBrand(rs.getString(4));
				carlinformation.setCarlineintro(rs.getString(5));
				int del=rs.getInt(6);
				if(del==0)
					carlinformation.setCarlinedel(false);
				else
				carlinformation.setCarlinedel(true);
				}

			rs.close();
			pst.execute();
			pst.close();
			return carlinformation;
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
	public List<Carlinformation> QryCar(Carlinformation carlinformation1) throws DbException {
		// TODO Auto-generated method stub
		List<Carlinformation> total=new ArrayList<Carlinformation>();
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="SELECT [carlineid],[brandid],[carlinename],[brand],[carlineintro],[carlinedel]"
					+ "  FROM [Course].[dbo].[carinformation]"
					+ "where brandid=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, carlinformation1.getBrandid());
			java.sql.ResultSet rs=pst.executeQuery();
			while(rs.next()){
				Carlinformation carlinformation =new Carlinformation();
				carlinformation.setCarlineid(rs.getInt(1));
				carlinformation.setBrandid(rs.getInt(2));
				carlinformation.setCarlinename(rs.getString(3));
				carlinformation.setBrand(rs.getString(4));
				carlinformation.setCarlineintro(rs.getString(5));
				int del=rs.getInt(6);
				if(del==0)
					carlinformation.setCarlinedel(false);
				else
					carlinformation.setCarlinedel(true);
				total.add(carlinformation);
			}
			rs.close();
			pst.execute();
			pst.close();
			return total;
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
	public List<Carlinformation> LoadCar() throws DbException {
		// TODO Auto-generated method stub
		List<Carlinformation> total=new ArrayList<Carlinformation>();
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="SELECT [carlineid],[brandid],[carlinename],[brand],[carlineintro],[carlinedel]"
					+ "  FROM [Course].[dbo].[carinformation]";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			java.sql.ResultSet rs=pst.executeQuery();
			if(!rs.next()) 
				return null;
			while(rs.next()){
				Carlinformation carlinformation =new Carlinformation();
				carlinformation.setCarlineid(rs.getInt(1));
				carlinformation.setBrandid(rs.getInt(2));
				carlinformation.setCarlinename(rs.getString(3));
				carlinformation.setBrand(rs.getString(4));
				carlinformation.setCarlineintro(rs.getString(5));
				int del=rs.getInt(6);
				if(del==0)
					carlinformation.setCarlinedel(false);
				else
					carlinformation.setCarlinedel(true);
				total.add(carlinformation);
			}
			rs.close();
			pst.execute();
			pst.close();
			return total;
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
	public void DelCar(Carlinformation carlinformation) throws DbException {
		// TODO Auto-generated method stub
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="UPDATE [Course].[dbo].[carinformation]"
					+ "[carlinedel] =1"
					+ "where [carlineid] = ?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, carlinformation.getBrandid());
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
