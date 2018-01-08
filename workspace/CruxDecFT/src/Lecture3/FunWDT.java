package Lecture3;

public class FunWDT {

	public static void main(String[] args) {
		byte b = 10;
		short s = 10;
		int i = 10;
		long lg = 10;

		lg = i;
		lg = s;
		lg = b;

		// i = lg;
		i = s;
		i = b;

//		s = lg;
//		s = i;
		s = b;
		
//		b = lg;
//		b = i;
//		b = s;
		
		// Part2
		b = 10;
		b = 127;
//		b = 128;
		b = (byte)128;
		System.out.println(b);
		
		// Part 3
//		System.out.println(10000000000);
		System.out.println(10000000000L);
		
		// Part 4
		float ft;
		
//		ft = 5.5;
		ft = 5.5f;
		
		double db = 5.5;
		
		// Part 5
		ft = i;
//		i = ft;
		i = (int)ft;
		
		// Part 6
//		if(i){
//			System.out.println("hi");
//		} else {
//			System.out.println("bye");
//		}
		
		if(i != 0){
			System.out.println("hi");
		} else {
			System.out.println("bye");
		}
		
		boolean bn = true; // or false
		
//		bn = (boolean)1;
		
		
		// Part 7
		char ch = '0';
		System.out.println(ch);
		i = ch;
		System.out.println(i);
		
		ch = 97;
		System.out.println(ch);
		
//		ch = 66000;
		ch = (char)(Math.pow(2, 16) + 97);
		System.out.println(ch);
		
//		ch = ch + 2;
		i = ch + 2;
		ch = (char)(ch + 2);
		
		System.out.println(ch);
		System.out.println(i);
		
		// Part 8
		System.out.println(10 + 20 + "Hello" + 10 + 20);
		System.out.println(2 + ' ' + 5);
		System.out.println(2 + " " + 5);
		System.out.println("Hello" + '\t' + "World");
		System.out.println("Hello" + "\t" + "World");
		
	}

}
