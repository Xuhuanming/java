package com.everelegance.reuserInfo.dao;

import java.util.List;
import java.util.Map;

import com.everelegance.reuserInfo.entity.User;

/**
 * 对用户的增删改查操作 根据参数path是否为空，选择是对文件的操作还是对数据库的操作
 * 
 * @author Zhang Jian 2016年7月7日下午2:06:23
 */
public interface UserDao {
	
	boolean add(Map<String, User> userMap, User user , String path);// 添加

	Map<String, User> selectAllToMap(String path);// 全部的用户信息,返回map集合

	List<User> selectAllToList(String path);// 全部用户信息，返回list集合

	boolean update(User user); //对数据库中的数据进行更新操作
	
}
