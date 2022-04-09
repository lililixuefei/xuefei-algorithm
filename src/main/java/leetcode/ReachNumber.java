package leetcode;

/**
 * @description:
 * @author: xuefei
 * @date: 2022/04/10 00:10
 */
public class ReachNumber {

    /**
     * 在一根无限长的数轴上，你站在0的位置。终点在target的位置。
     * 你可以做一些数量的移动 numMoves :
     * 每次你可以选择向左或向右移动。
     * 第 i 次移动（从  i == 1 开始，到 i == numMoves ），在选择的方向上走 i 步。
     * 给定整数 target ，返回 到达目标所需的 最小 移动次数(即最小 numMoves ) 。
     * 链接：https://leetcode-cn.com/problems/reach-a-number
     */

    public static int reachNumber(long target) {
        if (target == 0) {
            return 0;
        }
        target = Math.abs(target);
        long l = 0;
        long r = target;
        long m = 0;
        long near = 0;
        while (l <= r) {
            m = (l + r) / 2;
            if (sum(m) >= target) {
                near = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        if (sum(near) == target) {
            return (int) near;
        }
        if (((sum(near) - target) & 1) == 1) {
            near++;
        }
        if (((sum(near) - target) & 1) == 1) {
            near++;
        }
        return (int) near;
    }

    private static long sum(long n) {
        return (n * (n + 1)) / 2;

    }
}
