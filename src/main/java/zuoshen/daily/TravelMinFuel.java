package zuoshen.daily;


import java.util.ArrayList;
import java.util.List;

/**
 * @description: 最少耗费多少汽油
 * @author: xuefei
 * @date: 2023/05/10 23:27
 */
public class TravelMinFuel {


	public static int minFuel(int[] a,int[] b,int n){
		// 先建图
		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}
		for (int i = 0; i < a.length; i++) {
			graph.get(a[i]).add(b[i]);
			graph.get(b[i]).add(a[i]);
		}


	}

}
