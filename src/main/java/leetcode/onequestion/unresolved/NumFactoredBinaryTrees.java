package leetcode.onequestion.unresolved;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 带因子的二叉树
 * @author: xuefei
 * @date: 2023/08/29 22:34
 */
public class NumFactoredBinaryTrees {

    public int numFactoredBinaryTrees(int[] arr) {
        final long MOD = (long) 1e9 + 7;
        Arrays.sort(arr);
        int n = arr.length;
        Map<Integer, Integer> idx = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            idx.put(arr[i], i);
        }

        long ans = 0;
        long[] f = new long[n];
        for (int i = 0; i < n; i++) {
            int val = arr[i];
            f[i] = 1;
            // val 的因子一定比 val 小
            for (int j = 0; j < i; ++j) {
                int x = arr[j];
                // 另一个因子 val/x 必须在 arr 中
                if (val % x == 0 && idx.containsKey(val / x)) {
                    f[i] += f[j] * f[idx.get(val / x)];
                }
            }
            ans += f[i];
        }
        return (int) (ans % MOD);
    }

}
