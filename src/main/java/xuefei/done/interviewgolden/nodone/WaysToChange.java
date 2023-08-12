package xuefei.done.interviewgolden.nodone;

/**
 * @description: 硬币
 * @author: xuefei
 * @date: 2023/03/15 22:13
 */
public class WaysToChange {

	public static void main(String[] args) {
		WaysToChange waysToChange = new WaysToChange();
		System.out.println(waysToChange.waysToChange(6));
	}


	static final int MOD = 1000000007;
	int[] coins = {25, 10, 5, 1};

	public int waysToChange(int n) {
		int[] f = new int[n + 1];
		f[0] = 1;
		for (int c = 0; c < 4; ++c) {
			int coin = coins[c];
			for (int i = coin; i <= n; ++i) {
				f[i] = (f[i] + f[i - coin]) % MOD;
			}
		}
		return f[n];
	}

	// --------------------------------------------

	private int ways = 0;

	private int result = 0;

	public int waysToChange_backtrack(int n) {
		int[] coins = new int[]{1, 5, 10, 25};
		backtrack(coins, 0, n);
		return ways;
	}

	private void backtrack(int[] coins, int start, int n) {
		if (result == n) {
			ways++;
		}
		if (result > n) {
			return;
		}
		for (int i = start; i < coins.length; i++) {
			result += coins[i];
			backtrack(coins, i, n);
			result -= coins[i];
		}
	}

}
