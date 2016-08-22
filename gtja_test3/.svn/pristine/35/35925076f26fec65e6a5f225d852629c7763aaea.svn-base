package com.everelegance.reuserInfo.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * 设置字符编码为UTF-8的过滤器
 */
public class EncodingFilter implements Filter {
	
	private String encoding = "UTF-8";// 默认字符编码为UTF-8

	/**
	 * Default constructor.
	 */
	 public EncodingFilter() {
	 // TODO Auto-generated constructor stub
	 }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		request.setCharacterEncoding(encoding);// 设置请求的编码
		response.setContentType("text/html; charset=" + encoding);
		response.setCharacterEncoding(encoding);// 设置响应的编码
		chain.doFilter(request, response);// 传递给下一个过滤器
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		String encode = fConfig.getInitParameter("encoding");
		if (encoding != null) {
			encoding = encode;
		}
	}

}
