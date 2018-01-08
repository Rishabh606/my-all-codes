import java.util.Scanner;

public class jumping_dp {

	public static Scanner scn = new Scanner(System.in);
	
	public static void main(String[] args) {
		int[] steps=takeinput();
		int i = 0;
		int jumps = 0;
		int flag =-1;
		while(i<steps.length && flag<0){
			int count = 0;
			int x = 0;
			for(int j = 1;j<=steps[i];j++){
				if((i+j+1)>steps.length){
					flag = 1;
					break;
				}
				if(x<(steps[i+j]+j)){
					count = j;
					x = steps[i+j]+j;
				}
			}
			i = i+count;
			jumps++;
		}
		System.out.println(jumps);
	}

	public static int[] takeinput() {
		int n = scn.nextInt();
		int[] rv = null;
		// long n = scn.nextInt();
		rv = new int[n];
		for (int i = 0; i < n; i++) {
			rv[i] = scn.nextInt();
		}
		return rv;
	}

}
