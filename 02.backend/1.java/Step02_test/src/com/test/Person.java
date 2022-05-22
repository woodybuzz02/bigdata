package com.test;

public class Person {
	// 멤버 변수 (필드)
	int age;
	String name;
	boolean isMarried;
	int childNumber;
	
	// 생성자 함수
	public Person() {}
	public Person(int age, String name, boolean isMarried, int childNumber ) {
		this.age = age;
		this.name = name;
		this.isMarried = isMarried;
		this.childNumber = childNumber;
	}
	
	// 메소드
	public String showIsMarried() {
		return isMarried ? "이 남자는 결혼을 했고, " : "이 남자는 결혼을 안했고, " ;
	}
	
	public String showPerson() {
		return "나이가 "+age+"살, 이름이 "+name+"라는 남자가 있습니다. "+showIsMarried()+"자식이 "+childNumber+"명 있습니다."; 
	}
}
