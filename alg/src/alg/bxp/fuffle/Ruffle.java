package alg.bxp.fuffle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ruffle {
	public static void main(String[] args) throws IOException {	
		new Ruffle().fun();
	}
	public  void fun() throws IOException{
		//将输入的数据读出
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		int groupCount = Integer.parseInt(r.readLine());
		String[] infos = new String[groupCount * 2];
		int rowCount = 0;
		while (rowCount < groupCount * 2) {
			infos[rowCount] = r.readLine();
			rowCount++;
		}
		//循环洗牌组数
		for(int i = 0; i < infos.length; i+=2){
			//获取每组牌的数量和洗牌次数
			String[] info = infos[i].split(" ");
			//获取牌
			String[] infoString = infos[i + 1].split(" ");
			
			int n = Integer.parseInt(info[0]);
			int maxCount = Integer.parseInt(info[1]);
			//洗牌函数
			String[] result = fuffle(n, 1, maxCount, infoString);
					
			
			for(int j = 0; j < result.length; j++){
				System.out.print(result[j] + " ");
			}
			System.out.println();
		}
	}
	
	
	/**
	 * 
	 * @param n :共有2n张牌
	 * @param currentCount：当前是第几次洗牌
	 * @param maxCount：最多的洗牌次数
	 * @param infoString：上次的洗牌结果
	 * @return
	 */
	public String[] fuffle(int n, int currentCount, int maxCount, String[] infoString){
		//如果当前的洗牌次数大于总的洗牌次数，则返回
		if(currentCount > maxCount)
			return infoString;
		//进行洗牌
		//将后半部分插入前半部分
		
		for(int j = n; j < 2 * n; j++){
			//将前面的循环后移
			int i = 0;
			String posNum = infoString[j - i]; 
			while(i < n - 1){
				infoString[n-i] = infoString[n-i-1];
				i++;
			}
			infoString[n-i] = posNum;
		}
		
		return fuffle(n, currentCount + 1, maxCount, infoString);
	}
}
