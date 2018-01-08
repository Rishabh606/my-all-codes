import java.util.Scanner;

public class any2any {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println("enter a number");
		Scanner scn = new Scanner(System.in);
		
		//System.out.println("enter sourcebase");
		int sb = scn.nextInt();
		//System.out.println("enter destinationbase");
		int db = scn.nextInt();
		int n = scn.nextInt();
	//	int dec = bintodec(n);
	//	int dec2 = anytodec(n,sb);
		int retval = anytoany(n,sb,db);
		//System.out.println(dec);
		//System.out.println(dec2);
		System.out.println(retval);
	}
	
	public static int bintodec(int bin)
	{
		int i = 1, p=1,dec = 0;
		while(bin!=0)
		{
			i = bin%10;
			dec = dec + p*i;
			p = p*2;
			bin = bin/10;
		}
		return dec;
	}
	public static int anytodec(int n,int sb)
	{
		int i = 1, p=1,dec = 0;
		while(n!=0)
		{
			i = n%10;
			dec = dec + p*i;
			p = p*sb;
			n = n/10;
		}
		return dec;
	}
	public static int anytoany (int n, int sb, int db)
	{
		int retval=0,dec=0,i=0,p=1;
		dec = anytodec(n,sb);
		while(dec!=0)
		{

			i = dec%db;
			retval = retval + p*i;
			p = p*10;
			dec = dec/db;
		}
		return retval;
	}

}
