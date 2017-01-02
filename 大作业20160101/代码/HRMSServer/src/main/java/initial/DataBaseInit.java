package initial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * 数据库初始化
 * @author yilu
 *
 */
public class DataBaseInit {
	// JDBC 驱动名及数据库 URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/HRMS?useUnicode=true&characterEncoding=utf-8&useSSL=false";
	// 数据库的用户名与密码，需要根据自己的设置
	static final String USER = "root";
	static final String PASS = "HRMS";  //enter your password.

	static Connection conn;

	public DataBaseInit(){
	// 注册 JDBC 驱动
		try{
			// 注册 JDBC 驱动
			Class.forName(JDBC_DRIVER);
    		// 打开链接
			System.out.println("连接数据库...");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
		}catch(SQLException se){
			// 处理 JDBC 错误
			se.printStackTrace();
		}catch(Exception e){
			// 处理 Class.forName 错误
			e.printStackTrace();
		}
	}

	public static Connection getConnection(){
		return conn;
	}

}
