
public class client_hm {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		HashMap<String, Integer> hm = new HashMap<>(2);

		hm.put("A", 33);
		hm.put("B", 43);
		hm.put("C", 93);
		hm.put("D", 63);
		hm.put("E", 13);

		// hm.display();
		/*
		 * int[] arr = { 1, 5, 5, 10, 10 }; least_steps_to_min(arr);
		 */
	}

	public static void least_steps_to_min(int[] arr) throws Exception {
		int min = Integer.MAX_VALUE;
		int k = 0;
		for (int i = 0; i < arr.length; i++) {
			if (min > arr[i]) {
				min = arr[i];
				k = i;
			}
		}
		HashMap<Integer, Integer> Hm = new HashMap<>(5);
		Hm.put(0, 0);
		Hm.put(1, 0);
		Hm.put(2, 0);
		Hm.put(3, 0);
		Hm.put(4, 0);

		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			int delta = arr[i] - min;
			count += delta / 5;
			int landing = delta % 5;
			Hm.put(landing, Hm.getAt(landing) + 1);
		}

		int cost0 = Hm.getAt(0) * 0 + Hm.getAt(1) * 1 + Hm.getAt(2) * 1 + Hm.getAt(3) * 2 + Hm.getAt(4) * 2;
		int costm1 = Hm.getAt(0) * 1 + Hm.getAt(1) * 1 + Hm.getAt(2) * 2 + Hm.getAt(3) * 2 + Hm.getAt(4) * 1;
		int costm2 = Hm.getAt(0) * 1 + Hm.getAt(1) * 2 + Hm.getAt(2) * 2 + Hm.getAt(3) * 1 + Hm.getAt(4) * 2;

		count += Math.min(cost0, Math.min(costm1, costm2));
		System.out.println(count);
	}
}
