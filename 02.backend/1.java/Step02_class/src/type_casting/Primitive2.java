package type_casting;

public class Primitive2 {

	public static void main(String[] args) {
		int a = 1030299770;
		byte b = (byte) a;
		System.out.println(b); //데이터손실됨.
		
		int c = 127;
		byte d = (byte) c;
		System.out.println(d); //데이터의 손실이 발생하지 않음.
		
		int f = 128;
		byte g = (byte)f;
		System.out.println(g);

	}

}
