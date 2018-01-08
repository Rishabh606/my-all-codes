package practise2;

import java.util.ArrayList;
import java.util.Scanner;

public class practise_6 {
	public static Scanner scn = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(findtriple_a("cbaadaaabefaaaag", 0));
		//countoncetriple_a("cbaadaaabefaaaag", 0, 0);
//		String str = scn.nextLine();
//		decoder(str,"");
	//	System.out.println(in_brckt_print(str));
		//System.out.println(obstr(str));
		ArrayList<Character> br = new ArrayList<>();
		System.out.println(bal_bkt("((a + b))) + c)", 0,br));
	//	System.out.println(sumSS(str));
		
		System.out.println();
	}
	public static int[] takeinput() {
		int[] rv = null;
		int n = scn.nextInt();
		rv = new int[n];
		for (int i = 0; i < n; i++) {
			rv[i] = scn.nextInt();
		}
		return rv;
	}

	public static int findtriple_a(String s, int i) {
		if (i == s.length()) {
			return 0;
		}
		int sum = 0;

		sum = sum + findtriple_a(s, i + 1);
		if (i < 2) {
			return sum;
		}
		if (s.charAt(i) == 'a' && s.charAt(i - 1) == 'a' && s.charAt(i - 2) == 'a') {
			return 1 + sum;
		} else
			return sum;
	}

	public static void countoncetriple_a(String s, int i, int sum) {
		if (i >= s.length() - 2) {
			System.out.println(sum);
			return;
		}
		if (s.charAt(i) == 'a' && s.charAt(i + 1) == 'a' && s.charAt(i + 2) == 'a') {
			countoncetriple_a(s, i + 3, sum + 1);
		} else {
			countoncetriple_a(s, i + 1, sum);
		}
	}
	public static void decoder(String str,String osf){
		if(str.length() == 0){
			System.out.println(osf+"");
			return;
		}
		char ch1 = cheatsheet((int) str.charAt(0)-'0');
		decoder(str.substring(1),osf+ch1);
		if(str.length()<2){
			return;
		}
		int a = Integer.parseInt(str.substring(0, 2));
		if(a>26){
			return;
		}
		char ch2 = cheatsheet(a);
		decoder(str.substring(2),osf+""+ch2);
	}
	public static char cheatsheet(int i){
		char[] codes = { (char)0, 'a', 'b', 'c','d','e','f', 'g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		char a = codes[i];
		return a;
	}
	public static boolean obstr(String str){
		boolean istrue = false;
		if(str.length() == 0){
			return true;
		}
		if(str.charAt(0)=='a'){
			istrue = obstr(str.substring(1)); 
		}
		else if(str.length()-1>=2 && (str.charAt(0)=='b'&& str.charAt(1)=='b')){
			istrue=obstr(str.substring(2));
		}
		return istrue;
	}
	public static String in_brckt_print(String str){
		String in_bkt="";
		if(str.length() == 0){
			return null;
		}
		if(str.charAt(0)=='('){
			int i = 0;
			while(str.charAt(i)!=')'||str.length()> 0){
				i++;
				if(str.charAt(i)==')'||str.length()== 0){
					break;
				}
				in_bkt = in_bkt + str.charAt(i);
			}
			return in_bkt;
		}
		in_bkt = in_brckt_print(str.substring(1));
		return in_bkt;
	}
	//((a + b))) + c)
	public static boolean bal_bkt(String str, int i, ArrayList<Character> arr){
		boolean isbal = false;
			if(i == str.length()){
				if(arr.size() != 0){
					return false;
				} else {
					return true;
				}
			}

		if(str.charAt(i)=='}'){
			if(arr.size() == 0){
				return false;
			}
			if(arr.get(arr.size()-1)!='{'){
				return false;
			}
				arr.remove(arr.size()-1);
			}
		else if(str.charAt(i)==']'){
			if(arr.size() == 0){
				return false;
			}
			if(arr.get(arr.size()-1)!='['){
				return false;
			}
				arr.remove(arr.size()-1);
		}
		else if(str.charAt(i)==')'){
			if(arr.size() == 0){
				return false;
			}
			if(arr.get(arr.size()-1)!='('){
				return false;
			}
				arr.remove(arr.size()-1);
		}
		else if(str.charAt(i)=='{'||str.charAt(i)=='['||str.charAt(i)=='('){
			arr.add(str.charAt(i));
		}
		isbal = bal_bkt(str,i+1, arr);
		return isbal;
	}
	public static int sumSS(String s1){
		int sum = 0;
		if (s1.length() == 0) {
			return 1;
		}
        String ros = s1.substring(1);
         sum =  2*sumSS(ros);
       return sum;
	}
}
