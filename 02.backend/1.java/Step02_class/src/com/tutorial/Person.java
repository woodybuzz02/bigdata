package com.tutorial;

public class Person {
	
	// 멤버 변수
	String name;
	private int age; //private하면 본인만 수정가능
	
	// 생성자 함수
	
	public Person() {}
	public Person(String name, int age) {
		this.name = name; //name = name;하면 지역변수로 똑같이 인식, 그래서 this 씀.
		this.age = age;
	}
	

	// setter(Person 클래스의 필드(name, age)를 개별적으로 설정해주는 메서드
	// 명명규칙 : setXxx(), Xxx : 필드명
	public void setName(String name) {
		System.out.println("setName() 호출");
		this.name = name;
	}
	
	public void setAge(int age) {
		if(age >= 1 && age <= 100) {
		this.age = age;
		} else {
			return;
		}
	}
	
	// getter(Person 클래스의 필드값을 접근(조회)하는 메서드
	// 명명규칙 : getXxx(), Xxx: 카멜케이스가 적용된 필드명
	
	// 사람의 이름값(문자열)을 반환하는 메서드
	public String getName() {
		return name;
	}
	
	// 사람의 나이값(정수)을 반환하는 메서드
	public int getAge() {
		return age;
	}

	// 멤버 메서드
	// Person 인스턴스의 이름, 나이 출력, 반환 타입은 String
	public String showPerson() {
		return name +","+ age ;
		// 문자열 + 숫자 = 문자열
		// 숫자 + 문자열 = 문자열
	}
}
