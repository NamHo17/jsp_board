package com.namho.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.namho.dao.UserDao;

public class LoginController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private int result;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/login.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String user_id = req.getParameter("user_id");
		String user_pw = req.getParameter("user_pw");
		
		UserDao uDao = UserDao.getInstence();
		result = uDao.login(user_id, user_pw);
		
		if (result == 1) {
			HttpSession session = req.getSession();
			session.setAttribute("sessionID", user_id);
			resp.sendRedirect("main.do");
		} else {
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/login.jsp");
			rd.forward(req, resp);
		}
	}
}
