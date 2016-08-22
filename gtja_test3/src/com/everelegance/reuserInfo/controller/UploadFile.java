package com.everelegance.reuserInfo.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.everelegance.reuserInfo.util.UploadToMerge;

/**
 * @author Zhang Boxun
 * @Description 上传用户信息
 */
@WebServlet("/UploadFile.do")
public class UploadFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UploadFile() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = getServletConfig().getServletContext().getRealPath("/"+"userinfo.txt"); 
		File file = new File(path);
		if(!file.exists()){
			file.createNewFile();
		}
		PrintWriter out = response.getWriter();
				
		String path1 = "D://userinfo.txt";
		
		boolean doubt = new UploadToMerge().mergeUser(path, path1);
		
		if(doubt==true){
			out.print("true");
//			response.sendRedirect("UserInfo.do");
		}else{
			out.print("false");
//			response.sendRedirect("ViewDispacher?command=error");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
