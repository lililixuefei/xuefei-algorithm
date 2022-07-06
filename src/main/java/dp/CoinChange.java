package dp;

import java.util.Arrays;

/**
 * @description: 零钱兑换   https://leetcode.cn/problems/coin-change/
 * @author: xuefei
 * @date: 2022/07/07 00:07
 */
public class CoinChange {

    public static void main(String[] args) {
        int[] coin = {1,2,5,7,10};
        System.out.println(coinChange(coin,14));
    }

    public static int coinChange(int[] coins, int amount) {

        // 初始化数组 dp，长度为 amount + 1，因为在 dp 数组中还会存储金额为 0 的情况
        // dp[i] 表示想要凑齐 i 元需要的最少硬币个数
        // dp[0] 表示想要凑齐 0 元需要的最少硬币个数
        // dp[1] 表示想要凑齐 1 元需要的最少硬币个数
        // dp[14] 表示想要凑齐 14 元需要的最少硬币个数
        int[] dp = new int[amount + 1];

        // 首先将数组 dp 里面的值都初始化为 -1
        // -1 表示当前的金额还没有找到需要的最少硬币个数
        Arrays.fill(dp, -1);

        // 想要凑齐 0 元的最少硬币个数是 0 个
        dp[0] = 0;

        // 依次计算想要凑齐 1 元到 amount 的最少硬币个数是多少
        for(int i = 1 ; i <= amount ; i++){

            // 对于每个金额 i 来说，coins 中的每个面值小于 i 的硬币都可以尝试去拼凑 i
            // 比如 i = 8 ，coins 为 [1,2,5,7,10]
            // 其中 1，2，5，7 都小于 8
            // 1 可以尝试去拼凑 8
            // 2 可以尝试去拼凑 8
            // 5 可以尝试去拼凑 8
            // 7 可以尝试去拼凑 8
            // 所以，设置一个变量 j ，遍历数组 coins
            for(int j = 0 ; j < coins.length;j++){

                // 1、如果当前的硬币面值 coins[j] 小于了 i，表示这枚硬币有可能可以拼凑到 i
                // 2、那么 i - coins[j] 表示面值 coins[j] 的硬币想要拼凑 i 需要那些面值的硬币金额
                // 3、而 dp[i-coins[j]] 表示想要凑齐 i - coins[j] 元需要的最少硬币个数
                // 4、如果 dp[i-coins[j]] != -1 ，表示想要凑齐 i - coins[j] 元需要的最少硬币个数有结果
                if(coins[j] <= i && dp[i-coins[j]] != -1){
                    // 这个时候，对于金额 i 来说
                    // 1、如果它之前还没有找到凑齐 i 元需要的最少硬币个数
                    // 2、如果此时计算的最少硬币个数比之前保存的结果 dp[i] 更小
                    // 那么更新 dp[i]
                    if(dp[i] == -1 || dp[i-coins[j]] + 1 < dp[i]){
                        // 更新 dp[i]
                        // dp[i] 表示想要凑齐 i 元需要的最少硬币个数
                        // 这个时候 dp[i] 为获取面值为 j 的那 1 个硬币
                        // 加上获取面值为 i - coins[j] 最少需要 dp[i - coins[j]] 个硬币
                        dp[i] = dp[i - coins[j]] + 1;
                    }

                }
            }
        }

        // dp[amount] 表示想要凑齐 amount 元需要的最少硬币个数
        // 返回这个结果就行
        return dp[amount];
    }
}
