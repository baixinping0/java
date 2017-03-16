package genetics1;


import java.util.ArrayList;
import java.util.List;

import tools.Operational;
import tools.Point;

public class Ind {
	private int equRank[];				//设备1—8排列
	private int periodNum;				//此个体属于第几期
	private List<Integer> rowEquCounts;	//每行设备的数量 
	private Point[] point;				//此设备排列中的每个设备的坐标
	private double 	firstMaxWidth;	
	private double 	lastMaxWidth;
	private  boolean isPunish =  false;
//	public Ind(){
//		
//	}
	public Ind(int[] equRank,WorkShop workshop, 
			List<Equipment> equipments, EquMutalRelation equMutalRelation){
		initAttr(equRank, workshop, equipments, equMutalRelation);
		isPunish = judgeIsPunish(workshop);
	}
	
	//判断是否惩罚
	private boolean judgeIsPunish(WorkShop workshop){
		double width = (rowEquCounts.size() - 1) * workshop.getRowWidth() + workshop.getFirstMargin() + 0.5 *lastMaxWidth;
		if(width > workshop.getWsWidth())
			return true;
		return false;
	}
	
	public void initAttr(int[] equRank,WorkShop workShop, 
			List<Equipment> equipments, EquMutalRelation equMutalRelation){
		setEquRank(equRank);
		setRowEquCountsAndPoint(workShop, equipments, 
				equMutalRelation);
		setFirstMaxWidth(equipments);
		setLastMaxWidth(equipments);
	}
	
	/**
	 * 初始化最后一行设备最大宽度
	 * @param equipments
	 */
	private void setLastMaxWidth(List<Equipment> equipments) {
		int lastEquCount = rowEquCounts.get(rowEquCounts.size() - 1); //获取最后一行设备的数量
		for(int i = equRank.length - 1; i >= equRank.length - lastEquCount; i--){
			int index = equRank[i] - 1;		//依次取出设备排列编号对应的设备的下标
			Equipment equipment = equipments.get(index);	//取出相应的设备
			if(equipment.getEquLength() > lastMaxWidth)
				lastMaxWidth = equipment.getEquLength();
		}
	}
	
	/**
	 * 初始化第一行设备最大宽度
	 * @param equipments
	 */
	private void setFirstMaxWidth(List<Equipment> equipments) {
		int firstEquCount = rowEquCounts.get(0); //获取第一行设备的数量
		for(int i = 0; i < firstEquCount; i++){
			int index = equRank[i] - 1;		//依次取出设备排列编号对应的设备的下标
			Equipment equipment = equipments.get(index);	//取出相应的设备
			if(equipment.getEquLength() > firstMaxWidth)
				firstMaxWidth = equipment.getEquLength();
		}
	}

	/**
	 * 初始化equRank
	 * @param equRank	设备1——8排列
	 */
	private void setEquRank(int[] equRank) {
		this.equRank = equRank;
	}

	/**
	 * 初始化周期
	 * @param periodNum		此个体属于第几周期
	 */
	public void setPeriodNum(int periodNum){
		this.periodNum = periodNum;
	}
	/**
	 * 计算每行中存储的设备个数,和每个设备的坐标
	 * @param workShop 			车间信息
	 * @param equipments		设备信息
	 * @param equMutalRelation	设备间的关系信息
	 * @param producePeriod		产品生产的周期
	 */
	public void setRowEquCountsAndPoint(WorkShop workShop, List<Equipment> equipments, 
			EquMutalRelation equMutalRelation){
		point = new Point[equRank.length];
		rowEquCounts = new ArrayList<Integer>();
		int rowCount = 1;		//用于计数设备排列的行数
		int rowEquCount = 0;	//用于计数每行设备的数量
		double leng = 0;
		
		for(int i = 0; i < equRank.length; i ++ ){
			double judgeLeng = 0;			//判断长度是否超出车间的长度放范围
			int index = equRank[i] - 1;		//依次取出设备排列编号对应的设备的下标
			Equipment equipment = equipments.get(index);	//取出相应的设备
			if(leng == 0)		
				leng = Operational.add(leng, Operational.add(equipment.getEquWallMargin(), equipment.getEquLength()));
			else 
				leng = Operational.add(leng, Operational.add(equMutalRelation.getEquMargin(equRank[i] - 1, equRank[i-1] - 1), equipment.getEquLength()) );
			rowEquCount ++;
			
			//以下两个判断条件由于i的缘故，顺序不能进行颠倒
			//需要换行的时候进行保存
			
			judgeLeng = Operational.add(leng, equipment.getEquWallMargin());
			if(judgeLeng > workShop.getWsLength()){
				rowCount ++;	//行数加一
				leng = 0;		//重新计算第二行的长度
				Integer integer = new Integer(rowEquCount - 1);	//将数量进行保存
				rowEquCounts.add(integer);
				rowEquCount = 0;	//重新计算第二行的数量
				i --;			//计算中第一行最后用到的设备放于第二行开始
			}else {
				double X = Operational.sub(leng, Operational.div(equipment.getEquLength(),2));
				double Y = Operational.add(Operational.mul((rowCount - 1) , workShop.getRowWidth()), workShop.getFirstMargin());
				point[i] = new Point(X, Y);
			}
			
			//最后一个设备的时候进行保存
			if(i == equRank.length - 1){
				Integer integer = new Integer(rowEquCount);	//将数量进行保存
				rowEquCounts.add(integer);
			}		
		}
	}
	
	
	/**
	 * 通过设备的编号找出此设备的坐标
	 * @param equNum
	 * @return
	 */
	public Point getPointByEquNum(int equNum){
		int equPos = getEquPosByEquNum(equNum);
		return point[equPos];
	}
	public int getEquPosByEquNum(int equNum){
		for(int i = 0; i < equRank.length; i++){
			if(equNum == equRank[i]){
				return i;
			}
				
		}
		return -1;
	}
	
	
	
	public int[] getEquRank() {
		return equRank;
	}
	public int getPeriodNum() {
		return periodNum;
	}
	public List<Integer> getRowEquCounts() {
		return rowEquCounts;
	}
	public Point[] getPoint() {
		return point;
	}
	public double getFirstMaxWidth() {
		return firstMaxWidth;
	}
	public double getLastMaxWidth() {
		return lastMaxWidth;
	}
	public boolean isPunish() {
		return isPunish;
	}
	
	
	
	
	
	
}
