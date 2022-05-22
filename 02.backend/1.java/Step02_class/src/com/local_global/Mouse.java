package com.local_global;

public class Mouse {
	
	// Mouse라는 클래스의 멤버(속성과 메서드)
	
	// static 키워드가 붙지않는 속성 -> 인스턴스 변수, 객체(인스턴스)가 생성된 이후에만 접근 가능.
	int age;
	String name;
	
	// static 키워드가 붙은 속성 -> static(정적)/클래스 변수, 객체가 생성되기 전에도 접근(사용)이 가능.
	static int countOfTail = 1;
	
	// 우는 행위를 하는 메서드, static 키워드가 붙지 않았기 때문에 인스턴스 메서드, 객체가 생성된 이후에만 호출 가능.
	void sing( ) {
		 System.out.println(name+ "찍찍");
	}
	
	void staticTest() {// 인스턴스 메서드를 호출한다는 것은 static영역은 이미 활성화가 되어있다는 의미
		System.out.println(countOfTail); // static은 어디서나 접근이 가능하다.
	}
}
