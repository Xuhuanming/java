package com.everelegance.reuserInfo.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.everelegance.reuserInfo.entity.User;
import com.everelegance.reuserInfo.service.impl.UserService;
import com.everelegance.reuserInfo.util.FilePath;


/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletContext WebInfo;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		WebInfo = config.getServletContext();
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user=new User();
		user.setEmail(request.getParameter("useremail"));
		user.setUsername(new String(request.getParameter("username").getBytes("ISO-8859-1"),"UTF-8"));
		user.setPassword(request.getParameter("userpwd"));
		
//		response.setContentType("text/html");
		PrintWriter out=response.getWriter(); 
		String WebPath=FilePath.getInstance().getPath();
		
		if((new UserService()).registry(user,WebPath)){
			out.print("true");
		}else{
			out.print("false");
		}
	}
	

}
