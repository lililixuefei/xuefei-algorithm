package labuladong.math;

import java.util.Random;

/**
 * @Description 随机数索引
 * @Author xuefei
 * @Date 2023/11/30 22:12
 * @Version 1.0
 */
public class RandomPickIndex {


    private final int[] nums;
    private final Random rand;

    public RandomPickIndex(int[] nums) {
        this.nums = nums;
        this.rand = new Random();
    }

    public int pick(int target) {
        int count = 0, res = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != target) {
                continue;
            }
            count++;
            if (rand.nextInt(count) == 0) {
                res = i;
            }
        }

        return res;
    }

}
