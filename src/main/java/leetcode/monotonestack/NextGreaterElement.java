package leetcode.monotonestack;

import java.util.*;

/**
 * @description: 下一个更大元素 I 、下一个更大元素 II
 * @author: xuefei
 * @date: 2023/02/10 23:14
 */
public class NextGreaterElement {


    public static void main(String[] args) {
        int[] nums1 = new int[]{4, 1, 2};
        int[] nums2 = new int[]{1, 3, 4, 2};
//        System.out.println(nextGreaterElementI(nums1, nums2));

        int[] nums3 = new int[]{1, 2, 1};

        System.out.println(nextGreaterElementII(nums3));
    }


    public static int[] nextGreaterElementII(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);
        for (int i = 1; i < n * 2; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                int index = stack.pop();
                res[index] = nums[i % n];
            }
            stack.push(i % n);
        }
        return res;
    }

    public static int[] nextGreaterElementsII(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> s = new Stack<>();
        // 数组长度加倍模拟环形数组
        for (int i = 2 * n - 1; i >= 0; i--) {
            // 索引 i 要求模，其他的和模板一样
            while (!s.isEmpty() && s.peek() <= nums[i % n]) {
                s.pop();
            }
            res[i % n] = s.isEmpty() ? -1 : s.peek();
            s.push(nums[i % n]);
        }
        return res;
    }


    public static int[] nextGreaterElementI(int[] nums1, int[] nums2) {
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
