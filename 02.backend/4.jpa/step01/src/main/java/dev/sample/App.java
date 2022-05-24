package dev.sample;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dev.sample.model.Book;

public class App {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step01");

		// EntityManagerFactory�� ���� EntityManager ��ü ����
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			Book book = new Book();
			
//			book.setBookName("���ΰ� �ٴ�");

			// ���, em.persist(����� entity); list.add(entity);
//			em.persist(book);
			// ����, em.update()���� ������ ���� �޼���� �������� ����
			book.setBookName("�ٴٿ� ����");
			em.persist(book);
			
			// �� �� ��ȸ : em.find(��ȸ�� ��ƼƼ�� Ÿ��, @Id�� ������ �ʵ尪)
			// SELECT * FROM book WHERE id = 1;
			Book findBook = em.find(Book.class, 1L);
			System.out.println(findBook.getBookName());
			
			// ����:em.remove(������ entity)
			em.remove(findBook);

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}
	}
}