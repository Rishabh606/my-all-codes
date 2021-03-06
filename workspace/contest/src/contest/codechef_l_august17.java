package contest;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Scanner;

public class codechef_l_august17 {

	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws java.lang.Exception {
		// your code goes here
		// int n = scn.nextInt();
		int t = scn.nextInt();
		// long[] arr= takeinput(n);
		/*
		 * for(int i = 0; i<t;i++){ int [] arr = takeinput(); rainbow(arr); }
		 */
		/*
		 * for (long i = 0; i < t; i++) { int n = scn.nextInt(); int D =
		 * scn.nextInt(); long[] arr = takeinput(n); moverNew(arr, D); }
		 */
		/*
		 * for (int i = 0; i < t; i++) { Greedy_Candidates(); }
		 */
		/*
		 * for (int i = 0; i < t; i++) { palindromic_game(); }
		 */
		/*
		 * for(int i = 0;i<t;i++){ hill_jump(arr); }
		 */
		/*
		 * for (int i = 0; i < t; i++) { fibonacci(); }
		 */
		for (int i = 0; i < t; i++) {
			walks_on_binary();
		}
	}

	public static long[] takeinput(int n) {
		long[] rv = null;
		// long n = scn.nextInt();
		rv = new long[n];
		for (int i = 0; i < n; i++) {
			rv[i] = scn.nextLong();
		}
		return rv;
	}

	public static void rainbow(int[] arr) {
		int[] strg = new int[8];
		int left = 0;
		int right = arr.length - 1;
		boolean flag = true;
		while (left <= right) {
			// System.out.println("35");
			if (arr[left] != arr[right]) {
				flag = false;
				// System.out.println(arr[left]);
				break;
			}
			int ch = arr[left + 1] - arr[left];
			if (ch > 1) {
				flag = false;
				// System.out.println("44");
				break;
			}
			if (arr[left] < 8 && arr[left] > 0) {
				strg[arr[left]] = 1;
				// System.out.println("49");
			} else {
				flag = false;
				// System.out.println("52");
				break;
			}
			left++;
			right--;
		}
		for (int i = 1; i < strg.length && flag == true; i++) {
			if (strg[i] != 1) {
				// System.out.println("60");
				flag = false;
				break;
			}
		}
		// System.out.println(flag);
		if (flag == false) {
			System.out.println("no");
		} else {
			System.out.println("yes");
		}
	}

	public static void mover(long[] arr, int D) {
		long flag = 0;
		long total = 0, prevavg = 0;
		for (int i = 0; i < D && flag == 0; i++) {
			long count = 0, nume = 0;
			for (int j = i; j < arr.length; j = j + D) {
				count++;
				nume += arr[j];
			}
			if (nume % count != 0) {
				flag = 1;
				break;
			}
			long avg = nume / count;
			if (i > 0 && prevavg != avg) {
				flag = 1;
				break;
			}
			prevavg = avg;
			for (int j = i; j < arr.length; j = j + D) {
				long diff = arr[j] - avg;
				if (diff > 0) {
					total += diff;
				}
			}
		}
		if (flag == 1) {
			System.out.println("-1");
		} else {
			System.out.println(total);
		}
	}

	public static void moverNew(long[] arr, int d) {
		long flag = 0;
		long total = 0;
		long count = 0, nume = 0;
		for (int j = 0; j < arr.length; j++) {
			count++;
			nume += arr[j];
		}
		if (nume % count != 0) {
			flag = 1;
		}
		long avg = nume / count;
		for (int j = 0; j < arr.length - d && flag == 0; j++) {
			if (arr[j] > avg) {
				long diff = arr[j] - avg;
				arr[j] -= diff;
				arr[j + d] += diff;
				total += diff;
			} else {
				long diff = avg - arr[j];
				arr[j] += diff;
				arr[j + d] -= diff;
				total += diff;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != avg) {
				flag = 1;
				break;
			}
		}
		if (flag == 1) {
			System.out.println("-1");
		} else {
			System.out.println(total);
		}
	}

