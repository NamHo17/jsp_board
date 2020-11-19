package com.namho.dto;

import java.sql.Timestamp;

public class BoardDto {
	private int board_id;
	private String board_title;
	private String board_content;
	private Timestamp board_date;
	private String user_id;
	private String board_num;
	
	public int getBoard_id() {
		return board_id;
	}
	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getBoard_content() {
		return board_content;
	}
	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}
	public Timestamp getBoard_date() {
		return board_date;
	}
	public void setBoard_date(Timestamp board_date) {
		this.board_date = board_date;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getBoard_num() {
		return board_num;
	}
	public void setBoard_num(String board_num) {
		this.board_num = board_num;
	}
	@Override
	public String toString() {
		return "BoardDto [board_id=" + board_id + ", board_title=" + board_title + ", board_content=" + board_content
				+ ", board_date=" + board_date + ", user_id=" + user_id + ", board_num=" + board_num + "]";
	}
}