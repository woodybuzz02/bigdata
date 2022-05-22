package com.extend;

public class App {

	public static void main(String[] args) {
		
		Animal anAnimal = new Animal();
		anAnimal.sing();
		
//		Mouse m = new Mouse();
//		m.setAge(10);
//		m.setColor("brown");

		Mouse jerry = new Mouse(15, "제리", "뉴욕");
		
		jerry.sing();
	}

}
