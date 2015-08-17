package com.ayovel.nian.utils.db;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnectionUtil {


	private static String db_properties = "resource/db.properties";
	public static Properties props = new Properties();

	static {
		try {
			File file = new File(db_properties);
			props.load(new FileInputStream(file));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		Connection conn = null;
		
		String dbURL = props.getProperty("jdbc_url");
		String username = props.getProperty("user");
		String password = props.getProperty("password");
		String redshift_driver = props.getProperty("driver");
		try {
			Class.forName(redshift_driver);
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException" + e.getMessage());
		}
		try {
			conn = DriverManager.getConnection(dbURL, username, password);// 创建数据连接
		} catch (Exception e) {
			System.out.println("connection error" + e.getMessage());
		}
		System.out.println(" connection sucess:" + conn);
		return conn;
	}

	public static void closeConnection(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
				conn = null;
			}
		} catch (SQLException e) {
		} finally {
			try {
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
			}
		}
	}

}
