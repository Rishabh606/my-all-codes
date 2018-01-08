import java.util.Scanner;

public class MaxfreqChar {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		 String s = scn.nextLine();
		 //freq(s);
		 //consedel(s);
		// duplidel(s);
		// consecon(s);
		 conscon2(s);
	}
	public static void freq(String s){
		int[] arr = new int [256];
		int n = 0;
		for(int i = 0; i<s.length();i++)
		{
			arr[s.charAt(i)]++;
			
		}
		System.out.println((char)max.max1(arr));
		
	}
	public static void duplidel(String s){
		int[] arr = new int [256];
		int n = 0;
		for(int i = 0; i<s.length();i++)
		{
			arr[s.charAt(i)]++;
			if(n <=s.charAt(i))n=s.charAt(i);
		}
		//System.out.println((char)max.max1(arr));
		for(int i = 0; i<= n;i++)
		{
			if(arr[i]>0){
				System.out.print((char)i);
				if(arr[i]>1){
					System.out.print(arr[i]);
				}
			}
		}
		
	}
	public static void consedel(String s){
		int[] arr = new int [256];
		int n = 0;
		for(int i = 0; i<s.length()-1;i++)
		{
			if(s.charAt(i)!=s.charAt(i+1)){
				 System.out.print(s.charAt(i));
			}
			n = i;
		}
		 System.out.print(s.charAt(n+1));
		//System.out.println((char)max.max1(arr));
		
	}
	public static void consecon(String s){
		
		int n = 0;
		int p =0;
		int counter =0;
		for(int i = 0; i<s.length()-1;i++)
		{
			if(s.charAt(i)==s.charAt(i+1)){
				 counter++;
				 p=counter +1;
			}
			else{
				System.out.print(s.charAt(i));
				if(counter>=1)System.out.print(counter+1);
				 
				counter=0;
				
			}
			n = i;
		}
		 System.out.print(s.charAt(n+1));
		//System.out.println((char)max.max1(arr));
		 if(p>1)System.out.print(p);
		
	}
	 public static void conscon2(String s){
			int[] arr = new int [256];
			int n = 0;
			int counter = 0;
			for(int i = 0; i<s.length()-1;i++)
			{
				counter = 0;
				for(int j = i+1; j<s.length();j++)
	                {
	                if (s.charAt(i)==s.charAt(j)){
	                	counter++;
	                	i++;
	                }
	                else break;
	            }
				System.out.print(s.charAt(i));
				if (counter>0){
					System.out.print(counter+1);
				}
				if(i==s.length()-2){
					System.out.print(s.charAt(i+1));
				}
			}
			//System.out.println((char)max.max1(arr));
			
		}
	
}
