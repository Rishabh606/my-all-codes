package contest;

import java.util.Scanner;

public class acm2017 {

	 public static Scanner scn = new Scanner(System.in);
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int t = scn.nextInt();
		for(int i =0;i<t;i++){
			Kas();
		}
	}
	public static void Kas()
	{
		int N = scn.nextInt();
		int sd = scn.nextInt();
		if(N==1&&sd!=0)
		{
			System.out.println(-1);
			return;
		}
		double num=Math.sqrt((N*1.0/2)*sd*sd);
		for(int i=1;i<=N-2;i++)
			System.out.print(0+" ");
		System.out.println(num+" "+(-num)+" ");
	}
	private static void STDDEV() {
		// TODO Auto-generated method stub
		int N = scn.nextInt();
		int sd = scn.nextInt();
		double x = N;
		int flag = 0;
		while(true){
			double mw = ((N)*(N-1)+x)/2;
			double std = cal(x,mw,N-1);
			if(std-sd>1){
				if(flag==2){
					x--;
					break;
				}
				flag=1;
				x--;
			}
			else if(sd-std>1){
				if(flag==1){
					x++;
					break;
				}
				flag=2;
				x++;
			}
			else if (std==sd){
				for(int i =1;i<=x;i++){
					System.out.print(i+" ");
				}
				System.out.println();
				return;
			}else{
				break;
			}
		}
		flag = 0;
		while(true){
			double mw = ((N)*(N-1)+x)/2;
			double std = cal(x,mw,N-1);
			if(std-sd>0.1){
				if(flag==2){
					break;
				}
				flag = 1;
				x= x-0.01;
			}
			else if(sd-std>0.1){
				if(flag==1){
					break;
				}
				flag=2;
				x = x+0.01;
			}
			else{
				for(int i =1;i<=x;i++){
					System.out.print(i+" ");
				}
				System.out.println();
				return;
			}
		}
		System.out.println(-1);
		return;
	}

	private static double cal(double x, double mw,int E) {
		double diff = 0;
		for(int i = 1; i<=E;i++){
			diff+=(i-mw)*(i-mw);
		}
		diff=diff+(x-mw)*(x-mw);
		diff/=(E+1);
		return Math.sqrt(diff);
	}

}
