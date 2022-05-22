package com.abstracts.case2;

public class App {

	public static void main(String[] args) {
		
		Animal[] animal = new Animal[3];
		
		animal[0] = new Cat();
		animal[1] = new Mouse();
		animal[2] = new Dog();
//		animal[3] = new Animal();
		// 추상 클래스로 지정되었기 때문에 인스턴스(객체) 생성 불가.
		// 누군가 실수로 Animal 인스턴스를 생성하는 오류를 사전에 막을 수 있음.
		
		for (Animal a : animal) {
			a.sing();
		}

	}

}