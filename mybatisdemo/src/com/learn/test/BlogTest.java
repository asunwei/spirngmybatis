package com.learn.test;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import com.learn.dao.BlogDao;
import com.learn.entity.Blog;


/**
 * Blog的测试类
 * @author sunwei
 *
 */
public class BlogTest {

	private SqlSession getSession() {
		//1.读取配置文件sqMapConfig.xml来构建sqlSessionFactory实例。
		//通过类加载器读取.xml文件
		InputStream in = getClass().getClassLoader().getResourceAsStream("SqlMapConfig.xml");
		//2.每一个程序都是以一个sqlSessionFactory对象为核心，创建sqlSessionFactory.
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory sqlSessionFactory = builder.build(in);
		//3.创建sqlSession对象，该对象应该是线程私有的。每个方法都要创建一个，然后再finally块关闭。
		return sqlSessionFactory.openSession();
		
	}
	
	private BlogDao getBlogDao() {
		SqlSession session = getSession();
		return session.getMapper(BlogDao.class);
	}
	@Test
	public void testInsert() {
		BlogDao blogDao = getBlogDao();
		Blog blog = new Blog();
		blog.setId(2);
		blog.setName("AA");
		blog.setEmail("29730982739@ww.com");
		blogDao.insert(blog);
		System.out.println("插入完成");
	}
	
	@Test
	public void testFindById() {
		BlogDao blogDao = getBlogDao();
		Blog blog = blogDao.findById(1);
		System.out.println(blog.getEmail());
	}
	
	@Test
	public void testDelete() {
		BlogDao blogDao = getBlogDao();
		blogDao.delete(3);
		
	}
}
