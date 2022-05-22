package com.todo.mvc;

public class App {

	public static void main(String[] args) {
		/*
		* var, let, const : 해당 키워드 뒤에 쓰는 이름이 변수임을 명시
		* const a = 5;
		*/
		int studentId1 = 5;
		int studentId2 = 10;
			
//		int[] studentIDs = new int[3]; // 길이가 3인 빈(empty) 배열
//		System.out.println(studentIDs.length); // 해당 배열(변수)의 길이(size) 출력

		// 길이가 2인 배열에 정수형 값 2개를 한 번에 초기화(할당)
		int[] studentIDs = new int[] {studentId1, studentId2};
	 
		System.out.println(studentIDs.length);

		System.out.println(studentIDs); // 주소값
		
		// 배열의 요소(element) : 배열 내부에 있는 값
		// 배열의 요소에 접근하는 방법 : 인덱스 활용
		System.out.println(studentIDs[0]);
		System.out.println(studentIDs[1]);
//		System.out.println(studentIDs[2]); //런타임 에러, 문법적으로 오류가 없어 컴파일러가 오류를 못잡음.
		
		// 길이가 3인 비어있는 문자열 배열
		String[] studentNames = new String[3];
		
		//배열에 값 추가
		studentNames[0] = "신짱아";
		studentNames[1] = "신짱구";
		studentNames[2] = "김철수";
		
		//forEach() : 배열의 요소를 : 기준으로 좌측 변수에 반복할 때마다 새롭게 할당
		for (String studentName : studentNames) {
			System.out.println(studentName);
		}
		
		// 기본적인 for 반복문, i(index)값 활용하여 배열 요소 출력
		for (int i = 0; i < studentNames.length; i++) {
			System.out.println(studentNames[i]);
		}
	}

}
