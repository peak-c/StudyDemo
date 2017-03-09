package com.peak.StudyDemo.util;

import org.junit.Test;

import com.peak.StudyDemo.entity.Student;
import com.peak.StudyDemo.entity.Teacher;

public class ReflectionsTest {

	
	@Test
	public void fun1(){
		Teacher t = new Teacher();
		Student s = new Student();
		s.setName("小张");
		s.setTeacher(t);
		
		Reflections.invokeSetter(s, "teacher.name", "老师");
		System.out.println(s.toString());
		
		Reflections.invokeSetter(s, "name", "小李");
		System.out.println(s.toString());
		
		Reflections.setFieldValue(s, "name", "小王");
		System.out.println(s.toString());
		
	}
	
	
}
