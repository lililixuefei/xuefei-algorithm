package leetcode.basic.dfs;

/**
 * @description: 被围绕的区域
 * @author: xuefei
 * @date: 2023/04/18 00:07
 */
public class Solve {

	public void solve(char[][] board) {
		int n = board.length;
		int m = board[0].length;

		for (int i = 0; i < n; i++) {
			dfs(board, i, 0, 'O', '1');
			dfs(board, i, m - 1, 'O', '1');
		}

		for (int j = 0; j < m; j++) {
			dfs(board, 0, j, 'O', '1');
			dfs(board, n - 1, j, 'O', '1');
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (board[i][j] == 'O') {
					dfs(board, i, j, 'O', 'X');
				}
			}
		}

		for (int i = 0; i < n; i++) {
			dfs(board, i, 0, '1', 'O');
			dfs(board, i, m - 1, '1', 'O');
		}

		for (int j = 0; j < m; j++) {
			dfs(board, 0, j, '1', 'O');
			dfs(board, n - 1, j, '1', 'O');
		}
	}

	private void dfs(char[][] board, int i, int j, char s, char t) {
		int n = board.length;
		int m = board[0].length;
		if (i >= n || i < 0 || j >= m || j < 0) {
			return;
		}
		if (board[i][j] != s) {
			return;
		}
		board[i][j] = t;
		dfs(board, i - 1, j, s, t);
		dfs(board, i + 1, j, s, t);
		dfs(board, i, j - 1, s, t);
		dfs(board, i, j + 1, s, t);
	}

}
