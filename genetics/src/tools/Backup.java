package tools;

import java.util.ArrayList;
import java.util.List;

public class Backup {
	public static List<List<int[]>> backupEquRankss(List<List<int[]>> equRankss){
		List<List<int[]>> equList = new ArrayList<List<int[]>>();
		for(int i = 0; i < equRankss.size(); i++){
			List<int[]> list = new ArrayList<int[]>();
			for(int j = 0; j < equRankss.get(i).size(); j++){
				list.add(equRankss.get(i).get(j));
			}
			equList.add(list);
		}
		return equList;
	}
	
}
