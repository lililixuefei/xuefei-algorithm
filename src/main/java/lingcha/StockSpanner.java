package lingcha;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/online-stock-span/solutions/2470527/shi-pin-yi-ge-shi-pin-jiang-tou-dan-diao-cuk7/
 *
 * @Description 股票价格跨度
 * @Author xuefei
 * @Date 2023/10/10 21:06
 * @Version 1.0
 */
public class StockSpanner {

    private final Deque<int[]> stack = new LinkedList<>();


    // 第一个 next 调用算作第 0 天
    private int curDay = -1;

    public StockSpanner() {
        // 这样无需判断栈为空的情况
        stack.push(new int[]{-1, Integer.MAX_VALUE});
    }

    // 例如，如果未来 7 天股票的价格是 [100,80,60,70,60,75,85]，那么股票跨度将是 [1,1,1,2,1,4,6] 。

    public int next(int price) {
        while (price >= stack.peek()[1]) {
            // 栈顶数据后面不会再用到了，因为 price 更大
            stack.pop();
        }
        curDay++;
        int ans = curDay - stack.peek()[0];
        stack.push(new int[]{curDay, price});
        return ans;
    }

}
