package alg.bxp.sort;

import org.junit.Test;

public class QuickSoer {
	@Test
	public void test(){
		int[] data = new int[]{8,6,4,20,2,3,8,7,5,6,1,2,5,15,2,6,8,7,6,3,20,68,9,5,4,1,2,98,4,5,2,4,2,5,8,6,5,5,6,5,1,5,5,9};
		System.out.println("排序之前");
		for (int i : data) {
			System.out.print(i + "   ");
		}
		System.out.println();
		System.out.println("排序之后");
		quickStore(data, 0, data.length - 1);
		for (int i : data) {
			System.out.print(i + "   ");
		}
	}
	/**
	 * 思想：
	 * 1、选择一个基准点，以下代码是将最后一个元素作为基准点。
	 * 2、使用两个指针p和q。
	 * 3、然后判断p位置的值和基准值的大小，如果小将p和q对象的值进行交换。并将p++，q++。
	 * 如果大，只将p++，保证p和q之间的数据都是大于基准值的，q以前的数据都是小等于基准值的。
	 * 
	 * @param data
	 * @param startIndex
	 * @param endIndex
	 */
	public void quickStore(int[] data, int startIndex, int endIndex){
		if(startIndex >= endIndex){
			return;
		}
		int p = startIndex;
		int q = startIndex;
		while(p <= endIndex){
			if(data[p] <= data[endIndex]){
				int tmp = data[p];
				data[p] = data[q];
				data[q] = tmp;
				p ++;
				q ++;
			}else
				p++;
		}
		if(p == q)
			quickStore(data, 0, p - 2);
		else{
			quickStore(data, 0, p - 1);
			quickStore(data, p, q - 1);
		}
	}
}


















