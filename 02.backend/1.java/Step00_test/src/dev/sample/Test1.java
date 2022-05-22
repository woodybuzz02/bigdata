package dev.sample;

public class Test1 {

	public static void main(String[] args) {
		int i;
		String star = "*";
		String space = " ";
		
		for(i=1;i<=7;i++) {
			if(i%2==0)
				continue;
			System.out.println(space.repeat((7-i)/2)+star.repeat(i)+space.repeat((7-i)/2));
		}
		if(i>7) {
			for(i=5;i>=1;i--) {
				if(i%2==0)
					continue;
				System.out.println(space.repeat((7-i)/2)+star.repeat(i)+space.repeat((7-i)/2));
			}
		}

	}

}
