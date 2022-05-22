package com.overriding;

import java.awt.datatransfer.SystemFlavorMap;

public class Mouse extends Animal{
	public String address;
	
	public void showAddr( ) {
		System.out.printf("%s는  %s에 살아", name, address);
	}
	
	@Override // 오버라이딩 - 재정의 : 상위 클래스의 메서드와 '같은' 메서드 이름, '같은' 인자 리스트
	public void showName() {
		System.out.println("내 이름은 비밀인데?");
	}
	
	// 오버로딩 - 중복정의 : '같은' 메서드 이름, '다른' 인자 리스트, 상위클래스와 관련이 없는 개념
	public void showName(String yourName) {
		System.out.printf("%s 안녕, 나는 %s야 \n", yourName, name);
	}
	
//	public void showAddr() {
//	System.out.println("내 주소는 비밀인데?");
//}
//
//public void showAddr(String yourAddr) {
//	System.out.printf("너는, %s에 사는구나? 나는 %s에 살아", yourAddr, address);
//}
	
}
