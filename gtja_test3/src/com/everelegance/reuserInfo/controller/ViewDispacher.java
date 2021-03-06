package com.everelegance.reuserInfo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.everelegance.util.Constant;

/**
 * Servlet implementation class DispacherServlet
 */
@WebServlet("/ViewDispacher")
public class ViewDispacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String BASE_PATH="WEB-INF/pages/";
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewDispacher() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String command = request.getParameter("command");
		if ("login".equals(command)) {// 跳转到登录页面
			request.getRequestDispatcher(BASE_PATH + "userLogin.jsp").forward(request, response);
		}else
		if ("userInfo".equals(command)) {
			request.getRequestDispatcher("UserInfo.do").forward(request, response);
		}else
		if ("register".equals(command)) {// 跳转到注册页面
			request.getRequestDispatcher(BASE_PATH + "userRegister.jsp").forward(request, response);
		}else
		if ("error".equals(command)) {// 跳转到错误页面
			request.getRequestDispatcher(BASE_PATH + "error.jsp").forward(request, response);
		}else
		if ("".equals(command) || command == null) {// 跳转登录页面
			request.getRequestDispatcher(BASE_PATH + "userLogin.jsp").forward(request, response);
		}else 
		if("upload".equals(command)){
			request.getRequestDispatcher(BASE_PATH + "infoUpload.jsp").forward(request, response);
		}
	}

}
