package leetcode.interviewgolden.nodone;

/**
 * @description: 颜色填充
 * @author: xuefei
 * @date: 2023/03/11 16:24
 */
public class FloodFill {

	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		//新值和旧值相等就没必要涂了
		if (newColor == image[sr][sc]) {
			return image;
		}
		dfs(image, sr, sc, newColor, image[sr][sc]);
		return image;
	}

	public void dfs(int[][] image, int sr, int sc, int newColor, int oldColor) {
		//越界或者这个点不能涂就返回
		if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[sr].length || image[sr][sc] != oldColor) {
			return;
		}
		//涂色+四个方向扩散
		image[sr][sc] = newColor;
		dfs(image, sr - 1, sc, newColor, oldColor);
		dfs(image, sr + 1, sc, newColor, oldColor);
		dfs(image, sr, sc - 1, newColor, oldColor);
		dfs(image, sr, sc + 1, newColor, oldColor);
	}

}
