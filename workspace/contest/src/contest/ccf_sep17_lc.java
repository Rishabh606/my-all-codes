package contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class ccf_sep17_lc {

	public static FastScanner scn = new FastScanner(System.in);

	public static void main(String[] args) {
		int t = scn.nextInt();
		for (int i = 0; i < t; i++) {
			
			  int n = scn.nextInt();
			  int m = scn.nextInt();
			  long[] arr = new long[n];
			  int[][] cmd =  takeinput(m, 3);
			//  int[] arr = scn.nextIntArray(n);
//			  chefsum_Q1(arr);
			// minperm();
//			chefpdig();
			seaco(arr,n,m,cmd);
			System.out.println();
		}
	}
	public static int[][] takeinput(int n, int m) {
		int[][] rv  = new int[n][m+1];
		for (int i = 0; i < n; i++) {
			for(int j = 0; j<m;j++){
				rv[i][j] = scn.nextInt();
			}
		}
		return rv;
	}
	public static void seaco(long[] arr, int n , int m, int[][]cmd) {
		// TODO Auto-generated method stub
		queryperf2(arr, cmd, n, m);
		/*for(int i = 0; i<m;i++){
			if(cmd[i][0]==1){
				arr[cmd[i][1]-1]+=cmd[i][3];
				if(cmd[i][2]<arr.length){
				arr[cmd[i][2]]-=cmd[i][3];
				}
			 }
		}*/
		int val = (int)Math.pow(10, 9) +7;
		System.out.print(arr[0]%val+" ");
		 for(int i = 1; i<n; i++){
			arr[i] = arr[i]+arr[i-1];
			System.out.print(arr[i]%val+" ");
		 }
	}
	/*public static void queryperf(LazySegmentTree tree,int[][]cmd,int m,int n,int cq, int rs, int re){
			if(rs>re||cq>re||re>m){
				return;
			}
			 if(cmd[cq][0]==1){
				tree.updateRange(n, cmd[cq][1]-1,cmd[cq][2]-1, 1); 
			 }else{
				 queryperf(tree, cmd, m, n, cmd[cq][1]-1, cmd[cq][1]-1, cmd[cq][2]-1);
			 }
		 queryperf(tree, cmd, m, n, cq+1, rs+1, re);
	}*/
/*	public static void queryperf2(long[] arr,int[][]cmd,int m,int n,int cq, int rs, int re){
		if(rs>re||cq>re||re>m){
			return;
		}
		 if(cmd[cq][0]==1){
			arr[cmd[cq][1]-1]+=1;
			if(cmd[cq][2]<arr.length){
			arr[cmd[cq][2]]-=1;
			}
			cmd[cq][3]++;
		 }else{
			 queryperf2(arr, cmd, m, n, cmd[cq][1]-1, cmd[cq][1]-1, cmd[cq][2]-1);
		 }
	 queryperf2(arr,cmd, m, n, cq+1, rs+1, re);
}*/
	public static void queryperf2(long[] arr,int[][]cmd, int n, int m){
	//	LazySegmentTree tree = new LazySegmentTree(m);
		/*for(int i = 0; i<m;i++){
			if(cmd[i][0]==1){
				cmd[i][3]++;
			 }
		}*/
		int num = (int)Math.pow(10, 9) +7;
		long[] qf = new long[m+1]; 
		FenwickTree tree = new FenwickTree();
		//tree.createTree(qf);
		for(int i = m-1; i>=0;i--){
			if(cmd[i][0]==2){
				cmd[i][3]++;
				long val = tree.getSum(qf, i);
				tree.updateBinaryIndexedTree(qf, (cmd[i][3]+val)%num, cmd[i][1]);
				tree.updateBinaryIndexedTree(qf, -((cmd[i][3]+val)%num), cmd[i][2]+1);
		//	long val = 	tree.getSum(n, i,i);
		//		tree.updateRange(m, cmd[i][1]-1, cmd[i][2]-1, cmd[i][3]+val);
			 }
		}
		for(int i = 0; i<m;i++){
			if(cmd[i][0]==1){
				long val = (tree.getSum(qf, i)+1)%num;
				arr[cmd[i][1]-1]+=val;
				if(cmd[i][2]<arr.length){
				arr[cmd[i][2]]-=val;
				}
			}
		}
	}
	public static void chefpdig() {
		String num = scn.next();
		HashMap<Integer, Integer> strg = new HashMap<Integer, Integer>();
		for (int i = 0; i < num.length(); i++) {
			if (strg.containsKey(Integer.parseInt(num.charAt(i) + ""))) {
				strg.put(Integer.parseInt(num.charAt(i) + ""), strg.get(Integer.parseInt(num.charAt(i) + "")) + 1);
			} else {
				strg.put(Integer.parseInt(num.charAt(i) + ""), 1);
			}
		}

		ArrayList<Integer> keyset = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			if (strg.containsKey(i)) {
				keyset.add(i);
			}
		}
		int[] alpha = new int[26];
		for (int i = 0; i < keyset.size(); i++) {
			for (int j = i; j < keyset.size(); j++) {
				if (j == i) {
					if (strg.get(keyset.get(i)) > 1) {
						int k = 10 * keyset.get(i) + keyset.get(j);
						if (k > 64 && k < 91) {
//							System.out.print((char) k);
							alpha[k-65] = 1;
						}
					}
				} else {
					int k = 10 * keyset.get(i) + keyset.get(j);
					if (k > 64 && k < 91) {
						alpha[k-65] = 1;
						//System.out.print((char) k);
					}
					int p = 10 * keyset.get(j) + keyset.get(i);
					if (p > 64 && p < 91) {
						alpha[p-65] = 1;;
//						System.out.print((char) p);
					}
				}
			}
		}
		for(int i = 0; i<26;i++){
			if(alpha[i]>0){
				System.out.print((char)(i+65));
			}
		}
		System.out.println();
	}

	public static void minperm() {
		int n = scn.nextInt();
		int m = 0;
		if (n % 2 == 0) {
			m = n;
		} else {
			m = n - 3;
		}
		String str = "";
		for (int i = 1; i <= m; i = i + 2) {
//		str = str + (i + 1)+" "+i+" ";
			System.out.print((i + 1)+" "+i+" ");
		}
		if (m == n) {
//			System.out.println(str);
		} else {
//			str += (n - 1) + " " + n + " " + (n - 2)+" ";
			System.out.print((n - 1) + " " + n + " " + (n - 2)+" ");
//			System.out.println(str);
		}
		System.out.println();
	}

	public static void chefsum_Q1(int[] arr) {
		// TODO Auto-generated method stub
		int pos = 0;
		int min = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (min > arr[i]) {
				min = arr[i];
				pos = i;
			}
		}
		System.out.println(pos + 1);
	}

}

