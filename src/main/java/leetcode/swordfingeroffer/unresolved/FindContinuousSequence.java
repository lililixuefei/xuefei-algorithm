package leetcode.swordfingeroffer.unresolved;


import java.util.ArrayList;
import java.util.List;

/**
 * @description: 剑指 Offer 57 - II. 和为s的连续正数序列
 * @author: xuefei
 * @date: 2023/08/05 23:12
 */
public class FindContinuousSequence {

    public static void main(String[] args) {
        findContinuousSequence(9);
    }

    public static int[][] findContinuousSequence(int target) {
        int i = 1;
        int j = 1;
        int sum = 0;
        List<int[]> res = new ArrayList<>();

        while (i <= target / 2) {
            if (sum < target) {
                // 右边界向右移动
                sum += j;
                j++;
            } else if (sum > target) {
                // 左边界向右移动
                sum -= i;
                i++;
            } else {
                // 记录结果
                int[] arr = new int[j - i];
                for (int k = i; k < j; k++) {
                    arr[k - i] = k;
                }
                res.add(arr);
                // 左边界向右移动
                sum -= i;
                i++;
            }
        }

        return res.toArray(new int[res.size()][]);
    }


    public static int[][] findContinuousSequence_me(int target) {

        int n = target / 2;
        int i = 1;
        int j = 1;

        List<int[]> list = new ArrayList<>();
        int sum = 0;
        while (j <= n) {
            if (sum < target) {
                sum += i;
                i++;
            } else if (sum > target) {
                sum -= j;
                j++;
            } else {
                int[] nums = new int[i - j];
                for (int k = j; k < i; k++) {
                    nums[k - j] = k;
                }
                list.add(nums);
                sum += i;
                sum -= j;
                i++;
                j++;
            }
        }

        int[][] res = new int[list.size()][0];

        for (int m = 0; m < list.size(); m++) {
            res[m] = list.get(m);
        }
        return res;
    }

}