	public static void Greedy_Candidates() {
		int N = scn.nextInt();
		int M = scn.nextInt();
		long[] minSalary = takeinput(N);
		long[] offeredSalary = new long[M];
		long[] maxJobOffers = new long[M];
		long[] Jobtaken = new long[M];
		for (int i = 0; i < M; i++) {
			offeredSalary[i] = scn.nextLong();
			maxJobOffers[i] = scn.nextLong();
		}
		int[][] qual = new int[N][M];
		for (int i = 0; i < N; i++) {
			String inp = scn.next();
			for (int j = 0; j < M; j++) {
				qual[i][j] = inp.charAt(j) - 48;
			}
		}
		long count = 0;
		long TS = 0;
		for (int i = 0; i < N; i++) {
			long max = minSalary[i] - 1;
			int pos = -1;
			for (int j = 0; j < M; j++) {
				if (qual[i][j] == 1) {
					if (max < offeredSalary[j]) {
						if (maxJobOffers[j] > Jobtaken[j]) {
							pos = j;
							max = offeredSalary[j];
						}
						// max = j;
					}
				}
			}
			if (pos != -1) {
				Jobtaken[pos]++;
				count++;
				TS += offeredSalary[pos];
			}
		}
		int UC = 0;
		for (int j = 0; j < Jobtaken.length; j++) {
			if (Jobtaken[j] > 0) {
				UC++;
			}
		}
		int NUC = M - UC;
		System.out.println(count + " " + TS + " " + NUC);
	}

	public static void palindromic_game() {
		String s = scn.next();
		String t = scn.next();
		int flag = 0;
		HashMap<Character, Integer> rps = new HashMap<Character, Integer>();
		HashMap<Character, Integer> rpt = new HashMap<Character, Integer>();
		HashMap<Character, Integer> comm = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			if (rps.containsKey(s.charAt(i))) {
				int count = rps.get(s.charAt(i));
				rps.put(s.charAt(i), count + 1);
			} else {
				rps.put(s.charAt(i), 1);
			}
			if (rpt.containsKey(t.charAt(i))) {
				int count = rpt.get(t.charAt(i));
				rpt.put(t.charAt(i), count + 1);
			} else {
				rpt.put(t.charAt(i), 1);
			}
		}
		for (char key : rps.keySet()) {
			if (rpt.containsKey(key)) {
				comm.put(key, Math.min(rpt.get(key), rps.get(key)));
			}
		}

		for (int i = 0; i < s.length(); i++) {
			if (!rpt.containsKey(s.charAt(i))) {
				if (rps.get(s.charAt(i)) > 1) {
					flag = 1;
					break;
				} else {
					if (comm.size() == rpt.size()) {
						flag = 1;
						break;
					}
				}
			}
		}

