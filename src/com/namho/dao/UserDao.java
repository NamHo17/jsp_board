package com.namho.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.namho.dto.UserDto;

public class UserDao {
	private static UserDao uDao;
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private int result;
	private UserDto uDto;
	
	public static synchronized UserDao getInstence(){
		if (uDao == null) {
			uDao = new UserDao();
		}
		return uDao;
	}
	
	public Connection getConnect() {
		String URL = "jdbc:mysql://localhost:3306/survey?useSSL=false";
		String name = "rlaskagh7";
		String pw = "tmdgh11077";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(URL, name, pw);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public int join(UserDto uDto) {
		con = this.getConnect();
		String SQL = "INSERT INTO users VALUES (?, ?, ?, ?)";
		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, uDto.getUser_id());
			pstmt.setString(2, uDto.getUser_pw());
			pstmt.setString(3, uDto.getUser_name());
			pstmt.setString(4, uDto.getUser_gender());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close(con, pstmt, null);
		}
		return result;
	}
	
	public int login(String user_id, String user_pw) {
		con = this.getConnect();
		if (con == null) {
			System.out.println("1con= "+con);
		}
		System.out.println(user_id +" "+user_pw);
		String SQL = "SELECT user_pw FROM users WHERE user_id = ?";
		try {
			if (con == null) {
				System.out.println("2con= "+con);
			}
			pstmt = con.prepareStatement(SQL);
			if (con == null) {
				System.out.println("pstmt= "+pstmt);
			}
			pstmt.setString(1, user_id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				if (rs.getString("user_pw").equals(user_pw)) {
					return 1;
				} else {
					return 0;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close(con, pstmt, rs);
		}
		return -1;
	}
	
	public UserDto myList(String user_id) {
		con = this.getConnect();
		String SQL = "SELECT * FROM WHERE user_id = ?";
		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, user_id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				uDto.setUser_id(rs.getString("user_id"));
				uDto.setUser_name(rs.getString("user_name"));
				uDto.setUser_gender(rs.getString("user_gender"));
				return uDto;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close(con, pstmt, rs);
		}
		return uDto;
	}
}