
package dev.sample;

// Person이라는 클래스 정의
public class Person {
	
	// 사람의 이름과 나이를 갖는 필드(프로퍼티 in JS) 정의
	private String name;
	private int age;
	
	// name과 age를 입력받는 생성자 함수(Constructor) 작성
	// 생성자 함수의 특징 : 클래스 이름과 동일하다.
	public Person(String name, int age) {
		System.out.println("Person() 호출");
		this.name = name;
		this.age = age;
	}
	
	// getter 함수 작성 ex) getXxx()
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	
}
