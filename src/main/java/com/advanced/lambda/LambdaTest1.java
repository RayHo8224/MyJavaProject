package com.advanced.lambda;

/*
 * 	Lambda語法結構
 * 	input -> body
 * 
 * */
public class LambdaTest1 {

	Runnable r1=() -> System.out.println("r1:"+this.getClass());

	Runnable r2=new Runnable() {
		
		@Override
		public void run() {
			System.out.println("r2:"+this.getClass());
		}
	};
	
	public static void main(String[] args) {
		new LambdaTest1().testLamdda();
	}
	
	public void testLamdda(){
		
		new Thread(r1).start();
		new Thread(r2).start();
		
	}

	
	
}
