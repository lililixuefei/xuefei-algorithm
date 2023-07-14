package leetcode.onequestion.resolved;

/**
 * @description: 交替数字和
 * @author: xuefei
 * @date: 2023/07/12 22:49
 */
public class AlternateDigitSum {

	class Solution {
		public int alternateDigitSum(int n) {
			if (n < 10) {
				return n;
			}
			int count = 0;

			int temp = n;
			while (temp > 0) {
				count++;
				temp = temp / 10;
			}

			int tempCount = count;
			int ans = 0;
			for (int i = 0; i < tempCount; i++) {
				int m = n % 10;
				n = n / 10;
				if (count % 2 != 0) {
					ans += m;
				} else {
					ans -= m;
				}
				count--;
			}

			return ans;
		}
	}

}
