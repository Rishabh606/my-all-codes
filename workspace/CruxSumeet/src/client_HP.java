import java.util.ArrayList;
import java.util.Arrays;

public class client_HP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Heap<student> pq = new Heap<>();
		Heap<Integer> pr = new Heap<>();
		pr.addHP(1);
		pr.addHP(2);
		pr.addHP(3);
		pr.display();
		/*
		 * pq.addHP(new student("A",100,90)); pq.addHP(new student("B",200,80));
		 * pq.addHP(new student("C",300,70)); pq.addHP(new student("D",400,60));
		 * pq.addHP(new student("E",500,50)); pq.addHP(new student("F",600,40));
		 * pq.addHP(new student("G",700,30)); pq.display(); pq.addHP(new
		 * student("H",350,65));
		 */
		/*
		 * student[] arr = { new student("B", 200, 80), new student("A", 100,
		 * 90), new student("C", 300, 70), new student("E", 500, 50), new
		 * student("F", 600, 40), new student("G", 700, 30) }; Heap<student> pr
		 * = new Heap<>(arr); pr.display(); System.out.println(pr.removeHP());
		 */
		ArrayList<Integer>[] aoal = new ArrayList[4];

		aoal[0] = new ArrayList<>();
		aoal[1] = new ArrayList<>();
		aoal[2] = new ArrayList<>();
		aoal[3] = new ArrayList<>();
		/*
		 * ArrayList<Integer> l1 = {10,15,25,40}; ArrayList<Integer> l2 =
		 * {17,22,27,29}; ArrayList<Integer> l3 = {5,8,14,49};
		 * ArrayList<Integer> l4 = {16,72,89};
		 */
		aoal[0].add(10);
		aoal[0].add(15);
		aoal[0].add(25);
		aoal[0].add(40);
		aoal[1].add(17);
		aoal[1].add(22);
		aoal[1].add(27);
		aoal[1].add(29);
		aoal[2].add(5);
		aoal[2].add(8);
		aoal[2].add(14);
		aoal[2].add(48);
		aoal[3].add(16);
		aoal[3].add(72);
		aoal[3].add(89);
		mergeKarrays(aoal);
	}

	public static void Klargestelems() {
		
	}

	public static <T> void mergeKarrays(ArrayList<Integer>[] arr) {
		Heap<Integer> pt = new Heap<>();
		ArrayList<Integer> rv = new ArrayList<>();

		for (int i = 0; i < arr.length; i++) {
			pt.addHP(arr[i].get(0));
		}
		rv.add(pt.removeHP());
		int[] brr = new int[arr.length];
		Arrays.fill(brr, 1);

		// brr[0]++;
		int k = 0;
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i].size();
		}

		while (k < sum) {
			int min = Integer.MAX_VALUE;
			int count = 0;
			for (int i = 0; i < arr.length; i++) {
				if (brr[i] < arr[i].size()) {
					if (arr[i].get(brr[i]) < min) {
						min = arr[i].get(brr[i]);
						count = i;
					}
				}
			}
			brr[count]++;
			if (min != Integer.MAX_VALUE) {
				pt.addHP(min);

				rv.add(pt.removeHP());
			}
			k++;
		}
		while (!pt.isEmpty()) {
			rv.add(pt.removeHP());
		}
		System.out.println(rv);
	}
	
	private static class diapair implements Comparable<diapair> {
		int di;
		int li;
		int data;

		@Override
		public int compareTo(diapair o) {
			// TODO Auto-generated method stub
			return o.data - this.data;
		}
	}
	
	public static <T> void mergeKarrays2(ArrayList<ArrayList<Integer>> arr) {
		Heap<diapair> pt = new Heap<>();
		ArrayList res = new ArrayList<>();
		for (int i = 0; i < arr.size(); i++) {
			diapair dp = new diapair();
			dp.di = 0;
			dp.li = i;
			dp.data = arr.get(dp.li).get(dp.di);
			pt.addHP(dp);
		}
		while (!pt.isEmpty()) {
			diapair temp = pt.removeHP();
			res.add(temp.data);
			temp.di++;
			if (temp.di < arr.get(temp.li).size()) {
				pt.addHP(temp);
			}
		}
		System.out.println(res);
	}
	
	private static class student implements Comparable<student> {
		String name;
		int marks;
		int rank;

		student(String name, int marks, int rank) {
			this.name = name;
			this.marks = marks;
			this.rank = rank;
		}

		@Override
		public int compareTo(student o) {
			// TODO Auto-generated method stub
			return o.rank - this.rank;
		}

		public String toString() {
			return "{" + this.name + "@" + this.marks + "_" + this.rank + "}";
		}
	}
}
