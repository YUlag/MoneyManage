package com.leadersys;
/*
 *����:ManageDatabaseReading.class
 *�汾:1.0
 *����:2020��12��29��
 */
import java.sql.*;

public class ManageDatabaseReading {
	static Connection con=null;
	static Statement sql;
	ResultSet rs;

	 ManageDatabaseReading(){
		//��������  
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(Exception e){
			e.printStackTrace();
		}
		//�������ݿ�
		String uri="jdbc:mysql://localhost:3306/bigsystem";
		try{
			con=DriverManager.getConnection(uri,"root","123456");//�˺�����
			sql=con.createStatement();
			System.out.println("�������ݿ�ɹ�");
		}catch(SQLException e){
			System.out.println("�������ݿ�ʧ��");
			String temp=e.getMessage();
			System.out.println(temp);
		}
	}	
}
