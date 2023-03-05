package leetcode.basic.slidingwindow;

/**
 * @description: 最长的美好子字符串
 * @author: xuefei
 * @date: 2023/02/22 23:40
 */
public class LongestNiceSubstring {

    public static void main(String[] args) {
        System.out.println(longestNiceSubstring("cChH"));
    }

    /**
     * 错误了
     *
     * @param s
     * @return
     */
    public static String longestNiceSubstring(String s) {
        int[] dp = new int[s.length()];
        dp[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            dp[i] = Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(s.charAt(i - 1)) ? dp[i - 1] + 1 : 1;
        }
        int ans = 0;
        int index = 0;

        for (int i = 0; i < dp.length; i++) {
            if (ans < dp[i]) {
                ans = dp[i];
                index = i;
            }
        }
        return ans < 2 ? "" : s.substring(index - ans + 1, index + 1);
    }

}
