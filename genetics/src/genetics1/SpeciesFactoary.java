package genetics1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Random;

import tools.Backup;
import tools.Operational;

public class SpeciesFactoary {

	private WorkShop workshop;
	private List<Equipment> equipments;
	private EquMutalRelation equMutalRelation;
	private List<List<int []>> equRanks;
	private List<Result> optimalResult; //适应度结果
	private List<List<Ind>> indss;
	private Species species = null;
	private Calculate calculate = null;
	
	/**
	 * @param ws	车间信息
	 * @param equ	设备信息
	 * @param equMuRe	设备间关系
	 * @param equRanks	设备排列信息
	 */
	
	public SpeciesFactoary(WorkShop ws, List<Equipment> equ,
			EquMutalRelation equMuRe, List<List<int []>> equRanks,
			Species species, Calculate calculate)
	{
		this.workshop = ws;
		this.equipments = equ;
		this.equMutalRelation = equMuRe;
		this.equRanks = equRanks;
		this.species = species;
		this.calculate = calculate;
	}
	
	public List<Result> getResult()
	{
		return optimalResult;
	}
	
	
	/**
	 * 变异
	 * @param varPro 变异概率
	 */
	public void variation(double varPro)
	{
		int varCount = (int) (equRanks.size()*varPro);
		
		
		for(int t = 0; t < equRanks.get(0).size(); ++t)
		{
			int[] var = SpeciesFactoary.getCodes(equRanks.size());
			
		/*	if(t == 0)
			{
				for(int i = 0; i < varCount; ++i)
				{
					System.out.print(var[i] + " ");
				}
				System.out.println();
			}*/
			
			for(int i = 0; i < varCount; ++i)
			{
				int[] exchange = SpeciesFactoary.getCodes(equRanks.get(0).get(0).length);
				int[] rank = equRanks.get(var[i]-1).get(t).clone();
				
				int temp = rank[exchange[0]-1];
				rank[exchange[0]-1] = rank[exchange[1]-1];
				rank[exchange[1]-1] = temp;
				equRanks.get(var[i]-1).set(t, rank);
			}
		}
		
	}
	
	/**
	 * 选择操作
	 */
	public void selectAll()
	{
		double[] fitnessNum = SpeciesFactoary.getAdaptiveResultRateSum(optimalResult);
		
		
		for(int t = 0; t < equRanks.get(0).size(); ++t)
		{
			for(int i = 0; i < equRanks.size(); ++i)
			{
				double rand = Math.abs(Math.random());
				for(int j = 0; j < fitnessNum.length; ++j)
				{
					if(rand < fitnessNum[j])
					{
						equRanks.get(i).set(t, indss.get(j).get(t).getEquRank());
						break;
					}
				}
			}
		}
	}
	
	/**
	 * 交叉操作
	 */
	public void overlapAll()
	{
		for(int t = 0; t < equRanks.get(0).size(); ++t)
		{
			int[] overlapArray = SpeciesFactoary.getCodes(equRanks.size());
			int count = (int)(overlapArray.length * species.getCrossRate());
		
			/*	if(t == 0)
			{
				System.out.println("overlapArray="+overlapArray.length);
				for(int p = 0; p < overlapArray.length; ++p)
					System.out.print(overlapArray[p] + " ");
				System.out.println();
			}*/
			
			for(int i = 0; i < count; i+=2)
			{
				overlapOne(t, overlapArray[i]-1, overlapArray[i+1]-1);
			}
			
		}
		
	}
	
	/**
	 * @param t 期数
	 * @param a 交叉个体a
	 * @param b 交叉个体b
	 */
	private void overlapOne(int t, int a, int b)
	{
		Hashtable<Integer, Integer> codeMap = new Hashtable<Integer, Integer>();
		int[] rank = SpeciesFactoary.getCodes(equRanks.get(0).get(0).length);
		int start = rank[0] < rank[1] ? rank[0] : rank[1];
		int end = rank[0] > rank[1] ? rank[0] : rank[1];
	
		
		List<Integer> listA = new ArrayList<Integer>();
		List<Integer> listB = new ArrayList<Integer>();
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		for(int i = start-1; i < end; ++i)
		{		
			listA.add(equRanks.get(a).get(t)[i]);
			listB.add(equRanks.get(b).get(t)[i]);
		}
		list.add(listA);
		list.add(listB);
		
		list = getMap(list);
		for(int i = 0; i < list.get(0).size(); ++i)
		{
			codeMap.put(list.get(0).get(i), list.get(1).get(i));
			codeMap.put(list.get(1).get(i), list.get(0).get(i));
		}
		
					
		
		int[] newRankA = equRanks.get(a).get(t).clone();
		int[] newRankB = equRanks.get(b).get(t).clone();
		for(int i = 0; i < equRanks.get(a).get(t).length; ++i)
		{		
			if(codeMap.get(equRanks.get(a).get(t)[i]) != null)
			{
				newRankA[i] = codeMap.get(equRanks.get(a).get(t)[i]);
			}
			
			if(codeMap.get(equRanks.get(b).get(t)[i]) != null)
			{
				newRankB[i] = codeMap.get(equRanks.get(b).get(t)[i]);
			}
		}
		
		
		equRanks.get(a).set(t, newRankA);
		equRanks.get(b).set(t, newRankB);
		
	}
	
	private List<List<Integer>> getMap(List<List<Integer>> list)
	{
		for(int i = 0; i < list.get(0).size(); ++i)
		{
			if(list.get(1).contains(list.get(0).get(i)))
			{
				list.get(0).remove(i);
				list.get(1).remove(i);
				return getMap(list);
			}
		}
		
		return list;
	}
	
	
	public Result getOptimalResult()
	{
		Result result = optimalResult.get(0);
		for(int i = 1; i < optimalResult.size(); i++){
			if(result.getFitnessResult() < optimalResult.get(i).getFitnessResult())
				result = optimalResult.get(i);
		}
		return new Result(result);
	}
	
