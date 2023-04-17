package leetcode.basic.dfs;

/**
 * @description: 被围绕的区域
 * @author: xuefei
 * @date: 2023/04/18 00:07
 */
public class Solve {

	int n, m;

	public void solve(char[][] board) {
		n = board.length;
		if (n == 0) {
			return;
		}
		m = board[0].length;
		for (int i = 0; i < n; i++) {
			dfs(board, i, 0);
			dfs(board, i, m - 1);
		}
		for (int i = 1; i < m - 1; i++) {
			dfs(board, 0, i);
			dfs(board, n - 1, i);
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (board[i][j] == 'A') {
					board[i][j] = 'O';
				} else if (board[i][j] == 'O') {
					board[i][j] = 'X';
				}
			}
		}
	}

	public void dfs(char[][] board, int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= m || board[x][y] != 'O') {
			return;
		}
		board[x][y] = 'A';
		dfs(board, x + 1, y);
		dfs(board, x - 1, y);
		dfs(board, x, y + 1);
		dfs(board, x, y - 1);
	}


	public void solve_me(char[][] board) {
		int n = board.length;
		int m = board[0].length;

		for (int i = 0; i < n; i++) {
			dfs_me(board, i, 0, 'O', '1');
			dfs_me(board, i, m - 1, 'O', '1');
		}

		for (int j = 0; j < m; j++) {
			dfs_me(board, 0, j, 'O', '1');
			dfs_me(board, n - 1, j, 'O', '1');
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (board[i][j] == 'O') {
					dfs_me(board, i, j, 'O', 'X');
				}
			}
		}

		for (int i = 0; i < n; i++) {
			dfs_me(board, i, 0, '1', 'O');
			dfs_me(board, i, m - 1, '1', 'O');
		}

		for (int j = 0; j < m; j++) {
			dfs_me(board, 0, j, '1', 'O');
			dfs_me(board, n - 1, j, '1', 'O');
		}
	}

	private void dfs_me(char[][] board, int i, int j, char s, char t) {
		int n = board.length;
		int m = board[0].length;
		if (i >= n || i < 0 || j >= m || j < 0) {
			return;
		}
		if (board[i][j] != s) {
			return;
		}
		board[i][j] = t;
		dfs_me(board, i - 1, j, s, t);
		dfs_me(board, i + 1, j, s, t);
		dfs_me(board, i, j - 1, s, t);
		dfs_me(board, i, j + 1, s, t);
	}

}
