package com;

public class Ex5 {

	public static void main(String[] args) {
		try {
			System.out.println(5/0);
		} catch (Exception e) {
			System.out.println(e instanceof ArithmeticException);
		}
	}

}
