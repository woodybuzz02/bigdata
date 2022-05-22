package com.tutorial;

public class ConstructorTest {

	public static void main(String[] args) {
		/**App.java 기준
		 * 
		 */
		Person a = new Person("신짱구", 5);
		
		System.out.println(a.showPerson());
			
		Person b = new Person("신짱아", 1);
		
		System.out.println(b.showPerson());
		
		// 서로 같지 않다. 인스턴스는 고유하기 때문에.
		System.out.println(a == b);
		
		System.out.println(a);
		
		System.out.println(b);
		
		// 기본 생성자로 인스턴스를 생성하려면?
		Person sombody = new Person();
		
	}

}
