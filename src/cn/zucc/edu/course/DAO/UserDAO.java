package cn.zucc.edu.course.DAO;

import java.sql.Connection;
import java.sql.SQLException;

import cn.zucc.edu.course.model.User;
import cn.zucc.edu.course.util.DBUtil;
import cn.zucc.edu.course.util.DbException;
import cn.zucc.edu.course.workinterface.IUserDAO;

public class UserDAO implements IUserDAO {

	@Override
	public void createuser(User user) throws DbException {
		// TODO Auto-generated method stub
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="INSERT INTO [Course].[dbo].[user]"
					+ "([userid],[username],[passwork],[TEL],[address],[email],[usertype],[sex],[age],[userdel])"
					+ "VALUES(?,?,?,?,?,?,?,?,?,?)";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, user.getUserid());
			pst.setString(2, user.getUsername());
			pst.setString(3, user.getPassword());
			pst.setString(4, user.getTEL());
			pst.setString(5, user.getAddress());
			pst.setString(6, user.getEmail());
			pst.setInt(7, user.getUsertype());
			pst.setInt(8, user.getUsersex());
			pst.setInt(9, user.getUserage());
			if(user.isUserdel()==true)
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
	public User SearchUser(String ID) throws DbException {
		// TODO Auto-generated method stub
		User user =new User();
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="SELECT [userid],[username],[passwork],[TEL],[address],"
					+ "[email],[usertype],[sex],[age],[userdel]"
					+ "  FROM [Course].[dbo].[user]"
					+ "where [userid] like ?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, ID);
			java.sql.ResultSet rs=pst.executeQuery();
			if(!rs.next()) 
				return null;
			user.setUserid(rs.getString(1));
			user.setUsername(rs.getString(2));
			user.setPassword(rs.getString(3));
			user.setTEL(rs.getString(4));
			user.setAddress(rs.getString(5));
			user.setEmail(rs.getString(6));
			user.setUsertype(rs.getInt(7));
			user.setUsersex(rs.getInt(8));
			user.setUserage(rs.getInt(9));
			int del=rs.getInt(10);
			if(del==1)
				user.setUserdel(true);
			else
				user.setUserdel(false);
			rs.close();
			pst.execute();
			pst.close();
			return user;
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
	public void ModifryUser(User user) throws DbException {
		// TODO Auto-generated method stub
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="UPDATE [Course].[dbo].[user]"
					+ "   SET [username] = ?,[passwork] = ?,[TEL] = ?,"
					+ "[address] = ?,[email] = ?,[usertype] = ?,[sex] = ?,"
					+ "[age] = ?,[userdel] = ?"
					+ " WHERE [userid] = ?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			
			pst.setString(1, user.getUsername());
			pst.setString(2, user.getPassword());
			pst.setString(3, user.getTEL());
			pst.setString(4, user.getAddress());
			pst.setString(5, user.getEmail());
			pst.setInt(6, user.getUsertype());
			pst.setInt(7, user.getUsersex());
			pst.setInt(8, user.getUserage());
			if(user.isUserdel()==true)
				pst.setInt(9, 1);
			else
				pst.setInt(9, 0);
			pst.setString(10, user.getUserid());
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
	public void DelUSer(User user) throws DbException {
		// TODO Auto-generated method stub
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="UPDATE [Course].[dbo].[user]"
					+ "   SET [userdel] = 1"
					+ " WHERE [userid] =?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, user.getUserid());
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
