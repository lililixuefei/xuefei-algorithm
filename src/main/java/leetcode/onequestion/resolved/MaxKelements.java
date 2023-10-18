package leetcode.onequestion.resolved;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @description: 执行k次操作后的最大分数
 * @author: xuefei
 * @date: 2023/10/18 10:15
 */
public class MaxKelements {

    public static void main(String[] args) {
        System.out.println(Math.ceil((double) 10 / 3));

        int[] nums = {1, 10, 3, 3, 3};
        System.out.println(maxKelements(nums, 3));
    }


    public static long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(nums.length, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int num : nums) {
            priorityQueue.add(num);
        }

        long ans = 0;
        for (int i = 0; i < k; i++) {
            Integer num = priorityQueue.poll();
            if (num == null) {
                return ans;
            }
            ans += num;
            priorityQueue.add((int) Math.ceil((double) num / 3));
        }
        return ans;
    }


}
