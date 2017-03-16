package genetics1;

public class Equipment {
	private  double equLength;		//设备长度
	private  double equWidth;		//设备宽度
	private  double equWallMargin;	//设备距离墙的距离
	private  double cost;			//设备搬运费用
	
	public Equipment(double equLength, double equWidth, double equWallMargin,
			double cost) {
		super();
		this.equLength = equLength;
		this.equWidth = equWidth;
		this.equWallMargin = equWallMargin;
		this.cost = cost;
	}
	
	public double getEquLength() {
		return equLength;
	}
	public double getEquWidth() {
		return equWidth;
	}
	public double getEquWallMargin() {
		return equWallMargin;
	}
	public double getCost() {
		return cost;
	}
	
	
	
}
