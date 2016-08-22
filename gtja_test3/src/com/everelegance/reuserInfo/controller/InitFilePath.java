package com.everelegance.reuserInfo.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.everelegance.reuserInfo.util.FilePath;

/**
 * 服务器启动后就初始化这个servlet，将路径信息写入资源文件中
 * @author Zhang Jian
 * 2016年7月12日上午11:45:38
 *
 */
public class InitFilePath extends HttpServlet {
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init.....................");
		// TODO Auto-generated method stub
		String path = config.getServletContext().getRealPath("/")+"userinfo.txt";
		String path2 = InitFilePath.class.getResource("/").getPath();
		String websiteURL = (path2.replace("/build/classes", "").replace("%20","")+ "filepath.properties").replaceFirst("/", "");
		//将路径信息写入资源文件
		OutputStream fos = null;
		try {
			Properties prop = new Properties();
			fos = new FileOutputStream(websiteURL);
			prop.setProperty("filepath", path);
			prop.store(fos,null);
			fos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		FilePath filepath = FilePath.getInstance();
		filepath.setSourcePath(websiteURL);
//		filepath.setPath(path);
		super.init(config);
	}

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InitFilePath() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	@Override
	public void destroy() {
		System.out.println("destory.....................");
		super.destroy();
	}

}
