package com.peak.StudyDemo.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.Test;

public class CollectionTest {
	
	@Test
	public void fun1(){
		HashSet<String> hs = new HashSet<String>();
		
		HashMap<String, String> hm = new HashMap<String, String>();
		
		Hashtable<String, String> ht = new Hashtable<String, String>();
		
		
		Collections.synchronizedMap(hm);
		
		ConcurrentHashMap<String, String> chm = new ConcurrentHashMap<String, String>();
	}

}
