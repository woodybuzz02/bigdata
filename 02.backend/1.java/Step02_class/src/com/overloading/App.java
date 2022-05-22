package com.overloading;

public class App {

	public static void main(String[] args) {
		Mouse jerry = new Mouse();
//		System.out.println(jerry.age);
//		System.out.println(jerry.name);
		
		Mouse jay = new Mouse(15);
//		System.out.println(jay.age);
//		System.out.println(jay.name);
	
		Mouse jamie = new Mouse("제이미");
//		System.out.println(jamie.age);
		System.out.println(jamie.name);
		
		Mouse joo = new Mouse(5,"joo");
//		System.out.println(joo.age);
		System.out.println(joo.name);
	}

}
