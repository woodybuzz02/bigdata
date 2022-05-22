package com.polymorphism;

public class Mammal extends Animal{//포유류는 동물이다.
	// Animal : 상위 클래스, Mammal : 하위 클래스
	Mammal(){
		myClass = "포유류";
	}
}


/**
 * 고래를 뜻하는 Whale 클래스 - Mammal 클래스를 상속
 * 고양이를 뜻하는 Cat 클래스 - Mammal 클래스를 상속
 */