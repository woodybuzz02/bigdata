package com;

public class MethodEx1 {

	// MethodEx1의 멤버 메서드
	public static void main(String[] args) throws Exception {
		method1();
	}
	
	// MethodEx1의 멤버 메서드2
	static void method1() throws Exception{
		method2();
		System.out.println("method1() 호출");
	}
	
	// MethodEx1의 멤버 메서드3
	static void method2() throws Exception { // method2() 내부에서 에외가 발생하면,
		// 해당 예외에 대한 예외 처리를 method2()를 호출한 호출부에서 처리하도록 책임을 떠넘김.
		System.out.println(3/0);
	}
}
