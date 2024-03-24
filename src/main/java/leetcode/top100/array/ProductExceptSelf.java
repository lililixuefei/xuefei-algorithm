package leetcode.top100.array;

/**
 * @Description 除自身以外数组的乘积
 * @Author xuefei
 * @Date 2023/11/5 19:42
 * @Version 1.0
 */
public class ProductExceptSelf {


    public int[] productExceptSelf_me(int[] nums) {
        int zeroCount = 0;
        long product = 1;
        for (int num : nums) {
            if (num == 0) {
                zeroCount++;
                continue;
            }
            product *= num;
        }
        int[] productExceptSelf = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (zeroCount == 1) {
                    productExceptSelf[i] = (int) product;
                } else {
                    productExceptSelf[i] = 0;
                }
            } else {
                if (zeroCount != 0) {
                    productExceptSelf[i] = 0;
                } else {
                    productExceptSelf[i] = (int) (product / nums[i]);
                }
            }
        }
        return productExceptSelf;
    }


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

}
