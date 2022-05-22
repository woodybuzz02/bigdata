package dev.sample;

public class App {

	public static void main(String[] args) {
		System.out.println("Hello World");
		
		// 사람 객체 1개 생성
		Person yoo = new Person("유재석", 48);
		System.out.println(yoo.getName());
		
		// 길이가 2인 Person타입의 객체 배열 생성
		Person[] persons = new Person[2];
		
		persons[0] = new Person("신짱구", 5);
		persons[1] = new Person("신짱아", 1);
		
		for (Person person : persons) {
			System.out.println(person.getName() + " " + person.getAge());
		}

	}

}
