package leetcode.top150;

/**
 * @Description
 * @Author xuefei
 * @Date 2024/4/25 22:39
 * @Version 1.0
 */
public class Rotate {


    public void rotate(int[] nums, int k) {
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[(i + k) % nums.length] = nums[i];
        }
        System.arraycopy(arr, 0, nums, 0, arr.length);
    }

}
