package logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExecuteQuery {

	public static void main(String[] args) throws SQLException{
		Connection con = DriverManager.getConnection("jdbc:neo4j://localhost:7474/","neo4j","password");

		//Important part is to give a name to results to be then retrieved in the ResultSet 
		String queryGetGroupMembers = "MATCH (g:Group {project:{1}})-[:AS_GROUP]-(s:Student) RETURN s.name as name, s.surname as surname";
		String queryGetBigGroups = "MATCH (:Student)-[:AS_GROUP]->(g:Group) WITH count(*) as number,g as group WHERE number>=3 RETURN group.project as project";
		
		System.out.println("QueryGetGroupMembers results:");
		try (PreparedStatement stmt = con.prepareStatement(queryGetGroupMembers)) {

		    stmt.setString(1,"Smart Team Tracking");

		    try (ResultSet rs = stmt.executeQuery()) {
		        while(rs.next()) {
		        	 //HERE WE COULD SIMPLY PUT DATA INSIDE A JAVA OBJECT 
		             System.out.println(rs.getString("name")+" "+rs.getString("surname"));
		        }
		    }  //We should catch here SQLExceptionErrors
		}      //We should catch here SQLExceptionErrors
		
		System.out.println();
		
		//Cleaner example just throwing exceptions 
		System.out.println("QueryGetBigGroups results:");
		PreparedStatement stmt = con.prepareStatement(queryGetBigGroups);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			//Here we could simply put data inside a java object 
		    System.out.println(rs.getString("project"));
		}
	}
}