class FenwickTree {

    /**
     * Start from index+1 if you updating index in original array. Keep adding this value  
     * for next node till you reach outside range of tree
     */
    public void updateBinaryIndexedTree(long binaryIndexedTree[], long val, int index){
        while(index < binaryIndexedTree.length){
            binaryIndexedTree[index] += val;
            index = getNext(index);
        }
    }
    
    /**
     * Start from index+1 if you want prefix sum 0 to index. Keep adding value
     * till you reach 0
     */
    public long getSum(long binaryIndexedTree[], int index){
        index = index + 1;
        long sum = 0;
        while(index > 0){
            sum += binaryIndexedTree[index];
            index = getParent(index);
        }
        return sum;
    }
    
    /**
     * Creating tree is like updating Fenwick tree for every value in array
     */
    public long[] createTree(long input[]){
        long binaryIndexedTree[] = new long[input.length+1];
        for(int i=1; i <= input.length; i++){
            updateBinaryIndexedTree(binaryIndexedTree, input[i-1], i);
        }
        return binaryIndexedTree;
    }
    
    /**
     * To get parent
     * 1) 2's complement to get minus of index
     * 2) AND this with index
     * 3) Subtract that from index
     */
    private int getParent(int index){
        return index - (index & -index);
    }
    
    /**
     * To get next
     * 1) 2's complement of get minus of index
     * 2) AND this with index
     * 3) Add it to index
     */
    private int getNext(int index){
        return index + (index & -index);
    }
    
