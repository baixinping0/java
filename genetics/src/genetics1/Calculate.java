package genetics1;

import java.util.ArrayList;
import java.util.List;

import tools.Operational;
import tools.Point;

public class Calculate {
	
	public  double b1 = 0;
	public  double b2 = 0;
	public  double b3 = 0;
	public  double TR = 0;
	public  double T = 0;
	
	public Calculate(double b1, double b2, double b3, double TR,double T){
		this.b1 = b1;
		this.b2 = b2;
		this.b3 = b3;
		this.TR = TR;
		this.T = T;
	}
	
	/**
	 * 计算设备间的物料搬运费用最少
	 * @param inds				三期的个体数据
	 * @param equMutalRelation	设备间的关系
	 * @return
	 */
	public  double calCarryCost(List<Ind> inds,EquMutalRelation equMutalRelation){
		double carryCost = 0;
		for(int t = 0; t < inds.size(); t++){
//			System.out.println(inds.size());
			//循环取出三期中的每一个个体
			Ind ind = inds.get(t);
			//分别取出每一个个体中的坐标
			Point[] point = ind.getPoint();
			for(int i = 0; i < point.length; i++){
				Point pointI = point[i];
				for(int j = 0; j < point.length; j++){
					Point pointJ = point[j];
					double xyij = Operational.add(Math.abs(Operational.sub(pointI.X ,pointJ.X)), Math.abs(Operational.sub(pointJ.Y , pointJ.Y)));
					carryCost = Operational.add(carryCost, Operational.mul(Operational.mul(equMutalRelation.getP(i, j) , equMutalRelation.getQ(t, i, j)) , xyij)); 
				}
			}
		}
		return carryCost;
	}
	/**
	 * 计算设备重置费用
	 * @param inds			三期的个体数据
	 * @param equipments	设备数据
	 * @param r				周期数
	 * @return
	 */
	public double calEquResttingCost(List<Ind> inds, List<Equipment> equipments){
		double equResttingCost = 0;
		int p = getp(inds);			//实际变化的周期数
		for(int i = 0; i < inds.size() - 1; i++){
			//j表示当前期数
			int j = 0;
			//获取本期的设备个体
			Ind ind = inds.get(j);
			//获取下一期，即变化后的设备个体
			Ind indN = inds.get(j + 1);
			//获得本期中的设备的排列`
			int[] equRank = ind.getEquRank();
			
			//循环本期的设备排列和下一期的进行比较
			for(int l = 0; l < equRank.length; l++){
				//获取本期的设备的编号
				int equNum = equRank[l];
				//获取此设备在本期中对应的坐标
				Point pointL = ind.getPointByEquNum(equNum);
				//通过本期中的设备的编号找到此设备在下一期中的坐标
				Point pointN = indN.getPointByEquNum(equNum);
				//通过设备的编号在全部的设备中获取此设备
				Equipment equipment = equipments.get(equNum - 1);
				//计算结果
				equResttingCost = Operational.add(equResttingCost , Operational.mul(equipment.getCost() , (Operational.add(Math.abs(Operational.sub(pointL.X, pointN.X)), Math.abs(Operational.sub(pointL.Y , pointN.Y))))));
						
			}
			j++;
		}
		return Operational.add(equResttingCost, Operational.mul(p , T));
	}
	
	/**
	 * 计算是否变化的周期p,为计算设备重置费用做准备
	 * @param inds	三期的个体数据
	 * @return
	 */
	public int getp(List<Ind> inds){
		int p = 0;
		String str = "";
		for(int i = 0; i < inds.size(); i++){
			int[] equRank = inds.get(i).getEquRank();
			String equRankString = new String(equRank ,0,equRank.length);
			if(!str.equals(equRankString))
				p++;
			str = equRankString;
		}
		return p;
	}
	/**
	 * 面积利用
	 * @param inds
	 * @param workShop
	 * @return
	 */
	public double calAreaUse(List<Ind> inds, WorkShop workShop,List<Equipment> equipments){
		double areaUse = 0;
		//获取期数
		int t = inds.size();
		for(int i = 0; i < inds.size(); i++){
			//获取每一期中的个体
			Ind ind = inds.get(i);
			int rowCount = ind.getRowEquCounts().size();
			areaUse += workShop.getWsLength()* ((rowCount - 1) * workShop.getRowWidth() + 0.5 * (ind.getFirstMaxWidth() + ind.getLastMaxWidth()));
		}
		//用于存放设备所占用的总面积
		float equArea = 0;
		for(int i = 0; i < equipments.size(); i++){
			Equipment equipment = equipments.get(i);
			equArea += (equipment.getEquLength() * equipment.getEquWidth());
		}
		return Operational.div(equArea, (areaUse/(t * 1.0)));
	}
	
	/**
	 * 计算适应度的结果
	 * @param indss			50行的个体
	 * @param workShop		车间
	 * @param equipments	全部的设备
	 * @param equMutalRelation	设备间的关系
	 * @return
	 */
	public  List<Result> calAdaptive(List<List<Ind>> indss, WorkShop workShop,
			List<Equipment> equipments,EquMutalRelation equMutalRelation) {
		List<Result> list = new ArrayList<Result>();
		
		double result = 0;
		double a1 = 0;
		double a2 = 0;
		double a3 = 0;
		double Pk = 0;
		//计算50行的和值
		for(int i = 0; i < indss.size(); i++){
			//获取每一行（三期）的个体集合
			List<Ind> inds = indss.get(i);
			a1 = Operational.add(a1, calCarryCost(inds, equMutalRelation));
			a2 = Operational.add(a2, calEquResttingCost(inds, equipments));
			a3 = Operational.add(a3, calAreaUse(inds, workShop, equipments));
		}
		//循环50行
		
		for(int i = 0; i < indss.size(); i++){
			//取出每行数据
			List<Ind> inds = indss.get(i);
			result = Operational.add(Operational.add(Operational.mul(Operational.mul((Operational.div(1.0,a1)), b1) , calCarryCost(inds, equMutalRelation)), 
					Operational.mul(Operational.mul((Operational.div(1.0,a2)), b2) , calEquResttingCost(inds, equipments))), 
					Operational.mul(Operational.mul((Operational.div(1.0, a3)) , b3) , calAreaUse(inds, workShop,equipments)));	
			//遍历一行（三期）数据，如果有一个个体被惩罚，则Pk = 50，并结束
			for(int j = 0; j < inds.size(); j++){
				if(inds.get(j).isPunish()){
					Pk = T;
					break;
				}
			}
			result = Operational.div(1.0,(Operational.add(result, Pk)));
//			result = (Operational.add(result, Pk));
//			System.out.println("第" + i + "行适应度结果：" + result);
			Result newResult = new Result(inds, result, 
					calEquResttingCost(inds, equipments), 
					calCarryCost(inds, equMutalRelation), 
					calAreaUse(inds, workShop,equipments));
			list.add(newResult);
		}
		return list;
	}
	
	/**
	 * 将每次的50行结果传入返回最优的个体
	 * @param results  50个结果
	 * @return
	 */
	public  Result getOptimalResult(List<Result> results){
		Result result = null;
		for(int i = 0; i < results.size(); i++){
			if(i == 0)
				result = results.get(i);
			if(result.getFitnessResult() < results.get(i).getFitnessResult())
				result = results.get(i);
		}
		return result;
	}
}
