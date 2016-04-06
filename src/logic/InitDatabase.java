package logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import logic.NeoUtils;

public class InitDatabase {
	
	//Data retrieved from URL: http://ichatz.me/index.php/Site/PervasiveSystems2016
	
	public static void main(String[] args) throws SQLException{
		Connection connection = DriverManager.getConnection("jdbc:neo4j://localhost:7474/","neo4j","password");
		
		System.out.println("Populating Neo4j database with information from Pervasive System class...");
		
		//CREATING STUDENTS WITH RELATED PERSONAL PROJECT
		NeoUtils.createStudent(connection,"Davide","Tiriticco","Intel Curie");
		NeoUtils.createStudent(connection,"Daniele","Oriana","ThingStudio");
		NeoUtils.createStudent(connection,"Biagio","Botticelli","ESP8266");
		NeoUtils.createStudent(connection,"Fabrizio","Farinacci","Redis");
		NeoUtils.createStudent(connection,"Davide","Piccardi","Estimote");
		NeoUtils.createStudent(connection,"Luca","Mazzotti","Genuino");
		NeoUtils.createStudent(connection,"Marco","Casini","Raspberry Pi 2");
		NeoUtils.createStudent(connection,"Alessandro","Granato","Particle");
		NeoUtils.createStudent(connection,"Davide","Mazza","ELM326 OBD");
		NeoUtils.createStudent(connection,"Andrea","Bissoli","Estimote");
		NeoUtils.createStudent(connection,"Mattia","Brunetti","Sensoro");
		NeoUtils.createStudent(connection,"Salvatore","Rivieccio","AltBeacon");
		NeoUtils.createStudent(connection,"Sara","Veterini","AltBeacon");
		NeoUtils.createStudent(connection,"Andrea","Prosseda","Genuino");
		NeoUtils.createStudent(connection,"Davide","Meacci","Blynk");
		NeoUtils.createStudent(connection,"Guarmaral","Vasil","InfluxDB");
		NeoUtils.createStudent(connection,"Roberto","Gaudenzi","InfluxDB");
		NeoUtils.createStudent(connection,"Djordje","Simic","AWS IoT");
		NeoUtils.createStudent(connection,"Stefano","Conoci","Neo4j");
		NeoUtils.createStudent(connection,"Sara","Di Bartolomeo","Processing");
		NeoUtils.createStudent(connection,"Gianluca","Leo","resin.io");
		NeoUtils.createStudent(connection,"Andrea","Ranieri","resin.io");
		NeoUtils.createStudent(connection,"Massimo","Perri","Smart home & Arduino");
		NeoUtils.createStudent(connection,"Lorenzo","Travagliati","Smart care & Arduino");
		NeoUtils.createStudent(connection,"Gabriele","Vecchia","Android Fragments");
		NeoUtils.createStudent(connection,"Stefano","Coratti","XBee");

		//SETTING UP GROUPS
		NeoUtils.addGroupToStudent(connection,"Massimo","Perri", "Smart garden");
		NeoUtils.addGroupToStudent(connection,"Stefano","Coratti", "Smart garden");
		NeoUtils.addGroupToStudent(connection,"Davide","Piccardi", "Activity Tracking for Team Sports");
		NeoUtils.addGroupToStudent(connection,"Daniele","Oriana", "Activity Tracking for Team Sports");
		NeoUtils.addGroupToStudent(connection,"Davide","Mazza", "Activity Tracking for Team Sports");
		NeoUtils.addGroupToStudent(connection,"Stefano","Conoci", "Smart Team Tracking");
		NeoUtils.addGroupToStudent(connection,"Salvatore","Rivieccio", "Smart Team Tracking");
		NeoUtils.addGroupToStudent(connection,"Davide","Meacci", "Smart Team Tracking");
		NeoUtils.addGroupToStudent(connection,"Biagio","Botticelli", "Smart Team Tracking");
		NeoUtils.addGroupToStudent(connection,"Sara","Di Bartolomeo", "WeatherCraft");
		NeoUtils.addGroupToStudent(connection,"Lorenzo","Travagliati", "WeatherCraft");
		NeoUtils.addGroupToStudent(connection,"Fabrizio","Farinacci", "Smart Elder Care");
		NeoUtils.addGroupToStudent(connection,"Sara","Veterini", "Smart Elder Care");
		NeoUtils.addGroupToStudent(connection,"Marco","Casini", "Smart Doorbell");
		NeoUtils.addGroupToStudent(connection,"Mattia","Brunetti", "Smart Doorbell");

		System.out.println("Data added successfully.");
	}
	
}
