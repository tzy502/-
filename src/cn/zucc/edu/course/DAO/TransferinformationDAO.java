package cn.zucc.edu.course.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.zucc.edu.course.model.Transferinformation;
import cn.zucc.edu.course.util.DBUtil;
import cn.zucc.edu.course.util.DbException;
import cn.zucc.edu.course.workinterface.ITransferinformationDAO;

public class TransferinformationDAO implements ITransferinformationDAO {

	@Override
	public void CreateTransferinformation(Transferinformation car) throws DbException {
		// TODO Auto-generated method stub
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="INSERT INTO [Course].[dbo].[Transferinformation]"
					+ "([carid],[sellerid],[buyerid],[cartype],[displacement],[productionyear],[cardtime]"
					+ ",[travelmileage],[carstate],[realprice],[Tdel])"
					+ " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, car.getCarid());
			pst.setString(2, car.getSellerid());
			pst.setString(3, car.getBuyerid());
			pst.setString(4, car.getCartype());
			pst.setInt(5, car.getDisplacement());
			java.sql.Date productionyear =new java.sql.Date(car.getProductionyear().getDate());
			pst.setDate(6, productionyear);
			java.sql.Date cardtime =new java.sql.Date(car.getCardtime().getDate());
			pst.setDate(7, cardtime);
			pst.setInt(8, car.getTravelmileagel());
			pst.setString(9, car.getCarstate());
			pst.setInt(10, car.getRealprice());
			if(car.isTdel()==true)
				pst.setInt(11, 1);
			else
				pst.setInt(11, 0);
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
	public void ModifryTransferinformation(Transferinformation car) throws DbException {
		// TODO Auto-generated method stub
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="UPDATE [Course].[dbo].[Transferinformation]"
					+ "   SET [cartype] = ?,[displacement] = ?,[productionyear] = ?,[cardtime] = ?,"
					+ "[travelmileage] = ?,[carstate] = ?,[realprice] = ?,[Tdel] = ?"
					+ " WHERE [carid] = ? and [sellerid] = ? and [buyerid] = ?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);

			pst.setString(1, car.getCartype());
			pst.setInt(2, car.getDisplacement());
			java.sql.Date productionyear =new java.sql.Date(car.getProductionyear().getDate());
			pst.setDate(3, productionyear);
			java.sql.Date cardtime =new java.sql.Date(car.getCardtime().getDate());
			pst.setDate(4, cardtime);
			pst.setInt(5, car.getTravelmileagel());
			pst.setString(6, car.getCarstate());
			pst.setInt(7, car.getRealprice());
			if(car.isTdel()==true)
				pst.setInt(8, 1);
			else
				pst.setInt(7, 0);
			pst.setInt(9, car.getCarid());
			pst.setString(10, car.getSellerid());
			pst.setString(11, car.getBuyerid());
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
	public Transferinformation SearchTransferinformation(int carid,String sellerid,String buyerid) throws DbException {
		// TODO Auto-generated method stub
		Connection conn=null;
		Transferinformation ti=new Transferinformation();
		try {
			conn=DBUtil.getConnection();
			String sql="SELECT [carid],[sellerid],[buyerid],[cartype],[displacement],"
					+ "[productionyear],[cardtime],[travelmileage],[carstate],[realprice],[Tdel]"
					+ "  FROM [Course].[dbo].[Transferinformation]"
					+ "where [carid]=? and [sellerid]=? and [buyerid]=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, carid);
			pst.setString(2, sellerid);
			pst.setString(3, buyerid);
			java.sql.ResultSet rs=pst.executeQuery();
			if(!rs.next()) 
				return null;
			ti.setCarid(rs.getInt(1));
			ti.setSellerid(rs.getString(2));
			ti.setBuyerid(rs.getString(3));
			ti.setCartype(rs.getString(4));
			ti.setDisplacement(rs.getInt(5));
			ti.setProductionyear(rs.getDate(6));
			ti.setCardtime(rs.getDate(7));
			ti.setTravelmileagel(rs.getInt(8));
			ti.setCarstate(rs.getString(9));
			ti.setRealprice(rs.getInt(10));
			int del=rs.getInt(11);
			if(del==1)
				ti.setTdel(true);
			else
				ti.setTdel(false);		
			rs.close();
			pst.execute();
			pst.close();
			return ti;
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
	public List<Transferinformation> QryTransferinformation(Transferinformation car) throws DbException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Transferinformation> LoadTransferinformation() throws DbException {
		// TODO Auto-generated method stub
		Connection conn=null;
		
		List<Transferinformation> total=new ArrayList<Transferinformation>();
		try {
			conn=DBUtil.getConnection();
			String sql="SELECT [carid],[sellerid],[buyerid],[cartype],[displacement],"
					+ "[productionyear],[cardtime],[travelmileage],[carstate],[realprice],[Tdel]"
					+ "  FROM [Course].[dbo].[Transferinformation]";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			java.sql.ResultSet rs=pst.executeQuery();
			if(!rs.next()) 
				return null;
			while (rs.next()){
				Transferinformation ti=new Transferinformation();
				ti.setCarid(rs.getInt(1));
				ti.setSellerid(rs.getString(2));
				ti.setBuyerid(rs.getString(3));
				ti.setCartype(rs.getString(4));
				ti.setDisplacement(rs.getInt(5));
				ti.setProductionyear(rs.getDate(6));
				ti.setCardtime(rs.getDate(7));
				ti.setTravelmileagel(rs.getInt(8));
				ti.setCarstate(rs.getString(9));
				ti.setRealprice(rs.getInt(10));
				int del=rs.getInt(11);
				if(del==1)
					ti.setTdel(true);
				else
					ti.setTdel(false);	
				total.add(ti);
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
	public void DelTransferinformation(Transferinformation car) throws DbException {
		// TODO Auto-generated method stub
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="UPDATE [Course].[dbo].[Transferinformation]"
					+ "   SET [Tdel] =1"
					+ "where [carid]=? and [sellerid]=? and [buyerid]=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, car.getCarid());
			pst.setString(2, car.getSellerid());
			pst.setString(3, car.getBuyerid());		
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
