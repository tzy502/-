package cn.zucc.edu.course.DAO;

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

public class CarbaseDAO implements ICarbaseDAO {

	@Override
	public void CreateCar(Carbase car) throws DbException {
		// TODO Auto-generated method stub
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="INSERT INTO [Course].[dbo].[carbase]"
					+ "([userid],[cartypeid],[carlineid],[transmissiontype],[cartype],[displacement],"
					+ "[carage],[productionyear],[cardtime],[travelmileage],[carcolor],"
					+ "[suggestedprice],[realprice],[carstate],[cardel])"
					+ "VALUES(?,?,?,?,?,?,?, ?,?,?,?, ?,?,?,?)";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, car.getUserid());
			pst.setInt(2, car.getCartypeid());
			pst.setInt(3,car.getCarlineid());
			pst.setString(4, car.getTransmissiontype());
			pst.setString(5, car.getCartype());
			pst.setInt(6, car.getDisplacement());
			pst.setInt(7, car.getCarage());
			java.sql.Date Productionyear=new java.sql.Date(car.getProductionyear().getTime());
			pst.setDate(8,Productionyear);
			java.sql.Date cardtime=new java.sql.Date(car.getCardtime().getTime());		
			pst.setDate(9,cardtime);
			pst.setInt(10, car.getTravelmileage());
			pst.setString(11, car.getCarcolor());
			pst.setInt(12,car.getSuggestedprice());
			pst.setInt(13, car.getRealprice());
			pst.setString(14, car.getCarstate());
			pst.setInt(15, 0);
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
	public Carbase SearchCarId(int id) throws DbException {
		// TODO Auto-generated method stub
		Carbase car=new Carbase();
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="SELECT [userid],[carid],[cartypeid],[carlineid],[transmissiontype],[cartype] "
					+ ",[displacement],[carage],[productionyear],[cardtime],[travelmileage],"
					+ "[carcolor],[suggestedprice],[realprice],[carstate],[cardel]"
					+ "  FROM [Course].[dbo].[carbase]"
					+ " WHERE [carid] = ?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, id);
			java.sql.ResultSet rs=pst.executeQuery();
			car.setUserid(rs.getString(1));
			car.setCarid(rs.getInt(2));
			car.setCartypeid(rs.getInt(3));
			car.setCarlineid(rs.getInt(4));
			car.setTransmissiontype(rs.getString(5));
			car.setCartype(rs.getString(7));
			car.setDisplacement(rs.getInt(7));
			car.setCarage(rs.getInt(8));
			car.setProductionyear(rs.getDate(9));
			car.setCardtime(rs.getDate(10));
			car.setTravelmileage(rs.getInt(11));
			car.setCarcolor(rs.getString(12));
			car.setSuggestedprice(rs.getInt(13));
			car.setRealprice(rs.getInt(14));
			car.setCarstate(rs.getString(15));
			int del=rs.getInt(16);
			if (del==0){
				car.setCardel(false);
			}
			else{
				car.setCardel(true);
			}
			rs.close();
			pst.execute();
			pst.close();
			return car;
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
	public void ModifryCar(Carbase car) throws DbException {
		// TODO Auto-generated method stub
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="UPDATE [Course].[dbo].[carbase]"
					+ "   SET [userid] =?,[cartypeid] = ?,[carlineid] = ?,[transmissiontype] = ?,"
					+ "[cartype] = ?,[displacement] = ?,[carage] = ?,[productionyear] = ?"
					+ ",[cardtime] = ?,[carstate] = ?,[cardel] = ?"
					+ " WHERE [carid] = ?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, car.getUserid());
			pst.setInt(2, car.getCartypeid());
			pst.setInt(3,car.getCarlineid());
			pst.setString(4, car.getTransmissiontype());
			pst.setString(5, car.getCartype());
			pst.setInt(6, car.getDisplacement());
			pst.setInt(7, car.getCarage());
			java.sql.Date Productionyear=new java.sql.Date(car.getProductionyear().getTime());
			pst.setDate(8,Productionyear);
			java.sql.Date cardtime=new java.sql.Date(car.getCardtime().getTime());		
			pst.setDate(9,cardtime);
			pst.setInt(10, car.getTravelmileage());
			pst.setString(11, car.getCarcolor());
			pst.setInt(12,car.getSuggestedprice());
			pst.setInt(13, car.getRealprice());
			pst.setString(14, car.getCarstate());
			if(car.isCardel()==true){
				pst.setInt(15, 1);
			}
			else{
				pst.setInt(15, 0);
			}
			pst.setInt(16, car.getCarid());

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
	public List<Carbase> QryCar(Carbase searchcar) throws DbException {
		List<Carbase> totalcar=new ArrayList<Carbase>();
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="SELECT [carid],[cartypeid],[carlineid],[transmissiontype],[cartype] "
					+ ",[displacement],[carage],[productionyear],[cardtime],[travelmileage],"
					+ "[carcolor],[suggestedprice],[realprice],[carstate],[cardel]"
					+ "  FROM [Course].[dbo].[carbase]";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			java.sql.ResultSet rs=pst.executeQuery();
			if(!rs.next()) 
				return null;
			while(rs.next()){
				Carbase car=new Carbase();
				car.setCarid(rs.getInt(1));
				car.setCartypeid(rs.getInt(2));
				car.setCarlineid(rs.getInt(3));
				car.setTransmissiontype(rs.getString(4));
				car.setCartype(rs.getString(5));
				car.setDisplacement(rs.getInt(6));
				car.setCarage(rs.getInt(7));
				car.setProductionyear(rs.getDate(8));
				car.setCardtime(rs.getDate(9));
				car.setTravelmileage(rs.getInt(10));
				car.setCarcolor(rs.getString(11));
				car.setSuggestedprice(rs.getInt(12));
				car.setRealprice(rs.getInt(13));
				car.setCarstate(rs.getString(14));
				int del=rs.getInt(15);
				if (del==0){
					car.setCardel(false);
				}
				else{
					car.setCardel(true);
				}
				totalcar.add(car);
			}
			rs.close();
			pst.execute();
			pst.close();
			return totalcar;
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
	public List<Carbase> LoadCar() throws DbException {
		// TODO Auto-generated method stub
		List<Carbase> totalcar=new ArrayList<Carbase>();
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="SELECT [userid],[carid],[cartypeid],[carlineid],[transmissiontype],[cartype] "
					+ ",[displacement],[carage],[productionyear],[cardtime],[travelmileage],"
					+ "[carcolor],[suggestedprice],[realprice],[carstate],[cardel]"
					+ "  FROM [Course].[dbo].[carbase]";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			java.sql.ResultSet rs=pst.executeQuery();
			if(!rs.next()) 
				return null;
			while(rs.next()){
				Carbase car=new Carbase();
				car.setUserid(rs.getString(1));
				car.setCarid(rs.getInt(2));
				car.setCartypeid(rs.getInt(3));
				car.setCarlineid(rs.getInt(4));
				car.setTransmissiontype(rs.getString(5));
				car.setCartype(rs.getString(7));
				car.setDisplacement(rs.getInt(7));
				car.setCarage(rs.getInt(8));
				car.setProductionyear(rs.getDate(9));
				car.setCardtime(rs.getDate(10));
				car.setTravelmileage(rs.getInt(11));
				car.setCarcolor(rs.getString(12));
				car.setSuggestedprice(rs.getInt(13));
				car.setRealprice(rs.getInt(14));
				car.setCarstate(rs.getString(15));
				int del=rs.getInt(16);
				if (del==0){
					car.setCardel(false);
				}
				else{
					car.setCardel(true);
				}
				totalcar.add(car);
			}
			rs.close();
			pst.execute();
			pst.close();
			return totalcar;
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
	public void DelCar(Carbase car) throws DbException {
		// TODO Auto-generated method stub
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="UPDATE [Course].[dbo].[carbase] "
					+ "   SET [cardel] = ?"
					+ "  WHERE where carid=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, 1);
			pst.setInt(2,car.getCarid());
			car.setCardel(true);
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
