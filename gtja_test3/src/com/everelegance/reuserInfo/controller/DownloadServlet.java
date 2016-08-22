package com.everelegance.reuserInfo.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.everelegance.reuserInfo.util.Download;
/**
 * 
 * @author chenyimin
 * @date 2016年7月8日
 * 
 */
@WebServlet("/DownloadServlet.do")
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

 
    public DownloadServlet() {
    	super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 获取路径
		String DownloadPath_parent = "D://download";
		String DownloadPath_child = "/userinfo.txt";
		String FilePath = this.getServletContext().getRealPath("/"+"userinfo.txt");
		PrintWriter out = response.getWriter();
		boolean b = new Download().DownloadFile(FilePath, DownloadPath_parent,DownloadPath_child);
		if(b==true){
			out.print("true");
//			response.sendRedirect("UserInfo.do");
		}else{
			out.print("false");
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
