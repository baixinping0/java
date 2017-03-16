package alg.bxp.binarySearch;

public class BinarySearch {
	public static void main(String[] args) {
		int[] a = new int[]{0,1,1,2,2};
		int po = new BinarySearch().getPos(a, a.length, 1);
		System.out.println(po);
	}
	
	 public int getPos(int[] A, int n, int val) {
	        
		 return fun(A, val, 0, n-1);
	  }
	 
	 public int fun(int[] A, int val, int start, int end){
		 
		 if(start > end){
			 return -1;
		 }
		 if(A[start] == val){
			 return start;
		 }
		 int middle = (start + end)/2;
		 if(val > A[middle]){
			 start = middle + 1;
			 return fun(A, val, start, end);
		 }
		 if(val < A[middle]){
			 end = middle - 1;
			 return fun(A, val, start, end);
		 }
		 if(val == A[middle]) {
			 if(A[middle - 1] == A[middle]){
				 return middle - 1;
			 }else {
				 return middle;
			}
			
		}
		 return -1;
	 }
}
