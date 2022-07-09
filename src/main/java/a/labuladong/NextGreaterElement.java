package a.labuladong;

import java.util.*;

/**
 * @description: 下一个更大元素 I  II
 * @author: xuefei
 * @date: 2022/07/09 01:41
 */
public class NextGreaterElement {

    public int[] nextGreaterElementI(int[] nums1, int[] nums2) {
        int[] greater = nextGreaterElement(nums2);

        Map<Integer, Integer> greaterMap = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            greaterMap.put(nums2[i], greater[i]);
        }

        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = greaterMap.get(nums1[i]);
        }
        return res;
    }

    int[] nextGreaterElementsII(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Deque<Integer> stack = new LinkedList<>();
        // 数组长度加倍模拟环形数组
        for (int i = 2 * n - 1; i >= 0; i--) {
            // 索引 i 要求模，其他的和模板一样
            while (!stack.isEmpty() && stack.peek() <= nums[i % n]) {
                stack.pop();
            }
            res[i % n] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i % n]);
        }
        return res;
    }

    int[] nextGreaterElement(int[] nums) {
        int[] res = new int[nums.length];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return res;
    }
}
