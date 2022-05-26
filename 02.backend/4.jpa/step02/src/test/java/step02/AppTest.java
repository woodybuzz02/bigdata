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
	
	@Test
	public void testRead() { // �����̸� ��ȸ
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step02");
		EntityManager em = emf.createEntityManager();
		Student student = em.find(Student.class, 1L);
		System.out.println(student);
		System.out.println("���� �̸�: "+student.getMajor().getMajorName());
	}
	

	@Test
	public void updateRelation() {
		/*
		 * 1. ���ο� major �����а� ����, ����ȭ(persist)
		 * 2. �л�1(1L) ��ȸ �� (find), ���ο� �а�(�����а�)�� ����
		 */
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step02");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		
		// �а� ������ ����(INSERT)
		Major major2 = new Major("�����а�");
		em.persist(major2); // ����ȭ������!
		
		Student student1 = em.find(Student.class, 1L);
		student1.setMajor(major2); // em.update()���� ������ �޼���� ����, setXxx()�� Ȱ���Ͽ� ��ƼƼ ����,
		
		tx.commit(); // commit()�� ȣ��Ǹ� flush()�� ���������� 
	}
	
	@Test
	public void deleteRelation( ) {
		/*
		 * 1. �л�1�� ������ ����(null)
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
		 * 1. ��ǻ�� ���� ���� Entity�� DB���� ����
		 * 2. ������� ���� Entity�� DB���� ����
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
