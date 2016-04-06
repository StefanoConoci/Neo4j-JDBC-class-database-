package logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ClearDatabase {
	
	public static void main(String[] args) throws SQLException{
		Connection connection = DriverManager.getConnection("jdbc:neo4j://localhost:7474/","neo4j","password");
		System.out.println("Clearing database...");
		NeoUtils.clearDatabase(connection);
		System.out.println("Database cleared succesfully.");
	}
	
}
