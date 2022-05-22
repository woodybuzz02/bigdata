package com;

public class Ex2 {
	
	public static void main(String[] args) {
		int number = 100;
		int result = 0;
		
		// number값을 랜덤값으로 나눈 결과 출력
		for (int i = 0; i<10; i++) {
			try { // try block
				result = number /(int)(Math.random() * 10);
				System.out.println(result);
			} catch (ArithmeticException exception){
				// RuntimeException은 try-catch문을 사용하여 예외 처리를 하지않아도 컴파일 오류가 나지 않는다.
				// 이럴 경우 직접 예외 처리를 해야한다.
				// RuntimeException 하위 클래스 중 ArithmeticException은 산술 연산 중 발생할 수 있는 예외를 처리한다.
				// exception이라는 인스턴스는 코드의 실행 과정에서 0으로 나누는 예외가 발생하면 그때
				// new ArithmeticException(); 인스턴스를 생성하고, exception 변수에 초기화.
				// exception = new ArithmeticException(); 이 이루어짐.
				
				// 즉, 0으로 나누는 예외가 발생하기 전까지 exception 변수는 선언만 되어있는 상태인데,
				// 0으로 나누는 예외가 발생하면 그때 인스턴스가 생성되서 exception 변수가 초기화됨.
				System.out.println("손님, 0으로 나누시면 안됩니다.");
//				exception.printStackTrace();
				System.out.println(exception.getMessage());
			} // try-catch 끝
		} // for 끝
	} // main 끝
}
/*	try{
 * 		예외가 발생할 수 있는 코드 부분
 * 	 } catch(처리할 예외 타입 e) {
 * 	 try 블록 안에서 예외가 발생했을 때 예외를 처리하는 부분
 * 	}
 * 
 * 
 * 
 * 
 */
