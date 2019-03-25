package com.mitocode.model.repository;

import static com.mitocode.util.Util.getProperty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionDb {

	public static Connection getConnectionDb() throws Exception {
		Class.forName(getProperty("connection.jdbc"));
		return (DriverManager.getConnection(getProperty("connection.url"), getProperty("connection.user"),
				getProperty("connection.password")));
	}

	public static void close(Connection connection) {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
		}
	}

	public static void close(ResultSet resultSet) {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
		} catch (SQLException e) {
		}
	}

	public static void close(PreparedStatement preparedStatement) {
		try {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
		} catch (SQLException e) {
		}
	}

	public static void rollback(Connection cn) {
		try {
			if (cn != null) {
				cn.rollback();
			}
		} catch (SQLException e) {
		}

	}

}