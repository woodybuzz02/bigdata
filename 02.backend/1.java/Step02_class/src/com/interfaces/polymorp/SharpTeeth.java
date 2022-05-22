package com.interfaces.polymorp;

public class SharpTeeth implements Bitable{

	@Override
	public void bite(String food) {
		System.out.println("나는 육식상어 " + food + "우걱우걱");
	}
	
}
