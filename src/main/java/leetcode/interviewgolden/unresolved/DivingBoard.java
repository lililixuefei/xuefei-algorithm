package leetcode.interviewgolden.unresolved;

/**
 * @Description 跳水板
 * @Author xuefei
 * @Date 2023/9/16 15:48
 * @Version 1.0
 */
public class DivingBoard {

    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) {
            return new int[0];
        }
        if (shorter == longer) {
            return new int[]{shorter * k};
        }
        int[] lengths = new int[k + 1];
        for (int i = 0; i <= k; i++) {
            lengths[i] = shorter * (k - i) + longer * i;
        }
        return lengths;
    }

}
