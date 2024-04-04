package leetcode.top100.ame.backtrack.undo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description
 * @Author xuefei
 * @Date 2024/4/4 15:55
 * @Version 1.0
 */
public class SolveNQueens {

	private List<List<String>> ans;

	public List<List<String>> solveNQueens(int n) {
		ans = new ArrayList<>();
		char[][] dp = new char[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(dp[i], '.');
		}
		process(dp, 0);
		return ans;
	}

	private void process(char[][] dp, int row) {
		if (row == dp.length) {
			List<String> rowAns = new ArrayList<>();
			for (int m = 0; m < dp.length; m++) {
				StringBuilder stringBuilder = new StringBuilder();
				for (int n = 0; n < dp.length; n++) {
					stringBuilder.append(dp[m][n]);
				}
				rowAns.add(stringBuilder.toString());
			}
			ans.add(rowAns);
			return;
		}
		for (int col = 0; col < dp.length; col++) {
			if (!isValid(dp, row, col)) {
				continue;
			}
			dp[row][col] = 'Q';
			process(dp, row + 1);
			dp[row][col] = '.';
		}
	}

	private boolean isValid(char[][] dp, int i, int j) {
		for (int row = i; row >= 0; row--) {
			if (dp[row][j] == 'Q') {
				return false;
			}
		}
		for (int row = i, col = j; row >= 0 && col >= 0; row--, col--) {
			if (dp[row][col] == 'Q') {
				return false;
			}
		}
		for (int row = i, col = j; row >= 0 && col < dp.length; row--, col++) {
			if (dp[row][col] == 'Q') {
				return false;
			}
		}
		return true;
	}


}
