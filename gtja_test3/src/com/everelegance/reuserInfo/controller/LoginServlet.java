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
import javax.servlet.http.HttpSession;

import com.everelegance.reuserInfo.entity.User;
import com.everelegance.reuserInfo.service.impl.UserService;
import com.everelegance.reuserInfo.util.FilePath;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private ServletContext WebInfo;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }
    public void init(ServletConfig config) throws ServletException {
		super.init(config);
		WebInfo = config.getServletContext();
	}
    	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user=new User();
		user.setUsername(new String(request.getParameter("username").getBytes("ISO8859-1"),"UTF-8"));
		user.setPassword(request.getParameter("userpwd"));
	
		PrintWriter out=response.getWriter(); 
		String webPath=FilePath.getInstance().getPath();
		//路径待定
		if((new UserService()).login(user,webPath)){
			
			HttpSession session=request.getSession();
			session.setAttribute("user", user);
			out.print("true");
		}else{
			out.print("false");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
