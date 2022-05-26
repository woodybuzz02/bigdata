package step02;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Test;

import dev.sample.model.Major;
import dev.sample.model.Student;

public class AppTest {

	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

	@Test
	public void testSave() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step02");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		
		// 학과 데이터 저장(INSERT)
		Major major1 = new Major("컴퓨터 공학");
		em.persist(major1); // 영속화시켜줘!
		
		// 학생 데이터 저장
		Student student1 = new Student("seo");
		student1.setMajor(major1); // 연관관계 설정(외래키 설정)
		em.persist(student1);
		
		// 학생2 생성, 컴공과 맵핑, 저장(INSERT)
		Student student2 = new Student("kang");
		student2.setMajor(major1);
		em.persist(student2);
		
		tx.commit();
	}
	
	@Test
	public void testRead() { // 전공이름 조회
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step02");
		EntityManager em = emf.createEntityManager();
		Student student = em.find(Student.class, 1L);
		System.out.println(student);
		System.out.println("전공 이름: "+student.getMajor().getMajorName());
	}
	

	@Test
	public void updateRelation() {
		/*
		 * 1. 새로운 major 국문학과 생성, 영속화(persist)
		 * 2. 학생1(1L) 조회 후 (find), 새로운 학과(국문학과)로 설정
		 */
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step02");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		
		// 학과 데이터 저장(INSERT)
		Major major2 = new Major("국문학과");
		em.persist(major2); // 영속화시켜줘!
		
		Student student1 = em.find(Student.class, 1L);
		student1.setMajor(major2); // em.update()같은 별도의 메서드는 없고, setXxx()를 활용하여 엔티티 변경,
		
		tx.commit(); // commit()이 호출되면 flush()가 내부적으로 
	}
	
	@Test
	public void deleteRelation( ) {
		/*
		 * 1. 학생1의 전공을 제거(null)
		 */
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step02");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		
		Student student1 = em.find(Student.class, 1L);
		student1.setMajor(null);
		tx.commit();
	}
	
	@Test
	public void deleteEntity( ) {
		/*
		 * 1. 컴퓨터 공학 전공 Entity를 DB에서 제거
		 * 2. 관계부터 끊고 Entity를 DB에서 제거
		 */
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step02");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		Student student1 = em.find(Student.class, 1L);
		student1.setMajor(null);
		Student student2 = em.find(Student.class, 2L);
		student2.setMajor(null);
		
		Major major = em.find(Major.class, 1L);
		em.remove(major);
		tx.commit();
	}
	
}
