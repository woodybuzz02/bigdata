package com.todo.mvc;

public class BookTest {

	public static void main(String[] args) {
		// ���̰� 3�� ������ �迭
		int[] numbers = new int[3];
		// ���̰� 3�� ���ڿ� �迭
		String[] names = new String[3];
		
		Book[] books = new Book[3];
		
		Book book1 = new Book("���ΰ� �ٴ�", "��ֿ���");
		System.out.println(book1);
		System.out.println(book1.getBookName()); //���ΰ� �ٴٸ� ����ϵ���
		
		books[0] = book1;
		System.out.println(books[0]);
		
		books[1] = new Book("�ڹ��� ����", "���ü�");
		books[2] = new Book("�� ū ����", "�������丮");
		
		//�ݺ������� ������� ���ڸ� ���
		for (Book book : books) {// for(Ÿ�� ������: �迭)	
			System.out.println(book.getBookName()+" "+book.getAuthor());
			// book.getBookName == book.name(JS)
		}
	}

}
