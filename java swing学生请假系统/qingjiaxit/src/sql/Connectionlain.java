package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connectionlain {
	
	public Connection getConnect() {
		Connection conn=null;
	//	String url="jdbc:mysql://127.0.0.1:3306/guanliyuan";
	//	String url="jdbc:mysql://39.105.231.173/guanliyuan?serverTimezone=UTC&characterEncoding=utf-8";
		String url="jdbc:mysql://localhost:3306/guanliyuan?characterEncoding=utf-8";
		String user="root";
		String password="root";
	//	String password="aly66MYSQL!!!";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(url, user, password);
			return conn;
		}catch(ClassNotFoundException e){
		    System.out.println("错误");
		    e.printStackTrace();
		    return null;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
	}
	

}
