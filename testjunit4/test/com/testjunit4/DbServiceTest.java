package com.testjunit4;


import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DbServiceTest {

	private static DbService db;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("setUpBeforeClass");
		db = new DbService();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("tearDownAfterClass");
		db = null;
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("setUp");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("tearDown");
	}

	@Test
	public void testAddUser() {
		User u = new User();
		u.setAddress("茂名市");
		u.setPassword("123456");
		u.setPhoneNumer("13711678932");
		u.setUserId(11);
		u.setUserName("清风竹");
		boolean  ret = db.addUser(u);
		System.out.println("testAddUser");
		Assert.assertTrue("插入成功", ret);
	}

	@Test
	public void testUpdateUser() {
		System.out.println("testUpdateUser");
	}

	@Test
	public void testDeleteUser() {
		System.out.println("testDeleteUser");
	}

	@Test
	public void testFindUser() {
		System.out.println("testFindUser");
	}

	@Test
	public void testLogin() {
		System.out.println("testLogin");
	}

	@Test
	public void findAllUser(){
		System.out.println("findAllUser");
		List<User> list = db.findAllUser();
		assertNotNull(list);
		assertEquals("返回的长度10", 10, list.size());
	}
	
	@Test
	public void arrayTest(){
		int[] expecteds = new int[] {1, 2, 3,2};
		
		assertArrayEquals(expecteds, db.getArray());
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void TestExpected(){
		db.testExecption();
	}
	
	@Test(timeout=501)
	public void TestTimeout(){
		db.testTimeout();
	}
	
	@Test(timeout=501)
	public void TestCoding(){
		db.testTimeout();
	}
	
}
