
public class A7Q10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countTwins("AxAxA", 0));
	}
	
	public static int countTwins(String str, int i){
		if(i == str.length() - 2){
			return 0;
		}
		
		
		char ch1 = str.charAt(i);
		char ch3 = str.charAt(i + 2);
		
		if(ch1 == ch3){
			return 1 + countTwins(str, i + 1);
		} else {
			return 0 + countTwins(str, i + 1);
		}
		
	}

}
