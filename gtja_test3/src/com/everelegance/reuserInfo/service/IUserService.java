package com.everelegance.reuserInfo.service;

import com.everelegance.reuserInfo.entity.User;

/**
 * 
 * @author Xiao Qiao 2016年7月7日 下午3:29:41
 *
 */
public interface IUserService {


	public boolean login(User user, String path);		// 登陆
	
	public boolean registry(User user, String path);	// 注册

	public boolean update(User user, String path);	// 更新
	
	public User selectByUsername(String username, String path); 	// 根据用户名查询 
	
	public User selectOne(int userId, String path, String username);		// 选择一个用户的信息
	
	
}
