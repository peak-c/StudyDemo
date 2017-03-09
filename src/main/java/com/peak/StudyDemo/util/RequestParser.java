package com.peak.StudyDemo.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;


/**
 * 请求参数解析工具
 * @author peak
 * @Date 2017年1月18日 上午11:30:33
 */
public class RequestParser {


	/**
	 * 解析 url 转换参数为map
	 * @param queryStr
	 * @param enc
	 * @return map value 值为数组，如  /xxx?a=1&a=2&b=3   可将a解析为数组
	 */
	public static Map<Object,Object> getParamsMap(String queryStr, String enc) {   
		if(StringUtils.isBlank(enc)){
			enc = "UTF-8";
		}

		//截去?前边的
		String queryString = queryStr.substring(queryStr.indexOf("?")+1);


		Map<Object,Object> paramsMap = new HashMap<Object,Object>();     
		if (queryString != null && queryString.length() > 0) {     
			int ampersandIndex, lastAmpersandIndex = 0;     
			String subStr, param, value;     
			String[] paramPair, values, newValues;     
			do {     
				ampersandIndex = queryString.indexOf('&', lastAmpersandIndex) + 1;     
				if (ampersandIndex > 0) {     
					subStr = queryString.substring(lastAmpersandIndex, ampersandIndex - 1);     
					lastAmpersandIndex = ampersandIndex;     
				} else {     
					subStr = queryString.substring(lastAmpersandIndex);     
				}     
				paramPair = subStr.split("=");     
				param = paramPair[0];     
				value = paramPair.length == 1 ? "" : paramPair[1];     
				/*try {     
					value = URLDecoder.decode(value, enc);     
				} catch (UnsupportedEncodingException ignored) {     
				}  */   
				if (paramsMap.containsKey(param)) {     
					values = (String[])paramsMap.get(param);     
					int len = values.length;     
					newValues = new String[len + 1];     
					System.arraycopy(values, 0, newValues, 0, len);     
					newValues[len] = value;     
				} else {     
					newValues = new String[] { value };     
				}

				paramsMap.put(param, newValues);     
			} while (ampersandIndex > 0);     
		}     
		return paramsMap;     
	}

	/**   
	 * 获得指定名称的参数   
	 * @param name   
	 * @return   
	 */    
	public static String getParameter(Map<Object,Object> parameterMap,String name) {     
		String[] values = (String[])parameterMap.get(name);     
		if (values != null && values.length > 0) {     
			return values[0];     
		}     
		return null;     
	}     

	/**   
	 * 获得所有的参数名称   
	 * @return   
	 */    
	public static Enumeration getParameterNames(Map<Object,Object> parameterMap) {     
		return Collections.enumeration(parameterMap.keySet());     
	}     


}
