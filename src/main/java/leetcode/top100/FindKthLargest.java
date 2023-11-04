package leetcode.top100;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @description: 数组中第 k 个最大元素
 * @author: xuefei
 * @date: 2023/11/03 16:19
 */
public class FindKthLargest {

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k > nums.length) {
            return -1;
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(nums.length, (o1, o2) -> o2 - o1);
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
