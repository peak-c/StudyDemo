package com.peak.StudyDemo.util;

import org.junit.Test;

public class SwitchTest {


	@Test
	public void fun1(){
		int arg = 2;
		switch (arg) {
		case 1:

			break;
		case 2:

			arg = 4;
			System.out.println("2");
		case 3:

			arg = 4;
			System.out.println("3");
		case 4:
			System.out.println("4");
			break;

		default:
			break;
		}

	}
	@Test
	public void fun2(){
	
		StringBuffer sb = new StringBuffer("aaa");
		StringBuffer sb2 = new StringBuffer(sb.toString());
		
		sb.append("bbb");
		
		
		System.out.println(sb.toString() +"---" + sb2.toString());
		

	}
}
