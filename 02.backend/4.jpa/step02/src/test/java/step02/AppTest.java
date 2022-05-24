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
		
		// �а� ������ ����(INSERT)
		Major major1 = new Major("��ǻ�� ����");
		em.persist(major1); // ����ȭ������!
		
		// �л� ������ ����
		Student student1 = new Student("seo");
		student1.setMajor(major1); // �������� ����(�ܷ�Ű ����)
		em.persist(student1);
		
		// �л�2 ����, �İ��� ����, ����(INSERT)
		Student student2 = new Student("kang");
		student2.setMajor(major1);
		em.persist(student2);
		
		tx.commit();
	}
}
