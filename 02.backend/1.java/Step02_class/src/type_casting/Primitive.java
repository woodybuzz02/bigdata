package type_casting;

public class Primitive {

	public static void main(String[] args) {
		byte a = 50;
		int b = a; // 더 작은 byte타입에서 더 큰 int 타입으로의 자동 형변환.
		
		char c = 'A';
		int d = c;
		
		int e = 100;
		float f = e;
		
		float g = 10.5f;
		double h = g;
		
//		long i = f; // 자동 형 변환 불가
	}

}
