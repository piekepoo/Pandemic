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

	public List<String> getData(String QueryString) {
		List<String> dataBaseList = new ArrayList<>();
		try{  

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(  

			"jdbc:mysql://localhost:3306/PandemicDB?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","Blokkendoos1!");  

			Statement stmt=con.createStatement();  

			ResultSet rs=stmt.executeQuery(QueryString);  

			while(rs.next())  
				for (int i = 0; i < 14; i++) {
					dataBaseList.add(rs.getString(i+1));
				}

			con.close();  

		}catch(Exception e){ System.out.println(e);}
		return dataBaseList;  
	}  
}  