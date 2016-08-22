package com.everelegance.reuserInfo.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.everelegance.reuserInfo.dao.impl.UserDaoImpl;
import com.everelegance.reuserInfo.entity.User;
import com.everelegance.reuserInfo.service.IUserService;
import com.everelegance.reuserInfo.util.DbUtil;

/**
 * 
 * @author Xiao Qiao 2016年7月7日 下午3:36:33
 *
 */
public class UserService implements IUserService {
	
	private UserDaoImpl userDaoImpl;
	
	private Map<String, User> userMap;

	
	/**
	 * 登陆
	 * @author Xiao Qiao
	 * @param 	user
	 * @param 	path
	 * @return	true 为登陆成功，false登陆失败
	 */
	@Override
	public boolean login(User user,String path) {
		userDaoImpl = new UserDaoImpl();

		userMap = userDaoImpl.selectAllToMap(path);
		
		if(userMap.get(user.getUsername()) != null) {
			
			User u = userMap.get(user.getUsername());
			
			if(user.getPassword().equals(u.getPassword()))
				return true;
		}
		
		return false;
		
	}

	/**
	 * 注册
	 * @author  Xiao Qiao
	 * @param 	user  用户注册的信息
	 * @param 	path	 保存在服务器上的用户信息文本文件的路径
	 * @return 	true 为注册成功；false 为注册失败
	 */
	@Override
	public boolean registry(User user, String path) {
		userDaoImpl = new UserDaoImpl();
		
		userMap = userDaoImpl.selectAllToMap(path);
		
		if(this.userMap.get(user.getUsername()) != null)
			return false;
		
		this.userMap.put(user.getUsername(), user);
		
		return this.userDaoImpl.add(userMap, user, path); 
		
	}
	
	/**
	 * 更新
	 * @author Xiao Qiao
	 * @param user
	 * @param path
	 * @return true 为更新成功；false 为更新失败
	 */
	@Override
	public boolean update(User user,String path) {
		userDaoImpl = new UserDaoImpl();
		
		userMap = userDaoImpl.selectAllToMap(path);	
		
		if(user != null  && this.userMap.get(user.getUsername())!=null && path!=null){	// 文本更新
			User u = userMap.get(user.getUsername());
			
			// 更新用户 email 和 pwd
			u.setEmail(user.getEmail());
			u.setPassword(user.getPassword());
			
			userMap.put(u.getUsername(), u);		
			
			return userDaoImpl.add(userMap, user, path);
		} else {	// 数据库更新
			return this.userDaoImpl.update(user);
		}
		

	}
	
	/**
	 * 根据 username 进行查询
	 * @author Xiao Qiao
	 * @param 	username 	用户名
	 * @return	User		返回一个实体
	 */
	@Override
	public User selectByUsername(String username, String path) {
		
		userDaoImpl = new UserDaoImpl();
		userMap = new HashMap<>(); 
		
		userMap = userDaoImpl.selectAllToMap(path);
		
		User user = userMap.get(username);
		
		return user;
	}
	
	/**
	 * 根据用户 ID 进行查询
	 * @author  Xiao Qiao
	 * @param 	userId	用户ID
	 * @param 	path	 保存在服务器上的用户信息文本的路径
	 * @param 	username  用户名
	 * @return	User	返回一个用户实体
	 */
	@Override
	public User selectOne(int userId, String path, String username) {
		
		if(path==null){
			DbUtil dbUtil =  new DbUtil();
			
			String sql = "SELECT username,email, password FROM user WHERE userid =?";
			String userid = String.valueOf(userId);
			String params[] = {userid};
			List<User> userList = dbUtil.query(sql, params);
			User user = userList.get(0);
			
			return user;
		}
		return null;
	}
}
