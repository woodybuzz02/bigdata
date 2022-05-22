package com.basic;

import java.util.ArrayList;

public class ArrayListTest {

//	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		Mouse mini = new Mouse(10, "미니", "하와이", "구직중");
		Mouse mickey = new Mouse(25, "미키", "런던", "맨체스터 유나이티드");
		Mouse jay = new Mouse(15, "제이", "상하이", "텐센트");
		Mouse jerry = new Mouse(20, "제리", "도쿄", "라인");
		Mouse jamie = new Mouse(40, "제이미", "대한민국", "삼성");

		// 중복이 허용, 순서가 있음.
		// ArrayList 객체 생성, JS에서의 array와 같음.
		ArrayList<Mouse> list = new ArrayList<>();
		System.out.println(list.size());
		list.add(mini);
		list.add(mickey);
		list.add(jay);
		list.add(jerry);
		list.add(jamie); //<Mouse>를 하지 않았을 때 Object(최상위객체)를 타입을 받는다고 써있다. 그래서 누구든 다 들어갈 수 있다.
//		list.add(5);
		
		System.out.println("문자열"); 
		System.out.println(5); // 오버로딩
		
		// 리스트의 전체 길이(요소의 개수) 조회
		System.out.println(list.size());
		
		System.out.println(list.get(0).getName()); // Generic <Mouse>을 써서 형변환하지 않아도 됨.
		
//		Object o = list.get(0); 형변환
//		Mouse m = (Mouse) o;
		
		
		list.remove(2);
		
		for(Object object : list) {
			System.out.println((Mouse)object);
		}
		
	}

}
