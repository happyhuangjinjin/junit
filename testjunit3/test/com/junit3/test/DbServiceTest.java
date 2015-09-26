package com.junit3.test;

import junit.framework.TestCase;

public class DbServiceTest extends TestCase {

	private DbService db= null;
	
	protected void setUp() throws Exception {
		db = new DbService();
	}

	protected void tearDown() throws Exception {
		db = null;
	}

	public void testAddUser() {
		User u = new User();
		u.setUserId(11);
		u.setPassword("110");
		boolean ret = db.addUser(u);
//		assertEquals(true, ret);
		assertEquals(false, ret);
		
	}

	public void testUpdateUser() {
		User u = new User();
		u.setAddress("茂名市");
		u.setPassword("1234567");
		u.setPhoneNumer("13711659830");
		u.setUserId(1);
		u.setUserName("清风竹");
		boolean ret =db.updateUser(u);
//		assertTrue(ret);
//		assertFalse(ret);
		assertEquals("该方法正确", true, ret);
		assertEquals("该方法不正确", false, ret);
	}

	public void testDeleteUser() {
	}

	public void testFindUser() {
		User u = db.findUser(11);
//		assertNotNull(u);
		assertNull(u);
		
		
		
	}

	public void testLogin() {
	}

}
