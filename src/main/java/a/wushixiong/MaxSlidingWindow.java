package a.wushixiong;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

/**
 * @description: 滑动窗口最大值
 * @author: xuefei
 * @date: 2022/07/18 22:58
 */
public class MaxSlidingWindow {

    public static void main(String[] args) {

        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(maxSlidingWindow(nums, 3));

    }


    public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue1 = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if ((i + k) > nums.length) {
                break;
            }
            int max = Integer.MIN_VALUE;
            for (int start = i; start < i + k; start++) {
                int num = nums[start];
                max = Math.max(max,num);
            }
            queue1.add(max);
        }

        int[] result = new int[queue1.size()];
        int i = 0;
        while (Objects.nonNull(queue1.peek())) {
            result[i++] = queue1.poll();
        }
        return result;
    }
}
