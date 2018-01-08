package collegework;

import java.util.TreeSet;

public class client_hp_ps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Heap_ps pq = new Heap_ps(50,20,10,1,15,45,30,70,60,65,80);
		System.out.println(pq.HP());
		pq.addHP(100);
		pq.addHP(10);
		System.out.println(pq.HP());
		pq.update(100, 90);
		System.out.println(pq.delete());
		TreeSet <Integer> tr =new TreeSet<Integer>();
		tr.add(50);
		tr.add(20);
		tr.add(70);
		tr.add(10);
		tr.add(45);
		tr.add(30);
		tr.add(1);
		tr.add(15);
		tr.add(60);
		tr.add(80);
		tr.add(65);
		
		System.out.println("hey"+tr.last());
	}
}
