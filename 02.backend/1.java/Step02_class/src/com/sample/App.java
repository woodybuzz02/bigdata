package com.sample;

// App이라는 클래스 정의
public class App {
	
	// App 클래스가 가진 객체(클래스, 정적, static) 메서드 main()
	// 코드를 실행하면 이클립스가 내부적으로 main()을 호출함.
	public static void main(String[] args) {
		// main()은 메서드 자바에서는 모든 것들이 함수가 아니라 메서드
		System.out.println(add(3, 5)); // 자신의 속성이나 메서드는 그냥 사용할 수 있다.
//		App a = new App(); 굳이 이렇게 하지않고 호출할 수 있다.
//		System.out.println(a.add(5, 5));
		
		// 학생 인스턴스 하나 생성.
		Student s = new Student(); // 생성자 함수 호출
		
		s.showStudent(); // s 인스턴스가 가진 showStudent() 호출
		
		//1. 생성자 함수(constructor)를 통한 필드 값을 설정
		new Student("톰", 3).showStudent();
		
	} // main() 끝 
	
	// 덧셈 기능을 제공하는 메서드, add(), 반환 타입은 int, 파라미터(매개변수)로 a, b를 받음.
	public static int add(int a, int b) {
//		int result = a + b;
//		return result;
		return a + b;
	}

}
