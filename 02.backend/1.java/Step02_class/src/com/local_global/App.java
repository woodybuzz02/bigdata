package com.local_global;

public class App {

	public static void main(String[] args) {
		// countOfTail(static키워드가 붙어있는 멤버)에 접근하기 위해서는 클래스 이름으로 접근.
		// static키워드가 붙어있는 멤버는 프로그램 동작 시 바로 메모리에 등록되기때문에
		// 인스턴스(Mouse)를 생성하기도 전에도 접근(사용)이 가능하다.
		System.out.println(Mouse.countOfTail);
		
		Mouse jerry = new Mouse();
		System.out.println(jerry.countOfTail);
		// 참조변수 명보다는 클래스명으로 사용하는 것을 권장함.
		
		Mouse mickey = new Mouse();
		jerry.countOfTail = 2;
		System.out.println("미키의 꼬리는 "+mickey.countOfTail);

	}

}
