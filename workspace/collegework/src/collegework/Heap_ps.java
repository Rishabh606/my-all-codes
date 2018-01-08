package collegework;

import java.util.ArrayList;
import java.util.HashMap;

public class Heap_ps {
private ArrayList<Integer> data;
private HashMap<Integer,Integer>posmap;
	public Heap_ps(){
		data = new ArrayList<Integer>();
		posmap = new HashMap<Integer,Integer>();
	}
	public boolean isEmpty(){
		return data.size()==0;
	}
	public void addHP(int key){
		data.add(key);
		posmap.put(key, data.size()-1);
		upheapify(data.size()-1);
	}
	private void upheapify(int ci) {
		// TODO Auto-generated method stub
		if(ci==0){
			return;
		}
		int pi = (ci-1)/2;
		if(data.get(pi)<data.get(ci)){
			swap(pi,ci);
			upheapify(pi);
		}
		return;
	}
	private void swap(int i , int j){
		int ith = data.get(i);
		int jth = data.get(j);
		posmap.put(ith, j);
		posmap.put(jth, i);
		data.set(i, jth);
		data.set(j, ith);
	}
	public int HP(){
		return data.get(0);
	}
	private void downheapify(int ci) {
		// TODO Auto-generated method stub
		if(ci>=data.size()){
			return;
		}
		int li = 2*ci + 1;
		int ri = 2*ci + 2;
		int maxi = ci;
		if(li< data.size() && data.get(li)> data.get(maxi)){
			maxi = li;
		}
		if(ri<data.size() && data.get(ri)>data.get(maxi)){
			maxi = ri;
		}
		if(maxi!=ci){
			swap(maxi,ci);
			downheapify(maxi);
		}
		return;
	}
	public int delete(){
		int rv = data.get(0);
		swap(0, data.size()-1);
		data.remove(data.size()-1);
		posmap.remove(rv);
		downheapify(0);
		return rv;
	}
	public Heap_ps(int...sa){
		this();
		for(int i:sa){
			data.add(i);
			posmap.put(i, data.size()-1);
		}
		for(int i = data.size()/2 - 1;i>=0;i--){
			downheapify(i);
		}
	}
	public void update(int key, int nkey){
		if(posmap.containsKey(key)){
			int pos = posmap.remove(key);
			data.set(pos, nkey);
			posmap.put(nkey, pos);
			upheapify(pos);
			downheapify(pos);
		}
	}
}
