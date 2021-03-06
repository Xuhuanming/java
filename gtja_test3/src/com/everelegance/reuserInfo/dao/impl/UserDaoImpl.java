package com.everelegance.reuserInfo.dao.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.everelegance.reuserInfo.dao.UserDao;
import com.everelegance.reuserInfo.entity.User;
import com.everelegance.reuserInfo.util.DbUtil;
import com.everelegance.reuserInfo.util.FileOperate;

/**
 * UserDao的实现类，实现对用户的crud操作
 * 
 * @author Zhang Jian 2016年7月7日下午3:01:39
 *
 */
public class UserDaoImpl implements UserDao {

	private Map<String, User> users;
	private List<User> userList;
	private File file;
	private String sql;
	private DbUtil dbutil;

	/**
	 * 全部的用户信息，返回map集合
	 * @author Zhang Jian
	 * @param path :文件的路径，如果为空则就是对数据库操作
	 * @return 返回值是一个map集合，存放全部用户信息，key为用户名，value为该用户
	 *
	 */
	@Override
	public Map<String, User> selectAllToMap(String path) {
		if (path != null && !"".equals(path)) {// 对文件操作
			users = new HashMap<String, User>();
			try {
				users = new FileOperate().fileToMap(path);
			} catch (IOException e) {
				System.out.println("UserDaoImpl.selectAllToMap方法出错！");
				e.printStackTrace();
				return null;
			}
		} else {// 对数据库操作
			sql = "select userid,username,email,password from user";
			dbutil = new DbUtil();
			userList = dbutil.query(sql, null);
			users = this.listToMap(userList);
		}
		return users;
	}

	/**
	 * 全部的用户信息，返回list集合
	 * @author Zhang Jian
	 * @param path为文件的路径，若为空则就是对数据库操作
	 * @return 返回值为一个list集合，存放的是所有的用户信息
	 */
	@Override
	public List<User> selectAllToList(String path) {
		if (path != null && !"".equals(path)) {// 对文件进行操作
			userList = new ArrayList<User>();
			try {
				userList = new FileOperate().fileToList(path);
			} catch (IOException e) {
				System.out.println("UserDaoImpl.selectAllToList方法出错！");
				e.printStackTrace();
				return null;
			}
		} else {
			sql = "select userid,username,email,password from user";
			dbutil = new DbUtil();
			userList = dbutil.query(sql, null);
		}

		return userList;
	}

	/**
	 * 将用户信息添加
	 * @author Zhang Jian
	 * @param table为需要写入文件的所有的用户信息
	 * @param path为需要写入信息的文件路径
	 * @param user为需要添加到数据库中的用户信息(若table和path为空)
	 */
	@Override
	public boolean add(Map<String, User> table, User user, String path) {
		if (table != null && (path != null && !"".equals(path))) {// 对文件进行操作
			file = new File(path);
			if (!file.exists()) {
				try {
					file.createNewFile();
				} catch (IOException e) {
					System.out.println("创建文件失败！");
					return false;
				}
			}
			FileOperate fo = new FileOperate();
			fo.writeUserToFile(table, file);
			return true;
		} else if (user != null) {// 数据库操作
			String[] params = { user.getUsername(), user.getEmail(), user.getPassword() };
			String sql = "insert into user(username,email,password) values(?,?,?)";
			dbutil = new DbUtil();
			boolean b = dbutil.update(sql, params);
			return b;
		}
		return false;
	}

	/**
	 * @author Zhang Jian 
	 * @date 2016年7月8日 下午1:51:54 
	 * @Description:
	 *         list集合转化为map集合 
	 * @param list 
	 * @return Map<String,User> 
	 * @throws
	 */
	public Map<String, User> listToMap(List<User> list) {
		users = new HashMap<String, User>();
		for (User user : list) {
			users.put(user.getUsername(), user);
		}
		return users;
	}

	/**
	 * 对数据库中的数据进行跟新操作
	 */
	@Override
	public boolean update(User user) {
		dbutil = new DbUtil();
		String sql = "update user set email=?,password=? where username=?";
		String[] params = {user.getEmail(),user.getPassword(),user.getUsername()};
		boolean b =dbutil.update(sql, params);
		return b;
	}
}
