package com.namho.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.namho.dao.UserDao;
import com.namho.dto.UserDto;

public class SignUpController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	// 성공
	private String success;
	// 실패
	private String failure;
	private int u_result;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/signUp.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String user_id = req.getParameter("user_id");
		String user_pw = req.getParameter("user_pw");
		String user_name = req.getParameter("user_name");
		String user_gender = req.getParameter("user_gender");
		
		UserDto uDto = new UserDto();
		uDto.setUser_id(user_id);
		uDto.setUser_pw(user_pw);
		uDto.setUser_name(user_name);
		uDto.setUser_gender(user_gender);

		UserDao uDao = UserDao.getInstence();
		u_result = uDao.join(uDto);
		
		if (u_result == 1) {
			req.setAttribute("success", success);
			resp.sendRedirect("main.do");
		} else {
			req.setAttribute("failure", failure);
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/join.do");
			rd.forward(req, resp);
		}
	}
}