package com.peak.StudyDemo.util;

import org.junit.Test;

public class StringTest {
	@Test
	public void fun1(){
		String flightTime = "467196,467177,";
		int length = flightTime.length();
		String last  = flightTime.charAt(length-1)+"";
		if( length>0  &&  ",".equals( last ) ){
			flightTime = flightTime.substring(0,length-1);
		}
		System.out.println(flightTime);
	}

}
