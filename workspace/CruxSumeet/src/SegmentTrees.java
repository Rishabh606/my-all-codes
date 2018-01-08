

public class SegmentTrees {
	
	//ONLY AN EXAMPLE OF SEGMENT TREE, TO FIND THE MIN VALULE IN AN ARRAY 'ARR'
	
	private int[] segTree = {};
	private int arr_lenght = 0;
	
	public SegmentTrees(int[] arr){
		segTree = new int[segTreeLength(arr)];
		
		for(int i=0; i < segTree.length; i++){
            segTree[i] = Integer.MAX_VALUE;
		}
		arr_lenght = arr.length;
		constructTree(segTree, arr, 0, arr.length-1, 0);
	}
	
	private void constructTree(int[] segTree, int[] arr, int low, int high, int pos){
		if(low == high){
			segTree[pos] = arr[low];
			return;
		}
		int mid = (low+high)/2;
		
		
		constructTree(segTree, arr, low, mid, 2*pos+1);
		constructTree(segTree, arr, mid+1, high, 2*pos+2);
		segTree[pos] = Math.min(segTree[2*pos+1], segTree[2*pos+2]);
	}
	
	public int minQuery(int qlow, int qhigh){
		return this.minRange(segTree, qlow, qhigh, 0, arr_lenght-1, 0);
	}
	
	private int minRange(int segTree[], int qlow, int qhigh, int low, int high, int pos){
		// [qlow,qhigh] is our targeted range. [low,high] is the current node's range.
		if(qlow<=low && qhigh>= high){ // Total overlap
			return segTree[pos];
		}
		if(high<qlow || qhigh<low){ //No overlap
			return Integer.MAX_VALUE; //Return dummy value from here
		}
		
		int mid = (low+high)/2;								//Partial overlap
		
		
		return Math.min(minRange(segTree, qlow, qhigh, low, mid, 2*pos+1),
				minRange(segTree, qlow, qhigh, mid+1, high, 2*pos+2));
		//Return the query (in this case, finding minimun)
	}
	private void updateValueUtil(int ss, int se, int i, int diff, int si)
	    {
	        // Base Case: If the input index lies outside the range of 
	        // this segment
	        if (i < ss || i > se)
	            return;
	 
	        // If the input index is in range of this node, then update the
	        // value of the node and its children
	        segTree[si] = segTree[si] + diff;
	        int mid = (ss+se)/2;
	        if (se != ss) {
	            updateValueUtil(ss, mid, i, diff, 2 * si + 1);
	            updateValueUtil(mid + 1, se, i, diff, 2 * si + 2);
	        }
	    }
	 
	    // The function to update a value in input array and segment tree.
	   // It uses updateValueUtil() to update the value in segment tree
	   public void updateValue(int arr[], int n, int i, int new_val)
	    {
	        // Check for erroneous input index
	        if (i < 0 || i > n - 1) {
	            System.out.println("Invalid Input");
	            return;
	        }
	 
	        // Get the difference between new value and old value
	        int diff = new_val - arr[i];
	 
	        // Update the value in array
	        arr[i] = new_val;
	 
	        // Update the values of nodes in segment tree
	        updateValueUtil(0, n - 1, i, diff, 0);
	    }
	public int segTreeLength (int[] arr){
		int n = arr.length;
		while((n&(n-1)) != 0){
			n++;
		}
		return 2*n-1;
	}

	public void showSegTree(){
		for(int x: segTree){
			System.out.print(x +" ");
		}
		System.out.println();
	}
}
