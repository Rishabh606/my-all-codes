import java.util.ArrayList;
import java.util.HashMap;

public class Ternary_Heap {
	private class Node{
		int rep;
		int pos;
		Node(int rep, int pos){
			this.rep = rep;
			this.pos = pos;
		}
	}
ArrayList<Integer> data;
HashMap<Integer,Node>posmap;
	public Ternary_Heap(){
		this.data = new ArrayList<Integer>();
		this.posmap = new HashMap<Integer, Node>();
	}
	public Ternary_Heap(int[]sa){
		this();
		for(int i:sa){
			if(posmap.containsKey(i)){
				Node nd = new Node(posmap.get(i).rep+1,posmap.get(i).pos);
				posmap.put(i,nd);
			}else{
				data.add(i);
				Node nd = new Node (0,data.size()-1);
				posmap.put(i, nd);
			}
		}
		for(int i = data.size()/3-1;i>=0;i--){
			downheapify(i);
		}
	}
	private void downheapify(int ci) {
		// TODO Auto-generated method stub
		if(ci<0){
			return;
		}
		int li = 3*ci +1;
		int mi = 3*ci+ 2;
		int ri = 3*ci +3;
		int maxi = ci;
		if(li<data.size() && data.get(maxi)>data.get(li)){
			maxi = li;
		}
		if(mi<data.size() && data.get(maxi)>data.get(mi)){
			maxi = mi;
		}
		if(ri<data.size() && data.get(maxi)>data.get(ri)){
			maxi = ri;
		}
		if(maxi!=ci){
			swap(ci,maxi);
			downheapify(maxi);
		}
		return;
	}
	private void swap(int i, int j) {
		// TODO Auto-generated method stub
		int ith = data.get(i);
		int jth = data.get(j);
		Node in = new Node(posmap.get(ith).rep, j);
		posmap.put(ith, in);
		Node jn = new Node(posmap.get(jth).rep, i);
		posmap.put(jth, jn);
		data.set(i, jth);
		data.set(j, ith);
	}
	public int HP(){
		return data.get(0);
	}
	public void insert(int i){
		if(posmap.containsKey(i)){
			Node nd = new Node(posmap.get(i).rep+1,posmap.get(i).pos);
			posmap.put(i,nd);
		}else{
			data.add(i);
			Node nd = new Node (0,data.size()-1);
			posmap.put(i, nd);
			upheapify(data.size()-1);
		}
	}
	private void upheapify(int ci) {
		if(ci==0){
			return;
		}
		int pi = (ci-1)/3;
		if(data.get(pi)>data.get(ci)){
			swap(pi,ci);
			upheapify(pi);
		}
		return;
	}
	private class strg{
		int rp;
		int min;
		strg(int rp, int min){
			this.rp = rp;
			this.min = min;
		}
	}
	private strg deleteMininfo(){
		int mini = data.get(0);
		strg rv = new strg(posmap.get(mini).rep,mini);
		swap(0,data.size()-1);
		data.remove(data.size()-1);
		posmap.remove(mini);
		downheapify(0);
		return rv;
	}
	public int deleteMin(){
		int rv = data.get(0);
		swap(0,data.size()-1);
		data.remove(data.size()-1);
		posmap.remove(rv);
		downheapify(0);
		return rv;
	}
	public void printHeap(){
		System.out.print("Start");
		for(int i :data){
			for(int j = 0;j<=posmap.get(i).rep;j++){
				System.out.print(", "+i);
			}
		}
		System.out.println(", END");
	//	System.out.println(data);
	}
	public void ksmallest(int k){
		ArrayList<Integer>arr = new ArrayList<Integer>();
		for(int i = 0; i<k;){
			strg m = deleteMininfo();
			for(int j = 0; j<=m.rp;j++,i++){
				arr.add(m.min);
			} 
		}
		System.out.println(arr);
		for(int i:arr){
			insert(i);
		}
	}
	public void PrintSmaller(int k){
		System.out.print("Start");
		printsmaller(k, 0);
		if(posmap.containsKey(k)){
			for(int i = 0;i<=posmap.get(k).rep;i++){
				System.out.print(", "+k);
			}
		}
		System.out.println(" ,END");
	}
	private void printsmaller(int k, int ci){
		if(ci<0){
			return;
		}
		if(data.get(ci)>k){
			return;
		}
		for(int i = 0;i<=posmap.get(data.get(ci)).rep;i++){
			System.out.print(", "+data.get(ci));
		}
		int li = 3*ci+1;
		int mi = 3*ci+2;
		int ri = 3*ci+3;
		
		if(li<data.size() && k>data.get(li)){
			printsmaller(k, li);
		}
		if(mi<data.size() && k>data.get(mi)){
			printsmaller(k, mi);
		}
		if(ri<data.size() && k>data.get(ri)){
			printsmaller(k, ri);
		}
		return;
	}
}
