package com.test;

public class App {

	public static void main(String[] args) {
	
		// 생성자 함수 이용
		
		System.out.println(new Person(40,"James",true,3).showPerson());
		
		Order shopping = new Order();
		
		// getter와 setter를 이용
		
		shopping.setAddress("서울시 영등포구 여의도동 20번지");
		shopping.setDate("2018년 3월 12일");	
		shopping.setId("abc123");
		shopping.setName("홍길순");
		shopping.setOrderProductNumber("PD0345-12");
		shopping.setOrderNumber(201803120001L);
//		이유는 값을 변수에 저장하기 전에 임시로 메모리에 저장되는데
//		이때 임시로 저장하기 위해 사용하는 기본 데이터 타입이 int 라서이다.
//		int 타입이 수용할수 있는 범위는 2147483647 까지 이기 때문에
//		허용범위를 초과하는 리터럴은 임시로 저장하는 과정에서 에러가 나는 것이다.
//		이것을 해결하려면 아래와 같이 리터럴 끝에 소문자나 대문자 L 을 붙여주면된다
		
//		System.out.println("주문번호 : "+shopping.getOrderNumber());
//		System.out.println("주문자 아이디 : "+shopping.getId());
//		System.out.println("주문 날짜 : "+shopping.getDate());
//		System.out.println("주문자 이름 : "+shopping.getName());
//		System.out.println("주문 상품 번호 : "+shopping.getOrderProductNumber());
//		System.out.println("배송 주소 : "+shopping.getAddress());
		
		System.out.println(shopping.showShoppingOrder());
		
	}

}
