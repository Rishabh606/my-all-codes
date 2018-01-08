package practise2;

import java.util.Scanner;

public class hourrank19 {
	public static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		whatodds();
	}

	public static void whatodds() {
		int n = in.nextInt();
		int[] s = new int[n];
		for (int s_i = 0; s_i < n; s_i++) {
			s[s_i] = in.nextInt();
		}
		int count = 0;
		int sum = 0;
		for (int i = 0; i < s.length; i++) {
			sum = 0;
			for (int j = i; j < s.length; j++) {
				sum = sumer(s,i,j);
				if(sum%2==0&&sum!=0){ 
					count++;
				}
			}
			
			
		}
		System.out.println(count);
	}
	public static int sumer(int[]s, int start, int end){
		int retval = 0;
		int sum = 0;
		for(int i = 0; i<s.length;i++){
			if(i<start||i>end){
				sum = sum + s[i];
			}
		}
		return retval;
	}

}
