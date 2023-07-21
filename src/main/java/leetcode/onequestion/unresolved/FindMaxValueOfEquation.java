package leetcode.onequestion.unresolved;

import java.util.PriorityQueue;

/**
 * @description: 满足不等式的最大值
 * @author: xuefei
 * @date: 2023/07/21 21:35
 */
public class FindMaxValueOfEquation {

	public int findMaxValueOfEquation(int[][] points, int k) {
		int res = Integer.MIN_VALUE;
		PriorityQueue<int[]> heap = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
		for (int[] point : points) {
			int x = point[0];
			int y = point[1];
			while (!heap.isEmpty() && x - heap.peek()[1] > k) {
				heap.poll();
			}
			if (!heap.isEmpty()) {
				res = Math.max(res, x + y - heap.peek()[0]);
			}
			heap.offer(new int[]{x - y, x});
		}
		return res;
	}

}
