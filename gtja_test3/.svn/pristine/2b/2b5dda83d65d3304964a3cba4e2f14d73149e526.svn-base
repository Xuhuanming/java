package com.everelegance.reuserInfo.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;

/**
 * 将servlet中获取的路径set给此单例中的path变量
 * @author Zhang Jian
 * 2016年7月12日上午11:47:28
 *
 */
public class FilePath {
	//饿汉式
	private String path = null;
	private String sourcePath;
	// 私有的构造方法
	private FilePath() {
		
	}
	private static final FilePath filepath = new FilePath();
	// 静态工厂方法
	public static FilePath getInstance() {
		return filepath;
	}
	public String getPath() {
		this.getFilePath();
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	public String getSourcePath() {
		return sourcePath;
	}
	public void setSourcePath(String sourcePath) {
		this.sourcePath = sourcePath;
	}
	/**
	 * 
	 * @author Zhang Jian
	 * @date 2016年7月12日 下午5:37:19
	 * @Description: 读取编译后的class文件夹中资源文件里面的文本路径
	 * @return String
	 * @throws
	 */
	private void getFilePath(){
		String filepath = null;
		InputStream fis = null;
		Properties prop = new Properties();
		try {
			fis = new FileInputStream(sourcePath);
			prop.load(fis);
			Iterator<String> it=prop.stringPropertyNames().iterator();
			while(it.hasNext()){
			    String key=it.next();
			    filepath = prop.getProperty(key);
			    this.path =  filepath;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
