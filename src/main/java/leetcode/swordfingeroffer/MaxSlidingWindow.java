package leetcode.swordfingeroffer;

¬
import java.util.Deque;
import java.util.LinkedList;


/**
 * @description: 剑指 Offer 59 - I. 滑动窗口的最大值
 * @author: xuefei
 * @date: 2023/07/16 20:05
 */
public class MaxSlidingWindow {


	public static int[] maxSlidingWindow2(int[] nums, int k) {
		int[] res = new int[nums.length - k + 1];
		int j = 0;
		Deque<Integer> maxq = new LinkedList<>();
		for (int i = 0; i < nums.length; i++) {
			if (i < k - 1) {
				// 将小于 n 的元素全部删除
				while (!maxq.isEmpty() && maxq.getLast() < nums[i]) {
					maxq.pollLast();
				}
				// 然后将 n 加入尾部
				maxq.addLast(nums[i]);
			} else {
				// 将小于 n 的元素全部删除
				while (!maxq.isEmpty() && maxq.getLast() < nums[i]) {
					maxq.pollLast();
				}
				// 然后将 n 加入尾部
				maxq.addLast(nums[i]);

				// 记录当前窗口的最大值
				res[j++] = maxq.getFirst();
				// 移出旧数字
				if (nums[i - k + 1] == maxq.getFirst()) {
					maxq.pollFirst();
				}
			}
		}
		return res;
	}

	public static int[] maxSlidingWindow(int[] nums, int k) {
		if (nums == null || nums.length < 2 || k <= 1) {
			return nums;
		}
		Deque<Integer> deque = new LinkedList<>();
		// 先形成窗口
		for (int i = 0; i < k; i++) {
			while (!deque.isEmpty() && nums[i] > deque.peekLast()) {
				deque.removeLast();
			}
			deque.add(nums[i]);
		}
		int[] ans = new int[nums.length - k + 1];
		ans[0] = deque.peekFirst();
		int index = 1;
		for (int i = k; i < nums.length; i++) {
			if (!deque.isEmpty() && (nums[i - k] == deque.peekFirst())) {
				deque.removeFirst();
			}
			while (!deque.isEmpty() && nums[i] > deque.peekLast()) {
				deque.removeLast();
			}
			deque.add(nums[i]);
			ans[index++] = deque.peekFirst();
		}
		return ans;
	}

}
