package com.abstracts.case2;

public class Cat extends Animal {

	// 추상클래스 Animal을 상속받은 하위  클래스 Cat은 Animal 클래스의 추상 메서드(Animal.sing())의 구현(작성)이 강제됨.
	
	@Override
	void sing() {
		System.out.println("야옹");
	}
	
}