   /* public static void main(String args[]){
        int input[] = {1,2,3,4,5,6,7};
        FenwickTree ft = new FenwickTree();
        int binaryIndexedTree[] = ft.createTree(input);
        assert 1 == ft.getSum(binaryIndexedTree, 0);
        assert 3 == ft.getSum(binaryIndexedTree, 1);
        assert 6 == ft.getSum(binaryIndexedTree, 2);
        assert 10 == ft.getSum(binaryIndexedTree, 3);
        assert 15 == ft.getSum(binaryIndexedTree, 4);
        assert 21 == ft.getSum(binaryIndexedTree, 5);
        assert 28 == ft.getSum(binaryIndexedTree, 6);
    }*/
}
//Java program to demonstrate lazy propagation in segment tree
class LazySegmentTree
{
  int MAX;        // Max tree size
  long tree[];   // To store segment tree
  long lazy[];  // To store pending updates
  LazySegmentTree(int max){
 	this.MAX = (int) (2*(Math.pow(2, Math.ceil(Math.log(max)/Math.log(2)))) -1);
 	tree = new long[MAX];
 	lazy =  new long[MAX];
 }


 /*  si -> index of current node in segment tree
     ss and se -> Starting and ending indexes of elements for
                  which current nodes stores sum.
     us and eu -> starting and ending indexes of update query
     ue  -> ending index of update query
     diff -> which we need to add in the range us to ue */
 
 void updateRangeUtil(int si, int ss, int se, int us,
                      int ue, long diff)
 {
     // If lazy value is non-zero for current node of segment
     // tree, then there are some pending updates. So we need
     // to make sure that the pending updates are done before
     // making new updates. Because this value may be used by
     // parent after recursive calls (See last line of this
     // function)
     if (lazy[si] != 0)
     {
         // Make pending updates using value stored in lazy
         // nodes
         tree[si] += (se - ss + 1) * lazy[si];

         // checking if it is not leaf node because if
         // it is leaf node then we cannot go further
         if (ss != se)
         {
             // We can postpone updating children we don't
             // need their new values now.
             // Since we are not yet updating children of si,
             // we need to set lazy flags for the children
             lazy[si * 2 + 1] += lazy[si];
             lazy[si * 2 + 2] += lazy[si];
         }

         // Set the lazy value for current node as 0 as it
         // has been updated
         lazy[si] = 0;
     }

     // out of range
     if (ss > se || ss > ue || se < us)
         return;

     // Current segment is fully in range
     if (ss >= us && se <= ue)
     {
         // Add the difference to current node
         tree[si] += (se - ss + 1) * diff;

         // same logic for checking leaf node or not
         if (ss != se)
         {
             // This is where we store values in lazy nodes,
             // rather than updating the segment tree itelf
             // Since we don't need these updated values now
             // we postpone updates by storing values in lazy[]
             lazy[si * 2 + 1] += diff;
             lazy[si * 2 + 2] += diff;
         }
         return;
     }

     // If not completely in rang, but overlaps, recur for
     // children,
     int mid = (ss + se) / 2;
     updateRangeUtil(si * 2 + 1, ss, mid, us, ue, diff);
     updateRangeUtil(si * 2 + 2, mid + 1, se, us, ue, diff);

     // And use the result of children calls to update this
     // node
     tree[si] = tree[si * 2 + 1] + tree[si * 2 + 2];
 }

 // Function to update a range of values in segment
 // tree
 /*  us and eu -> starting and ending indexes of update query
     ue  -> ending index of update query
     diff -> which we need to add in the range us to ue */
 void updateRange(int n, int us, int ue, long l)  {
     updateRangeUtil(0, 0, n - 1, us, ue, l);
 }

 void constructSTUtil(long arr[], int low, int high, int pos)
 {
 	if(low == high){
         tree[pos] = arr[low];
         return;
     }
     int mid = (low + high)/2;
     constructSTUtil(arr, low, mid, 2 * pos + 1);
     constructSTUtil(arr, mid + 1, high, 2 * pos + 2);
     tree[pos] = tree[2*pos+1]+ tree[2*pos+2];
 }

