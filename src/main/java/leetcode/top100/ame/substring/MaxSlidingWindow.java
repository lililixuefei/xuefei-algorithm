package leetcode.top100.ame.substring;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description
 * @Author xuefei
 * @Date 2024/3/30 18:36
 * @Version 1.0
 */
public class MaxSlidingWindow {


	public static void main(String[] args) {
		maxSlidingWindow(new int[]{1, 3, 1, 2, 0, 5}, 3);
	}

	public static int[] maxSlidingWindow(int[] nums, int k) {
		Deque<Integer> queue = new LinkedList<>();
		int[] ans = new int[nums.length - k + 1];
		int p = 0;
		for (int i = 0; i < nums.length; i++) {
			while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
				queue.removeLast();
			}
			queue.add(i);
			if (i >= (k - 1)) {
				ans[p++] = nums[queue.peekFirst()];
			}
			if (queue.peekFirst() == (i - k + 1)) {
				queue.removeFirst();
			}
		}
		return ans;
	}

}
