package genetics1;

import java.io.Serializable;

public class Data implements Serializable{
	/**
	 * 
	 */
	public Data() {
		
	}
//	private static final long serialVersionUID = -8227367986883549395;
	//车间需要的数据
	public  double wsLength;
	public  double wsWidth;
	public  int wsEquCount;			//设备的数量
	public  double wsRowWidth; 		//车间中存放设备时每行设备的宽度
	public  double wsFirstMargin;	//第一行设备距离墙的宽度
//	public   double wsT = 500;				//500
	
	
	//设备需要的数据
	//***************************************************
	public  double[] equLength = null; 
	public  double[] equWidth = null;
	public  double[] equWallMargin = null;
	public  double[] cost = null;
	
	
	//设备间关系需要的数据
	//***************************************************
	public  double[][] equMargin = null;
	public  double[][] P = null;
	public  double[][] Q1 = null;
	public  double[][] Q2 = null;
	public  double[][] Q3 = null;
	
	
	
	//种群需要用到的数据
	//***************************************************
	public   int producePeriod ;		//周期
	public   int indiCount ;			//个体数量（每期初始产生多少个1-8的编码）
	public   int screenCount;			//选择变异的次数
	public   double variationRate;		//变异概率
	public   double crossRate;			//交叉概率
	
	//计算时需要用到的数据
	public   double b1;
	public   double b2;
	public   double b3;
	public   double TR;				//设备重置时需要用到的TR
	public   double T;				//罚函数
	
	//混沌迭代时需要用到的数据
	public   int resuleIteratorCount;
	public   double u;
	public   int m;
	
//	//算法选择标志位
//	public int flag = 0;
}
