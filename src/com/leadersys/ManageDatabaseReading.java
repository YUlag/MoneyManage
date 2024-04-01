package com.leadersys;
/*
 *类名:ManageDatabaseReading.class
 *版本:1.0
 *日期:2020年12月29日
 */
import java.sql.*;

public class ManageDatabaseReading {
	static Connection con=null;
	static Statement sql;
	ResultSet rs;

	 ManageDatabaseReading(){
		//加载驱动  
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(Exception e){
			e.printStackTrace();
		}
		//连接数据库
		String uri="jdbc:mysql://localhost:3306/bigsystem";
		try{
			con=DriverManager.getConnection(uri,"root","123456");//账号密码
			sql=con.createStatement();
			System.out.println("链接数据库成功");
		}catch(SQLException e){
			System.out.println("链接数据库失败");
			String temp=e.getMessage();
			System.out.println(temp);
		}
	}	
}
