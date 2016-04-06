package logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class NeoUtils {
	static String createStudent = "MERGE (i:Individual {subject:{3}}) CREATE (s:Student {name:{1},surname:{2}})-[:AS_INDIVIDUAL]->(i) ";
	static String createStudentWithGroup = "MERGE (i:Individual {subject:{3}}) MERGE (g:Group {project:{4}}) CREATE (s:Student {name:{1},surname:{2}})-[:AS_INDIVIDUAL]->(i) CREATE (s)-[:AS_GROUP]->(g)";
	static String addGroupToStudent = "MATCH (s:Student {name:{1},surname:{2}}) MERGE (g:Group {project:{3}}) CREATE (s)-[:AS_GROUP]->(g)";
	
	public static void createStudent(Connection connection,String name, String surname, String subject ) throws SQLException{
		PreparedStatement stmt = connection.prepareStatement(createStudent);
		stmt.setString(1, name);
		stmt.setString(2, surname);
		stmt.setString(3, subject);
		stmt.execute();
	}
	
	public static void createStudentWithGroup(Connection connection, String name, String surname, String subject, String project ) throws SQLException{
		PreparedStatement stmt = connection.prepareStatement(createStudentWithGroup);
		stmt.setString(1, name);
		stmt.setString(2, surname);
		stmt.setString(3, subject);
		stmt.setString(4, project);
		stmt.execute();
	}
	

	public static void addGroupToStudent(Connection connection,String name, String surname, String project ) throws SQLException{
		PreparedStatement stmt = connection.prepareStatement(addGroupToStudent);
		stmt.setString(1, name);
		stmt.setString(2, surname);
		stmt.setString(3, project);
		stmt.execute();
	}
	
	public static void clearDatabase(Connection connection) throws SQLException{
		Statement stmt = connection.createStatement();
		stmt.executeQuery("MATCH (n) DETACH DELETE (n)");
	}
}
