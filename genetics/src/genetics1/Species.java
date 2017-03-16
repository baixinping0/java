package genetics1;


public class Species {
	private int producePeriod;		//周期
	private int indiCount;			//每期的个体数量（每期初始产生多少个1-8的编码）
	private int screenCount;		//选择交叉变异的次数
	private double variationRate;	//变异的概率
	private double crossRate;		//交叉概率
	
	public Species(int producePeriod, int indiCount, int screenCount, 
			WorkShop workshop, double variationRate, double crossRate) {
		this.producePeriod = producePeriod;
		this.indiCount = indiCount;
		this.screenCount = screenCount;
		this.variationRate = variationRate;
		this.crossRate = crossRate;
	}
	public int getProducePeriod() {
		return producePeriod;
	}
	public int getIndiCount() {
		return indiCount;
	}
	public int getScreenCount() {
		return screenCount;
	}
	
	public double getVariationRate() {
		return variationRate;
	}
	public double getCrossRate() {
		return crossRate;
	}
	
	
	
}
