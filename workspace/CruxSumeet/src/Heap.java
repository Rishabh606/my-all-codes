import java.util.ArrayList;
import java.util.HashMap;
public class Heap<T extends Comparable<T>> {
	private ArrayList<T> data;
	private HashMap<T, Integer> posmap;
	public static void main(String[] args) {
	    System.out.println("JUST see the code.");
	   Heap<Integer> pq = new Heap<>();
	   System.out.println(pq.size());
	   pq.addHP(1);
	   pq.addHP(2);
	   pq.addHP(3);
	   pq.addHP(4);
	   pq.addHP(5);
	   pq.addHP(6);
	   pq.addHP(7);
	   pq.addHP(8);
	   System.out.println(pq.getHP());
		}
	public Heap() {
		this.data = new ArrayList<>();
		this.posmap = new HashMap<>();
	}

	public int size() {
		return data.size();
	}

	public boolean isEmpty() {
		return data.size() == 0;
	}

	public void display() {
		System.out.println(data);
	}

	public T getHP() {
		return data.get(0);
	}

	public void addHP(T item) {
		data.add(item);
		posmap.put(item, data.size()-1);
		upheapify(data.size() - 1);
	}

	public void upheapify(int ci) {
		if (ci == 0) {
			return;
		}
		int pi = (ci - 1) / 2;
		if (isHP(ci, pi)) {
			swap(ci, pi);
			upheapify(pi);
		}
	}

	public T removeHP() {
		T rv = data.get(0);
		swap(0, data.size() - 1);
		data.remove(data.size() - 1);
		posmap.remove(rv);
		downheapify(0);
		return rv;
	}

	private void downheapify(int pi) {
		int lci = 2 * pi + 1;
		int rci = 2 * pi + 2;
		int maxi  = pi;
		if (lci < data.size() && isHP(lci, maxi)) {
			maxi = lci;
		}
			
		 if (rci < data.size() && isHP(rci, maxi)) {
			maxi = rci;
		}
		 if(maxi!=pi){
			 swap(pi, maxi);
			downheapify(maxi);
		 }
	}

	private void swap(int i, int j) {
		T ith = data.get(i);
		T jth = data.get(j);
		posmap.put(ith, j);
		posmap.put(jth, i);
		data.set(i, jth);
		data.set(j, ith);

	}

	private boolean isHP(int i, int j) {
		T ith = data.get(i);
		T jth = data.get(j);
		if (ith.compareTo(jth) > 0) {
			return true;
		} else {
			return false;
		}
	}

	public Heap(T [] arr){
		this();
		for(int i = 0;i<arr.length;i++){
			data.add(arr[i]);
			posmap.put(arr[i], data.size()-1);
		}
		for(int i = data.size()/2 -1; i>=0;i--){
			downheapify(i);
		}
	}
	public void update(T item){
		int it = posmap.get(item);
		data.set(it, item);
		upheapify(it);
		downheapify(it);
	}
	
}
