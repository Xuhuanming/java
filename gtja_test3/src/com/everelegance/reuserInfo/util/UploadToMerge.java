package com.everelegance.reuserInfo.util;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.everelegance.reuserInfo.dao.impl.UserDaoImpl;
import com.everelegance.reuserInfo.entity.User;

/**
 * 上传一批用户信息并与服务器上原有的用户信息合并
 * 
 * @author Zhang Boxun
 *	
 */
public class UploadToMerge {
	
	/**
	 * @author Zhang Boxun
	 * @param localFileParh 服务器上的用户信息文件地址
	 * @param newUsersPath  需要上传的用户信息文件地址
	 * @Description 分别从两个文件中读取数据到Map中并合并成一个Map，把用户信息写进服务器文件中去
	 * @return ture上传并合并文件成功  false上传或者合并文件失败
	 */
	public boolean mergeUser(String localFileParh,String newUsersPath){
		
		
		try {
			FileOperate fo = new FileOperate();
			//把两个文件的信息读到Map中
			Map<String, User> user = fo.fileToMap(localFileParh);
			List<User>  userList = fo.fileToList(newUsersPath);
			Map<String, User> newusers = new UserDaoImpl().listToMap(userList);
			//合并用户信息
			user.putAll(newusers);
			
			//根据路径创建File
			File file = new File(localFileParh);
			if(!file.exists()){
				file.createNewFile();
			}
			
			//调用文件写操作，把用户信息写到服务器文件中
			new FileOperate().writeUserToFile(user, file);
			
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
}
