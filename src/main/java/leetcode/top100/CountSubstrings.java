package leetcode.top100;

/**
 * @description: 回文子串
 * @author: xuefei
 * @date: 2023/11/03 16:28
 */
public class CountSubstrings {

    public static void main(String[] args) {
        System.out.println(countSubstrings("hello"));
    }

    public static int countSubstrings(String s) {
        int n = s.length(), ans = 0;
        for (int i = 0; i < 2 * n - 1; ++i) {
            int l = i / 2, r = i / 2 + i % 2;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                --l;
                ++r;
                ++ans;
            }
        }
        return ans;
    }

    public static int countSubstrings_dp(String s) {
        // 动态规划法
        boolean[][] dp = new boolean[s.length()][s.length()];
        int ans = 0;

        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    ans++;
                }
            }
        }

        return ans;
    }

    public static int countSubstrings_me_r(String s) {
        int length = s.length();
        int ans = s.length();
        for (int i = 0; i < length; i++) {
            for (int j = length - 1; j > i; j--) {
                if (process(s, i, j)) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public static boolean process(String s, int i, int j) {
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}
