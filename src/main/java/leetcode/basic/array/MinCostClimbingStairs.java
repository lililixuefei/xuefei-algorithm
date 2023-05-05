package leetcode.basic.array;

/**
 * @description: 使用最小花费爬楼梯
 * @author: xuefei
 * @date: 2023/05/05 23:14
 */
public class MinCostClimbingStairs {

	public int minCostClimbingStairs(int[] cost) {
		int size = cost.length;
		int[] minCost = new int[size];
		minCost[0] = 0;
		minCost[1] = Math.min(cost[0], cost[1]);
		for (int i = 2; i < size; i++) {
			minCost[i] = Math.min(minCost[i - 1] + cost[i], minCost[i - 2] + cost[i - 1]);
		}
		return minCost[size - 1];
	}

}
