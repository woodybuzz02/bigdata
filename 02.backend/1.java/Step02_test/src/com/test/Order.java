package com.test;

public class Order {
	long orderNumber;
	String id;
	String date;
	String name;
	String orderProductNumber;
	String address;
	public long getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(long orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOrderProductNumber() {
		return orderProductNumber;
	}
	public void setOrderProductNumber(String orderProductNumber) {
		this.orderProductNumber = orderProductNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String showShoppingOrder() {
		return "주문번호 : "+ orderNumber +
		"\n주문자 아이디 : "+ orderNumber +
		"\n주문 날짜 : "+ date +
		"\n주문자 이름 : "+ name +
		"\n주문 상품 번호 : "+ orderProductNumber +
		"\n배송 주소 : "+ address ;
		}
	
	// setter 메서드를 사용하는 이유 : 필드의 값을 무분별하게 설정하는 것을 막기 위함이다.
	// private 제어자 쓰는 이유 : 외부에서의 무분별한 접근 및 수정을 막기 위해서, 효과 : 실제 값의 접근은 해당 클래스 자신만 접근할 수 있음, 정보 은닉(information hiding)효과
	
}
