package dp;

/**
 * @description: 机器人走路
 * @author: xuefei
 * @date: 2022/04/05 23:27
 */
public class RobotWalk {

    public static void main(String[] args) {
        int result1 = ways1(4, 2, 4, 4);
        System.out.println(result1);

        int result2 = ways2(4, 2, 4, 4);
        System.out.println(result2);

        int result3 = ways3(4, 2, 4, 4);
        System.out.println(result3);
    }

    /**
     * @param N     一共有多少个位置
     * @param start 机器人一开始在哪
     * @param aim   机器人目标是哪
     * @param K     一共可以走几步
     * @return
     */
    public static int ways1(int N, int start, int aim, int K) {
        return process1(start, K, aim, N);
    }

    /**
     * @param N     一共有多少个位置
     * @param start 机器人一开始在哪
     * @param aim   机器人目标是哪
     * @param K     一共可以走几步
     * @return
     */
    public static int ways2(int N, int start, int aim, int K) {
        // 缓存表
        int[][] dp = new int[N + 1][K + 1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= K; j++) {
                dp[i][j] = -1;
            }
        }
        // dp 缓存表
        return process2(start, K, aim, N, dp);
    }


    /**
     * @param N     一共有多少个位置
     * @param start 机器人一开始在哪
     * @param aim   机器人目标是哪
     * @param K     一共可以走几步
     * @return
     */
    public static int ways3(int N, int start, int aim, int K) {
        // 缓存表
        int[][] dp = new int[N + 1][K + 1];
        dp[aim][0] = 1;
        for (int rest = 1; rest <= K; rest++) {
            dp[1][rest] = dp[2][rest - 1];
            for (int curr = 2; curr < N; curr++) {
                dp[curr][rest] = dp[curr - 1][rest - 1] + dp[curr + 1][rest - 1];
            }
            dp[N][rest] = dp[N - 1][rest - 1];
        }
        return dp[start][K];


    }

    /**
     * 暴力递归
     *
     * @param curr 当前位置
     * @param rest 剩余步数
     * @param aim  目标位置
     * @param N    还有哪些位置
     * @return 机器人从 cur 出发，走过rest步后，最终停在aim的方法数是多少？
     */
    public static int process1(int curr, int rest, int aim, int N) {
        // base case
        // 如果已经不需要走了，走完了
        if (rest == 0) {
            return curr == aim ? 1 : 0;
        }
        if (curr == 1) {
            return process1(2, rest - 1, aim, N);
        }
        if (curr == N) {
            return process1(N - 1, rest - 1, aim, N);
        }
        // 中间位置
        return process1(curr - 1, rest - 1, aim, N) + process1(curr + 1, rest - 1, aim, N);
    }

    /**
     * 记忆化搜索、从顶向下的动态规划
     *
     * @param curr 当前位置 1 ~ N
     * @param rest 剩余步数 0 ~ K
     * @param aim  目标位置
     * @param N    还有哪些位置
     * @return 机器人从 cur 出发，走过rest步后，最终停在aim的方法数是多少？
     */
    public static int process2(int curr, int rest, int aim, int N, int[][] dp) {
        if (dp[curr][rest] != -1) {
            return dp[curr][rest];
        }
        // base case
        // 如果已经不需要走了，走完了
        int ans = 0;
        if (rest == 0) {
            ans = curr == aim ? 1 : 0;
        } else if (curr == 1) {
            ans = process2(2, rest - 1, aim, N, dp);
        } else if (curr == N) {
            ans = process2(N - 1, rest - 1, aim, N, dp);
        } else {
            // 中间位置
            ans = process2(curr - 1, rest - 1, aim, N, dp) + process2(curr + 1, rest - 1, aim, N, dp);
        }
        dp[curr][rest] = ans;
        return ans;
    }

    /**
     * 给定一个整型数组arr，代表数值不同的纸牌排成--条线
     * 玩家A和玩家B依次拿走每张纸牌
     * 规定玩家A先拿，玩家B后拿
     * 但是每个玩家每次只能拿走最左或最右的纸牌
     * 玩家A和玩家B都绝顶聪明.
     * 请返回最后获胜者的分数。
     */

}
