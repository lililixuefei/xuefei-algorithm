package xuefei.done.me.daily;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @description: 滑动窗口最大值
 * @author: xuefei
 * @date: 2022/10/14 00:13
 */
public class MaxSlidingWindow {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{7, 2, 4}, 2)));
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
