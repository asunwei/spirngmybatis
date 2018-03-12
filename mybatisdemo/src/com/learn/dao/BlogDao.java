package com.learn.dao;

import java.util.List;

import com.learn.entity.Blog;

/**
 * BlogDao.java 的方法名与 BlogDao.xml的方法名一致。
 * @author sunwei
 *
 */
public interface BlogDao {
	public void insert(Blog blog);
    public void delete(int id);
    public void update(Blog blog);
    public Blog findById(int id);
    public List<Blog> findAll();
}
