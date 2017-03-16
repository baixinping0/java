package genetics1;

import java.util.ArrayList;
import java.util.List;






import tools.Operational;

public class Chaos {
		
	public static int flag = 0;
	public static final int GA = 1;
	public static final int L_CGA = 2;
	public static final int T_CGA = 3;
	/**
	 * 将最优解的排列信息进行波动，返回一个list集合
	 * @param srcEquRank	最优结果的排列信息
	 * @param disCount		混沌扰动次数
	 * @param k				迭代次数
	 * @param m				扰动参数
	 * @param u				扰动参数
	 * @return
	 */
	
	public static List<List<int[]>> disTotalEquRank(List<int[]> srcEquRank, int disCount, int k, int m, double u)
	{
		List<List<int[]>> destList = new ArrayList<List<int[]>>();
		
		destList.add(srcEquRank);
		
		for(int i = 0; i < disCount-1; ++i)
		{
			List<int[]> list = new ArrayList<int[]>();
			for(int t = 0; t < srcEquRank.size(); ++t)
			{
				double[] src = intToDoubleRank(destList.get(i).get(t));
				list.add(doubleToIntRank(chaosDistribute(k, m, src, u)));
			}
			destList.add(list);
		}
		
		return destList;
	}
	
	
	/**
	 * 将所有的小数排列转化为整数排列
	 * @param srcList
	 * @return
	 */
	public static List<List<int[]>> getTotalIntRank(List<List<double[]>> srcList)
	{
		List<List<int[]>> destList = new ArrayList<List<int[]>>();
		for(int i = 0; i < srcList.size(); ++i)
		{
			List<int[]> oneList = new ArrayList<int[]>();
			for(int j = 0; j < srcList.get(0).size(); ++j)
			{
				oneList.add(doubleToIntRank(srcList.get(i).get(j)));
			}
			destList.add(oneList);
		}
		return destList;
	}
	
	
	/**
	 * 产生所有三期的0-1的排列
	 * @param indCount	每一期个体个数
	 * @param tCount	期数
	 * @param n			设备个数
	 * @param u			混沌变动参数
	 * @return
	 */
	public static List<List<double[]>> getTotalDoubleEquRank(int indCount, int tCount, int n, double u)
	{
		List<List<double[]>> list = new ArrayList<List<double[]>>();
		list.add(getOneTotalPeroidEquRank(tCount, n));
		
		for(int i = 0; i < indCount-1; ++i)
		{
			List<double[]> onePeriodList = new ArrayList<double[]>();
			
				//有u的算法
			for(int t = 0; t < tCount; ++t){
//				if(flag == L_CGA){
					onePeriodList.add(chaosAdjust(list.get(i).get(t), u));
//				}else if(flag == T_CGA){
//				//没有u的算法
//					onePeriodList.add(chaosAdjust(list.get(i).get(t)));
//				}
			}
			
			if(flag == T_CGA){
				for(int p = 1; p <= i && p < 5; ++p)
				{
					for(int t = 0; t < onePeriodList.size(); ++t)
					{
						double[] rank = onePeriodList.get(t).clone();
						for(int j = 0; j < onePeriodList.get(0).length; ++j)
						{	
							if(rank[j] == list.get(i-p).get(t)[j] || 
								rank[j]==0 || rank[j]==0.25 || rank[j]==0.5 || rank[j]==0.75)
							{
								//重置xk;
								rank[j] = Math.abs(Math.random());
							}
						}
						onePeriodList.set(t, rank);
					}
				}
			}
						
			list.add(onePeriodList);
		}
		
		return list;
	}
	
