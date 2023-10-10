package leetcode.onequestion.unresolved;

import java.util.Arrays;

/**
 * @Description 移动机器人
 * @Author xuefei
 * @Date 2023/10/10 19:47
 * @Version 1.0
 */
public class SumDistance {

    public int sumDistance(int[] nums, String s, int d) {
        final long MOD = (long) 1e9 + 7;
        int n = nums.length;
        // 用 long 是因为 nums[i]+d 可能是 2e9+1e9，溢出了
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = (long) nums[i] + (s.charAt(i) == 'L' ? -d : d);
        }
        Arrays.sort(a);

        long ans = 0, sum = 0;
        for (int i = 0; i < n; i++) {
            ans = (ans + i * a[i] - sum) % MOD;
            sum += a[i];
        }
        return (int) ans;
    }

}
