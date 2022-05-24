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

		// EntityManagerFactory를 통해 EntityManager 객체 생성
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			Book book = new Book();
			
//			book.setBookName("노인과 바다");

			// 등록, em.persist(등록할 entity); list.add(entity);
//			em.persist(book);
			// 수정, em.update()같은 별도의 수정 메서드는 존재하지 않음
			book.setBookName("바다와 노인");
			em.persist(book);
			
			// 한 행 조회 : em.find(조회할 엔티티의 타입, @Id로 매핑한 필드값)
			// SELECT * FROM book WHERE id = 1;
			Book findBook = em.find(Book.class, 1L);
			System.out.println(findBook.getBookName());
			
			// 삭제:em.remove(삭제할 entity)
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