		if (flag == 0) {
			System.out.println("B");
		} else {
			System.out.println("A");
		}
	}

	public static void hill_jump(long[] arr) {
		int type = scn.nextInt();
		if (type == 1) {
			int pos = scn.nextInt() - 1;
			int jumps = scn.nextInt();
			int j = 0;
			for (int i = 0; i < jumps; i++) {
				j = pos + 1;
				/*
				 * if(j>=arr.length||pos>arr.length-1){ break; }
				 */
				while (j < arr.length && arr[j] <= arr[pos] && j - pos <= 100) {
					j++;
				}
				/*
				 * if(j>=arr.length||pos>arr.length-1){ break; }
				 */
				if (j < arr.length && j - pos <= 100 && arr[j] > arr[pos]) {
					pos = j;
				}
				if (j - pos > 100 || j > arr.length - 1) {
					break;
				}
			}
			/*
			 * if(pos>arr.length||j>arr.length-1){ pos = arr.length-1; }
			 */
			System.out.println(pos + 1);
		} else {
			int start = scn.nextInt() - 1;
			int end = scn.nextInt() - 1;
			long diff = scn.nextInt();
			for (int i = start; i <= end; i++) {
				arr[i] += diff;
			}
		}
	}

	public static void fibonacci() {
		int n = scn.nextInt();
		long[] arr = takeinput(n);
		String s = "";
		for (int i = 0; i < arr.length; i++) {
			s += arr[i];
		}
		HashMap<String, Integer> map = new HashMap<>();
		int res = fib(s, map);
		System.out.println(res);
	}

	public static int fib(String s, HashMap<String, Integer> map) {
		int count = 0;
		StringBuilder sb = new StringBuilder(s);
		for (int i = 0; i < s.length() - 1; i++) {
			if (sb.charAt(i) - '0' > 0 && sb.charAt(i + 1) - '0' > 0) {
				sb.setCharAt(i, (char) (sb.charAt(i) - 1));
				sb.setCharAt(i + 1, (char) (sb.charAt(i + 1) - 1));
				if (i < s.length() - 2) {
					sb.setCharAt(i + 2, (char) (sb.charAt(i + 2) + 1));
					String ps = sb.toString();
					if (!map.containsKey(ps)) {
						map.put(ps, 1);
						count += fib(ps, map);
					}
					sb.setCharAt(i + 2, (char) (sb.charAt(i + 2) - 1));
				}
				if (i == s.length() - 2) {
					sb.append('1');
					String ps = sb.toString();
					if (!map.containsKey(ps)) {
						map.put(ps, 1);
						count += fib(ps, map);
					}
					sb.deleteCharAt(sb.length() - 1);
				}
				sb.setCharAt(i, (char) (sb.charAt(i) + 1));
				sb.setCharAt(i + 1, (char) (sb.charAt(i + 1) + 1));
			}
		}
		return count + 1;
	}


	public static void walks_on_binary() {
		int N = scn.nextInt();
		int Q = scn.nextInt();
		BigInteger X = BigInteger.valueOf(0);
		//BigInteger count = BigInteger.valueOf(1);
		//BigInteger count = BigInteger.valueOf(1);
		//HashMap <BigInteger, Integer> map = new HashMap<BigInteger, Integer>();
		//String count= "0";
		HashMap <String, Integer> map = new HashMap<String, Integer>();
		map.put("0", 1);
		for (int i = 0; i < Q; i++) {
			char inp = scn.next().charAt(0);
			if (inp == '!') {
				int C = scn.nextInt();
				 BigInteger big = BigInteger.valueOf(2).pow(C).add(X);//
				 big = big.mod(BigInteger.valueOf(2).pow(N));//
				// X = (int) ((X + Math.pow(2, C)) % Math.pow(2, N));
				String num = big.toString(2);
				X = big;
				while(num.length()<N){
					num='0'+num;
				}
				//BigInteger curr = BigInteger.valueOf(0);
				String curr = "0";
				for (int j = 0; j < num.length(); j++) {
					if(num.charAt(j)=='0'){
						//curr = curr.multiply(BigInteger.valueOf(2)).add(BigInteger.ONE);//
						String one = "1";
						curr = add(curr,curr);
						curr = add(curr,one);
						for(int k = 0; k<curr.length()-1;k++){
							if(curr.charAt(k)!='0'){
								curr = curr.substring(k);
								break;
							}
							if(k==curr.length()-2){
								curr = curr.substring(curr.length()-2);
							}
						}
						if(!map.containsKey(curr)){
							map.put(curr, 1);
							//count= add(count,"1");
						}
					}else{
						//curr = curr.multiply(BigInteger.valueOf(2)).add(BigInteger.ONE).add(BigInteger.ONE);//
						String two = "10";
						curr = add(curr,curr);
						curr = add(curr,two);
						for(int k = 0; k<curr.length()-1;k++){
							if(curr.charAt(k)!='0'){
								curr = curr.substring(k);
								break;
							}
							if(k==curr.length()-2){
								curr = curr.substring(curr.length()-2);
							}
						}
						if(!map.containsKey(curr)){ 
							map.put(curr, 1);
							//count= add(count,"10");
						}
					}
				}
			}else{
				//System.out.println(new BigInteger(count, 2));
				System.out.println(map.size());
			}
		}
	}

	public static String add(String a, String b) {
		//assume a=b
		String res = "";
		while(a.length()>b.length()){
			b ="0"+b;
		}
		while(b.length()>a.length()){
			a = "0"+a;
		}
		int carry = 0;
		for(int i = 0;i<a.length();i++){
			if(a.charAt(a.length()-1-i)=='1' && b.charAt(b.length()-1-i)=='1'){
				if(carry == 1)
				{
					res= "1"+res;
				}
				else
				{
					res = "0"+res;					
				}
			carry = 1;
			}
			if(a.charAt(a.length()-1-i)=='0' && b.charAt(b.length()-1-i)=='0'){
				if(carry == 1)
				{
					res= "1"+res;
				}
				else
				{
					res = "0"+res;					
				}
			carry = 0;
			}
			if((a.charAt(a.length()-1-i)=='1' && b.charAt(b.length()-1-i)=='0')||(a.charAt(a.length()-1-i)=='0' && b.charAt(b.length()-1-i)=='1')){
				if(carry == 1)
				{
					res= "0"+res;
					carry =1;
				}
				else
				{
					res = "1"+res;
					carry = 0;
				}
			}
			
		}
		if(carry==1){
			res = "1"+res;
		}
		return res;
	}
}
