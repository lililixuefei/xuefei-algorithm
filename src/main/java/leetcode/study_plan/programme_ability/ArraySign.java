package leetcode.study_plan.programme_ability;

/**
 * @description: 数组元素积的符号   https://leetcode.cn/problems/sign-of-the-product-of-an-array/
 * @author: xuefei
 * @date: 2022/05/23 22:27
 */
public class ArraySign {

    public static void main(String[] args) {
        int[] nums = {9, 72, 34, 29, -49, -22, -77, -17, -66, -75, -44, -30, -24};
        System.out.println(arraySign(nums));
    }

    public static int arraySign(int[] nums) {
        int num1 = 0;
        for (int num : nums) {
            if (num == 0) {
                return 0;
            }
            if (num < 0) {
                num1++;
            }
        }

        if (num1 % 2 == 1) {
            return -1;
        } else {
            return 1;
        }
    }

}
