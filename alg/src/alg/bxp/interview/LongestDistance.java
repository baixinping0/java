package alg.bxp.interview;

import org.junit.Test;

/*
 * 美团：
 * 有一个长为n的数组A，求满足0≤a≤b<n的A[b]-A[a]的最大值。
	给定数组A及它的大小n，请返回最大差值。 
	测试样例：
	[10,5],2
	返回：0
 */
public class LongestDistance {

	@Test
	public void test(){
		System.out.println(getDis(new int[]{10,5,6}, 3));
	}
	/**
	 * @param A
	 * @param n
	 * @return
	 */
	public int getDis(int[] A, int n) {
		int max = 0;
		/*
		 * 1、每次循环算出差的最大值，存放
		 */
		for(int i = n - 1; i >= 0; i--){
			for(int j = i; j >= 0; j--){
				int val = A[i] - A[j];
				if(val > max)
					max = val;
			}
		}
		return max;
	}
}