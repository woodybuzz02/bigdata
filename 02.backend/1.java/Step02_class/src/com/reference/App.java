package com.reference;

public class App {

	public static void main(String[] args) {
		// custom type
		Student park = new Student("박서준", 20);
		Student han = new Student("한소희", 20);
		
/*new라는 키워드를 사용해서 인스턴스를 생성하면 heap메모리(오른쪽 부분)에 실제 박서준(인스턴스)가 자리잡음
 * 그리고 그 박서준의 위치(Student@762efe5d)값을 park라고 하는 '참조 변수'에 할당
 * 참조변수park는 자신이 가진 주소Student@762efe5d을 가지고 자신의 실제 인스턴스 값에 찾아갈 수 있다.(참조한다.)
 * 참조변수는 하나의 주소값만 저장할 수 있다.
 * 사용이 끝나면 자바가 가비지 컬렉터를 사용하여 자동으로 메모리 해제해준다.
 */
		
		System.out.println(park.getAge() + park.getName());
		System.out.println(han.getAge() + han.getName());
		System.out.println(park);
		
		park = han;
		System.out.println(park.getName());
	}

}
