package com.namho.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.namho.dao.BoardDao;

public class DeleteController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	int dResult;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}
	
	public void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String board_id = req.getParameter("board_id");
		
		BoardDao bDao = BoardDao.getInstence();
		dResult = bDao.delete(board_id);
		resp.sendRedirect("list.do");
	}
}
