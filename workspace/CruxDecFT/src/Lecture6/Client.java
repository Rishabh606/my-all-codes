package Lecture6;

public class Client {

	public static void main(String[] args) {
		// Part 1
		String str;
		
//		System.out.println(str);
		
		// Part 2
		str = "Hello";
		System.out.println(str.length());
		
		// Part 3 (No setChar to preserve immutability)
		System.out.println(str.charAt(0));
//		System.out.println(str.charAt(str.length()));
		System.out.println(str.charAt(str.length() - 1));
		
		// Part 4
		System.out.println(str.substring(2, 4));
		System.out.println(str.substring(2, 3));
		System.out.println(str.substring(2, 2));
//		System.out.println(str.substring(2, 1));
		System.out.println(str.substring(2, 5));
//		System.out.println(str.substring(2, 6));
		System.out.println(str.substring(2));
		
		// Part 5
		String s1 = "hi";
		String s2 = "bye";
		String s3 = s1 + s2;
		System.out.println(s1 + ", " + s2 + ", " + s3);
		String s4 = s1.concat(s2);
		System.out.println(s1 + ", " + s2 + ", " + s4);
		
		// Part 6
		System.out.println(str.indexOf("el"));
		System.out.println(str.indexOf("eL"));
		
		// Part 7
		System.out.println(str.startsWith("He"));
		System.out.println(str.startsWith("he"));
		
		// Part 8
		s1 = "Hello";
		s2 = s1;
		s3 = "Hello";
		s4 = new String("Hello");
		
		System.out.println((s1 == s2) + ", " + s1.equals(s2));
		System.out.println((s1 == s3) + ", " + s1.equals(s3));
		System.out.println((s1 == s4) + ", " + s1.equals(s4));
		
		printChars("hello");
		
		System.out.println("*******************************************");
		
		StringBuilder sb = new StringBuilder("abcd");
		System.out.println(sb);
		
		sb.setCharAt(2, 'e');
		System.out.println(sb);
		
		System.out.println(sb.length());
		
		sb.append("hello");
		System.out.println(sb);
		
		sb.deleteCharAt(0);
		System.out.println(sb);
		
		sb.insert(2,'z');
		System.out.println(sb);
		
		sb.insert(sb.length(), 'y');
		System.out.println(sb);
		
		s1 = sb.toString();
	}
	
	public static void printChars(String str){
		for(int i = 0; i < str.length(); i++){
			char ch = str.charAt(i);
			System.out.println(ch);
		}
	}
	
	

}
