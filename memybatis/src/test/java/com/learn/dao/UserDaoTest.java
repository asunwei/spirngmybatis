package com.learn.dao;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.learn.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring-mybatis.xml" })
//https://www.cnblogs.com/hellboy0621/p/7423466.html
public class UserDaoTest {

	private Logger logger = LoggerFactory.getLogger(UserDaoTest.class);

	@Autowired
	private UserDao userDAO;

	@Test
	public void test() {
		System.out.println(1);
	}
	
	@Test
	public void testInsert() {
		User user = new User();
		user.setBirthday(new Date());
		user.setName("James");
		user.setSalary(15000.0);
		this.userDAO.insert(user);
		logger.info("insert the user={}", user);
		this.userDAO.delete(user.getId());
		User u = this.userDAO.findById(user.getId());
		logger.info("after delete the user={}", u);
	}

	@Test
	public void testUpdate() {
		User user = new User();
		user.setBirthday(new Date());
		user.setName("Daniel");
		user.setSalary(13000.0);
		logger.info("before update the user={}", user);
		this.userDAO.insert(user);
		user.setSalary(22000.0);
		this.userDAO.update(user);
		User u = this.userDAO.findById(user.getId());
		logger.info("after update the user={}", u);
		this.userDAO.delete(u.getId());
	}

	@Test
	public void testFindAll() {
		List<User> users = this.userDAO.findAll();
		logger.info("all the users={}", users);
	}
}
