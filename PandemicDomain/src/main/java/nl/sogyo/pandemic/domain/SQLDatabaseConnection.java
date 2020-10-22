package nl.sogyo.pandemic.domain;

import java.sql.*;  
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

class SQLDatabaseConnection{  

	public SQLDatabaseConnection() {
		
	}

	public List<String> getData(String QueryString, int number) {
		List<String> dataBaseList = new ArrayList<>();
		try{  

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(  

			"jdbc:mysql://localhost:3306/PandemicDB?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","Blokkendoos1!");  

			Statement stmt=con.createStatement();  

			ResultSet rs=stmt.executeQuery(QueryString);  

			while(rs.next())  
				for (int i = 0; i < number; i++) {
					dataBaseList.add(rs.getString(i+1));
				}

			con.close();  

		}catch(Exception e){ System.out.println(e);}
		return dataBaseList;  
	}

	public void setData(String QueryString, int number) {
		// TODO Auto-generated method stub
		List<String> dataBaseList = new ArrayList<>();
		try{  

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(  

			"jdbc:mysql://localhost:3306/PandemicDB?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","Blokkendoos1!");  

			Statement stmt=con.createStatement();  

			int rs=stmt.executeUpdate(QueryString);  

//			while(rs.next())  
//				for (int i = 0; i < number; i++) {
//					dataBaseList.add(rs.getString(i+1));
//				}

			con.close();  

		}catch(Exception e){ System.out.println(e);}
//		return dataBaseList;  
	}  
}  