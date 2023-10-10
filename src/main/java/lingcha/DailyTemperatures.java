package lingcha;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description 每日温度
 * @Author xuefei
 * @Date 2023/10/10 21:28
 * @Version 1.0
 */
public class DailyTemperatures {

    // [73,74,75,71,69,72,76,73]

    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new LinkedList<>();
        int n = temperatures.length;
        int[] ans = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return ans;
    }

}
