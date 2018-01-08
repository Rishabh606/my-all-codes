import java.util.ArrayList;
import java.util.Scanner;

public class recur3 {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = scn.nextLine();
		// System.out.println(getSS(s1));
		// System.out.println(getSSascii(s1));
		//System.out.println(permutSS(s1));
		//System.out.println(keypadcomb(s1));
		//System.out.println(countKeypadCombinations(s1));
		printKeypadCombinations(s1,"");
	//	int curr = scn.nextInt();
	//	int end = scn.nextInt();
		//ArrayList<String> br= snakeladder(end,curr);
	//	System.out.println(br);
	//	printSSascii("abc", "");
		//printPerm("abc", "");
	}

	public static ArrayList<String> getSS(String s1) {
		if (s1.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;

		}
		char ch = s1.charAt(0);
		String ros = s1.substring(1);

		ArrayList<String> recres = getSS(ros);
		ArrayList<String> myres = new ArrayList<>();

		for (int i = 0; i < recres.size(); i++) {
			myres.add(recres.get(i));
			myres.add(ch + recres.get(i));
		}

		return myres;
	}

	public static ArrayList<String> getSSascii(String s1) {
		if (s1.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;

		}
		char ch = s1.charAt(0);
		String ros = s1.substring(1);

		ArrayList<String> recres = getSSascii(ros);
		ArrayList<String> myres = new ArrayList<>();

		for (int i = 0; i < recres.size(); i++) {
			myres.add(recres.get(i));
			myres.add(ch + recres.get(i));
			myres.add((int) ch + recres.get(i));
		}

		return myres;
	}

	public static ArrayList<String> permutSS(String s1) {
		if (s1.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;

		}
		char ch = s1.charAt(0);
		String ros = s1.substring(1);

		ArrayList<String> recres = permutSS(ros);
		ArrayList<String> myres = new ArrayList<>();

		for (int i = 0; i < recres.size(); i++) {
			String mystr = recres.get(i);
			for (int j = 0; j <= mystr.length(); j++) {
				myres.add(mystr.substring(0, j) + ch + mystr.substring(j));
			}
		}

		return myres;
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
		String[] codes = { ",;", "abc", "def", "ghi", "jkl", "mno", "pqr", "stu", "vwx", "yz" };
		return codes[ch - '0'];
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
	 public static void printKeypadCombinations(String s1,String osf){
		 if (s1.length() == 0) {
			 System.out.println(osf);
				return;
			}
		 char ch = s1.charAt(0);
	      String ros = s1.substring(1);
	      String chCode = getCode(ch);
	      printKeypadCombinations(ros, osf);
	      for(int i = 0; i<chCode.length();i++){
	      printKeypadCombinations(ros, osf+chCode.charAt(i));
	      }
	 }
	public static ArrayList<String> snakeladder(int end,int curr){
		if(curr == end){
			ArrayList<String> br = new ArrayList<>();
			br.add("\n");
			return br;
		}
				if(curr>end){
					ArrayList<String> br = new ArrayList<>();
					return br;
				}
				ArrayList<String> myres = new ArrayList<>();	
				for(int dice = 1; dice<=6;dice++)
				{
					ArrayList<String> recres = snakeladder(end,curr+dice);
					for(int i = 0; i<recres.size();i++){
						myres.add(dice+recres.get(i));
					}
				}
				return myres;
	}
	public static void printSS(String str, String osf){
		if(str.length() == 0){
			System.out.print(osf+"	");
			return;
		}
		
		char ch = str.charAt(0);
		String ros = str.substring(1);
		
		printSS(ros, osf + "");
		printSS(ros, osf + ch);
	}
	public static void printSSascii(String str, String osf){
		if(str.length() == 0){
			System.out.println(osf);
			return;
		}
		
		char ch = str.charAt(0);
		String ros = str.substring(1);
		printSSascii(ros, osf + "");
		printSSascii(ros, osf + ch);
		printSSascii(ros, osf +(int)ch);
	}
	public static void printPerm(String str, String osf){
		if(str.length() == 0){
			System.out.println(osf);
			return;
		}
		for(int i =0; i<str.length();i++){
		char ch = str.charAt(0);
		String ros = str.substring(1);
		
		printPerm(ros, osf + "");
		printPerm(ros, osf + ch);
		}
	}
}