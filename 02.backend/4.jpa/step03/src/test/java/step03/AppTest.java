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
		// EntityManagerFactory를 통해 EntityManager 객체 생성
		EntityManager em = emf.createEntityManager(); // EntityManager 생성 -> 영속성 컨텍스트 만들어짐.
		// 영속성 컨텍스트(Persistence Context)란 Entity를 영구히 저장하는 환경
		// 영속성 컨텍스트는 Entity를 식별자(PK, 기본키, @Id로 Table의 기본 키와 맵핑한 값)로 구분
		// 영속성 컨텍스트 내에 엔티티가 저장된다면 각 엔티티들은 식별자를 갖고 있기 때문에 중복객체를 식별할 수 있다.
		/*
		 * 엔티티 생명 주기(Entity LifeCycle)
		 * 
		 * 비영속(new/transient): 영속성 컨텍스트와 전혀 관계가 없는 상태 영속(managed): 영속성 컨텍스트에 저장된 상태
		 * 준영속(detached): 영속성 컨텍스트에 저장되었다가 분리된 상태 삭제(removed): 삭제된 상태
		 */
		EntityTransaction tx = em.getTransaction(); // 데이터 변경시 Transaction을 해야한다.

		tx.begin(); // Transaction 시작

		Major major1 = new Major("컴퓨터 공학");
		em.persist(major1); // 영속성 컨텍스트로 보냄, managed가 된 entity를 캐시에 저장

		Student student1 = new Student("Yoo");
		student1.setMajor(major1); //
		em.persist(student1); // 변경 감지(dirty checking): em.update()같은 메서드는 없음, 영속성 컨텍스트로 보냄 Entity의 변경 사항을 DB에 자동으로 반영하는 기능

		Student student2 = new Student("Kang");
		student2.setMajor(major1);
		em.persist(student2); // 영속성 컨텍스트로 보냄

		tx.commit(); // flush()가 자동호출(영속성 컨텍스트의 변경 내용을 DB에 동기화), Transaction 종료
		/*
		 * em.flush() 를 직접 호출하면 영속성 컨텍스트를 강제로 플러시한다. 하지만 이는 거의 사용하지 않는 기능이다.
		 * 트랜잭션 커밋시 자동 호출되어야 하는 이유는 flush() 와 COMMIT 이 다르기 때문이다. 
		 * flush()는 우리가 DB Editor에서 SQL을 작성하는것이라고 할 수 있으며, 트랜잭션 커밋은 말 그대로 COMMIT 을 수행하는것이다.
		 * SQL을 쓰지 않고 COMMIT을 수행한다면 당연히 어떤 일도 일어나지 않는다. 
		 * 트랜잭션 커밋시 flush()가 자동호출 되는 이유가 바로 이 때문이다.
		 */
	}

	@Test
	public void readStudents() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step03");
		EntityManager em = emf.createEntityManager();

		Major major = em.find(Major.class, 1L); //DB를 조회해서 Entity를 생성, 1차 캐시에 저장한 후 영속 상태의 Entity를 반환

		List<Student> students = major.getStudents();
		for (Student student : students) {
			System.out.println(student.getStudentName());
		}
	}

	@Test
	public void testSaveNonOwnerWithJPA() { // JPA를 적용한 양뱡향 연관관계에사 연관관계의 주인이 아닌 곳에만 값을 입력한 경우
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step03");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();
		Major major1 = new Major("컴퓨터 공학");
		em.persist(major1);

		Student student1 = new Student("Yoo");
		// 만약 연관관계의 주인이 아닌 곳에만 연관관계를 설정할 경우,
		List<Student> students = major1.getStudents();
		students.add(student1);
		em.persist(student1);

		// 학생2 저장
		Student student2 = new Student("Kang");
		// 만약 연관관계의 주인이 아닌 곳에만 연관관계를 설정할 경우,
		students.add(student2);
		em.persist(student2);

		tx.commit();
	}

	@Test
	public void testSaveOwnerWithOOP() { // 순수한 객체지향 코드에서 연관관계의 설정
		Major major1 = new Major("컴퓨터 공학");

		Student student1 = new Student("Yoo");
		student1.setMajor(major1);

		Student student2 = new Student("Kang");
		student2.setMajor(major1);

		List<Student> students = major1.getStudents();
		System.out.println("students.size : " + students.size());
	}

	@Test
	public void biWithPureOOP() { // 순수한 객체지향 코드에서 양방향 연관관계 적용
		Major major1 = new Major("컴퓨터 공학");
		List<Student> students = major1.getStudents();

		Student student1 = new Student("Yoo");
		student1.setMajor(major1); // 연관관계의 주인 방향에서 연관관계 설정
		students.add(student1); // 반대편에서도 연관관계 설정

		Student student2 = new Student("Kang");
		student2.setMajor(major1); // 연관관계의 주인 방향에서 연관관계 설정
		students.add(student2); // 반대편에서도 연관관계 설정

		System.out.println("students.size : " + students.size());
	}

	@Test
	public void biWithJPA() { // JPA를 통한 양방향 맵핑
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step03");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();

		Major major1 = new Major("국문학");
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
