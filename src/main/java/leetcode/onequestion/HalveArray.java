package leetcode.onequestion;

import java.util.PriorityQueue;

/**
 * @description: 将数组和减半的最少操作次数
 * @author: xuefei
 * @date: 2023/07/25 00:13
 */
public class HalveArray {

	public static void main(String[] args) {
		int[] nums = {6, 58, 10, 84, 35, 8, 22, 64, 1, 78, 86, 71, 77};
		System.out.println(halveArray(nums));
	}

	public static int halveArray(int[] nums) {
		PriorityQueue<Double> priorityQueue = new PriorityQueue<>(nums.length, (o1, o2) -> {
			if (o1.equals(o2)) {
				return 0;
			}
			return o2 - o1 > 0 ? 1 : -1;
		});

		long sum = 0;
		for (int num : nums) {
			sum += num;
			priorityQueue.add((double) num);
		}
		double value = (double) sum / 2;

		double curValue = 0;
		int ops = 0;
		for (int i = 0; i < nums.length; i++) {
			ops++;
			double v = priorityQueue.poll() / 2;
			curValue += v;
			if (curValue >= value) {
				return ops;
			}
			priorityQueue.add(v);
		}
		return ops;
	}

}