	/**
	 * 产生一个三期的设备的小数排列信息
	 * @param tCount	总期数
	 * @param n			设备数量
	 * @return
	 */
	public static List<double[]> getOneTotalPeroidEquRank(int tCount, int n)
	{
		List<double[]> list = new ArrayList<double[]>();
		
		for(int i = 0; i < tCount; ++i)
		{
			list.add(productDoubleRand(n));
		}
				
		return list;
	}
	
	
	/**
	 * 最优结果迭代一次
	 * @param k
	 * @param m
	 * @param src
	 * @param u
	 * @return
	 */
	public static double[] chaosDistribute(int k, int m, double[] src, double u)
	{
		double[] dest = new double[src.length];
		double q = calQ(k, m);
		double[] chaos = null;
//		if(flag == L_CGA){
//			//有u的算法
		chaos = chaosAdjust(src, u);
//		}else if(flag == T_CGA){
//			没有u的算法
//			chaos = chaosAdjust(src);
//		}
		
		
		for(int i = 0; i < dest.length; ++i)
		{
			//dest[i] = (1-q) * src[i] + q*chaos[i];
			dest[i] = Operational.add(Operational.mul(Operational.sub(1, q), src[i]),
									 Operational.mul(q, chaos[i]));
		}
		
		return dest;
	}
	/**
	 * 迭代方法1、
	 * 产生编码迭代一次
	 * @param src
	 * @param u
	 * @return
	 */
	public static double[] chaosAdjust(double[] src, double u)
	{
		double[] dest = new double[src.length];
		for(int i = 0; i < dest.length; ++i)
		{
			if(flag == L_CGA){
				dest[i] = Operational.mul(u ,Operational.mul( src[i], (1-src[i])));
			}
				//dest[i] = u * src[i] * (1-src[i]);
				
			else if(flag == T_CGA){
				if(src[i] >= 0 && src[i] <= 0.5)
					//dest[i] = 2*src[i];
					dest[i] = Operational.mul(2, src[i]);
				else
					//dest[i] = 2 * (1-src[i]);
					dest[i] = Operational.mul(2, Operational.sub(1, src[i]));
			}
		}
		
		return dest;
	}
	/**
	 * 迭代方法2、
	 * @param src
	 * @return
	 */
//	public static double[] chaosAdjust(double[] src)
//	{
//		double[] dest = new double[src.length];
//		for(int i = 0; i < dest.length; ++i)
//		{
//			if(src[i] >= 0 && src[i] <= 0.5)
//				//dest[i] = 2*src[i];
//				dest[i] = Operational.mul(2, src[i]);
//			else
//				//dest[i] = 2 * (1-src[i]);
//				dest[i] = Operational.mul(2, Operational.sub(1, src[i]));
//		}
//		return dest;
//	}
	/**
	 * 将int数组转换成double类型
	 * @param src
	 * @return
	 */
	public static double[] intToDoubleRank(int[] src)
	{
		double[] dest = new double[src.length];
		for(int i = 0; i < dest.length; ++i)
		{
			dest[i] = Operational.div(src[i]-1, src.length-1);
		}
		
		return dest;
	}
	
	/**
	 * 计算0
	 * @param k
	 * @param m
	 * @return
	 */
	public static double calQ(int k, int m)
	{
		double result = 0;
		
		//result = 1 - Math.pow((k-1)/1.0/k, m);
		//ArithUtil.sub(k, 1)
		result = Operational.sub(1, Math.pow(Operational.div(k-1, k), m));
		
		return result;
	}
	/**
	 * 产生0-1间的一组随机排列
	 * @param n
	 * @return
	 */
	public static double[] productDoubleRand(int n)
	{ 
		double[] rand = new double[n];
		
		for(int i = 0; i < rand.length; ++i)
		{
			rand[i] = Math.abs(Math.random());
		}
		return rand;
	}
	
	/**
	 * 0-1间的排列转换到1-8之间
	 * @param src
	 * @return
	 */
	public static int[] doubleToIntRank(double[] src)
	{ 
		double[] aa = new double[src.length];
		for(int i = 0; i < src.length; i++){
			aa[i] = src[i];
		}
		int[] dest = new int[aa.length];
		
		for(int i = 0; i < aa.length; ++i) 
		{
			double temp = aa[i]; 
			int maxIndex = i; 
			for(int j = 0; j < aa.length; ++j)
			{
				if(aa[j] > temp)
				{
					maxIndex = j; 
					temp = aa[j];
				}	 		
			}  
			dest[i] = maxIndex+1;
			aa[maxIndex] = -1;	
		}
		return dest;
	}
	
	
	
	
}
