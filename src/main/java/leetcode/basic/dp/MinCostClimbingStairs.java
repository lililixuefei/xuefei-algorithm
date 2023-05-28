package leetcode.basic.dp;

/**
 * @description: 使用最小花费爬楼梯
 * @author: xuefei
 * @date: 2023/05/28 12:55
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

	public int process(int[] cost, int n) {

		if (n <= 1) {
			return 0; //如果顶楼是0和层 不需要消耗任能量
		}
		if (n == 2) {
			return Math.min(cost[0], cost[1]);
		}

		int one = process(cost, n - 1) + cost[n - 1];//走过阶梯n 需要消耗能量
		int two = process(cost, n - 2) + cost[n - 2]; //走过阶梯n 需要消耗能量

		return Math.min(one, two);
	}

}
