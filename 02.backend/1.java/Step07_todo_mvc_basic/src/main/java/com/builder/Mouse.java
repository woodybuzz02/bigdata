package com.builder;

public class Mouse {
	private String name;
	private String address;
	private String color;
	private int age;
	private int height; // 키
	
	
	public Mouse(Builder builder) {
		this.name = builder.name;
		this.address = builder.address;
		this.color = builder.color;
		this.age = builder.age;
		this.height = builder.height;
	}

// 점층적 패턴	
//	public Mouse() {
//		
//	}
//	
//	public Mouse(String name) {
////		this.name = name; // this : 인스턴스 자기 자신
////		this();// this() : 생성자
//		this(name, null, null, 0, 0);
//	}
//	
//	public Mouse(String name, String address) {
//		this(name, address, null, 0, 0);
//	}
//	
//	public Mouse(String name, String address, String color, int age, int height) {
//		super();
//		this.name = name;
//		this.address = address;
//		this.color = color;
//		this.age = age;
//		this.height = height;
//	}

	
	@Override
	public String toString() {
		return "Mouse [name=" + name + ", address=" + address + ", color=" + color + ", age=" + age + ", height="
				+ height + "]";
	}

	// 별도의 정적 클래스 생성
	public static class Builder {
		private String name;
		private String address;
		private String color;
		private int age;
		private int height;
		
		// name이 필수로 작성해야하는 필드일 경우
		public Builder(String name) {
			this.name = name;
		}
		
		public Builder address(String address) {
			this.address = address;
			return this;
		}
		
		public Builder color(String color) {
			this.color = color;
			return this;
		}
		public Builder age(int age) {
			this.age = age;
			return this;
		}
		public Builder height(int height) {
			this.height = height;
			return this;
		}
		
		public Mouse build() {
			return new Mouse(this);
		}
	}
	
	
}
