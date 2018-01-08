package practise2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//pr17
public class bookshop {
	public static Scanner scn = new Scanner(System.in);
	static String[] Bnames1 = { "highschooldxd", "Danmachi", "percyjackson-1", "JackReacher-1", "Harrypotter-1",
			"AtlasShrugged", "returnofsherlockhomles", "fairytailvol-1","Harrypotter-2" };
	static String[] Bnames = { "highschooldxd", "Danmachi", "percy jackson-1", "Jack Reacher-1", "Harry potter-1",
			"Atlas Shrugged", "return of sherlock homles", "fairy tail vol-1","Harry potter-2"};
	static int[] Bisbn = { 4626, 2789, 9075, 1483, 5001, 6060, 6969, 8910,7989 };
	static int[] Bprice = { 800, 500, 450, 700, 500, 100, 450, 700, 600 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		takeinput();
	}

	public static void takeinput() {
		while (true) {
			System.out.println("Welcome to book information library. Enter any of the following numbers");
			System.out.println("0 - to quit the program");
			System.out.println("1 - Search by book's name");
			System.out.println("2 - Search by book's ISBN no.");
			System.out.println("3 - Search by book's price");
			System.out.println("Also at any point to go back to main search menu type -1");
			int n = scn.nextInt();
			if (n == 0) {
				return;
			}
			switch (n) {
			case 1:
				namesearch();
				break;
			case 2:
				isbnsearch();
				break;
			case 3:
				pricesearch();
				break;
			default:
				System.out.println("invalid input");
				takeinput();
			}
		}
	}

	private static void pricesearch() {
		int key = scn.nextInt();
		if (key == -1) {
			return;
		}

		ArrayList<Integer> position = new ArrayList<>();
		// int position = Arrays.binarySearch(Bprice, key);
		for (int i = 0; i < Bprice.length; i++) {
			if (key == Bprice[i]) {
				position.add(i);
			}
		}
		if (position.size() == 0) {
			System.out.println("no book exists for this price. enter another price");
			pricesearch();
			return;
		} else {
			for (int i = 0; i < position.size(); i++) {
				System.out.println("book name-" + Bnames[position.get(i)]);
				System.out.println("book ISBN no-" + Bisbn[position.get(i)]);
				System.out.println("book price-" + Bprice[position.get(i)]);
			}
		}
	}

	private static void isbnsearch() {
		System.out.println("enter isbn no without '-'");
		int key = scn.nextInt();
		if (key == -1) {
			return;
		}
		int position = Arrays.binarySearch(Bisbn, key);
		if (position < 0) {
			System.out.println("no book exists of this ISBN number. enter another ISBN number");
			isbnsearch();
			return;
		} else {
			System.out.println("book name-" + Bnames[position]);
			System.out.println("book ISBN no-" + Bisbn[position]);
			System.out.println("book price-" + Bprice[position]);
		}
	}

	private static void namesearch() {
		String str = scn.nextLine();
		str = scn.nextLine();
		if (str.equals("-1")) {
			return;
		}
		StringBuilder sb = new StringBuilder(str);
		for (int i = 0; i < sb.length(); i++) {
			if (sb.charAt(i) == ' ') {
				sb.deleteCharAt(i);
			}
		}
		String str1 = sb.toString();
		// int position = Arrays.binarySearch(Bnames, str1);
		int position = linearsearch(Bnames1, str1);
		if (position < 0) {
			position = linearsubstringsearch(Bnames1, str1);
		}
		if (position < 0) {
			System.out.println("no book exists of this name. enter new choice");
			takeinput();
			return;
		} else {
			System.out.println("book name-" + Bnames[position]);
			System.out.println("book ISBN no-" + Bisbn[position]);
			System.out.println("book price-" + Bprice[position]);
		}
	}

	public static int linearsearch(String[] arr, String key) {
		int retval = -1, i = 0;
		for (i = 0; i < arr.length; i++) {
			if (key.equals(arr[i])) {
				retval = i;
				break;
			}

		}

		return retval;
	}

	public static int linearsubstringsearch(String[] arr, String key) {
		int retval = -1, i = 0, k = 0;
		ArrayList<Integer> br = new ArrayList<>();
		for (i = 0; i < arr.length; i++) {
			for (int p1 = 0; p1 < arr[i].length(); p1++) {
				for (int p2 = p1; p2 <= arr[i].length(); p2++) {
					if (key.equals(arr[i].substring(p1, p2))) {
						br.add(i);
					}
				}
			}

		}
		if (br.size() != 0) {
			System.out.println("choose one of the following books by typing number given against it");
			for (k = 0; k < br.size(); k++) {
				System.out.println(Bnames[br.get(k)] + " - " + k);
			}
			int ret = scn.nextInt();
			if (ret < k) {
				retval = br.get(ret);
			}
		}
		return retval;
	}

}
