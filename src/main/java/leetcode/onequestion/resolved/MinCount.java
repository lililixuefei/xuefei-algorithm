package leetcode.onequestion.resolved;

/**
 * @Description 拿硬币
 * @Author xuefei
 * @Date 2023/9/20 0:02
 * @Version 1.0
 */
public class MinCount {

    public int minCount2(int[] coins) {
        int sum = 0;
        for (int i : coins) {
            sum += (i + 1) / 2;
        }
        return sum;
    }

    public int minCount(int[] coins) {
        int minCount = 0;
        for (int j : coins) {
            int coin = j;
            while (coin > 0) {
                minCount++;
                coin -= 2;
            }
        }
        return minCount;
    }

}
