package labuladong.math;

import java.util.Arrays;
import java.util.Random;

/**
 * @Description 打乱数组
 * @Author xuefei
 * @Date 2023/11/30 21:53
 * @Version 1.0
 */
public class Solution {

    private final int[] nums;
    private final Random rand = new Random();

    public Solution(int[] nums) {
        this.nums = nums;
    }

    public int[] reset() {
        return nums;
    }

    // 洗牌算法
    public int[] shuffle() {
        int n = nums.length;
        int[] copy = Arrays.copyOf(nums, n);
        for (int i = 0; i < n; i++) {
            // 生成一个 [i, n-1] 区间内的随机数
            int r = i + rand.nextInt(n - i);
            // 交换 nums[i] 和 nums[r]
            swap(copy, i, r);
        }
        return copy;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
