package contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class cf_1sep17_div2 {

	public static FastScanner scn = new FastScanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = scn.nextInt();
		int[] arr = takeinput(n);
		// OddsEnds(arr);
		 TellWorld(arr);
	}
	public static void TellWorld(int[] arr) {
		// TODO Auto-generated method stub
		double slope1 = (arr[1]-arr[0]);
		HashMap<Double, Integer>map1 = new HashMap<>();
		HashMap<Integer, Integer>map2 = new HashMap<>();
		double[] l1 = new double [arr.length];
		double[] l2 = new double [arr.length];
		map2.put(0, 1);
		//double slope2 = (arr[2]-arr[0]);
		for(int i =1; i<arr.length;i++){
			double slope2 = ((double)(arr[i]-arr[0]))/((double)(i-0));
			l1[i] = slope2;
			if(!map1.containsKey(slope2)){
				map1.put(slope2, i);
			}else{
				slope1 = slope2;
				map2.put(i, 1);
				map2.put(map1.get(slope2), 1);
			}
		}
		int key = 1;
		for(int i = 0; i<arr.length;i++){
			if(!map2.containsKey(i)){
				key = i;
				break;
			}
		}
		
		for(int i =1; i<arr.length;i++){
			if(i==key){
				continue;
			}
			if(map2.containsKey(i)){
				continue;
			}
			double slope2 = ((double)(arr[i]-arr[key]))/((double)(i-key));
			l2[i] = slope2;
			if(slope1!=slope2){
				System.out.println("No");
				return;
			}
		}
		System.out.println("Yes");
	}
	public static void OddsEnds(int[] arr) {
		// TODO Auto-generated method stub
		if(arr.length%2==0){
			System.out.println("No");
			return;
		}
		if(arr[0]%2==0 || arr[arr.length-1]%2==0){
			System.out.println("No");
			return;
		}
		System.out.println("Yes");
		return;
	}
	public static int[] takeinput(int n) {
		int[] rv = null;
		// long n = scn.nextInt();
		rv = new int[n];
		for (int i = 0; i < n; i++) {
			rv[i] = scn.nextInt();
		}
		return rv;
	}

}
 class FastScanner {
	BufferedReader reader;
	StringTokenizer st;

	FastScanner(InputStream stream) {
		reader = new BufferedReader(new InputStreamReader(stream));
		st = null;
	}

	String next() {
		while (st == null || !st.hasMoreTokens()) {
			try {
				String line = reader.readLine();
				if (line == null) {
					return null;
				}
				st = new StringTokenizer(line);
			} catch (Exception e) {
				throw new RuntimeException();
			}
		}
		return st.nextToken();
	}

	String nextLine() {
		String s = null;
		try {
			s = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return s;
	}

	int nextInt() {
		return Integer.parseInt(next());
	}

	long nextLong() {
		return Long.parseLong(next());
	}

	double nextDouble() {
		return Double.parseDouble(next());
	}

	char nextChar() {
		return next().charAt(0);
	}

	int[] nextIntArray(int n) {
		int[] a = new int[n];
		int i = 0;
		while (i < n) {
			a[i++] = nextInt();
		}
		return a;
	}

	long[] nextLongArray(int n) {
		long[] a = new long[n];
		int i = 0;
		while (i < n) {
			a[i++] = nextLong();
		}
		return a;
	}

	int[] nextIntArrayOneBased(int n) {
		int[] a = new int[n + 1];
		int i = 1;
		while (i <= n) {
			a[i++] = nextInt();
		}
		return a;
	}

	long[] nextLongArrayOneBased(int n) {
		long[] a = new long[n + 1];
		int i = 1;
		while (i <= n) {
			a[i++] = nextLong();
		}
		return a;
	}

	void close() {
		try {
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}