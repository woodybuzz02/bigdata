package com.local_global;

public class Animal {
	int age; // static 키워드가 붙지 않았기 때문에 인스턴스 변수
	static String kind; // static 변수
	
	void instanceMethod() { // 인스턴스 메서드 static 키워드가 붙지 않았기 때문에
		System.out.println(age); // age는 인스턴스 변수기 때문에 접근 가능.
		// 인스턴스  메서드를 호출한다는 것은 객체가 이미 생성되었다는 것이기 때문에
		System.out.println(kind);
	}
	
	static void staticMethod( ) {
		//System.out.println(age);
		// static 영역에 staticMethod()가 올라갈 시점에는 인스턴스가 생성되지 않았을 수 있기 때문에 접근 불가능.
		
		System.out.println(kind); // 둘 다 static 키워드가 있기 때문에 가능.
		// instanceMethod(): // age와 마찬가지.
		
		// 만약 여기서 객체(인스턴스)를 생성한다면?
		Animal a = new Animal(); // static메서드 내부라고 할 지라도, 객체(인스턴스)가 생성되었기 때문에
		// 그 다음 시점인 23번 라인 이후 부터는 접근이 가능해짐.
		a.instanceMethod();
		
	}
} // 전역변수와 지역번수로 나누어져있는데 전역변수는 멤버변수와 static변수로 구분된다.

//개발자가 작성하는 대부분의 코드는 클래스 내부에 있음.
//(not always)
//
//// 클래스 외부
//package com.todo; // 자동 생성됨
//import ~
//
//멤버 : 어떤 클래스의 구성원(필드, 메서드)
//public class Mouse { 
//   // 클래스 내부
//
//   // 멤버 변수(어떤 클래스가 구성원으로 가지고 있는 변수)
//   // 멤버 변수 중에서도 전역 변수
//   // 전역변수 중에서 id는 인스턴스 변수
//   private Long id;
//   // 전역변수 중에서 title은 클래스 변수 혹은 객체 변수 혹은 static 변수
//   private static String title;
//
//   // 멤버 변수 중에서도 지역 변수
//   Todo( )생성자의 인자값으로 전달된 id, title -> 지역 변수
//   // 메서드 내부에 있기 때문에
//public Todo(Long id, String title, LocalDate dueDate, String description) {
//		this.id = id;
//		this.title = title;
//		this.description = description;
//		this.dueDate = dueDate;
//		this.isCompleted = false; // 기본값은 false
//	}
//}

