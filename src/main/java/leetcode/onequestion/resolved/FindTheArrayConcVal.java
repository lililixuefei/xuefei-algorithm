package leetcode.onequestion.resolved;

/**
 * @Description 找出数组的串联值
 * @Author xuefei
 * @Date 2023/10/12 22:05
 * @Version 1.0
 */
public class FindTheArrayConcVal {

    public static void main(String[] args) {
        int[] nums = {5, 14, 13, 8, 12};
        findTheArrayConcVal(nums);
    }

    public static long findTheArrayConcVal_me(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        long ans = 0;
        while (i < j) {
            ans += Integer.parseInt((nums[i] + "" + nums[j]));
            i++;
            j--;
        }
        if (i == j) {
            ans += nums[i];
        }
        return ans;
    }

    public static long findTheArrayConcVal(int[] nums) {
        long ans = 0;
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int x = nums[i];
            int y = nums[j];
            while (y != 0) {
                x *= 10;
                y /= 10;
            }
            ans += x + nums[j];
            i++;
            j--;
        }
        if (i == j) {
            ans += nums[i];
        }
        return ans;
    }

}
