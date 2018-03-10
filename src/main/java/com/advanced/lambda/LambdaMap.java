package com.advanced.lambda;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LambdaMap {

	public static void main(String[] args) {
		
		Map<String,String> map=new HashMap<String,String>();
		map.put("1", "a");
		map.put("2", "b");
		map.put("3", "c");
		map.put("4", "d");
		
		Set<String> keySet=map.keySet();
		for(String k : keySet){
			System.out.println(k+","+map.get(k));
		}
		
		//Lambda
		map.forEach((k,v) -> System.out.println("lambda :"+k+","+v));
		
	}

}
