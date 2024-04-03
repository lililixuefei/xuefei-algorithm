package leetcode.top100.ame.heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Description
 * @Author xuefei
 * @Date 2024/4/3 22:01
 * @Version 1.0
 */
public class TopKFrequent {

	public int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> frequentMap = new HashMap<>();
		for (int num : nums) {
			frequentMap.put(num, frequentMap.getOrDefault(num, 0) + 1);
		}
		PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
		for (Map.Entry<Integer, Integer> entry : frequentMap.entrySet()) {
			priorityQueue.add(entry);
		}
		int[] ans = new int[k];
		for (int i = 0; i < k; i++) {
			ans[i] = priorityQueue.poll().getKey();
		}
		return ans;
	}

}
