package leetcode.dp.knapsack;


import java.util.Arrays;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/2/7 7:11 PM
 * @Version 1.0
 */
public class CoinChangeII {

    public int change(int amount, int[] coins) {
        return dfs(coins, 0, amount);
    }

    int dfs(int[] coins, int i, int amount) {
        //金额为0，直接返回1
        if (amount == 0) {
            return 1;
        }
        //金额小于0，或者没有可选的硬币了，返回0
        if (amount < 0 || i == coins.length) {
            return 0;
        }
        int res = 0;
        //每种硬币有两种状态，选和不选当前硬币
        res += dfs(coins, i + 1, amount);
        //选当前硬币,注意这里选的时候i没变，也就是说下次还可以再选，因为每个硬币可以选择无数次
        res += dfs(coins, i, amount - coins[i]);
        return res;
    }


    public int change2(int amount, int[] coins) {
        int[][] map = new int[coins.length][amount + 1];
        for (int i = 0; i < map.length; i++) {
            Arrays.fill(map[i], -1);
        }
        return dfs(coins, 0, amount, map);
    }

    int dfs(int[] coins, int i, int amount, int[][] map) {
        //金额为0，直接返回1
        if (amount == 0) {
            return 1;
        }
        //金额小于0，或者没有可选的硬币了，返回0
        if (amount < 0 || i == coins.length) {
            return 0;
        }
        if (map[i][amount] != -1) {
            return map[i][amount];
        }
        int res = 0;
        //每种硬币有两种状态，选和不选当前硬币
        res += dfs(coins, i + 1, amount, map);
        //选当前硬币,注意这里选的时候i没变，也就是说下次还可以再选，因为每个硬币可以选择无数次
        res += dfs(coins, i, amount - coins[i], map);
        return map[i][amount] = res;
    }


    public int change3(int amount, int[] coins) {
        //dp[i][j]前i个硬币能凑成金额为j的组合数（前i个不一定全部用到）
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int i = 0; i < coins.length + 1; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                //第j枚硬币可以选择0次，1次，2次……
                for (int k = 0; i >= coins[j] * k; k++) {
                    dp[j + 1][i] += dp[j][i - coins[j] * k];
                }
            }
        }
        return dp[coins.length][amount];
    }


}
