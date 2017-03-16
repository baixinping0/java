package genetics1;

import java.awt.Choice;
import java.util.ArrayList;
import java.util.List;






import tools.PrintResult;

public class Main {
	
	/**
	 * 1、初始化车间。
	 * 2、初始化设备。
	 * 3、初始化计算过程所要使用到的其他的信息。
	 * 4、产生设备排列个体（同时计算个体中的属性），一次性产生三期，同时计算三期需要的属性，并保存。
	 * 5、 
	 */
	
	
	public  Result main(Data data, int flag) {
			
//			int flag = data.flag;
			Chaos.flag = flag;
			WorkShop workshop = null;
			List<Equipment> equipments = null;
			EquMutalRelation equMutalRelation = null;
			Species species = null;
			List<List<int []>> equRanks = new ArrayList<List<int []>>();		//用于存储所有的种群编码
			//用于放每期的最优结果
//			List<Result> optimalResult = new ArrayList<Result>();
			
			//初始化物种的基本属性
			species = new Species(data.producePeriod, data.indiCount, data.screenCount, workshop,data.variationRate, data.crossRate);
			//初始化车间
			workshop = new WorkShop(data.wsLength, data.wsWidth, 
					data.wsEquCount, data.wsRowWidth, data.wsFirstMargin);
			
			//初始化设备
			equipments = new ArrayList<Equipment>();
			for(int i = 0; i < data.wsEquCount; i ++){
				Equipment equipment = new Equipment(data.equLength[i], 
						data.equWidth[i], data.equWallMargin[i], data.cost[i]);
				equipments.add(equipment);
			}
			
			//初始化设备间的信息
			List<double[][]> Q = new ArrayList<double[][]>();
			Q.add(data.Q1);
			Q.add(data.Q2);
			Q.add(data.Q3);
			equMutalRelation = new EquMutalRelation(data.equMargin, data.P, Q);
			
			//创建计算的 类
			Calculate calculate = new Calculate(data.b1, data.b2, data.b3, data.TR,data.T);
			
			//随机产生设备的排列信息
			if(flag == 1)
				equRanks = SpeciesFactoary.getEquRanks(workshop, species.getProducePeriod(),species.getIndiCount());
			else {
				//通过混沌产生
				List<List<double[]>> chaosDoubleEquRank = Chaos.getTotalDoubleEquRank(100, species.getProducePeriod(), workshop.getEquCount(), data.u);
				
//				System.out.println("数组长度 ： " + chaosDoubleEquRank.size());
				
				List<List<int[]>> chaosEquRank = Chaos.getTotalIntRank(chaosDoubleEquRank);
				
				List<List<Ind>> chaosIndss = SpeciesFactoary.changIndss(chaosEquRank, workshop, equipments, equMutalRelation);
				List<Result> chaosResults = calculate.calAdaptive(chaosIndss, workshop, equipments, equMutalRelation);
				
				System.out.println("chaosEquRank="+chaosEquRank.size());
				//equRanks = chaosEquRank;
				
				//从解的区域中选出50个作为种子进行遗传
				for(int i = 0; i < 50; ++i)
				{
					int maxIndex = 0;
					for(int j = 0; j < chaosResults.size(); ++j)
					{
						double temp = chaosResults.get(0).getFitnessResult();
						if(chaosResults.get(j).getFitnessResult() > temp)
						{
							temp = chaosResults.get(j).getFitnessResult();
							maxIndex = j;
						}
					}
					
					List<int []> list = new ArrayList<int[]>();
					for(int p = 0; p < chaosIndss.get(maxIndex).size(); ++p)
					{		
						list.add(chaosIndss.get(maxIndex).get(p).getEquRank());
					}
					equRanks.add(list);
					chaosResults.remove(maxIndex);
					chaosIndss.remove(maxIndex);
				}
			}
			
			//初始化MyMain类
			SpeciesFactoary speciesFactoary = new SpeciesFactoary(workshop, equipments, equMutalRelation, equRanks, species, calculate);
			//存放每一代的最优结果
			List<Result> results = new ArrayList<Result>();
			
			//循环迭代次数
			int iterCount = data.resuleIteratorCount;
			
			for(int i = 0; i < iterCount; ++i)
			{
				speciesFactoary.initInf();	//初始化信息
				
				Result result = speciesFactoary.getOptimalResult();
				if(i == 0 || results.get(i-1).getFitnessResult() < result.getFitnessResult())	
					results.add(result);
				else
					results.add(results.get(i-1));
				speciesFactoary.selectAll();	//选择操作
						
				speciesFactoary.overlapAll();	//交叉操作
				
				speciesFactoary.variation(species.getVariationRate());	//变异操作	
			}
			
			//输出选择、交叉、变异之后每一代的最优结果
			/*for(int j = 0; j < results.size(); ++j)
			{
				System.out.println("最优结果代数：@@@@@@@@@@@@@@ "+ (j+1) + "代");
				PrintResult.print(results.get(j));
			}*/
			
			int maxIndex = serachMost(results);
			System.out.println("maxIndex=" + maxIndex);
			System.out.println("最优结果********");
			PrintResult.print(results.get(maxIndex));
			if(flag == 1){
				return results.get(maxIndex);
			}
			
			List<int[]> srcEquRank = new ArrayList<int[]>();
			for(int i = 0; i < results.get(maxIndex).getInds().size(); ++i)
			{
				srcEquRank.add(results.get(maxIndex).getInds().get(i).getEquRank());
			}
			
			List<List<int[]>> disResultEquRank = Chaos.disTotalEquRank(srcEquRank, data.resuleIteratorCount, maxIndex+1, data.m, data.u);
		/*	
			for(int i = 0; i < disResultEquRank.size(); ++i)
			{
				System.out.println("第" + (i+1) + "个");
				for(int t = 0; t < disResultEquRank.get(0).size(); ++t)
				{
					for(int j = 0; j < disResultEquRank.get(0).get(0).length; ++j)
					{
						System.out.print(disResultEquRank.get(i).get(t)[j] + " ");
					}
					System.out.println();
				}
			}*/
			
			List<List<Ind>> disIndss = SpeciesFactoary.changIndss(disResultEquRank, workshop, equipments, equMutalRelation);
			List<Result> disResult = calculate.calAdaptive(disIndss, workshop, equipments, equMutalRelation);
			maxIndex = serachMost(disResult);
			
			System.out.println("混沌扰动之后的最优结果：");
			for(int i = 0; i < disResult.size(); ++i)
			{
				PrintResult.print(disResult.get(i));
			}
			
			System.out.println("maxIndex=" + maxIndex);
			System.out.println("&&&&&&&&&&最终的最优结果：");
			PrintResult.print(disResult.get(maxIndex));
			return disResult.get(maxIndex);
		}
		
		public static int serachMost(List<Result> results)
		{
			double temp = results.get(0).getFitnessResult();
			int maxIndex = 0;
			for(int i = 1; i < results.size(); ++i)
			{
				if(results.get(i).getFitnessResult() > temp)
				{
					maxIndex = i;
					temp = results.get(i).getFitnessResult();
				}
			}
			
			return maxIndex;
		}
		
	
	
}
