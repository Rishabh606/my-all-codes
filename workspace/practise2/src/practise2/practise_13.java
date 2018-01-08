package practise2;

import java.util.*;
public class practise_13 {

	public static Scanner scn = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = scn.next();
		 System.out.println(countPermSS(s));
		 printperm(s, "");
		ArrayList<String> br =	PermSS(s);
	    System.out.println(br);	
	   
	}
	 public static int countKeypadCombinations(String s1){
	      int sum = 0;
		      if (s1.length() == 0) {
					return 1;
				}
		      char ch = s1.charAt(0);
		      String ros = s1.substring(1);
		      String chCode = getCode(ch);
		      sum = chCode.length()*countKeypadCombinations(ros);
		      return sum;
	  }
	  public static void printKeypadCombinations(String str,String osf){
	 
		  if(str.length()==0){
			  System.out.println(osf);
			  return;
		  }

			char ch = str.charAt(0);
			String ros = str.substring(1);
			String chCode = getCode(ch);

		
				for (int j = 0; j < chCode.length(); j++) {
					printKeypadCombinations(ros,osf +""+ chCode.charAt(j));
				}
				
	  }
	  public static ArrayList<String> keypadcomb(String s1) {
			if (s1.length() == 0) {
				ArrayList<String> br = new ArrayList<>();
				br.add("");
				return br;
			}

			char ch = s1.charAt(0);
			String ros = s1.substring(1);
			String chCode = getCode(ch);

			ArrayList<String> recres = keypadcomb(ros);
			ArrayList<String> myres = new ArrayList<>();

			for (int i = 0; i < recres.size(); i++) {
				for (int j = 0; j < chCode.length(); j++) {
					myres.add(chCode.charAt(j) + recres.get(i));
				}
			}

			return myres;
		}

		public static String getCode(char ch) {
			String[] codes = {"", "abc", "def", "ghi", "jkl", "mno", "pqr", "stu", "vwx", "yz", ",;" };
			return codes[ch - '0'];
		}
		public static void printperm(String str, String osf) {
			if (str.length() == 0) {
				System.out.println(osf);
				return;
			}
			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				String ros = null;
				ros = str.substring(0, i) + "" + str.substring(i + 1);
				printperm(ros, ch + osf);

			}

		}
		public static ArrayList<String> PermSS(String s1) {
			if (s1.length() == 0) {
				ArrayList<String> br = new ArrayList<>();
				br.add("");
				return br;
			}
			char ch = s1.charAt(0);
			ArrayList<String> recres = PermSS(s1.substring(1));
			ArrayList<String> myres = new ArrayList<>();
			for (int i = 0; i < recres.size(); i++) {
				String mystr = recres.get(i);
				for (int j = 0; j <= mystr.length(); j++) {
					myres.add(mystr.substring(0, j) + ch + mystr.substring(j));
				}
			}
			return myres;
		}
		public static int countPermSS(String s1) {
			
			return   fact(s1.length());
		}
		public static int fact(int a){
			if(a==1){
				return 1;
			}
			return a*fact(a-1);
		}
	
}
