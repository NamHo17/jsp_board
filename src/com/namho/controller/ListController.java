package com.namho.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.namho.dao.BoardDao;
import com.namho.dto.BoardDto;

public class ListController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private int result;
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}
	
	public void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BoardDao bDao = BoardDao.getInstence();
		List<BoardDto> bList = new ArrayList<>();
	
		
		String page_number = req.getParameter("page_number");
		String search = req.getParameter("search");
		
		bList = bDao.list(page_number, search);
		
		result = bDao.nextVal();
		int page_button = 1;
		if ((result % 10) != 0) {
			page_button = (result / 10) + 1;
			req.setAttribute("page_button", page_button);
		} else {
			req.setAttribute("page_button", page_button);
		}
		
		System.out.println(page_button + "개의 버튼을 생성합니다.");
		System.out.println("현재 게시물의 갯수는: " + result + "개");
		
		
		req.setAttribute("page_number", page_number);
		req.setAttribute("result", result);
		req.setAttribute("bList", bList);
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/list.jsp");
		rd.forward(req, resp);
	}
}