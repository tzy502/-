package cn.zucc.edu.course.util;

import java.sql.Connection;

public class DBUtil {
	private static final String jdbcUrl="jdbc:jtds:sqlserver://127.0.0.1:1433/Course";
	private static final String dbUser="root";
	private static final String dbPwd="zucc";
	static{
		try {
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getConnection() throws java.sql.SQLException{
		return java.sql.DriverManager.getConnection(jdbcUrl, dbUser, dbPwd);
	}
}
