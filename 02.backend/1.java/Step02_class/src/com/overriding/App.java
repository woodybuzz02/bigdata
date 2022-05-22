package com.overriding;

public class App {

	public static void main(String[] args) {
		Animal animal = new Animal(); // ctrl + 1
		animal.name = "어떤 동물";
		
		animal.showName();
		
		Mouse jerry = new Mouse();
		jerry.name = "제리";
		jerry.address = "하와이";
		
		jerry.showName(); //오버라이딩
		jerry.showName("톰"); //오버로딩
		
		// 다형성(Polymorphism)
		Animal anAnimal = new Animal();
		Mouse jay = new Mouse();
		
		Animal mickey = new Mouse(); // 하위 클래스인 Mouse 타입의 인스턴스를 상위 클래스인 Animal 타입의 참조변수 mickey에 대입
		// 하위 타입에서 상위 타입으로의 형 변환은 자동
		
		mickey.name = "미키마우스";
//		mickey.address = "롯데타워"; // 상위 타입의 참조변수(Animal mickey)로 하위 타입의 멤버(address) 사용 불가.
		
		mickey.showName(); // 상위 타입(Animal)의 참조변수지만, 오버라이딩되었기 때문에 예외적으로 사용 가능.
//		mickey.showAddr(); // 상위 타입의 참조변수(Animal mickey)로 하위 타입의 멤버(address) 사용 불가.
		
	}

}
