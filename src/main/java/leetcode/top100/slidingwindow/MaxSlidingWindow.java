package leetcode.top100.slidingwindow;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description 滑动窗口最大值
 * @Author xuefei
 * @Date 2023/11/2 22:54
 * @Version 1.0
 */
public class MaxSlidingWindow {


    public static void main(String[] args) {
        int[] nums = {1, -1};
        maxSlidingWindow(nums, 1);
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        Deque<Integer> deque = new LinkedList<>();
        int[] ans = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {

            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.removeLast();
            }
            deque.offer(i);
            if (i - deque.peekFirst() >= k) {
                deque.removeFirst();
            }

            if (i + 1 >= k) {
                ans[i + 1 - k] = nums[deque.peekFirst()];
            }
        }
        return ans;
    }

}
