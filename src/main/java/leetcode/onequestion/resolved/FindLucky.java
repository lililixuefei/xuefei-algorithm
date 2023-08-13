package leetcode.onequestion.resolved;

/**
 * @description: 找出数组中的幸运数
 * @author: xuefei
 * @date: 2023/08/13 21:54
 */
public class FindLucky {

    public static void main(String[] args) {
        int[] arr = {4, 4, 3, 3, 1, 3, 2, 5, 2, 4, 4};
        findLucky(arr);
    }

    public static int findLucky(int[] arr) {

        int[] nums = new int[501];

        for (int i : arr) {
            nums[i]++;
        }

        int ans = -1;
        for (int i = 1; i < nums.length; i++) {
            if (i == nums[i]) {
                ans = i;
            }
        }
        return ans;

    }

}
