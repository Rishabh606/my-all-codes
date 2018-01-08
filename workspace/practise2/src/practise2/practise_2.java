package practise2;

import java.util.ArrayList;
import java.util.Arrays;

public class practise_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,3,7};
		int[] arr1 = {1,3,4,2,5};
		ArrayList<Integer> br2 = new ArrayList<Integer>();
		int[] arr2 = new int[1];
		//Arrays.asList(arr);
		// snakeladder(15, 3, "3");
		// System.out.println(cmp(3, 3, 0, 0));
		// pmp(3, 3, 0, 0, "0");
		// System.out.println( gmp(3, 3, 0, 0));
		// printperm("abc","");
		//printSS("abc", "");
		//printPSS(arr, arr2);
	//	System.out.println(keypadcomb("abcd"));
		System.out.println(getSS("abcd"));
		//sumpair(arr1,5);
	}
	
	public static void printPSS(int[] str, int[] osf) {
		if (str.length == 0) {
			System.out.print("[");
			for(int i = 0; i<osf.length;i++){
				if(osf[i]!=0){
				System.out.print(osf[i]+", ");
				}
			}
				System.out.println("End]");
			/*Arrays.asList(osf);
			System.out.println(osf);*/
			return;
		}
		int ch = str[0];
	//	ArrayList<Integer> br2 = new ArrayList<Integer>();
		int[] arr = new int[str.length-1];
		for(int i = 0; i<str.length-1;i++){
			arr[i] = str[i+1] ;
		}
		printPSS(arr, osf);
		int[] arr2 = new int[osf.length+1];
		arr2[0] = ch;
		for(int i = 1; i<osf.length;i++){
			arr2[i] = osf[i-1];
		}
		printPSS(arr, arr2);
	}
	/*public static ArrayList<String> keypadcomb(String s1){
		for(int i = 0; i<s1.length();i++){
			getCode('i');
		}
	}*/
	public static String getCode(char ch) {
		String[] codes = { ",;", "abc", "def", "ghi", "jkl", "mno", "pqr", "stu", "vwx", "yz" };
		return codes[ch - '0'];
	}
	public static void sumpair(int[] arr,int key){
		Arrays.sort(arr);
		int left = 0,right = arr.length-1;
		int flag = -1;
		while(left<=right){
			int middle = (arr[left]+arr[right]);
			if(key==middle){
				System.out.println(arr[left]+" and "+arr[right]);
				flag = 1;
				left++;
				right--;
			}
			else if(key<middle){
				right--;
			}
			else
			{
				left++;
			}
		}
		if (flag == -1){
			System.out.println(-1);
		}
	}
	 public static ArrayList<String> getSS(String s1){
	        if (s1.length() == 0) {
				ArrayList<String> br = new ArrayList<>();
				br.add("");
				return br;
			}
	        char ch = s1.charAt(0);
	        String ros = s1.substring(1);
	        ArrayList<String> myres = new ArrayList<>();
	        ArrayList<String> recres = getSS(ros);
	        for(int i = 0; i<recres.size();i++){
	            myres.add(recres.get(i));
	            myres.add(recres.get(i)+ch);
	        }
	       return myres;
	    }
}
