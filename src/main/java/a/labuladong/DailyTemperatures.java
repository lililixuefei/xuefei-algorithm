package a.labuladong;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description: 每日温度
 * @author: xuefei
 * @date: 2022/07/09 01:56
 */
public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && (temperatures[stack.peek()] <= temperatures[i])){
                stack.pop();
            }
            res[i] = stack.isEmpty() ? 0 : (stack.peek() - i);
            stack.push(i);
        }
        return res;
    }
}
