package leetcode.top100.ame.backtrack.undo;

/**
 * @Description
 * @Author xuefei
 * @Date 2024/4/5 00:13
 * @Version 1.0
 */
public class Exist {

	public boolean exist(char[][] board, String word) {
		int m = board.length;
		int n = board[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (dfs(board, i, j, word, 0)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean dfs(char[][] board, int i, int j, String word, int start) {
		if (i >= board.length || i < 0 || j >= board[0].length || j < 0) {
			return false;
		}
		if (board[i][j] != word.charAt(start)) {
			return false;
		}
		if (start == word.length() - 1) {
			return true;
		}
		board[i][j] = '\0';
		boolean result = dfs(board, i - 1, j, word, start + 1) ||
				dfs(board, i + 1, j, word, start + 1) ||
				dfs(board, i, j - 1, word, start + 1) ||
				dfs(board, i, j + 1, word, start + 1);
		board[i][j] = word.charAt(start);
		return result;
	}

}
