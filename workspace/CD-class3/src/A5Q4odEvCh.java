import java.util.Scanner;
public class A5Q4odEvCh {

	public static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
    String s = scn.nextLine();
    System.out.println(oddEven(s));
   System.out.println( diffBetweenAscii(s));
    }
 public static String diffBetweenAscii(String s){
	 StringBuilder sb = new StringBuilder();
	 for(int i = 0; i<s.length()-1; i++){
		 char prev = s.charAt(i);
		 char curr = s.charAt(i+1);
		 int diff = (int)(curr- prev);
		 sb.append(prev);
		 sb.append(diff);
		// sb.append(curr);
		 if(i==s.length()-2)sb.append(curr);
	 }
	
	 return sb.toString();
    }
    
    public static String oddEven(String s){
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i<s.length();i++){
    	char ch = s.charAt(i);
    if (i%2==0){
    	ch = (char)((int)ch+1);
    	sb.append(ch);
    }
    else
    {
    	ch = (char)((int)ch-1);
    	sb.append(ch);
    }
    }
    return sb.toString();
    }
}

