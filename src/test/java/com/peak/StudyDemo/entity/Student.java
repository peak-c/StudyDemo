package com.peak.StudyDemo.entity;

/**
 * @author peak
 * @Date 2017年1月5日 下午4:02:18
 */
public class Student {

	private String name;
	
	private Teacher teacher;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", teacher=" + teacher + "]";
	}
	
	
}
