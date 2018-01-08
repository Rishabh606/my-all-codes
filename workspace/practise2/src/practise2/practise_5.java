package practise2;

public class practise_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*int s =1;
		for(int i =1;i<=3;i++){
			//s = s * i;
			int t = 0;
			for(int j =1;j<=i;j++){
				t = t+s;
			}
			s = t;
		}
		System.out.println(s);*/
		String s = "12345";
		int a = Integer.parseInt(s.substring(0, 3));
		System.out.println(++a);
	}
}
