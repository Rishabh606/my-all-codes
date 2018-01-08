package Lecture8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Recursion {

	public static Scanner scn = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(getSS("abcd"));
//		System.out.println(getSSWAscii("ab"));
//		System.out.println(getPerms("abcd"));
		
//		String kpc = scn.next();
//		System.out.println(getKPC(kpc));
		
//		System.out.println(getBoardPaths(15, 0).size());
		
		printPerm("abc", "");
	}

	public static ArrayList<String> getSS(String str) {
		if (str.length() == 0) {
			ArrayList<String> baseResult = new ArrayList<>();

			baseResult.add("");

			return baseResult;
		}

		char ch = str.charAt(0);
		String ros = str.substring(1);

		ArrayList<String> recResult = getSS(ros);
		ArrayList<String> myResult = new ArrayList<>();

		for (int i = 0; i < recResult.size(); i++) {
			myResult.add("" + recResult.get(i));
			myResult.add(ch + recResult.get(i));
		}

		return myResult;
	}

	public static ArrayList<String> getSSWAscii(String str) {
		if (str.length() == 0) {
			ArrayList<String> baseResult = new ArrayList<>();

			baseResult.add("");

			return baseResult;
		}

		char ch = str.charAt(0);
		String ros = str.substring(1);

		ArrayList<String> recResult = getSSWAscii(ros);
		ArrayList<String> myResult = new ArrayList<>();

		for (int i = 0; i < recResult.size(); i++) {
			myResult.add("" + recResult.get(i));
			myResult.add(ch + recResult.get(i));
			myResult.add((int)ch + recResult.get(i));
		}

		return myResult;
	}

	public static ArrayList<String> getPerms(String str){
		if (str.length() == 0) {
			ArrayList<String> baseResult = new ArrayList<>();

			baseResult.add("");

			return baseResult;
		}
		
		char ch = str.charAt(0);
		String ros = str.substring(1);
		
		ArrayList<String> myResult = new ArrayList<>();
		ArrayList<String> recResult = getPerms(ros);
		for(int i = 0; i < recResult.size(); i++){
			String recString = recResult.get(i);
			
			for(int j = 0; j <= recString.length(); j++){
				String myString = recString.substring(0, j) + ch + recString.substring(j);
				myResult.add(myString);
			}
		}
		
		return myResult;
	}

	public static ArrayList<String> getKPC(String str){
		if (str.length() == 0) {
			ArrayList<String> baseResult = new ArrayList<>();

			baseResult.add("");

			return baseResult;
		}
		
		char ch = str.charAt(0);
		String ros = str.substring(1);
		
		String chCode = getCode(ch);
		
		ArrayList<String> myResult = new ArrayList<>();
		ArrayList<String> recResult = getKPC(ros);
		for(int i = 0; i < recResult.size(); i++){
			String recString = recResult.get(i);
			
			for(int j = 0; j < chCode.length(); j++){
				String myString = chCode.charAt(j) + recString;
				myResult.add(myString);
			}
		}
		
		return myResult;
	}
	
	public static String getCode(char ch){
		String[] codes = {".;", "abc", "def", "ghi", "jkl", "mno", "pqr", "stu", "vwx", "yz"};
		return codes[ch - '0'];
	}

	public static ArrayList<String> getBoardPaths(int end, int current){
		if(current == end){
			ArrayList<String> baseResult = new ArrayList<>();

			baseResult.add("\n");

			return baseResult;
		}
		
		if(current > end){
			ArrayList<String> baseResult = new ArrayList<>();

			return baseResult;
		}
		
		
		ArrayList<String> myResult = new ArrayList<>();
		
		for(int dice = 1; dice <= 6; dice++){
			ArrayList<String> recResult = getBoardPaths(end, current + dice);
			
			for(int i = 0; i < recResult.size(); i++){
				myResult.add(dice + recResult.get(i));
			}
		}
		
		return myResult;
	}
	
	public static void printSS(String str, String osf){
		if(str.length() == 0){
			System.out.println(osf);
			return;
		}
		
		char ch = str.charAt(0);
		String ros = str.substring(1);
		
		printSS(ros, osf + "");
		printSS(ros, osf + ch);
	}
	
	public static void printPerm(String str, String osf){
		if(str.length() == 0){
			System.out.println(osf);
			return;
		}
		
		for(int i = 0; i < str.length(); i++){
			char ch = str.charAt(i);
			String ros = str.substring(0, i) + str.substring(i + 1);
			
			printPerm(ros, osf + ch);
		}
	}
}
