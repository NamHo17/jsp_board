package com.namho.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.namho.dao.BoardDao;
import com.namho.dto.BoardDto;

public class WriteController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private int result;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/write.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String board_title = req.getParameter("board_title");
		String board_content = req.getParameter("board_content");
		
		HttpSession session = req.getSession();
		String user_id = (String)session.getAttribute("sessionID");
		
		BoardDao bDao = BoardDao.getInstence();
		BoardDto bDto = new BoardDto();
		
		bDto.setBoard_title(board_title);
		bDto.setBoard_content(board_content);
		if (user_id == null) {
			user_id = "비회원";
			bDto.setUser_id(user_id);
		} else {
			bDto.setUser_id(user_id);
		}
		result = bDao.write(bDto);
		System.out.println("게시글 작성 " + result);
		resp.sendRedirect("list.do");
	}
}
