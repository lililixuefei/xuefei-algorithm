package leetcode.top100.ame.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Description
 * @Author xuefei
 * @Date 2024/4/3 21:59
 * @Version 1.0
 */
public class FindKthLargest {

	public int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
		for (int num : nums) {
			priorityQueue.add(num);
		}
		int ans = 0;
		for (int i = 0; i < k; i++) {
			ans = priorityQueue.poll();
		}
		return ans;
	}

}
