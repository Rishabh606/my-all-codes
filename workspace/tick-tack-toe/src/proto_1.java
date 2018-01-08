import java.util.Scanner;

public class proto_1 {
	public static Scanner scn = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] arr= new char[3][3];
		
	//	System.out.println((char) 0);
	//	System.out.println("player 1 plays first with a 'X'");
	//	System.out.println("player 2 plays first with a 'O'");
		//player1(arr);
		//player2(arr);
	}
public static void player1(char[][] arr){
	
}
public static void player2(char[][] arr){
	
}
public static boolean winchecker(char[][] arr){
	for(int i = 0;i<arr[0].length;i++){
		if(arr[i][0]==arr[i][1] && arr[i][0]==arr[i][2]){
			return true;
		}
	}
	for(int i = 0;i<arr[0].length;i++){
		if(arr[0][i]==arr[1][i] && arr[0][i]==arr[i][1]){
			return true;
		}
	}
	if(arr[0][0]==arr[1][1] && arr[0][0]==arr[2][2]){
		return true;
	}
	if(arr[2][0]==arr[1][1] && arr[1][1]==arr[0][2]){
		return true;
	}
	return false;	
}
public static boolean isfilled(char[][] arr){
	int flag = 0;
	for(int i = 0; i<3;i++){
		for(int j = 0; j<3; j++){
			if(arr[i][j]=='0'){
				flag =1;
			}
			else{
				if(arr[i][j]==(char) 0){
					
				}
			}
		}
	}
	return false;
}
}
