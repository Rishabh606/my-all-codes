package Lecture10;

public class testOopClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(testOop.count);
		
		testOop a = new testOop();
		a.data = 10;
		a.dis
		System.out.println(a.count);
		testOop b = new testOop();
		b.data = 20;
		System.out.println(b.count);
		System.out.println(a.count);
		a.count++;
		System.out.println(a.count);
		System.out.println(b.count);

	}

}
