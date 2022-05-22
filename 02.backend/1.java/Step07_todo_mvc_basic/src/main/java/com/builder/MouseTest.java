package com.builder;

import com.builder.Mouse.Builder;

public class MouseTest {

	public static void main(String[] args) {
//		Mouse jerry = new Mouse("제리", null, "갈색", 2, 0);
//		
//		// 점층적 생성자 패턴
//		Mouse jay = new Mouse();
//		System.out.println(jay);
//		
//		// 이름만 알고 있을 때
//		Mouse jamie = new Mouse("제이미");
//		System.out.println(jamie);
//		
//		// 이름과 주소를 알고 있을 때
//		Mouse jayz = new Mouse("제이지", "5");
//		System.out.println(jayz);
		
		// 빌더 패턴
		
		// Builder 클래스로 생성한 인스턴스
//		Builder b = new Mouse.Builder("제리");
//		b.address("하와이");
		
		// 이것도 Builder 클래스로 생성한 인스턴스(반환타입이 this니까)
//		new Mouse.Builder("제리").address("하와이")
		
		Mouse jerry = new Mouse.Builder("제리")
				.address("하와이")
				.age(5)
				.build();
		
		System.out.println(jerry);
	}

}
