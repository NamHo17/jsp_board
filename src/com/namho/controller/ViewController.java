package com.namho.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.namho.dao.BoardDao;
import com.namho.dto.BoardDto;

public class ViewController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private BoardDto bDto;
	
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
		
		BoardDao bDao = new BoardDao();
		bDto = new BoardDto();
		
		bDto = bDao.view(board_id);
		req.setAttribute("bDto", bDto);
		
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view.jsp");
		rd.forward(req, resp);
	}
}
