package com.advanced.lambda;

import java.util.LinkedList;
import java.util.List;

public class LambdaList {

	public static void main(String[] args) {
		List<String> list=new LinkedList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		
		for(String x : list){
			System.out.println(x);
		}
	
		//Lambda
		list.forEach(x -> System.out.println("Lambda :"+x));
		
		
	}

}
