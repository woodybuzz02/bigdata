package com.polymophism2;

public class App {

	public static void main(String[] args) {
		Animal animal = new Whale(); // 참조 변수(animal)가 사용할 수 있는 멤버의 개수(2)는 참조하고 있는 인스턴스(Whale) 멤버의 개수(3)보다 같거나 작다.
		animal.name = "Animal 타입으로";
				
		animal.sing();
		
		Whale whale = new Whale();
		whale.name = "whale 타입으로";
		whale.sing();
		
//		animal.swim();
		// 상위 타입의 참조변수로 하위 타입의 멤버 사용 불가.

		whale.swim();
		
		// 반대도 가능할까?
//		Whale w = new Animal(); // 불가능
		
	}

}
