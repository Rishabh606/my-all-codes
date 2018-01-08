package practise2;

import java.math.BigInteger;
import java.util.Scanner;

public class practise26 {

	public static Scanner scn = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigInteger n,k,ans;
		for(int i = 0; i<10;i++){
			BigInteger x= scn.nextBigInteger();
			BigInteger y= scn.nextBigInteger();
			compute(x,y);
		}
	}

}
