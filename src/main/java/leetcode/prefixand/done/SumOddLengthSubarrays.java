package leetcode.prefixand.done;

/**
 * @description: 所有奇数长度子数组的和
 * @author: xuefei
 * @date: 2023/02/21 22:13
 */
public class SumOddLengthSubarrays {

    public static void main(String[] args) {

        int[] arr = new int[]{1,4,2,5,3};
        System.out.println(sumOddLengthSubarrays(arr));
    }


    public static int sumOddLengthSubarrays(int[] arr) {
        int[] pre = new int[arr.length + 1];
        for (int i = 1; i <= arr.length; i++) {
            pre[i] = pre[i - 1] + arr[i - 1];
        }

        int ans = 0;
        for (int i = pre.length - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j = j - 2) {
                int value = pre[i] - pre[j];
                ans += value;
            }
        }
        return ans;
    }
}
