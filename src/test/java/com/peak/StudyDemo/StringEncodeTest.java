package com.peak.StudyDemo;


import org.junit.Test;

public class StringEncodeTest {

	@Test
	public void fun1() throws Exception{

		byte[] bytes = "abc你好".getBytes();
		
        String str1 = new String(bytes, "UTF-8");//to UTF-8 string  
        String str2 = new String(bytes, "ISO-8859-1");//to ISO-8859-1 string  
        String str3 = new String(bytes, "GBK");//to GBK string  

        System.out.println(str1);//abc你好  
        System.out.println(str2);//abcä½ å¥½  
        System.out.println(str3);//abc浣犲ソ
        
        System.out.println(str1.equals(str2));
        System.out.println(str1.equals(str3));
        System.out.println(str2.equals(str3));
		
		
	}
}
