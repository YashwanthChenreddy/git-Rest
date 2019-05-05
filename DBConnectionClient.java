package com.db.TestClient;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnectionClient {

	private final String url = "jdbc:postgresql://localhost/postgres";
	private final String user = "postgres";
	private final String password = "Mac%^~1";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("started");
		DBConnectionClient client = new DBConnectionClient();
		client.connect();
		
	}
	
	public Connection connect() {
        Connection conn = null;
        try {
        	System.out.println("in try block");
            conn = DriverManager.getConnection(url, user, password);
        	Statement stmt = conn.createStatement();
            System.out.println("Connected to the PostgreSQL server successfully.");
            
            ResultSet rs = stmt.executeQuery("select * from students");

            while (rs.next()) {
                System.out.println("ID = " + rs.getString(1) + ", Name = " + rs.getString(2));
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
 
        return conn;
    }

}
