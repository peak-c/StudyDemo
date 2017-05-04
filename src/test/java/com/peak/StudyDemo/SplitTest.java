package com.peak.StudyDemo;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

public class SplitTest {

	@Test
	public void fun1(){
		String str = "03-20 00:00:30.296,d35ae49b-066f-49a8-afb0-cc8403fa25b61489939228613,72567f700f949e9e,oad,5,,,,,,,9308204,CA,1380,5.5.1,TkVPLVUx,wifi,0,0,0,2703,,,tv,,1,,,,,,,eb93f7b2bd234616ad1554befdc7a696,1,3612049,75,62882cb3dcb4dea0b921de1766ea3110";
		
		str = "1,2,,4,,";
		
		String [] params = StringUtils.split(str, ",");
		System.out.println(params.length);
		for (String s : params) {
			System.out.println("----"+s);
		}
		
		System.out.println("----------------------------------------------------");
		
		String [] params1 = str.split(",",-1);
		System.out.println(params1.length);
		for (String s : params1) {
			System.out.println("----"+s);
		}
	}
}
