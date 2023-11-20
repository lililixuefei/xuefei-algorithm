package labuladong.dfs.floodfill;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/11/20 23:15
 * @Version 1.0
 */
public class ColorBorder {

    private int target;
    private boolean[][] visited;


    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        visited = new boolean[grid.length][grid[0].length];
        target = grid[row][col];
        process(grid, row, col, color);
        return grid;
    }

    private int process(int[][] image, int i, int j, int newColor) {
        if (i < 0 || i >= image.length || j < 0 || j >= image[0].length) {
            return 0;
        }
        if (visited[i][j]) {
            return 1;
        }
        if (image[i][j] != target) {
            return 0;
        }
        visited[i][j] = true;
        int surround = process(image, i - 1, j, newColor) +
                process(image, i + 1, j, newColor) +
                process(image, i, j - 1, newColor) +
                process(image, i, j + 1, newColor);
        if (surround < 4) {
            image[i][j] = newColor;
        }
        return 1;
    }

}
