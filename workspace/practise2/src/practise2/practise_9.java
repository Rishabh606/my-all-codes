package practise2;

import java.util.ArrayList;
import java.util.Scanner;

public class practise_9 {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boxoperations();
		//countQmoves();
	}
	public static int[][] takeinput2d(int rows) {
		int[][] rv = null;
		rv = new int[rows][];

		for (int i = 0; i < rows; i++) {
			rv[i] = new int[2];
		}
		for(int i = 0; i<rv.length;i++)
		{
			for(int j = 0; j<2;j++)
			{
				 rv[i][j] = scn.nextInt();
			}
		}
		
		return rv;
	}
	public static void countQmoves() {
		int bsize = scn.nextInt();
		int obsno = scn.nextInt();
		int Qv = scn.nextInt();
		int Qh = scn.nextInt();
		int sum = 0;
		ArrayList<Integer> brH = new ArrayList<>();
		ArrayList<Integer> brV = new ArrayList<>();
		ArrayList<Integer> brDur = new ArrayList<>();
		ArrayList<Integer> brDul = new ArrayList<>();
		int[][] obspos = takeinput2d(obsno);
		for (int i = 0; i < obsno; i++) {
			if (Qh == obspos[i][1]) {
				brH.add(obspos[i][0] - Qv);
			}
			if (Qv == obspos[i][0]) {
				brV.add(obspos[i][1] - Qh);
			}
			if (obspos[i][0] - Qv == obspos[i][1] - Qh) {
				brDur.add(obspos[i][1] - Qh);
			}
			if (obspos[i][0] - Qv == Qh - obspos[i][1]) {
				brDul.add(Qh - obspos[i][1]);
			}

		}
		sum = sum + movecal(brH,bsize,Qv);
		sum = sum + movecal(brV,bsize,Qh);
		sum = sum + movecalDur(brDur,bsize,Qh,Qv);
		sum = sum + movecalDul(brDul,bsize,Qh,Qv);
		System.out.println(sum);
	}
	public static int movecal(ArrayList<Integer> br,int bsize, int Qpos){
		int sum =0;
		int minP = bsize-Qpos+1, minN = -Qpos;
		for(int i = 0; i<br.size();i++){
			if(br.get(i)>0){
				if(br.get(i)<minP){
					minP = br.get(i);
				}
			}
			if(br.get(i)<0){
				if(br.get(i)>minN){
					minN = br.get(i);
				}
			}
		}
		sum = minP -1-(minN)-1;
		return sum;
	}
	public static int movecalDur(ArrayList<Integer> br,int bsize, int Qh, int Qv){
		int sum =0;
		int minP = 0, minN = 0;
		for(int r = Qh, c = Qv;c<bsize && r<bsize; c++,r++){
			minP++;
		}
		minP++;
		for(int r = Qh, c = Qv;c>1 && r>1; c--,r--){
			minN--;
		}
		minN--;
		for(int i = 0; i<br.size();i++){
			if(br.get(i)>0){
				if(br.get(i)<minP){
					minP = br.get(i);
				}
			}
			if(br.get(i)<0){
				if(br.get(i)>minN){
					minN = br.get(i);
				}
			}
		}
		sum = minP-1-(minN)-1;
		return sum;
	}
	public static int movecalDul(ArrayList<Integer> br,int bsize, int Qh, int Qv){
		int sum =0;
		int minP = 0, minN = 0;
		for(int r = Qh, c = Qv;c>1 && r<bsize; c--,r++){
			minP++;
		}
		minP++;
		for(int r = Qh, c = Qv;c<bsize && r>1; c++,r--){
			minN--;
		}
		minN--;
		for(int i = 0; i<br.size();i++){
			if(br.get(i)>0){
				if(br.get(i)<minP){
					minP = br.get(i);
				}
			}
			if(br.get(i)<0){
				if(br.get(i)>minN){
					minN = br.get(i);
				}
			}
		}
		sum = minP-1-(minN)-1;
		return sum;
	}
	public static int[][] takeinput2d_4xr(int rows) {
		int[][] rv = null;
		rv = new int[rows][];

		for (int i = 0; i < rows; i++) {
			rv[i] = new int[4];
		}
		for(int i = 0; i<rv.length;i++)
		{
			for(int j = 0; j<4;j++)
			{
				if(rv[i][0]==3||rv[i][0]==4){
					if(j==3){
						rv[i][3] = 0;
						break;
					}
				}
				 rv[i][j] = scn.nextInt();
			}
		}
		
		return rv;
	}
	public static void boxoperations(){
		 int n = scn.nextInt();
	        int q = scn.nextInt();
	        int[] box = new int[n];
	        for(int box_i=0; box_i < n; box_i++){
	            box[box_i] = scn.nextInt();
	        }
	    	int[][] queries = takeinput2d_4xr(q);
	    	for(int i=0;i<q;i++){
	    		if(queries[i][0]==1){
	    			for(int j =queries[i][1];j<=queries[i][2];j++){
	    				box[j] = box[j] + queries[i][3];
	    			}
	    			
	    		}
	    		else if(queries[i][0]==2){
	    			for(int j =queries[i][1];j<=queries[i][2];j++){
	    				//queries[i][j] = (int)Math.ceil((double)(queries[i][j]/ queries[i][3]));
	    				//box[j] = greates_int((double)box[j]/ (double)queries[i][3]);
	    				box[j] = (int)Math.floor((double)box[j]/ (double)queries[i][3]);
	    			}
	    		}
	    		else if(queries[i][0]==3){
	    			int min = Integer.MAX_VALUE;
	    			for(int j =queries[i][1];j<=queries[i][2];j++){
	    				if(box[j]<min){
	    					min = box[j];
	    				}
	    			}
	    			System.out.println(min);
	    		}
	    		else if(queries[i][0]==4){
	    			int sum = 0;
	    			for(int j =queries[i][1];j<=queries[i][2];j++){
	    				sum = box[j] + sum;
	    			}
	    			System.out.println(sum);
	    		}
	    	}
	}
	public static int greates_int(double num){
		if(num<0){
			if(num-(int)num!=0){
			num = (int)(Math.ceil(num)-1);
			}
		}
		return (int)num;
	}
	public static int[] takeinput() {
		int[] rv = null;
		int n = scn.nextInt();
		rv = new int[n];
		for (int i = 0; i < n; i++) {
			rv[i] = scn.nextInt();
		}
		return rv;
	}
	public static void two_subarrays(){
		int[] org = takeinput();
		
	}
}
