package com.learn.dao;

import java.util.List;

import com.learn.entity.User;

/**
 * 
 * @author sunwei
 *
 */
public interface UserDao {
	 public void insert(User user);
     public void delete(int id);
     public void update(User user);
     public User findById(int id);
     public List<User> findAll();
}
