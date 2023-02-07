package xuefei.done.dp;


import java.util.Arrays;

/**
 * @description: 硬币找零问题
 * @author: xuefei
 * @date: 2022/05/28 21:40
 */
public class GetMinCoinCount {

    public static void main(String[] args) {

        // 硬币面值
        int[] values = {3, 5};
        // 总值
        int total = 22;

        // 求得最小的硬币数量
        int minCounts = getMinCounts(total, values);
        System.out.println(minCounts);
    }


    public static int getMinCounts(int k, int[] values) {
        int[] memo = new int[k + 1];
        Arrays.fill(memo, -1);
        // 初始化状态
        memo[0] = 0;

        for (int v = 1; v <= k; v++) {
            // 模拟无穷大
            int minCount = k + 1;
            for (int currentValue : values) {
                // 如果当前面值大于硬币总额，那么跳过
                if (currentValue > v) {
                    continue;
                }

                // 使用当前面值，得到剩余硬币总额
                int rest = v - currentValue;
                int restCount = memo[rest];

                // 如果返回-1，说明组合不可信，跳过
                if (restCount == -1) {
                    continue;
                }

                // 保留最小总额
                int kCount = 1 + restCount;
                if (kCount < minCount) {
                    minCount = kCount;
                }
            }

            // 如果是可用组合，记录结果
            if (minCount != k + 1) {
                memo[v] = minCount;
            }
        }

        return memo[k];
    }


}
