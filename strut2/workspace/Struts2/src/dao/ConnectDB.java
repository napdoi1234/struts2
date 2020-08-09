package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectDB {

	public static Connection Open() throws ClassNotFoundException {
		Class.forName("org.postgresql.Driver");
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/News?user=postgres&password=napdoi123");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	public static void Close(Connection conn, PreparedStatement pstmt) {

		try {
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static PreparedStatement setParamenter(PreparedStatement pstmt, Object... a) {
		try {
			for (int i = 0; i < a.length; i++) {
				if (a[i] instanceof Integer) {
					pstmt.setInt(i + 1, (int) a[i]);
				}
				if (a[i] instanceof String) {
					pstmt.setString(i + 1, (String) a[i]);
				}
				if (a[i] instanceof Boolean) {
					pstmt.setBoolean(i + 1, (boolean) a[i]);
				}
				if(a[i] instanceof Date) {
					pstmt.setDate(i+1, (Date) a[i]);
				}
			}
			return pstmt;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pstmt;
	}

}
