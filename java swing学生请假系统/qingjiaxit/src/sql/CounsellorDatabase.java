package sql;
import info.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import info.User;


public class CounsellorDatabase {
	
	private static Connection conn = null;

	// 取得数据库连接，本服务器程序仅使用这一个连接实例
	private static Connection getConnection() {
		if (conn != null) {
			return conn;
		}

		String driver_MySQL = "com.mysql.jdbc.Driver";
		//String url = "jdbc:mysql://localhost:3306/shixun";
	//	String url = "jdbc:mysql://localhost:3306/guanliyuan";
		String url="jdbc:mysql://localhost:3306/guanliyuan?characterEncoding=utf-8";
	//	String url = "jdbc:mysql://39.105.231.173/guanliyuan?serverTimezone=UTC&characterEncoding=utf-8";
		String account_MySQL = "root";
		String password_MySQL = "root";
	//	String password_MySQL = "aly66MYSQL!!!";

		try {
			Class.forName(driver_MySQL);
			conn = DriverManager.getConnection(url, account_MySQL,
					password_MySQL);
			System.out.println("创建数据库连接成功！");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("创建数据库连接失败！");
		}
		return conn;
	}

	private static String toSqlString(String str) {
		return new String(" '" + str + "' ");
	}

	// account is Name
	public static User userQquery(String accountName) {
		User user = null;

		String sql = "select * from cuserlist where name = " + toSqlString(accountName);
		
		try {
			Statement stmt = getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			//ResultSet rs = stmt.executeQuery("SELECT*FROM userlist");
			if (rs.next() == true) {
				user = new User();
//				user.setId(rs.getLong(1));
//				user.setName(rs.getString(2));
//				user.setStuNum(rs.getString(3));
//				user.setPwd(rs.getString(4));
				user.setName(rs.getString(1));
				user.setPwd(rs.getString(2));
				user.setZhuangye(rs.getString(3));
			}
		} catch (SQLException sqle) {
			System.out.println("查询数据出现异常: " + sqle.getMessage());
		}

		return user;
}}