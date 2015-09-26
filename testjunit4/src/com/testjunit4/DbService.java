package com.testjunit4;

import java.util.ArrayList;
import java.util.List;

public class DbService {

	private  List<User> db = new ArrayList<User>();

	 {
		for (int i = 0; i < 10; i++) {
			User u = new User();
			u.setUserId(i+1);
			u.setAddress("password" + i);
			u.setAddress("广州大马路" + i);
			u.setPhoneNumer("1371198192" + i);
			u.setUserName("userName" + i);
			db.add(u);
		}
	}

	public boolean addUser(User u) {
		if (u != null) {
			db.add(u);
			return true;
		}
		return false;
	}

	public boolean updateUser(User u) {
		for (int i = 0; i < db.size(); i++) {
			User tmp = db.get(i);
			if (u.getUserId() == tmp.getUserId()) {
				tmp.setAddress(u.getAddress());
				tmp.setPassword(u.getPassword());
				tmp.setPhoneNumer(u.getPhoneNumer());
				tmp.setUserName(u.getUserName());
				return true;
			}
		}
		return false;
	}

	public boolean deleteUser(int userId) {
		User tmp = null;
		for (int i = 0; i < db.size(); i++) {
			tmp = db.get(i);
			if (userId == tmp.getUserId()) {
				break;
			}
		}
		if (tmp != null) {
			db.remove(tmp);
			return true;
		}
		return false;
	}

	public User findUser(int userId) {
		for (int i = 0; i < db.size(); i++) {
			User tmp = db.get(i);
			if (userId == tmp.getUserId()) {
				return tmp;
			}
		}
		return null;
	}

	public User login(String userName, String password) {
		if (userName == null || userName.trim().equals("")) {
			return null;
		}

		if (password == null || password.trim().equals("")) {
			return null;
		}
		for (int i = 0; i < db.size(); i++) {
			User tmp = db.get(i);
			if (userName.equals(tmp.getUserName()) && password.equals(tmp.getPassword())) {
				return tmp;
			}
		}
		return null;
	}
	
	public List<User> findAllUser(){
		return db;
	}

	public int[] getArray(){
		return new int[]{1,2, 3};
	}
	
	
	public void testExecption(){
		int[] ret = new int[]{1,2, 3};
		System.out.println(ret[3]);
	}
	
	public static void main(String[] args) {
		DbService db = new DbService();
		db.testExecption();
	}
	
	
	public void testTimeout(){
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
