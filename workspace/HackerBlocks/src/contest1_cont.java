import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class contest1_cont {

	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// factsumer();
		// cumulativeneg();
		//HCFcal();
		/*int t = scn.nextInt();
		for(int i = 0; i<t; i++){
			countsetbits2(scn.nextInt());
		}*/
		//uniquenumb2();
		/*int t = scn.nextInt();
		for(int i = 0; i<t; i++){
			helpRamu();
		}*/
		//sanjayjob();
		/*float a = 1.00f;
		a = a/2;
		
		System.out.println(String.format("%.2f", a));*/
		//System.out.println(a);
		//probabcoin();
	//	searcher();
		int t = scn.nextInt();
		for(int i = 0; i<t; i++){
			seriescal2();
		}
	}

	public static void factsumer() {
		int n = scn.nextInt();
		long sum = 0;
		for (int i = 0; i < n; i++) {
			sum += fact(scn.nextInt());
		}
		System.out.println(sum % 107);
	}

	public static long fact(int n) {
		if (n == 0 || n == 1) {
			return 1;
		}
		return fact(n - 1) * (n);
	}

	public static int gcd(int a, int b) {
		if (a == 0)
			return b;
		return gcd(b % a, a);
	}

	public static void cumulativeneg() {
		int sum = 0;
		ArrayList<Integer> arr = new ArrayList<Integer>();
		int count = 0;
		while (true) {
			int k = scn.nextInt();
			sum += k;
			if (sum <= 0) {
				break;
			}
			arr.add(k);
		}
		for (int i : arr) {
			System.out.println(i);
		}
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
	public static diapair[] takeinputobj(int n) {
		diapair[] rv = null;
		// long n = scn.nextInt();
		rv = new diapair[n];
		for (int i = 0; i < n; i++) {
			rv[i] = new diapair(scn.next(), scn.nextInt());
		}
		return rv;
	}
	public static void HCFcal() {
		int n = scn.nextInt();
		int[] arr = takeinput(n);
		if (n > 1) {
			int first = gcd(arr[0], arr[1]);
			for (int i = 2; i < arr.length; i++) {
				first = gcd(first, arr[i]);
			}
			System.out.println(first);
		}else{
			System.out.println(arr[0]);
		}
		
	}
	
	public static void countsetbits1(int a){
		int count = 0;
		while(a!=0){
		count += (a & 1) ;
		a = a>>1;
		}
		System.out.println(count);
	}
	
	public static void countsetbits2(int a){
		int count = 0;
		while(a!=0){
		a = (a & (a-1)) ;
		count++;
		}
		System.out.println(count);
	}
	
	public static void uniquenumb2(){
		int n = scn.nextInt();
		int[] arr= takeinput(n);
		int first = 0;
		for(int i = 0; i< n;i++){
			first = first ^ arr[i];
		}
		int res= first;
		int idx = 0;
		while(true){
			if((first&1)!=0){
				break;
			}
			first = first>>1;
			idx++;
		}
		int x = 1;
		x = x<<idx;
		first = 0;
		for(int i = 0; i< n;i++){
			if((x & arr[i])!=0){
				first = first^arr[i];
			}
		}
		int second = first^res;
		System.out.println(second);
		System.out.println(first);
	}
	
	public static int[][] takeinput(int rows, int cols) {
		int[][] rv = null;
		rv = new int[rows][cols];
		for (int i = 0; i < rv.length; i++) {
			for (int j = 0; j < rv[i].length; j++) {
				rv[i][j] = scn.nextInt();
			}
		}

		return rv;
		/*int sum = 0;
		int a = nodes.size() - 1;
		for (int k = stacks - 1; k >= 0; k--) {
			if (k > nodes.get(a)) {
				sum = sum + (arr[k][0] - arr[nodes.get(a)][0]) * arr[k][1];
			} else {
				a--;
			}
		}
		System.out.println(sum);*/
	}
	
	public static void helpRamu(){
		int [] arr = takeinput(4);
		int n =scn.nextInt();
		int m = scn.nextInt();
		int[] N = takeinput(n);
		int[] M = takeinput(m);
		int sum = 0;
		for(int i = 0; i<n;i++){
			if(N[i]*(i+1)>arr[1]){
				sum+=arr[1];
			}else{
			sum+=N[i]*(i+1);
			}
		}
		if(sum>arr[2]){
			sum = arr[2];
		}
		int sum2 = 0;
		for(int i = 0; i<m;i++){
			if(M[i]*(i+1)>arr[1]){
				sum2+=arr[1];
			}else{
			sum2+=M[i]*(i+1);
			}
		}
		if(sum2>arr[2]){
			sum2 = arr[2];
		}
		sum = sum +sum2;
		if(sum>arr[3]){
			System.out.println(arr[3]);
		}else{
			System.out.println(sum);
		}
	}
	
	public static void sanjayjob(){
		int x = scn.nextInt();
		int N = scn.nextInt();
		diapair[]arr = takeinputobj(N);
		Arrays.sort(arr);
		for(int i = 0; i< arr.length;i++){
			if(arr[i].data>=x){
				System.out.println(arr[i].name+" "+ arr[i].data);
			}
		}
	}
	
	private static class diapair implements Comparable<diapair> {
		String name;
		int data;
		diapair(String name, int data){
		this.name= name;
		this.data = data;
		}
		@Override
		public int compareTo(diapair o) {
			// TODO Auto-generated method stub
			if((this.data-o.data)==0){
				return this.name.compareTo(o.name);
			}
			if(this.data > o.data){
				return -1;
			}
			return 1;
		}
	}
	public static void probabcoin(){
		int n = scn.nextInt();
		int N = (int) Math.pow(2, n);
		System.out.println(N);
	}
	public static void searcher(){
		int n = scn.nextInt();
		int[] arr= takeinput(n);
		int key = scn.nextInt();
		System.out.println(Arrays.binarySearch(arr, key));
	}
	public static void seriescal(){
		long n = scn.nextInt();
		long f = 0;
		for(long i = 1; i<=n;i++){
			f +=Math.pow(-1, i)*i;
		}
		System.out.println(f);
	}
	public static void seriescal2(){
		long n = scn.nextLong();
		long f = 0;
		for(long i = 1; i<=n;i++){
			f +=(long)power(-1, i)*i;
		}
		System.out.println(f);
	}
		public static long power(long a, long b){
		if(b==0){
		    return 1;
		}
		if(b==1){
		    return a;
		}
		if((b&1)!=0){
		    long t = power(a,b/2);
		    return a*t*t;
		}else{
		    long t = power(a,b/2);
		    return t*t;
		}
	}
}
