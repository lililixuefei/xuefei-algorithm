package leetcode.basic.dp.basic.onedimensional;

/**
 * @description: 解码方法
 * @author: xuefei
 * @date: 2023/07/06 23:37
 */
public class NumDecodings {

	public static void main(String[] args) {
		String s = "226";
		System.out.println(numDecodings(s));
	}

	public static int numDecodings(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		char[] str = s.toCharArray();
		int N = str.length;
		// dp[i] -> process(str, index)返回值 index 0 ~ N
		int[] dp = new int[N + 1];
		dp[N] = 1;

		// dp依次填好 dp[i] dp[i+1] dp[i+2]
		for (int i = N - 1; i >= 0; i--) {
			if (str[i] != '0') {
				dp[i] = dp[i + 1];
				if (i + 1 == str.length) {
					continue;
				}
				int num = (str[i] - '0') * 10 + str[i + 1] - '0';
				if (num <= 26) {
					dp[i] += dp[i + 2];
				}
			}
		}
		return dp[0];
	}

}
