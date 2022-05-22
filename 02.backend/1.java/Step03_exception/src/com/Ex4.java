package com;

public class Ex4 {
	
	// Ex4 class의 멤버 메서드 중에서 클래스 메서드(static)
	public static void main(String[] args) {
		method1();
		System.out.println("method1()의 수행 종료. main()로 복귀");
	}
	
	// Ex4 class의 또 다른 멤버 메서드
	public static void method1() {
		try {
			System.out.println("method1()이 호출되었음.");
			return;
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // 예외처리 진행 여부에 상관없이 무조건 실행되는 부분
			System.out.println("method1()의 finally block이 실행되었음.");
		}
	}
}