 /* Function to construct segment tree from given array.
    This function allocates memory for segment tree and
    calls constructSTUtil() to fill the allocated memory */
 void constructST(long arr[], int n)
 {
     // Fill the allocated memory st
     constructSTUtil(arr, 0, n - 1, 0);
 }
 long getSumUtil(int ss, int se, int qs, int qe, int si)
 {
     // If lazy flag is set for current node of segment tree,
     // then there are some pending updates. So we need to
     // make sure that the pending updates are done before
     // processing the sub sum query
     if (lazy[si] != 0)
     {
         // Make pending updates to this node. Note that this
         // node represents sum of elements in arr[ss..se] and
         // all these elements must be increased by lazy[si]
         tree[si] += (se - ss + 1) * lazy[si];

         // checking if it is not leaf node because if
         // it is leaf node then we cannot go further
         if (ss != se)
         {
             // Since we are not yet updating children os si,
             // we need to set lazy values for the children
             lazy[si * 2 + 1] += lazy[si];
             lazy[si * 2 + 2] += lazy[si];
         }

         // unset the lazy value for current node as it has
         // been updated
         lazy[si] = 0;
     }

     // Out of range
     if (ss > se || ss > qe || se < qs)
         return 0;

     // At this point sure, pending lazy updates are done
     // for current node. So we can return value (same as
     // was for query in our previous post)

     // If this segment lies in range
     if (ss >= qs && se <= qe)
         return tree[si];

     // If a part of this segment overlaps with the given
     // range
     int mid = (ss + se) / 2;
     return getSumUtil(ss, mid, qs, qe, 2 * si + 1) +
            getSumUtil(mid + 1, se, qs, qe, 2 * si + 2);
 }

 // Return sum of elements in range from index qs (query
 // start) to qe (query end).  It mainly uses getSumUtil()
 long getSum(int n, int qs, int qe)
 {
     // Check for erroneous input values
     if (qs < 0 || qe > n - 1 || qs > qe)
     {
         return 0;
     }

     return getSumUtil(0, n - 1, qs, qe, 0);
 }

 void updateAll(int ci, int ss, int se){
 	if(ss>se||ci>tree.length){
 		return;
 	}
         if(lazy[ci]!=0){
         	  tree[ci] += (se - ss + 1) * lazy[ci];
               if (ss != se)
               {
                   lazy[ci * 2 + 1] += lazy[ci];
                   lazy[ci * 2 + 2] += lazy[ci];
               }
               lazy[ci] = 0;
         }
         if(ss==se){
        	 
         	System.out.print(tree[ci]+" ");
         	return;
         }
         int mid = (ss+se)/2;
         updateAll(2*ci+1, ss, mid);
         updateAll(2*ci+2,mid+1, se);
 	}
 void Totalupdate(int n){
 	updateAll(0, 0, n-1);
 }
 // Driver program to test above functions
}
class FastScanner {
	BufferedReader reader;
	StringTokenizer st;

	FastScanner(InputStream stream) {
		reader = new BufferedReader(new InputStreamReader(stream));
		st = null;
	}

	String next() {
		while (st == null || !st.hasMoreTokens()) {
			try {
				String line = reader.readLine();
				if (line == null) {
					return null;
				}
				st = new StringTokenizer(line);
			} catch (Exception e) {
				throw new RuntimeException();
			}
		}
		return st.nextToken();
	}

	String nextLine() {
		String s = null;
		try {
			s = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return s;
	}

	int nextInt() {
		return Integer.parseInt(next());
	}

	long nextLong() {
		return Long.parseLong(next());
	}

	double nextDouble() {
		return Double.parseDouble(next());
	}

	char nextChar() {
		return next().charAt(0);
	}

	int[] nextIntArray(int n) {
		int[] a = new int[n];
		int i = 0;
		while (i < n) {
			a[i++] = nextInt();
		}
		return a;
	}

	long[] nextLongArray(int n) {
		long[] a = new long[n];
		int i = 0;
		while (i < n) {
			a[i++] = nextLong();
		}
		return a;
	}

	int[] nextIntArrayOneBased(int n) {
		int[] a = new int[n + 1];
		int i = 1;
		while (i <= n) {
			a[i++] = nextInt();
		}
		return a;
	}

	long[] nextLongArrayOneBased(int n) {
		long[] a = new long[n + 1];
		int i = 1;
		while (i <= n) {
			a[i++] = nextLong();
		}
		return a;
	}

	void close() {
		try {
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
