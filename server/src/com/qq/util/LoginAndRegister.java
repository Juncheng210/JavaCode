package com.qq.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public final class LoginAndRegister {
	private static final String USER_FILE_PATH = "src/com/qq/resources/userlist/user.properties";
	
	public static boolean loginCheck(String username, String password) {
		Properties pro = new Properties();
		try {
			pro.load(new FileInputStream(USER_FILE_PATH));
			if(pro.getProperty(username)!=null || pro.getProperty(username).equals(password)) {
				return true;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean registerCheck(String username, String password) {
		Properties pro = new Properties();
		try {
			pro.load(new FileInputStream(USER_FILE_PATH));
			if(pro.getProperty(username)==null ) {
				pro.put(username, password);
				return true;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
}
