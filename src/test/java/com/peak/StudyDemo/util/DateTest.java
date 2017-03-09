package com.peak.StudyDemo.util;

import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.junit.Test;

public class DateTest {

	@Test
	public void fun1() throws Exception{

		SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM d HH:mm:ss 'CST' yyyy", Locale.ENGLISH);
		Date date = dateFormat.parse("Fri Aug 28 18:08:30 CST 2015");
		System.out.println(date.getTime());
		
	}
}
