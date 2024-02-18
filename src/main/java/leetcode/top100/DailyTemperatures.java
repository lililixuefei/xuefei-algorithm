package leetcode.top100;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description
 * @Author xuefei
 * @Date 2024/2/18 22:23
 * @Version 1.0
 */
public class DailyTemperatures {

    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        dailyTemperatures(temperatures);
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length < 2) {
            return null;
        }
        int[] ans = new int[temperatures.length];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = temperatures.length - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                stack.push(i);
                ans[i] = 0;
                continue;
            }
            if (temperatures[stack.peek()] > temperatures[i]) {
                ans[i] = stack.peek() - i;
                stack.push(i);
            } else {
                while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    ans[i] = stack.peek() - i;
                } else {
                    ans[i] = 0;
                }
                stack.push(i);
            }
        }
        return ans;
    }

    public int[] dailyTemperatures2(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && (temperatures[stack.peek()] <= temperatures[i])) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? 0 : (stack.peek() - i);
            stack.push(i);
        }
        return res;
    }

}
