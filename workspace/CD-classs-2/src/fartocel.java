import java.util.Scanner;

public class fartocel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("enter min, max, step");
				Scanner Scn = new Scanner(System.in);
				int Fmin = Scn.nextInt();
				
				System.out.println("enter a number");
				Scanner ren = new Scanner(System.in);
				int Fmax = ren.nextInt();
				
				System.out.println("enter a number");
				Scanner pen = new Scanner(System.in);
				int step = pen.nextInt();
				
				int C =0;
				for(int F = Fmin; F<=Fmax;F=F+step)
				{
					C = (int)((5.0/9.0)*(F-32));
					System.out.println(F+"\t"+C);
				}
	}

}
