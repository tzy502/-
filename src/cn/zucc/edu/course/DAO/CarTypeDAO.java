package cn.zucc.edu.course.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.zucc.edu.course.model.Cartype;
import cn.zucc.edu.course.util.DBUtil;
import cn.zucc.edu.course.util.DbException;
import cn.zucc.edu.course.workinterface.ICartypeDAO;

public class CarTypeDAO implements ICartypeDAO {

	@Override
	public void CreateCar(Cartype cartype) throws DbException {
		// TODO Auto-generated method stub
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="INSERT INTO [Course].[dbo].[cartype]"
					+ "([cartypename],[cartypeintro],[cartypeuse],[cartypedel])"
					+ "VALUES(?,?,?,?)";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, cartype.getCartypename());
			pst.setString(2, cartype.getCartypeintroduce());
			pst.setString(3,cartype.getCartypeuse());
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
	public void ModifryCar(Cartype cartype) throws DbException {
		// TODO Auto-generated method stub
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="UPDATE [Course].[dbo].[cartype]"
					+ "   SET [cartypename] = ?,[cartypeintro] = ?,[cartypeuse] = ?,[cartypedel] =?"
					+ " WHERE [cartypeid] = ?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, cartype.getCartypename());
			pst.setString(2, cartype.getCartypeintroduce());
			pst.setString(3,cartype.getCartypeuse());
			if(cartype.isCartypedel()==true)
				pst.setInt(4, 1);
			else
				pst.setInt(4, 0);
			pst.setInt(5, cartype.getCartypeid());
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
	public Cartype SearchCarId(int id) throws DbException {
		// TODO Auto-generated method stub
		Cartype cartype=new Cartype();
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="SELECT [cartypeid],[cartypename],[cartypeintro],[cartypeuse],[cartypedel]"
					+ "  FROM [Course].[dbo].[cartype]"
					+ "WHERE [cartypeid]=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			java.sql.ResultSet rs=pst.executeQuery();
			pst.setInt(1, id);
			if(!rs.next()) 
				return null;
			cartype.setCartypeid(rs.getInt(1));
			cartype.setCartypename(rs.getString(2));
			cartype.setCartypeintroduce(rs.getString(3));
			cartype.setCartypeuse(rs.getString(4));
			int del=rs.getInt(5);
			if(del==1)
				cartype.setCartypedel(true);
			else
				cartype.setCartypedel(false);
			rs.close();
			pst.execute();
			pst.close();
			return cartype;
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
	public List<Cartype> QryCar(Cartype cartype) throws DbException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cartype> LoadCar() throws DbException {
		// TODO Auto-generated method stub
		List<Cartype> total=new ArrayList<Cartype>();

		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="SELECT [cartypeid],[cartypename],[cartypeintro],[cartypeuse],[cartypedel]"
					+ "  FROM [Course].[dbo].[cartype]";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			java.sql.ResultSet rs=pst.executeQuery();
			if(!rs.next()) 
				return null;
			while(rs.next()){
				Cartype cartype=new Cartype();
				cartype.setCartypeid(rs.getInt(1));
				cartype.setCartypename(rs.getString(2));
				cartype.setCartypeintroduce(rs.getString(3));
				cartype.setCartypeuse(rs.getString(4));
				int del=rs.getInt(5);
				if(del==1)
					cartype.setCartypedel(true);
				else
					cartype.setCartypedel(false);
				total.add(cartype);

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
	public void DelCar(Cartype cartype) throws DbException {
		// TODO Auto-generated method stub
		List<Cartype> total=new ArrayList<Cartype>();

		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="UPDATE [Course].[dbo].[cartype]"
					+ "    SET [cartypedel] = 1"
					+ "where cartypeid=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, cartype.getCartypeid());

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
