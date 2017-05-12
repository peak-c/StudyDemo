package com.peak.StudyDemo.util;

import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

import net.sourceforge.jeval.EvaluationException;
import net.sourceforge.jeval.Evaluator;

public class JevalTest {


	@Test
	public void fun1() throws Exception{
		Double X_VALUE = 1.0;
		String exp = "2 + (7-5) * 3.14159 * #{x} + sin(0)";  


		// compile  
		Evaluator jevalEvaluator = new Evaluator();  
		jevalEvaluator.setVariables(Collections.singletonMap("x", Double.toString(X_VALUE)));  

		// evaluate  
		double result = Double.parseDouble(jevalEvaluator.evaluate(exp));  

		System.out.println(result);//-> 2.0 
	}

	@Test
	public void fun2(){

		String s = "1+1+#{x}+1+#{y}";

		Pattern p = Pattern.compile("#\\{(\\w+)\\}");
		Matcher m = p.matcher(s);
		while (m.find()) { 
			  
			//System.out.println(m.groupCount());  
			System.out.println(m.group(1));  
			
		}  


	}
	@Test
	public void fun3() throws EvaluationException{
		String exp = "((0)||(1))";
		Evaluator jevalEvaluator = new Evaluator();  
		
		System.out.println(jevalEvaluator.evaluate(exp));
	}





}
