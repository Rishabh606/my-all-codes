import java.util.Scanner;

public class tavas_and_saddas {

	public static Scanner scn = new Scanner (System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = scn.next();
		long a = ans1(s);
		System.out.println(a);
		long b = ans2(s);
		System.out.println(b);
		System.out.println(a+b+1);
	}

	private static long ans1(String s) {
		int n = s.length();
	
		return (long)(-2+Math.pow(2, n));
	}

	private static long ans2(String s) {
		int n = s.length();
		long rv = 0;
		for(int i=0;i<n;i++){
			if(s.charAt(i)=='4'){
				continue;
			}else{
				rv += (long)Math.pow(2, n-i-1);
			}
		}
		return rv;
	}

}
