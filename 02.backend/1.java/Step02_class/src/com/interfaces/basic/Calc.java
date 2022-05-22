package com.interfaces.basic;

public interface Calc {// 키워드가 class에서 interface로 바뀜
	// 상수와 추상 메서드만 작성할 수 있음.
	
	// 상수, public static final은 작성하지 않아도 컴파일러가 자동으로 생성해줌
	public static final double PI = 3.14;
	public static final int ERROR = -9999999;
	
	// 추상 메서드, public abstract는 작성하지 않아도 컴파일러가 자동으로 생성해줌 
	public abstract int add(int a, int b);
	public abstract int substract(int a, int b);
}
