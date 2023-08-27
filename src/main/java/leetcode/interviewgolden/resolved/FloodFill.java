package leetcode.interviewgolden.resolved;

/**
 * @description: 颜色填充
 * @author: xuefei
 * @date: 2023/08/27 22:30
 */
public class FloodFill {

    int tarColor;

    boolean[][] visited;


    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        tarColor = image[sr][sc];
        visited = new boolean[image.length][image[0].length];
        dfs(image, sr, sc, newColor);
        return image;
    }


    private void dfs(int[][] image, int i, int j, int newColor) {
        if (i < 0 || i >= image.length || j < 0 || j >= image[0].length) {
            return;
        }
        if (image[i][j] != tarColor || visited[i][j]) {
            return;
        }

        visited[i][j] = true;
        image[i][j] = newColor;
        dfs(image, i + 1, j, newColor);
        dfs(image, i - 1, j, newColor);
        dfs(image, i, j + 1, newColor);
        dfs(image, i, j - 1, newColor);
    }

}
