package leetcode.swordfingeroffer.resolved;

/**
 * @description: 剑指 Offer 10- II. 青蛙跳台阶问题
 * @author: xuefei
 * @date: 2023/07/30 18:32
 */
public class NumWays {

    public int numWays(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int[] stairs = new int[n];
        stairs[0] = 1;
        stairs[1] = 2;
        for (int i = 2; i < n; i++) {
            stairs[i] = (stairs[i - 1] + stairs[i - 2]) % 1000000007;
        }
        return stairs[n - 1];
    }

}
