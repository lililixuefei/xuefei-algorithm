package labuladong.dfs.floodfill;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/11/20 22:48
 * @Version 1.0
 */
public class FloodFill {

    public static void main(String[] args) {
        int[][] image = {{0, 0, 0}, {0, 1, 1}};
        FloodFill floodFill = new FloodFill();
        floodFill.floodFill(image, 1, 1, 1);
    }

    private int target;

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (newColor == image[sr][sc]) {
            return image;
        }
        target = image[sr][sc];
        process(image, sr, sc, newColor);
        return image;
    }

    private void process(int[][] image, int i, int j, int newColor) {
        if (i < 0 || i >= image.length || j < 0 || j >= image[0].length) {
            return;
        }
        if (image[i][j] != target) {
            return;
        }
        image[i][j] = newColor;
        process(image, i - 1, j, newColor);
        process(image, i + 1, j, newColor);
        process(image, i, j - 1, newColor);
        process(image, i, j + 1, newColor);
    }

}
