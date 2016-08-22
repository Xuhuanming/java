package com.everelegance.reuserInfo.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.everelegance.reuserInfo.entity.User;
import com.everelegance.reuserInfo.service.impl.UserService;
import com.everelegance.reuserInfo.util.FilePath;

/**
 * @author chenyimin
 * 
 */
@WebServlet("/UpdateServlet.do")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 取得服务器根路径和文件名
		String path = FilePath.getInstance().getPath();
		// 取得需要修改的用户名信息(登录者)
		String oldName = new String(request.getParameter("username").getBytes("ISO8859-1"),"utf-8");
		User u1 = new User();
		u1.setUsername(oldName);
		if(request.getParameter("useremail") ==null || request.getParameter("userpwd")==null){
			return;
		}
		u1.setEmail(request.getParameter("useremail"));
		u1.setPassword(request.getParameter("userpwd"));
		UserService us = new UserService();
		boolean b = us.update(u1, path);
		PrintWriter out = response.getWriter();
		if(b==true){
			out.print("true");
//			response.sendRedirect("ViewDispacher");
		}else{
			out.print("false");
//			response.sendRedirect("UserInfo.do");
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
