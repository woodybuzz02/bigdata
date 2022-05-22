package com.basic;

public class App {

	public static void main(String[] args) {
		Mouse mini = new Mouse(10, "미니", "하와이", "구직중");
		Mouse mickey = new Mouse(25, "미키", "런던", "맨체스터 유나이티드");
		Mouse jay = new Mouse(15, "제이", "상하이", "텐센트");
		Mouse jerry = new Mouse(20, "제리", "도쿄", "라인");
		Mouse jamie = new Mouse(40, "제이미", "대한민국", "삼성");

		// Mouse 배열 생성 후 추가
//		Mouse[] mice = new Mouse[5];
		
		Mouse[] mice = {mini, mickey, jay, jerry, jamie};
		// 반복문으로 쥐들 조회
		for (Mouse mouse : mice) {
			System.out.println(mouse);
		}
		jay.setAddress("프랑스");
		jay.setCompany("루브르박물관");
		System.out.println(mice[2]);
		
		System.out.println(mice[3].getCompany());
		
		mice[2] = null;
		System.out.println(mice[2]);
		
		mice[4] = null;
		System.out.println(mice[4]);
		
		for (Mouse mouse : mice) {
			System.out.println(mouse);
		}
		
		System.out.println(mice.length);
	}

}
