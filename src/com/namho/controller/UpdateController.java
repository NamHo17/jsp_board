package com.namho.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.namho.dao.BoardDao;
import com.namho.dto.BoardDto;

public class UpdateController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private int vResult;
	private BoardDto bDto;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String board_id = req.getParameter("board_id");
		BoardDao bDao = BoardDao.getInstence();
		bDto = new BoardDto();
		bDto = bDao.view(board_id);
		
		req.setAttribute("bDto", bDto);
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/update.jsp");
		rd.forward(req, resp);
	}
	 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String board_id = req.getParameter("board_id");
		String board_title = req.getParameter("board_title");
		String board_content = req.getParameter("board_content");
		
		
		bDto = new BoardDto();
		BoardDao bDao = BoardDao.getInstence();
		
		bDto.setBoard_id(Integer.parseInt(board_id));
		bDto.setBoard_title(board_title);
		bDto.setBoard_content(board_content);
		
	    vResult = bDao.update(bDto);
		System.out.println(vResult);
		resp.sendRedirect("list.do");
	}
}