package com.peak.StudyDemo;

import org.junit.Test;

public class TryCatchTest {
	
	@Test
	public void fun1(){
		try {
			System.exit(1);
		} finally {
			System.out.println("test");
			
		}
	}

}
