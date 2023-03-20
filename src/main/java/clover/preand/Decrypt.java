package clover.preand;

/**
 * @description: 拆炸弹
 * @author: xuefei
 * @date: 2023/03/20 22:10
 */
public class Decrypt {

	public int[] decrypt(int[] code, int k) {
		int n = code.length;
		int[] ans = new int[n];
		if (k == 0) {
			return ans;
		}
		int[] sum = new int[n * 2 + 10];
		for (int i = 1; i <= 2 * n; i++) {
			sum[i] += sum[i - 1] + code[(i - 1) % n];
		}
		for (int i = 1; i <= n; i++) {
			if (k < 0) {
				ans[i - 1] = sum[i + n - 1] - sum[i + n + k - 1];
			} else {
				ans[i - 1] = sum[i + k] - sum[i];
			}
		}
		return ans;
	}

}
