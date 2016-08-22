package com.everelegance.reuserInfo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.everelegance.reuserInfo.entity.User;

/**
 * 连接数据库的工具类
 * 
 * @author Zhang Jian 2016年7月7日下午4:56:38
 *
 */
public class DbUtil {

	private String driver;//mysql数据库驱动
	private String url;//地址
	private String user;//用户名
	private String password;//密码
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;

	/**
	 * 
	 * @author Zhang Jian
	 * @date 2016年7月8日 下午5:12:01
	 * @Description: 获取数据库连接
	 * @param 
	 * @return Connection
	 * @throws
	 */
	public Connection getConn() {

		try {
			//读取资源文件
			ResourceBundle rb = ResourceBundle.getBundle("jdbc");
			driver=rb.getString("driver");
			url=rb.getString("url");
			user=rb.getString("user");
			password=rb.getString("password");
			//加载驱动类
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			System.out.println("找不到驱动程序类 ，加载驱动失败！");
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * 
	 * @author Zhang Jian 
	 * @date 2016年7月8日 上午11:31:39 
	 * @Description: 对数据库查询 
	 * @param sql 需要执行的sql语句	
	 * @param params 如果sql语句有查询条件，将参数按照顺序封装到此数组中
	 * @return List<User> 
	 * @throws
	 */
	
	public List<User> query(String sql, String[] params) {
		List<User> list = new ArrayList<User>();
		try {
			conn = this.getConn();
			pst = conn.prepareStatement(sql);
			if (params != null) { 
				for (int a = 1; a <= params.length; a++) {//给sql语句的查询条件赋值
					pst.setString(a, params[a - 1]);
				}
			}
			rs = pst.executeQuery();
			while (rs.next()) {
				Integer id = rs.getInt("userid");
				String username = rs.getString("username");
				String email = rs.getString("email");
				String password = rs.getString("password");
				User user = new User();
				user.setId(id);
				user.setUsername(username);
				user.setEmail(email);
				user.setPassword(password);
				list.add(user);
			}
		} catch (SQLException e) {
			System.out.println("query查询失败！");
			e.printStackTrace();
		} finally {
			this.close(conn, pst, rs);
		}
		return list;
	}

	/**
	 * 
	 * @author Zhang Jian 
	 * @date 2016年7月8日 上午11:39:48 
	 * @Description:数据库insert，update，delete操作方法 
	 * @param sql 需要执行的sql语句
	 * @param params  如果sql语句有查询条件，将参数按照顺序封装到此数组中
	 * @return boolean 
	 * @throws
	 */
	public boolean update(String sql, String[] params) {
		try {
			conn = this.getConn();
			pst = conn.prepareStatement(sql);
			for (int a = 1; a <= params.length; a++) {//给sql语句的查询条件赋值
				pst.setString(a, params[a - 1]);
			}
			int i = pst.executeUpdate();
			if (i > 0) {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("update方法修改，增加数据库失败！");
			e.printStackTrace();
		} finally {
			this.close(conn, pst, rs);
		}
		return false;
	}

	/**
	 * @author Zhang Jian 
	 * @date 2016年7月8日 下午2:17:33 
	 * @Description: 关闭资源 
	 * @param conn 
	 * @param pst 
	 * @param rs 
	 * @return void 
	 * @throws
	 */
	public void close(Connection conn, PreparedStatement pst, ResultSet rs) {
		try {
			if(rs !=null ){
				rs.close();
			}
			pst.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("数据库资源关闭失败！");
		}
	}
}
