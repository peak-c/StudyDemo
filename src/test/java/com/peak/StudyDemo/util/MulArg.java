package com.peak.StudyDemo.util;

import org.junit.Test;

public class MulArg {

	@Test
	public void fun1(){
		String[] s = new String[]{"1","2"};
		fun2(s);
	}
	
	public void fun2(String... arg){
		for (String string : arg) {
			System.out.println(string);
			
		}
	}
}
