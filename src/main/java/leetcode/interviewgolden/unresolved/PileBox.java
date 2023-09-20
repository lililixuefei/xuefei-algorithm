package leetcode.interviewgolden.unresolved;

import java.util.Arrays;

/**
 * @description: 推箱子
 * @author: xuefei
 * @date: 2023/09/20 19:58
 */
public class PileBox {

    public static void main(String[] args) {
        int[][] box = {{1, 1, 1}, {2, 2, 2}, {3, 3, 3}};
        pileBox(box);
    }

    public static int pileBox(int[][] box) {
        Arrays.sort(box, (x, y) -> x[0] - y[0]);
        int[] dp = new int[box.length];
        int res = 0;
        for (int i = 0; i < box.length; ++i) {
            for (int j = 0; j < i; ++j) {
                // i 的三维都要比 j 大
                if (box[i][0] > box[j][0] && box[i][1] > box[j][1] && box[i][2] > box[j][2]) {
                    //在 0 <= j < i 范围内找到最大的 dp[j]
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            //最后加上最底端箱子的高度
            dp[i] += box[i][2];
            res = Math.max(dp[i], res);
        }
        return res;
    }


    public static int pileBox_wrong(int[][] box) {
        if (box == null || box.length <= 0 || box[0].length <= 0) {
            return 0;
        }
        if (box.length == 1) {
            return box[0][2];
        }

        Arrays.sort(box, (o1, o2) -> o2[0] - o1[0]);

        int maxHigh1 = getMaxHigh(box, 1, 2);

        Arrays.sort(box, (o1, o2) -> o2[1] - o1[1]);
        int maxHigh2 = getMaxHigh(box, 0, 2);

        Arrays.sort(box, (o1, o2) -> o2[2] - o1[2]);

        int maxHigh3 = getMaxHigh(box, 0, 1);
        return Math.max(maxHigh1, Math.max(maxHigh2, maxHigh3));

    }

    private static int getMaxHigh(int[][] box, int m, int n) {
        int maxHigh = 0;
        int[] bottomBox = box[0];
        int curHigh = bottomBox[2];
        for (int i = 1; i < box.length; i++) {
            if (box[i][m] < bottomBox[m] && box[i][n] < bottomBox[n]) {
                curHigh = box[i][2] + curHigh;
                maxHigh = Math.max(maxHigh, curHigh);
            } else {
                bottomBox = box[i];
                curHigh = bottomBox[2];
            }
        }
        return maxHigh;
    }

}
