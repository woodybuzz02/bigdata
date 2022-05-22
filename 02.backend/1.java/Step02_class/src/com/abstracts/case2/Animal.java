package com.abstracts.case2;

// 추상(abstract) 클래스를 작성하기 위해서는 class 키워드 앞에 abstract 키워드를 추가해야함
public abstract class Animal {
	abstract void sing();// 추상 메서드
		// 몸체는 없고, 선언부만 있는 메서드
		// 일반적으로 메서드는 구현부까지 작성해야되지만, abstract 키워드를 붙이면 추상 메서드가 된다.
		// 선언부만 작성함.
	void eat() { // 메서드 선언부
		// 메서드 몸체, 구현부
		// 추상클래스는 일반 메서드도 가질 수 있다.
	}
	
}
