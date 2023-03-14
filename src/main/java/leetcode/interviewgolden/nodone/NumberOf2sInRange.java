package leetcode.interviewgolden.nodone;

import java.util.Arrays;

/**
 * @description: 2出现的次数
 * @author: xuefei
 * @date: 2023/03/14 23:00
 */
public class NumberOf2sInRange {

	public static void main(String[] args) {
		NumberOf2sInRange numberOf2sInRange = new NumberOf2sInRange();
		System.out.println(numberOf2sInRange.numberOf2sInRange_longtime(559366752));
	}

	char[] s;

	int[][] dp;

	public int numberOf2sInRange(int n) {
		s = Integer.toString(n).toCharArray();
		int m = s.length;
		dp = new int[m][m];
		for (int i = 0; i < m; i++) {
			Arrays.fill(dp[i], -1);
		}
		return f(0, 0, true);
	}

	int f(int i, int cnt2, boolean isLimit) {
		if (i == s.length) {
			return cnt2;
		}
		if (!isLimit && dp[i][cnt2] >= 0) {
			return dp[i][cnt2];
		}
		int res = 0;
		// 枚举要填入的数字 d
		for (int d = 0, up = isLimit ? s[i] - '0' : 9; d <= up; ++d) {
			res += f(i + 1, cnt2 + (d == 2 ? 1 : 0), isLimit && d == up);
		}
		if (!isLimit) {
			dp[i][cnt2] = res;
		}
		return res;
	}


	// ---------自己写的递归超时----------

	public int numberOf2sInRange_longtime(int n) {
		int count = 0;
		for (int i = 0; i <= n; i++) {
			int count1 = count(i, 0);
			System.out.println(i + "---" + count1);
			count += count1;
		}
		return count;
	}


	public int count(int n, int count) {
		if (n <= 11) {
			if (n == 2) {
				count++;
			}
			return count;
		}

		int curValue1 = n % 10;
		if (curValue1 == 2) {
			count++;
		}
		int curValue2 = n / 10;
		return count(curValue2, count);
	}

}
