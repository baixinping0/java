package tools;

import genetics1.Calculate;
import genetics1.EquMutalRelation;
import genetics1.Equipment;
import genetics1.Ind;
import genetics1.Result;
import genetics1.WorkShop;

import java.util.List;

public class PrintResult {
	public static void print(Result result){ 
		System.out.println("适应度结果：" + result.getFitnessResult());
		List<Ind> inds = result.getInds();
		System.out.println("设备间的搬运费用：" + result.getCarryCost());
		System.out.println("设备重置费用："+ result.getEquResttingCost());
		System.out.println("设备面积利用" + result.getAreaUse());
		for(int j = 0; j < inds.size(); j++){
			Ind ind = inds.get(j);
			int[] equ = ind.getEquRank();
			System.out.println();
			for(int i = 0; i < equ.length; i++){
				System.out.print(equ[i]+ "  ");
			}
			System.out.println();
			List<Integer> row = ind.getRowEquCounts();
			System.out.println("行数：" + row.size());
			for(int i = 0; i < row.size(); i++){
				System.out.println("第"+ i +"行的设备数量： " + row.get(i));
			}
			Point[] point = ind.getPoint();
			for(int i = 0; i < point.length; i++){
				System.out.print("第" + (i + 1) +"个设备 的坐标：(" + point[i].X+ "," + point[i].Y+")   ");
			}
			System.out.println();
			System.out.println();
		}
	}
	
	public static void separator(){
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("#################################混沌波动后结果");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
	}
	public static void printList(List<List<int[]>> equRankss){
		for(int i = 0; i < equRankss.size(); i++){
			List<int[]> list = equRankss.get(i);
			System.out.println("第" + i +"期");
			for(int j = 0; j < list.size(); j++){
				int[] equRank = list.get(j);
				System.out.print("第" + j + "行    ");
				for(int n = 0; n < equRank.length; n++){
					System.out.print(equRank[n] + "  " );
				}
				System.out.println();
			}
		}
	}
	
	public static void printArray(double[][] a){
		System.out.println();
		if(a != null)
			for(int i = 0; i < a.length; i++){
				for(int j = 0; j < a[i].length; j++){
					System.out.print(a[i][j] + "  ");
				}
				System.out.println();
			}
	}
	public static void printArray(double[] a){
		System.out.println();
		if(a != null)
			for(int i = 0; i < a.length; i++){
				System.out.print(a[i] + " ");
			}
		System.out.println();
	}
	
}
