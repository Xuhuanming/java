package com.everelegance.reuserInfo.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.everelegance.reuserInfo.dao.impl.UserDaoImpl;
import com.everelegance.reuserInfo.entity.User;
import com.everelegance.reuserInfo.service.impl.UserService;
import com.everelegance.reuserInfo.util.FileOperate;
import com.everelegance.reuserInfo.util.FilePath;

/**
 * Servlet implementation class UserInfo
 */
@WebServlet("/UserInfo.do")
public class UserInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletContext WebInfo;
	private static final String BASE_PATH = "WEB-INF/pages/";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		WebInfo = config.getServletContext();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());

		HttpSession session = request.getSession();
		User userFromInput = (User) session.getAttribute("user");// 通过session获取展示信息的用户

		String userName = userFromInput.getUsername();
//		String webPath = WebInfo.getRealPath("/") + "userInfo.txt";// 用户信息文件位置
		String webPath = FilePath.getInstance().getPath();// 用户信息文件位置

		// 遍历用户信息文件里的用户，查询要展示信息的用户的信息
		User userFromDb = new UserService().selectByUsername(userName, webPath);
		request.setAttribute("user", userFromDb);
		request.getRequestDispatcher(BASE_PATH + "userInfo.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
