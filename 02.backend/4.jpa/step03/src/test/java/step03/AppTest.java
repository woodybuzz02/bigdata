package step03;

import static org.junit.Assert.*;

import java.util.List;

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
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step03");
		// EntityManagerFactory�� ���� EntityManager ��ü ����
		EntityManager em = emf.createEntityManager(); // EntityManager ���� -> ���Ӽ� ���ؽ�Ʈ �������.
		// ���Ӽ� ���ؽ�Ʈ(Persistence Context)�� Entity�� ������ �����ϴ� ȯ��
		// ���Ӽ� ���ؽ�Ʈ�� Entity�� �ĺ���(PK, �⺻Ű, @Id�� Table�� �⺻ Ű�� ������ ��)�� ����
		// ���Ӽ� ���ؽ�Ʈ ���� ��ƼƼ�� ����ȴٸ� �� ��ƼƼ���� �ĺ��ڸ� ���� �ֱ� ������ �ߺ���ü�� �ĺ��� �� �ִ�.
		/*
		 * ��ƼƼ ���� �ֱ�(Entity LifeCycle)
		 * 
		 * �񿵼�(new/transient): ���Ӽ� ���ؽ�Ʈ�� ���� ���谡 ���� ���� ����(managed): ���Ӽ� ���ؽ�Ʈ�� ����� ����
		 * �ؿ���(detached): ���Ӽ� ���ؽ�Ʈ�� ����Ǿ��ٰ� �и��� ���� ����(removed): ������ ����
		 */
		EntityTransaction tx = em.getTransaction(); // ������ ����� Transaction�� �ؾ��Ѵ�.

		tx.begin(); // Transaction ����

		Major major1 = new Major("��ǻ�� ����");
		em.persist(major1); // ���Ӽ� ���ؽ�Ʈ�� ����, managed�� �� entity�� ĳ�ÿ� ����

		Student student1 = new Student("Yoo");
		student1.setMajor(major1); //
		em.persist(student1); // ���� ����(dirty checking): em.update()���� �޼���� ����, ���Ӽ� ���ؽ�Ʈ�� ���� Entity�� ���� ������ DB�� �ڵ����� �ݿ��ϴ� ���

		Student student2 = new Student("Kang");
		student2.setMajor(major1);
		em.persist(student2); // ���Ӽ� ���ؽ�Ʈ�� ����

		tx.commit(); // flush()�� �ڵ�ȣ��(���Ӽ� ���ؽ�Ʈ�� ���� ������ DB�� ����ȭ), Transaction ����
		/*
		 * em.flush() �� ���� ȣ���ϸ� ���Ӽ� ���ؽ�Ʈ�� ������ �÷����Ѵ�. ������ �̴� ���� ������� �ʴ� ����̴�.
		 * Ʈ����� Ŀ�Խ� �ڵ� ȣ��Ǿ�� �ϴ� ������ flush() �� COMMIT �� �ٸ��� �����̴�. 
		 * flush()�� �츮�� DB Editor���� SQL�� �ۼ��ϴ°��̶�� �� �� ������, Ʈ����� Ŀ���� �� �״�� COMMIT �� �����ϴ°��̴�.
		 * SQL�� ���� �ʰ� COMMIT�� �����Ѵٸ� �翬�� � �ϵ� �Ͼ�� �ʴ´�. 
		 * Ʈ����� Ŀ�Խ� flush()�� �ڵ�ȣ�� �Ǵ� ������ �ٷ� �� �����̴�.
		 */
	}

	@Test
	public void readStudents() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step03");
		EntityManager em = emf.createEntityManager();

		Major major = em.find(Major.class, 1L); //DB�� ��ȸ�ؼ� Entity�� ����, 1�� ĳ�ÿ� ������ �� ���� ������ Entity�� ��ȯ

		List<Student> students = major.getStudents();
		for (Student student : students) {
			System.out.println(student.getStudentName());
		}
	}

	@Test
	public void testSaveNonOwnerWithJPA() { // JPA�� ������ �瓇�� �������迡�� ���������� ������ �ƴ� ������ ���� �Է��� ���
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step03");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();
		Major major1 = new Major("��ǻ�� ����");
		em.persist(major1);

		Student student1 = new Student("Yoo");
		// ���� ���������� ������ �ƴ� ������ �������踦 ������ ���,
		List<Student> students = major1.getStudents();
		students.add(student1);
		em.persist(student1);

		// �л�2 ����
		Student student2 = new Student("Kang");
		// ���� ���������� ������ �ƴ� ������ �������踦 ������ ���,
		students.add(student2);
		em.persist(student2);

		tx.commit();
	}

	@Test
	public void testSaveOwnerWithOOP() { // ������ ��ü���� �ڵ忡�� ���������� ����
		Major major1 = new Major("��ǻ�� ����");

		Student student1 = new Student("Yoo");
		student1.setMajor(major1);

		Student student2 = new Student("Kang");
		student2.setMajor(major1);

		List<Student> students = major1.getStudents();
		System.out.println("students.size : " + students.size());
	}

	@Test
	public void biWithPureOOP() { // ������ ��ü���� �ڵ忡�� ����� �������� ����
		Major major1 = new Major("��ǻ�� ����");
		List<Student> students = major1.getStudents();

		Student student1 = new Student("Yoo");
		student1.setMajor(major1); // ���������� ���� ���⿡�� �������� ����
		students.add(student1); // �ݴ������� �������� ����

		Student student2 = new Student("Kang");
		student2.setMajor(major1); // ���������� ���� ���⿡�� �������� ����
		students.add(student2); // �ݴ������� �������� ����

		System.out.println("students.size : " + students.size());
	}

	@Test
	public void biWithJPA() { // JPA�� ���� ����� ����
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step03");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();

		Major major1 = new Major("������");
		em.persist(major1);

		Student student1 = new Student("Park");
		student1.setMajor(major1);
		List<Student> students = major1.getStudents();
		students.add(student1);
		em.persist(student1);

		Student student2 = new Student("Kim");
		student2.setMajor(major1);
		students.add(student2);
		em.persist(student2);

		tx.commit();

		// SELECT s.*, m.major_name FROM student s JOIN major m ON s.major_id =
		// m.major_id WHERE s.major_id = 1;
	}
}
