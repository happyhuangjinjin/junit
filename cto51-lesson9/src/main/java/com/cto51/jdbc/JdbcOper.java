package com.cto51.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JdbcOper {

	private static final Logger logger = LoggerFactory.getLogger(JdbcOper.class);

	public static void main(String[] args) {
		//driver根据不同厂商数据库是不一样的
		String driver = "com.mysql.jdbc.Driver"; 
		String url = "jdbc:mysql://localhost:3306/userdb?serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8";
		String username = "root";
		String password = "root";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// 1. 加载数据库驱动 
			Class.forName(driver);
			// 2. 建立数据库连接
			conn = DriverManager.getConnection(url, username, password);
			// 3. 创建数据库操作对象
			stmt = conn.createStatement();
			String sql = "select * from t_user";
			// 4. 执行操作数据库的SQL语
			rs = stmt.executeQuery(sql);
			// 5. 获取操作数据库的结果
			while (rs.next()) {
				// 解析结果集
				logger.info("user id = {}", rs.getInt("id"));
			}
		} catch (Exception e) {
			// 记录错误日志
			logger.error("fail", e);
		} finally {
			// 6. 关闭操作数据库的资源
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
				}
			}

			if (stmt != null) {
				try {
					rs.close();
				} catch (SQLException e) {
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}

}
