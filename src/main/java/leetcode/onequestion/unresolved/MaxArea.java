package leetcode.onequestion.unresolved;

import java.util.Arrays;

/**
 * @description: 切割后面积最大的蛋糕
 * @author: xuefei
 * @date: 2023/10/27 17:06
 */
public class MaxArea {

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        return (int) ((long) calMax(horizontalCuts, h) * calMax(verticalCuts, w) % 1000000007);
    }

    public int calMax(int[] arr, int boardr) {
        int res = 0, pre = 0;
        for (int i : arr) {
            res = Math.max(i - pre, res);
            pre = i;
        }
        return Math.max(res, boardr - pre);
    }

}
