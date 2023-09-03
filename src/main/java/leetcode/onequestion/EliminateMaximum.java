package leetcode.onequestion;

import java.util.Arrays;

/**
 * @description: 消灭怪物的最大数量
 * @author: xuefei
 * @date: 2023/09/03 21:35
 */
public class EliminateMaximum {

    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        int[] arrivalTimes = new int[n];
        for (int i = 0; i < n; i++) {
            arrivalTimes[i] = (dist[i] - 1) / speed[i] + 1;
        }
        Arrays.sort(arrivalTimes);
        for (int i = 0; i < n; i++) {
            if (arrivalTimes[i] <= i) {
                return i;
            }
        }
        return n;
    }

}
