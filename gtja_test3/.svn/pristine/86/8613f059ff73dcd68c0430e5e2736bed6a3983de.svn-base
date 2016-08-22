package com.everelegance.reuserInfo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.everelegance.reuserInfo.entity.User;
import com.everelegance.reuserInfo.service.impl.UserService;
import com.everelegance.reuserInfo.util.FilePath;

/**
 * 跳转到登录用户信息展示页面，将用户信息查询展示在页面
 * @author Zhang Jian
 * 2016年7月12日下午7:12:06
 *
 */
@WebServlet("/ToAlterUserpage.do")
public class ToAlterUserpage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToAlterUserpage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = new String(request.getParameter("username").getBytes("ISO8859-1"),"utf-8");
		UserService us = new UserService();
		String path = FilePath.getInstance().getPath();
		User user = us.selectByUsername(username, path);
		request.setAttribute("user1", user);
		request.getRequestDispatcher("/WEB-INF/pages/userAlter.jsp").forward(request, response);
	}

}
