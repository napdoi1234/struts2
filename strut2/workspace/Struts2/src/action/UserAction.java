package action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import dao.ConnectDB;
import form.UserModal;

public class UserAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<UserModal> userList;
	private UserModal user;
	private Connection conn = null;

	public List<UserModal> getUserList() {
		return userList;
	}

	public void setUserList(List<UserModal> userList) {
		this.userList = userList;
	}

	public UserModal getUser() {
		return user;
	}

	public void setUser(UserModal user) {
		this.user = user;
	}

	public String getAllUser() throws SQLException {
		
		try {
			conn = ConnectDB.Open();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String query = "Select * from users ";
		PreparedStatement pstmt = null;
		userList = new ArrayList<UserModal>();

		pstmt = conn.prepareStatement(query);

		ResultSet rs = pstmt.executeQuery();
		UserModal user = null;
		while (rs.next()) {
			user = new UserModal();
			user.setUser_ID(rs.getString(1));
			user.setFull_Name(rs.getString(2));
			user.setGender(rs.getString(3));
			user.setPhone(rs.getInt(4));
			user.setRole(rs.getString(5));
			user.setEmail(rs.getString(6));
			user.setUser_Status(rs.getString(7));
			user.setUsername(rs.getString(8));
			userList.add(user);
		}
		ConnectDB.Close(conn, pstmt);
		return "success";
	}

	public String insertUser() throws SQLException, ClassNotFoundException {
		Connection conn = ConnectDB.Open();
		String query = "INSERT INTO users VALUES (?, ?, ?, ?, ?,?,?,?)";
		PreparedStatement pstmt = null;

		pstmt = conn.prepareStatement(query);
		pstmt = ConnectDB.setParamenter(pstmt, user.getUser_ID(), user.getFull_Name(), user.getGender(),
				user.getPhone(), user.getRole(), user.getEmail(), user.getUser_Status(), user.getUsername());
		int rs=0;
		try {
			rs = pstmt.executeUpdate();
		} catch (Exception e) {
			return "insertError";
		}
		if (rs > 0) {
			ConnectDB.Close(conn, pstmt);
			return "insertSuccess";
		}
		return "insertError";
	}

	public String editUser() throws SQLException {
		try {
			conn = ConnectDB.Open();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String query = "UPDATE users SET Full_Name = ?, Gender=?,Phone=?,Role=?,Email=?,User_Status=?,Username=? WHERE User_ID=?";
		PreparedStatement pstmt = conn.prepareStatement(query);
		pstmt = ConnectDB.setParamenter(pstmt, user.getFull_Name(), user.getGender(), user.getPhone(), user.getRole(),
				user.getEmail(), user.getUser_Status(), user.getUsername(), user.getUser_ID());
		int rs = pstmt.executeUpdate();
		if (rs > 0) {
			ConnectDB.Close(conn, pstmt);
			return "editSuccess";
		}

		return "editError";
	}

	public String findUser() throws SQLException {
		try {
			conn = ConnectDB.Open();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String query = "select * from users where user_id=?";
		PreparedStatement pstmt = conn.prepareStatement(query);
		pstmt = ConnectDB.setParamenter(pstmt, user.getUser_ID());
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			user = new UserModal();
			user.setUser_ID(rs.getString(1));
			user.setFull_Name(rs.getString(2));
			user.setGender(rs.getString(3));
			user.setPhone(rs.getInt(4));
			user.setRole(rs.getString(5));
			user.setEmail(rs.getString(6));
			user.setUser_Status(rs.getString(7));
			user.setUsername(rs.getString(8));
			ConnectDB.Close(conn, pstmt);
		}
		return "findSuccess";
	}

	public String deleteUser() throws SQLException {
		try {
			conn = ConnectDB.Open();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String query = "DELETE FROM users WHERE user_id=?;";
		PreparedStatement pstmt = conn.prepareStatement(query);
		pstmt = ConnectDB.setParamenter(pstmt, user.getUser_ID());
		int rs = pstmt.executeUpdate();
		return "deleteSuccess";
	}
}
