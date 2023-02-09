package leetcode.prefixand;

/**
 * @description: 除自身以外数组的乘积
 * @author: xuefei
 * @date: 2023/02/09 22:50
 */
public class ProductExceptSelf {


    public int[] productExceptSelf(int[] nums) {
        int[] l = new int[nums.length];
        int[] r = new int[nums.length];

        l[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            l[i] = nums[i - 1] * l[i - 1];
        }

        r[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            r[i] = nums[i + 1] * r[i + 1];
        }

        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = l[i] * r[i];
        }
        return ans;
    }


    /**
     * 超时了
     *
     * @param nums
     * @return
     */
    public int[] productExceptSelf2(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int ans = 1;
            int mid1 = i - 1;
            while (mid1 >= 0) {
                ans *= nums[mid1];
                mid1--;
            }
            int mid2 = i + 1;
            while (mid2 < nums.length) {
                ans *= nums[mid2];
                mid2++;
            }
            result[i] = ans;
        }
        return result;
    }
}
