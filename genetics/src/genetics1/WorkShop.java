package genetics1;


public class WorkShop {
	private  double wsLength;	//车间的长度
	private  double wsWidth;	//车间的宽度
	private  int equCount;		//车间中所放的设备的数量
	private  double rowWidth;		//车间中存放设备时每行设备的宽度
	private  double firstMargin;	//第一行设备距离墙的宽度
	
	//private  double T;				//500
	
	
	
	public WorkShop() {

	}
	
	public WorkShop(double wsLength, double wsWidth, int equCount,
			double rowWidth, double firstMargin) {
		super();
		this.wsLength = wsLength;
		this.wsWidth = wsWidth;
		this.equCount = equCount;
		this.rowWidth = rowWidth;
		this.firstMargin = firstMargin;
	}
	
	
	
	
	public double getWsLength() {
		return wsLength;
	}
	public double getWsWidth() {
		return wsWidth;
	}
	public int getEquCount() {
		return equCount;
	}
	public double getRowWidth() {
		return rowWidth;
	}
	public double getFirstMargin() {
		return firstMargin;
	}
	
}
