package com.namho.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.namho.dto.BoardDto;

public class BoardDao {
	private static BoardDao bDao;
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private int result;
	
	public static synchronized BoardDao getInstence() {
		if (bDao == null) {
			bDao = new BoardDao();
		}
		return bDao;
	}
	
	public Connection getConnect() {
		String URL = "jdbc:mysql://localhost:3306/survey?useSSL=false";
		String name = "rlaskagh7"; String pw = "tmdgh11077";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(URL, name, pw);
		} catch (ClassNotFoundException e) {
			System.out.println("DB연동 오류");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("SQL오류");
			e.printStackTrace();
		}
		return con;
	}
	
	public void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		if(rs != null) {
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
	
	public int nextVal() {
		con = this.getConnect();
		String SQL = "SELECT MAX(board_id) FROM board";
		try {
			pstmt = con.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				result = rs.getInt("MAX(board_id)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close(con, pstmt, rs);
		}
		return result;
	}
	
	public int write(BoardDto bDto) {
		con = this.getConnect();
		String SQL = "INSERT INTO board (board_id, board_title, board_content, board_date, user_id)"
				   + "VALUES (?, ?, ?, SYSDATE(), ?)";
		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, bDto.getBoard_id());
			pstmt.setString(2, bDto.getBoard_title());
			pstmt.setString(3, bDto.getBoard_content());
			pstmt.setString(4, bDto.getUser_id());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close(con, pstmt, null);
		}
		return result;
	}
		
	public List<BoardDto> list(String page_number, String search) {
		if (page_number == null) {
			page_number = "1";
		}
		if (search == null) {
			search = "";
		}
		System.out.println("page_number="+page_number +"\nsearch="+search);
		
		List<BoardDto> bList = new ArrayList<>();
		int startNum = (Integer.parseInt(page_number) - 1) * 10 + 1; 
		int endNum = Integer.parseInt(page_number) * 10;
		
		System.out.println(startNum);
		System.out.println(endNum);
		try {
			con = this.getConnect();
			String SQL = "SELECT * FROM(SELECT @board_num:= @board_num +1 AS board_num, b. * FROM board b,(SELECT @board_num := 0) d ORDER BY board_date DESC) SUB WHERE board_num BETWEEN ? AND ? AND board_title LIKE ?";
			pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, startNum);
			pstmt.setInt(2, endNum);
			pstmt.setString(3, "%"+ search +"%");
			rs = pstmt.executeQuery();
			while(rs.next()){
				BoardDto bDto = new BoardDto();
				bDto.setBoard_id(rs.getInt("board_id"));
				bDto.setBoard_title(rs.getString("board_title"));
				bDto.setBoard_content(rs.getString("board_content"));
				bDto.setBoard_date(rs.getTimestamp("board_date"));
				bDto.setUser_id(rs.getString("user_id"));
				bDto.setBoard_num(rs.getString("board_num"));
				bList.add(bDto);			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close(con, pstmt, rs);
		}
		return bList;
	}
	
	public BoardDto view(String board_id) {
		con = this.getConnect();
		BoardDto bDto = new BoardDto();
		String SQL = "SELECT * FROM board WHERE board_id = ?";
		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, board_id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				bDto.setBoard_title(rs.getString("board_title"));
				bDto.setBoard_content(rs.getString("board_content"));
				bDto.setBoard_date(rs.getTimestamp("board_date"));
				bDto.setUser_id(rs.getString("user_id"));
				bDto.setBoard_id(rs.getInt("board_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close(con, pstmt, rs);
		}
		return bDto;
	}
	
	public int update(BoardDto bDto) {
		con = this.getConnect();
		String SQL = "UPDATE board SET board_title = ?, board_content = ?, board_date = SYSDATE() WHERE board_id = ?";
		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, bDto.getBoard_title());
			pstmt.setString(2, bDto.getBoard_content());
			pstmt.setTimestamp(3, bDto.getBoard_date());
			pstmt.setInt(4, bDto.getBoard_id());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close(con, pstmt, null);
		}
		return result;
	}
	
	public int delete(String board_id) {
		con = this.getConnect();
		String SQL = "DELETE FROM board WHERE board_id = ?";
		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, board_id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close(con, pstmt, rs);
		}
		return result;
	}
}