package leetcode.onequestion.resolved;


/**
 * @description:  宝石补给
 * @author: xuefei
 * @date: 2023/09/15 18:31
 */
public class GiveGem {

    public int giveGem(int[] gem, int[][] operations) {

        for (int[] operation : operations) {
            int i = operation[0];
            int j = operation[1];
            if (i == j) {
                continue;
            }
            int m = gem[i] / 2;
            gem[i] -= m;
            gem[j] += m;
        }

        int min = gem[0];
        int max = gem[0];
        for (int num : gem) {
            min = Math.min(num, min);
            max = Math.max(num, max);
        }
        return max - min;

    }

}
