package com;

public class Ex3 {

	public static void main(String[] args) {
		System.out.println(1);
		System.out.println(2);
		try {
			System.out.println(2.5);
			System.out.println(3/0); // 예외가 발생해서, 예외 인스턴스(new ArithmeticException())가 생성되는 부분
			System.out.println(3); // 10번 라인에서 예외가 발생했기때문에 catch block으로 이동하게 되고, 3은 실행되지 않음.
		} catch (Exception exception) { // 처리할 예외 타입은 Exception이고 try 블록안에서 ArithmeticException 예외 발생.
			System.out.println("예외 발생!");
			//코드를 자유롭게 작성 가능한 부분
			if(exception instanceof ArithmeticException) { // 예외가 ArithmeticException 예외인지 묻는 것.
				System.out.println(exception instanceof ArithmeticException); // true
				// 참조변수 exception 내부에 들어있는 실제 인스턴스가 ArithmeticException 클래스의 인스턴스인지 확인하는 연산자
				// 실제 인스턴스가 ArithmeticException이면 해당 조건식의 결과값은 true, 아니면 false
//				System.out.println(exception instanceof NullPointerException); // false
			}
			System.out.println(4);
		} // try-catch 끝
		System.out.println(5);
	} // main() 끝

}
