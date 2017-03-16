package alg.bxp.sort;

import org.junit.Test;

public class InsertSort {
	
	@Test
	public void test(){
		int[] data = new int[]{4,6,8,3,5,1,5,7};
		insert2(data);
		for (int i : data) {
			System.out.print(i + "  ");
		}
	}
	/**
	 * 实现：
	 * 让数组的前半部分都是排序好的，将后面的数据一个一个往前插入。不符合要求的数据就往后移动。
	 * @param data
	 */
	//实现二：
	public void insert2(int[] data){
		for(int i = 1; i < data.length; i++){
			int tmp = data[i];
			int j = i;
			while(j > 0 && tmp > data[j - 1]){
				data[j] = data[j - 1];
				j--;
			}
			data[j] = tmp;
		}
	}
	//实现一：
	public void insert(int[] data){
		for(int i = 1; i < data.length; i++){
			int tmp = data[i];
			for(int j = i; j >= 0; j--){
				if(tmp > data[j - 1]){
					data[j] = data[j - 1]; 
					if(j -1 == 0){
						data[j - 1] = tmp;
						break;
					}
				}else{
					data[j] = tmp;
					break;
				}
			}
		}
	}
}
