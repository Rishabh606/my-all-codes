import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Scanner;
public class practise1 {
	public static Scanner scn = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = takeinput();
		//int[] arr2 = takeinput();
        //Bsort(arr, 0,0);
        //display(arr);
		//int key = scn.nextInt();
		//foundall(arr,0,key, 0);
		// revarr(arr,0);
		// sshort(arr,0,0,0);
		// display(arr);
		//System.out.println(str2num("128",0,0));
		String s1= scn.nextLine();
	//	String s2= scn.nextLine();
		//System.out.println(isrev(s1,s2,0));
	//	System.out.println(ispalindrome(s1,0));
		/*StringBuilder sb =  formtdupli(s1, 0);
		System.out.println(sb.toString());*/
		/*StringBuilder sb =  deldupli(s1, 0);
		System.out.println(sb.toString());*/
		//StringBuilder sb =  xdel(s1, 0);
		//System.out.println(sb.toString());
		//System.out.println(arrintersection(arr1, arr2));
		System.out.println(binarysearch (arr1,3));
	}
	 public static void display(int[] arr) {
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i]+" ");
			}
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
	public static void Bsort(int[] arr, int i,int counter){
	    if(counter==arr.length-1){
	        return;
	    }
	    if(i==arr.length-counter-1){
	        i = 0;
	      counter++;
	       // Bsort(arr,  0,counter+1);
	        //return;
	    }
	         if(arr[i]>arr[i+1]){
	            int t = arr[i];
	            arr[i]=arr[i+1];
	            arr[i+1] = t;
	    }
	    Bsort(arr,  i+1,counter);
	}
	public static void foundall(int[] arr,int i,int key, int fsf){
		if(i==arr.length-1){
			if(fsf==0){
				System.out.print(-1);
			}
			return;
		}
		if(arr[i]==key){
			System.out.print(i+" ");
			fsf+=1;
		}
		foundall(arr,i+1,key,fsf);
	}
	public static void revarr(int[] arr, int i) {
		if((arr.length-1)==i){
			return ;
		}
        int t = arr[i];
		 revarr(arr,i+1);
         arr[t] = i;
           // System.out.print(arr[t]+" ");
	}
	public static void sshort(int[] arr,int i ,int max, int counter){
		if(i>=arr.length-counter){
			int t =arr[arr.length-1-counter] ;
			arr[arr.length-1-counter] = arr[max];
			arr[max] = t;
			i = 0;
			//counter++;
			max = 0;
			sshort(arr,i,max,counter+1);
			return;
			
		}
		if(counter>=arr.length-1){
			return;
		}
		if(arr[max] <=arr[i]){
			max = i;
		}
		
		
		sshort(arr,i+1,max,counter);
	}
	public static int stringsum(String s, int i){
		int sum = 0;
		if(i == s.length()){
			
			return sum;
		}
		sum = stringsum(s, i+1);
		int num = s.charAt(i)-48;
		sum = sum + num;
		return sum;
	}
	public static int str2num(String s, int i, int sum){
		if(i == s.length()){
			
			return sum;
		}
		
		int num = s.charAt(i)-48;
		sum = sum*10 + num;
		sum = str2num(s, i+1,sum);
		return sum;
	}
	public static boolean isrev(String s1,String s2, int i){
		if(i==s1.length()){
			return true;
		}
		 boolean rev = isrev(s1,s2, i+1);
		 if(rev && s1.charAt(i)==s2.charAt(s2.length()-1-i)){
				return true;
		 }
		 else { 
			 return false;
		 }
	}
	public static boolean ispalindrome(String s1, int i){
		if(i>=s1.length()/2){
			return true;
		}
		 boolean pal = ispalindrome(s1, i+1);
		 if(pal && s1.charAt(i)==s1.charAt(s1.length()-1-i)){
				return true;
		 }
		 else { 
			 return false;
		 }
	}	
	public static StringBuilder formtdupli(String s1, int i){
		if(i==s1.length()){
			StringBuilder sb = new StringBuilder();
			sb.append("");
			return sb;
		}
		StringBuilder sb = formtdupli(s1, i+1);
		if(s1.length()-1>i && s1.charAt(i)==s1.charAt(i+1)){
			 sb.insert(0, "*");
		 }
		sb.insert(0,s1.charAt(i));
		 
		 return sb;
		 
	}	
	public static StringBuilder deldupli(String s1, int i){
		if(i==s1.length()){
			StringBuilder sb = new StringBuilder();
			sb.append("");
			return sb;
		}
		StringBuilder sb = deldupli(s1, i+1);
		if(s1.length()-1>i && s1.charAt(i)==s1.charAt(i+1)){
			 sb.deleteCharAt(0);
		 }
		sb.insert(0,s1.charAt(i));
		 
		 return sb;
		 
	}	
	public static StringBuilder xdel(String s1, int i){
		if(i==s1.length()){
			StringBuilder sb = new StringBuilder();
			sb.append("");
			return sb;
		}
		StringBuilder sb = xdel(s1, i+1);
		if(s1.length()-1>=i && s1.charAt(i)!='x'){
			// sb.deleteCharAt(0);
			 sb.insert(0,s1.charAt(i));
		 }
		if(i==0){
			int diff = s1.length()-sb.length();
			for(int j= 0; j<diff;j++){
				sb.append("x");
			}
		}
		 
		 return sb;
		 
	}	
	public static int binarysearch (int[] arr, int key)
	{
		int retval = -1, left = 0, right = arr.length-1 ;
		int middle = 0;
		while(left<=right) {
			middle = (left+right)/2;
			if (key==arr[middle]) {
				retval = middle;
				break;
			}
			else if (arr[middle]>key)
			{
				right = middle - 1;
			}
			else
			{
				left = middle + 1;
			}

		}

		return retval;
	}
	public static int linearsearch(int[] arr, int key) {
		int retval = -1, i = 0;
		for (i = 0; i < arr.length; i++) {
			if (key == arr[i]) {
				retval = i;
				break;
			}

		}

		return retval;
	}
	public static ArrayList<Integer> arrintersection2(int[] arr1,int[] arr2){
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		ArrayList<Integer> br = new ArrayList<>();
		for(int i = 0; i<=arr1.length-1;i++){
			int t = arr1[i];
		int position = 	linearsearch(arr2,arr1[i]);
		if(position>-1){
			br.add(arr1[i]);
			arr2[position]=-56;
		}
		}
		/*Integer[] arr3 = new Integer[br.size()];
		br.toArray(arr3);*/
		
		return br;
	}
	public static ArrayList<Integer> arrintersection(int[] arr1,int[] arr2){
		ArrayList<Integer> br = new ArrayList<>();
		for(int i = 0; i<=arr1.length-1;i++){
			int t = arr1[i];
		int position = 	linearsearch(arr2,arr1[i]);
		if(position>-1){
			br.add(arr1[i]);
			arr2[position]=-56;
		}
		}
		/*Integer[] arr3 = new Integer[br.size()];
		br.toArray(arr3);*/
		 Bsort(br, 0,0);
		return br;
	}
	    }

