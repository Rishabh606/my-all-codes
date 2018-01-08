
public class good_questions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	public static void least_steps_to_min(int[] arr){
		int min = Integer.MAX_VALUE;
		int k= 0;
		for(int i = 0; i<arr.length;i++){
			if(min<arr[i]){
				min=arr[i];
				k  = i;
			}
		}
		int count = 0;
		for(int i = 0; i<arr.length;i++){
			int delta = arr[i] - min;
			
		}
		int r = min%5;
		if(r!=0){
			int m = r%2;
			if(m==1){
				r--;
				m--;
				count++;
			}
			
		}
	}
}
