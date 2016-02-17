package com.product.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCUtils {

	private final static String USERNAME = "root";
	private final static String PASSWORD = "123456";
	private final static String DRIVER = "com.mysql.jdbc.Driver";
	private final static String URL = "jdbc:mysql://localhost:3306/mydb";

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("Connect datebase success.");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}

	public static void release(ResultSet rs, Statement sta, Connection con) {
		try {
			if (null != rs) {
				rs.close();
				rs = null;
			}

			if (null != sta) {
				sta.close();
				sta = null;
			}

			if (null != con) {
				con.close();
				con = null;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
