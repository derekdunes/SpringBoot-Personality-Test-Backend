package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;
import java.sql.DriverManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PersonalityTestApplicationTests {

	@Test
	void contextLoads() {
		// TODO Auto-generated method stub
//		String connectionMessage = "";
//
//		String jdbcUrl = "jdbc:mysql://localhost:3306/personality_db?useSSL=false&serverTimezone=UTC";
//		String user = "root";
//		String pass = "";
//
//		try {
//			System.out.println("Connecting to database: " + jdbcUrl);
//
//			Connection con = DriverManager.getConnection(jdbcUrl, user, pass);
//
//			connectionMessage = "Connection successfull!!!";
//
//		}catch(Exception e) {
//			e.printStackTrace();
//			connectionMessage = e.getMessage();
//		}
//
//		assertEquals(connectionMessage, "Connection successfull!!!");

	}

}
