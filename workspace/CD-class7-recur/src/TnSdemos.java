
public class TnSdemos {
	public static long start = 0;
	public static long end = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//startTimer();
		int[]arr = {3,7,1,5,0,2,10,-1};
		//timecomplex.quicksort(arr, 0, arr.length-1);
		//System.out.println(endTimer());
		//char ch = '0';
		//System.out.println(ch-'0');
		//ch = (char)(ch + 5);
		System.out.println(Integer.toBinaryString(6));
	}

	public static void startTimer() {
		TnSdemos.start = System.currentTimeMillis();
	}

	public static long endTimer() {
		TnSdemos.end = System.currentTimeMillis();
		return TnSdemos.end-TnSdemos.start;
	}
	
}