	public void initInf()
	{
		indss = SpeciesFactoary.changIndss(equRanks, workshop, equipments, equMutalRelation);
		optimalResult = calculate.calAdaptive(indss, workshop, equipments, equMutalRelation);
	}
	
	
	
	public void showResult()
	{
		for(int i = 0; i < optimalResult.size(); ++i)
		{
			System.out.println(i + ":" + optimalResult.get(i).getFitnessResult());
		}
	}
	
	public void showOneEquRanks()
	{
		for(int t = 0; t < equRanks.get(0).size(); ++t)
		{
			System.out.println("第" + (t+1) +"期");
			for(int i = 0; i < equRanks.size(); ++i)
			{		
				System.out.print((i+1) + ": ");
				for(int j = 0; j < equRanks.get(i).get(t).length; ++j)
					System.out.print(equRanks.get(i).get(t)[j] + " ");
				System.out.println();
			}
		}	
	}
	
	// 产生一组随机编码
	public static int[] getCodes(int count) {
		// int equCount = workshop.getEquCount();

		int[] equDisorderCodes = new int[count];

		int[] equOrderCodes = new int[count];
		for (int i = 0; i < count; i++) {
			equOrderCodes[i] = i + 1;
		}

		Random random = new Random();
		// 用于记录最后的下标
		int endIndex = count - 1;
		for (int i = 0; i < count; i++) {
			int index;
			// 1、产生随机的下标
			if (endIndex != 0)
				index = random.nextInt(endIndex);
			else
				index = 0;
			// 2、将产生的随机下标在有序数组中对应的值赋值给无序数组
			equDisorderCodes[i] = equOrderCodes[index];
			// 3、将产生的下标对应的值和最后一个值进行交换

			int tem = equOrderCodes[index];
			equOrderCodes[index] = equOrderCodes[endIndex];
			equOrderCodes[endIndex] = tem;
			endIndex--;
		}
		return equDisorderCodes;
	}

	/**
	 * 产生50行个体编码
	 * 
	 * @param workshop
	 */
	public static ArrayList<List<int[]>> getEquRanks(WorkShop workshop,
			int producePeriod, int indiCount) {
		ArrayList<List<int[]>> equRanks = new ArrayList<List<int[]>>();
		for (int i = 0; i < indiCount; i++) {
			List<int[]> list = new ArrayList<int[]>();
			for (int j = 0; j < producePeriod; j++) {
				int[] equRank = getCodes(workshop.getEquCount());
				list.add(equRank);
			}
			equRanks.add(list);
		}
		return equRanks;
	}

	// 将50行的编码转化为个体
	public static List<List<Ind>> changIndss(List<List<int[]>> equRanks,
			WorkShop workshop, List<Equipment> equipments,
			EquMutalRelation equMutalRelation) {
		List<List<Ind>> indss = new ArrayList<List<Ind>>();
		for (int i = 0; i < equRanks.size(); i++) {
			List<Ind> list = new ArrayList<Ind>();
			for (int j = 0; j < equRanks.get(i).size(); j++) {
				Ind ind = new Ind(equRanks.get(i).get(j), workshop, equipments,
						equMutalRelation);
				ind.setPeriodNum(j + 1);
				list.add(ind);
			}
			indss.add(list);
		}
		return indss;
	}

	
	/**
	 * 计算比率的和值数组
	 * 
	 * @param results
	 * @return
	 */
	private static double[] getAdaptiveResultRateSum(List<Result> results) {
		// 存放结果的和值
		double adaptiveResultSum = 0;
		// 存放适应度结果的比率
		double[] adaptiveResultRate = new double[results.size()];
		// 计算适应度的比率和
		double[] adaptiveResultRateSum = new double[results.size()];

		for (int i = 0; i < results.size(); i++) {
			// 循环遍历50个结果,计算出结果的和值
			adaptiveResultSum = Operational.add(adaptiveResultSum,
					results.get(i).getFitnessResult());
		}
		for (int i = 0; i < results.size(); i++) {
			// 循环遍历50个结果,计算出每个适应度结果的比率，存入数组
			adaptiveResultRate[i] = Operational.div(
					(results.get(i).getFitnessResult()), adaptiveResultSum);
		}

		for (int i = 0; i < adaptiveResultRate.length; i++) {
			// 循环50比率，将加和存放
			if (i == 0)
				adaptiveResultRateSum[i] = adaptiveResultRate[i];
			else
				adaptiveResultRateSum[i] = Operational.add(
						adaptiveResultRateSum[i - 1], adaptiveResultRate[i]);
		}
		return adaptiveResultRateSum;
	}

	


	/**
	 * 将在选择时将每个集合中存放的3个编码的50个行元素转换为每个集合中存放50个编码的3个列元素转换回去，便于下一次的运算。
	 * 
	 * @param equRankss
	 * @return
	 */
	public static List<List<int[]>> changeNewCodes(List<List<int[]>> equRankss) {
		List<List<int[]>> list = new ArrayList<List<int[]>>();
		// 循环行，50次
		for (int i = 0; i < equRankss.get(0).size(); i++) {
			List<int[]> list2 = new ArrayList<int[]>();
			for (int j = 0; j < equRankss.size(); j++) {
				list2.add(equRankss.get(j).get(i));
			}
			list.add(list2);
		}
		return list;
	}
}
