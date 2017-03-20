package alg.bxp.interview;

import java.util.*;

/**
 * 在4x4的棋盘上摆满了黑白棋子，黑白两色的位置和数目随
 * 机其中左上角坐标为(1,1),右下角坐标为(4,4),现在依次
 * 有一些翻转操作，要对一些给定支点坐标为中心的上下左
 * 右四个棋子的颜色进行翻转，请计算出翻转后的棋盘颜色。
 * 
 * 给定两个数组A和f,分别为初始棋盘和翻转位置。其中翻转
 * 位置共有3个。请返回翻转后的棋盘。 测试样例：
 * 
 * [[0,0,1,1],[1,0,1,0],[0,1,1,0],[0,0,1,0]],[[2,2],[3,3],[4,4]]
 * 
 * 返回：[[0,1,1,1],[0,0,1,0],[0,1,1,0],[0,0,1,0]]
 * 
 * @author bxp
 *
 */
public class Flip {
	
	
	public int[][] flipChess(int[][] A, int[][] f) {
		for (int[] pos : f) {
			int xIndex = pos[0] - 1;
			int yIndex = pos[1] - 1;
			//计算上下左右的位置坐标，并将其进行反转
			int left = xIndex-1;
			int top = yIndex-1;
			int right = xIndex+1;
			int below = yIndex+1;
			if(left >=0){
				A[left][yIndex] = A[left][yIndex] == 0 ? 1 : 0;
			}
			if(top >= 0){
				A[xIndex][top]= A[xIndex][top] == 0 ? 1 : 0;
			}
			if(right < 4){
				A[right][yIndex]= A[right][yIndex] == 0 ? 1 : 0;
			}
			if(below < 4){
				A[xIndex][below]= A[xIndex][below] == 0 ? 1 : 0;
			}
		}
		return A;
	}
}










