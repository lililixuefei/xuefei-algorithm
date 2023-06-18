package leetcode.basic.dp.basic.tree;

/**
 * @description: 不同的二叉搜索树
 * @author: xuefei
 * @date: 2023/06/18 23:21
 */
public class NumTrees {

	public int numTrees(int n) {
		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;

		for (int i = 2; i < n + 1; i++) {
			for (int j = 1; j < i + 1; j++) {
				dp[i] += dp[j - 1] * dp[i - j];
			}
		}

		return dp[n];
	}

}
