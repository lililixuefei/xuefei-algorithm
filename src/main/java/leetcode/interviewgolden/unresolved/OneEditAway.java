package leetcode.interviewgolden.unresolved;

/**
 * @description: 一次编辑
 * @author: xuefei
 * @date: 2023/08/12 01:57
 */
public class OneEditAway {

    public static void main(String[] args) {
        oneEditAway("a", "ab");
    }

    public static boolean oneEditAway(String first, String second) {
        if (first == null || second == null) {
            return false;
        }

        char[] chars1 = first.toCharArray();
        char[] chars2 = second.toCharArray();
        int abs = Math.abs(chars1.length - chars2.length);
        if (abs > 1) {
            return false;
        }

        int lcl = dis(chars1, chars2);

        return lcl <= 1;

    }

    private static int dis(char[] chars1, char[] chars2) {
        int n = chars1.length;
        int m = chars2.length;

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= m; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (chars1[i - 1] == chars2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + 1, Math.min(dp[i][j - 1] + 1, dp[i - 1][j - 1] + 1));
                }
            }
        }
        return dp[n][m];
    }


    /**
     * wrong
     *
     * @param chars1
     * @param chars2
     * @return
     */
    private int lcl(char[] chars1, char[] chars2) {
        int n = chars1.length;
        int m = chars2.length;

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (chars1[i - 1] == chars2[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }

}
