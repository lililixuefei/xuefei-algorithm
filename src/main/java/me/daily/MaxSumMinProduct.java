package me.daily;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description: 子数组最小乘积的最大值   https://leetcode.cn/problems/maximum-subarray-min-product/
 * @author: xuefei
 * @date: 2022/10/18 23:20
 */
public class MaxSumMinProduct {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2};
        System.out.println(maxSumMinProduct(nums));
    }

    public static int maxSumMinProduct(int[] nums) {

        int[][] nearLess = getNearLess(nums);

        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int nearLess1 = nearLess[i][0] == -1 ? 0 : (nearLess[i][0] + 1);
            int nearLess2 = nearLess[i][1] == -1 ? (nums.length - 1) : (nearLess[i][1] - 1);

            long j = 0;
            for (; nearLess1 <= nearLess2; nearLess1++) {
                j += nums[nearLess1];
            }
            ans = Math.max(ans, num * j);
        }
        return (int) (ans % 1000000007);
    }


    public static int[][] getNearLess(int[] arr) {
        int[][] res = new int[arr.length][2];


        // List<Integer> -> 放的是位置，同样值的东西，位置压在一起
        // 代表值    底  ->  顶   小  -> 大
        Stack<List<Integer>> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) { // i -> arr[i] 进栈
            // 底 -> 顶， 小 -> 大
            while (!stack.isEmpty() && arr[stack.peek().get(0)] > arr[i]) {
                List<Integer> popIs = stack.pop();
                // 取位于下面位置的列表中，最晚加入的那个
                int leftLessIndex = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
                for (Integer popi : popIs) {
                    res[popi][0] = leftLessIndex;
                    res[popi][1] = i;
                }
            }
            // 相等的、比你小的
            if (!stack.isEmpty() && arr[stack.peek().get(0)] == arr[i]) {
                stack.peek().add(Integer.valueOf(i));
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                stack.push(list);
            }
        }
        while (!stack.isEmpty()) {
            List<Integer> popIs = stack.pop();
            // 取位于下面位置的列表中，最晚加入的那个
            int leftLessIndex = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
            for (Integer popi : popIs) {
                res[popi][0] = leftLessIndex;
                res[popi][1] = -1;
            }
        }
        return res;
    }
}
