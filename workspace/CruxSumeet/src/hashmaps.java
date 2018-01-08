import java.util.ArrayList;
import java.util.HashMap;

public class hashmaps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 2,12,9,16,10,5,3,20,25,11,8,6
		// 8,9,10,11,12
		int[] one = { 1, 1, 2, 2, 2, 5 };
		int[] two = { 1, 1, 1, 2, 2, 3, 5 };
		int[] three = { 2, 12, 9, 16, 10, 5, 3, 20, 25, 11, 8, 6 };
		com_elem(one, two);
		inter_elem(one, two);
		longest_possible_subseq(three);
	}

	public static void com_elem(int[] one, int[] two) {
		HashMap<Integer, Integer> com = new HashMap<>();
		for (int i = 0; i < one.length; i++) {
			com.put(one[i], one[i]);
		}
		ArrayList<Integer> br = new ArrayList<>();
		for (int i = 0; i < two.length; i++) {
			if (com.get(two[i]) != null) {
				br.add(two[i]);
				com.remove(two[i]);
			}
		}
		System.out.println(br);
	}

	public static void inter_elem(int[] one, int[] two) {
		HashMap<Integer, Integer> com = new HashMap<>();
		for (int i = 0; i < one.length; i++) {
			int temp = 0;
			if (com.get(one[i]) == null) {
				com.put(one[i], 1);
			} else {
				temp = com.get(one[i]);
				com.put(one[i], temp + 1);
			}
		}
		ArrayList<Integer> br = new ArrayList<>();
		for (int i = 0; i < two.length; i++) {
			if (com.get(two[i]) != null && com.get(two[i]) > 0) {
				br.add(two[i]);
				int temp = com.get(two[i]);
				com.put(two[i], temp - 1);
			}
		}
		System.out.println(br);
	}

	/*
	 * public static void longest_possible_subseq(int[] three){ HashMap<Integer,
	 * Integer> com = new HashMap<>(); HashMap<Integer, ArrayList<Integer>> sol
	 * = new HashMap<>(); for (int i = 0; i < three.length; i++) {
	 * com.put(three[i], three[i]); } int flag = 0; int count = 0; int max =
	 * Integer.MIN_VALUE; int j = 0; for(int i = 0;i<com.size()-1;i++){
	 * if(com.get(i)==null){ flag =1; count =0; }else{ int temp = com.get(i);
	 * sol.put(j, ) } } }
	 */
	public static void longest_possible_subseq(int[] three) {
		HashMap<Integer, Integer> com = new HashMap<>();
		HashMap<Integer, Integer> sol = new HashMap<>();
		int Min = three[0];
		int Max = three[0];
		for (int i = 0; i < three.length; i++) {
			Min = Math.min(Min, three[i]);
			com.put(three[i], three[i]);
			Max = Math.max(Max, three[i]);
		}
		int flag = 1;
		int count = 0;
		int j = 0;
		for (int i = Min; i <= Max; i++) {
			if (com.get(i) == null) {
				flag = 1;
				count = 0;
			} else if (flag == 0) {
				count++;
				int temp = sol.get(j);
				sol.put(j, temp + 1);
			} else {
				flag = 0;
				count++;
				j = com.get(i);
				sol.put(com.get(i), 1);
			}
		}
		int max = Integer.MIN_VALUE;
		int key = -1;
		for (int i = Min; i <= Max; i++) {
			if (sol.containsKey(i)) {
				if (sol.get(i) >= max) {
					max = sol.get(i);
					key = i;
				}
			}
		}
		for (int i = key; i < key + max; i++) {
			System.out.println(i);
		}
	}
}
