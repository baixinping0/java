package genetics1;

import java.util.List;

public class Result {
	private List<Ind> 	Inds;			//存放每一行（三期）的所有个体
	private double	fitnessResult;		//存放适应度的结果
	private double equResttingCost;		//设备重置费用
	private double CarryCost;			//设备间物料搬运费用
	private double areaUse;				//面积使用率
		
	
	public double getEquResttingCost() {
		return equResttingCost;
	}
	public void setEquResttingCost(double equResttingCost) {
		this.equResttingCost = equResttingCost;
	}
	public double getCarryCost() {
		return CarryCost;
	}
	public void setCarryCost(double carryCost) {
		CarryCost = carryCost;
	}
	public double getAreaUse() {
		return areaUse;
	}
	public void setAreaUse(double areaUse) {
		this.areaUse = areaUse;
	}
	public void setInds(List<Ind> inds) {
		Inds = inds;
	}
	public void setFitnessResult(double fitnessResult) {
		this.fitnessResult = fitnessResult;
	}
	public List<Ind> getInds() {
		return Inds;
	}
	public double getFitnessResult() {
		return fitnessResult;
	}
	public Result(List<Ind> inds, double fitnessResult, double equResttingCost,
			double carryCost, double areaUse) {
		super();
		Inds = inds;
		this.fitnessResult = fitnessResult;
		this.equResttingCost = equResttingCost;
		CarryCost = carryCost;
		this.areaUse = areaUse;
	}
	
	public Result(Result result)
	{
		Inds = result.getInds();
		this.fitnessResult = result.getFitnessResult();
		this.equResttingCost = result.getEquResttingCost();
		CarryCost = result.getCarryCost();
		this.areaUse = result.getAreaUse();
	}
	
	
	
	
}
