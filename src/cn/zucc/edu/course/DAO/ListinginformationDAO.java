package cn.zucc.edu.course.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.zucc.edu.course.model.Listinginformation;
import cn.zucc.edu.course.util.DBUtil;
import cn.zucc.edu.course.util.DbException;
import cn.zucc.edu.course.workinterface.IListinginformationDAO;

public class ListinginformationDAO implements IListinginformationDAO {

	@Override
	public void Createistinginformation(Listinginformation car) throws DbException {
		// TODO Auto-generated method stub
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="INSERT INTO [Course].[dbo].[Listinginformation]"
					+ "([carid],[userid],[Sellinformation],[selltime],[realprice],"
					+ "[carage],[transmissiontype],[cartype],[seeway],[Ldel])"
					+ "VALUES(?,?,?,?,?,?,?,?,?,?)";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, car.getCarid());
			pst.setString(2, car.getUserid());
			pst.setString(3, car.getSellinformation());
			pst.setDate(4, (java.sql.Date)car.getSelltime());
			pst.setInt(5, car.getRealprice());
			pst.setInt(6, car.getCarage());
			pst.setString(7, car.getTransmissiontype());
			pst.setString(8, car.getCartype());
			pst.setInt(9, car.getSeeway());
			if(car.isLdel()==true)
				pst.setInt(10, 1);
			else
				pst.setInt(10, 0);
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
	public void Modifrytinginformation(Listinginformation car) throws DbException {
		// TODO Auto-generated method stub
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="UPDATE [Course].[dbo].[Listinginformation]"
					+ "   SET [Sellinformation] = ?,[selltime] = ?,[realprice] = ?,"
					+ "[carage] =?,[transmissiontype] =?,[cartype] = ?,[seeway] =?,[Ldel] = ?"
					+ " WHERE [carid] = ? and [userid] = ?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, car.getSellinformation());
			pst.setDate(2, (java.sql.Date)car.getSelltime());
			pst.setInt(3, car.getRealprice());
			pst.setInt(4, car.getCarage());
			pst.setString(5, car.getTransmissiontype());
			pst.setString(6, car.getCartype());
			pst.setInt(7, car.getSeeway());
			if(car.isLdel()==true)
				pst.setInt(8, 1);
			else
				pst.setInt(8, 0);
			pst.setInt(9, car.getCarid());
			pst.setString(10, car.getUserid());

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
	public Listinginformation Searchistinginformation(int carid,String userid) throws DbException {
		// TODO Auto-generated method stub
		Listinginformation listinginformation=new Listinginformation();
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="SELECT [carid],[userid],[Sellinformation],[selltime],"
					+ "[realprice],[carage],[transmissiontype],[cartype],[seeway],[Ldel]"
					+ "  FROM [Course].[dbo].[Listinginformation]"
					+ " WHERE [carid] = ? and [userid] = ?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, carid);
			pst.setString(2, userid);
			java.sql.ResultSet rs=pst.executeQuery();
			if(!rs.next()) 
				return null;
			listinginformation.setCarid(rs.getInt(1));
			listinginformation.setUserid(rs.getString(2));
			listinginformation.setSellinformation(rs.getString(3));
			listinginformation.setSelltime(rs.getDate(4));
			listinginformation.setRealprice(rs.getInt(5));
			listinginformation.setCarage(rs.getInt(6));
			listinginformation.setTransmissiontype(rs.getString(7));
			listinginformation.setCartype(rs.getString(8));
			listinginformation.setSeeway(rs.getInt(9));
			int del=rs.getInt(10);
			if(del==1)
				listinginformation.setLdel(true);
			else
				listinginformation.setLdel(false);
			rs.close();
			pst.execute();
			pst.close();
			return listinginformation;
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
	public List<Listinginformation> Qryistinginformation(Listinginformation car) throws DbException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Listinginformation> Loadistinginformation() throws DbException {
		
		List<Listinginformation> total=new ArrayList<Listinginformation>();
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="SELECT [carid],[userid],[Sellinformation],[selltime],"
					+ "[realprice],[carage],[transmissiontype],[cartype],[seeway],[Ldel]"
					+ "  FROM [Course].[dbo].[Listinginformation]";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			java.sql.ResultSet rs=pst.executeQuery();
			if(!rs.next()) 
				return null;
			while (rs.next()){
				Listinginformation listinginformation=new Listinginformation();
				listinginformation.setCarid(rs.getInt(1));
				listinginformation.setUserid(rs.getString(2));
				listinginformation.setSellinformation(rs.getString(3));
				listinginformation.setSelltime(rs.getDate(4));
				listinginformation.setRealprice(rs.getInt(5));
				listinginformation.setCarage(rs.getInt(6));
				listinginformation.setTransmissiontype(rs.getString(7));
				listinginformation.setCartype(rs.getString(8));
				listinginformation.setSeeway(rs.getInt(9));
				int del=rs.getInt(10);
				if(del==1)
					listinginformation.setLdel(true);
				else
					listinginformation.setLdel(false);
				total.add(listinginformation);
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
	public void Delistinginformation(Listinginformation car) throws DbException {
		// TODO Auto-generated method stub	
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="UPDATE [Course].[dbo].[Listinginformation]"
					+ "   SET [Ldel] = 1"
					+ " WHERE [carid] = ? and [userid] = ?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, car.getCarid());
			pst.setString(2, car.getUserid());
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
