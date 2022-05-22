package com.todo.mvc;

public class BookTest {

	public static void main(String[] args) {
		// 길이가 3인 정수형 배열
		int[] numbers = new int[3];
		// 길이가 3인 문자열 배열
		String[] names = new String[3];
		
		Book[] books = new Book[3];
		
		Book book1 = new Book("노인과 바다", "헤밍웨이");
		System.out.println(book1);
		System.out.println(book1.getBookName()); //노인과 바다를 출력하도록
		
		books[0] = book1;
		System.out.println(books[0]);
		
		books[1] = new Book("자바의 정석", "남궁성");
		books[2] = new Book("다 큰 왕자", "생택쥐페리");
		
		//반복문으로 도서명과 저자명 출력
		for (Book book : books) {// for(타입 변수명: 배열)	
			System.out.println(book.getBookName()+" "+book.getAuthor());
			// book.getBookName == book.name(JS)
		}
	}

}
