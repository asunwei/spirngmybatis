package com.learn.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
/**
 * 用户的实体类
 * @author sunwei
 *
 */


public class User implements Serializable {
	private int id;
    private String name;
    private Date birthday;
    private double salary;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
    
}
