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
}
