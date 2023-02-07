package xuefei.done.study.wushixiong;

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
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }
        int[] res = new int[nums.length - k + 1];
        // 单调递减的双端队列
        Deque<Integer> deque = new LinkedList<>();
        int r = 0;
        while (r < nums.length) {
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[r]) {
                deque.removeLast();
            }
            deque.addLast(r);

            if (r >= k && r - k == deque.peekFirst()) {
                deque.removeFirst();
            }

            if (r + 1 >= k) {
                res[r - k + 1] = nums[deque.peek()];
            }
            r++;
        }
        return res;
    }

    public static int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
        }
        res[0] = deque.peekFirst();

        for (int i = k; i < nums.length; i++) {
            if (deque.peekFirst() == nums[i - k]) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }

            deque.addLast(nums[i]);
            res[i - k + 1] = deque.peekFirst();
        }
        return res;
    }


    public static int[] maxSlidingWindow3(int[] nums, int k) {
        Deque<Integer> queue1 = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if ((i + k) > nums.length) {
                break;
            }
            int max = Integer.MIN_VALUE;
            for (int start = i; start < i + k; start++) {
                int num = nums[start];
                max = Math.max(max, num);
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
