package leetcode.monotonestack;

import java.util.*;

/**
 * @description: 下一个更大元素 I
 * @author: xuefei
 * @date: 2023/02/10 23:14
 */
public class NextGreaterElement {


    public static void main(String[] args) {
        int[] nums1 = new int[]{4, 1, 2};
        int[] nums2 = new int[]{1, 3, 4, 2};
        System.out.println(nextGreaterElement(nums1, nums2));
    }


    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // 构建nums2的单调递减栈
        Deque<Integer> stack = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();

        stack.push(nums2[0]);
        for (int i = 1; i < nums2.length; i++) {
            while (stack.peek() != null && stack.peek() < nums2[i]) {
                Integer cur = stack.peek();
                stack.pop();
                map.put(cur, nums2[i]);
            }
            stack.push(nums2[i]);
        }
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.getOrDefault(nums1[i], -1);
        }
        return ans;
    }
}
