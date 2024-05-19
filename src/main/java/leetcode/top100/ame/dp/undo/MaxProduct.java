package leetcode.top100.ame.dp.undo;

/**
 * @Description
 * @Author xuefei
 * @Date 2024/4/20 22:22
 * @Version 1.0
 */
public class MaxProduct {


    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax * nums[i], nums[i]);
            imin = Math.min(imin * nums[i], nums[i]);

            max = Math.max(max, imax);
        }
        return max;
    }


}
