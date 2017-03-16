
package genetics1;

import java.util.List;

public class EquMutalRelation {
	private double[][] equMargin;	//设备ij之间的间距
	private  double[][] P;			//设备ij之间的物料单位搬运费用	
	private  List<double[][]> Q;	//设备ij之间的物料单位搬运频率
	public EquMutalRelation(double[][] equMargin, double[][] p,
			List<double[][]> q) {
		super();
		this.equMargin = equMargin;
		P = p;
		Q = q;
	}
	
	public double getEquMargin(int i, int j){
		return equMargin[i][j];
	}
	public double getP(int i, int j){
		return P[i][j];
	}
	public double getQ(int t, int i, int j){
		return (Q.get(t))[i][j];
	}
	
}
