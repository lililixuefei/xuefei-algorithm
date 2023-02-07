package xuefei.done.leetcode.study_plan.programme_ability;

import java.util.Arrays;

/**
 * @description: 判断能否形成等差数列   https://leetcode.cn/problems/can-make-arithmetic-progression-from-sequence/
 * @author: xuefei
 * @date: 2022/05/23 22:39
 */
public class CanMakeArithmeticProgression {

    public static void main(String[] args) {

    }

    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        if (arr.length == 2) {
            return true;
        }

        int difference1 = arr[1] - arr[0];
        for (int i = 2; i < arr.length; i++) {
            int difference2 = arr[i] - arr[i - 1];
            if (difference2 != difference1) {
                return false;
            }
        }
        return true;
    }
}
