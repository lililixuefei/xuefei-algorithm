package xuefei.done.done;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description: 每日温度
 * @author: xuefei
 * @date: 2022/07/17 22:03
 */
public class DailyTemperatures {


    // 单调栈
    public int[] dailyTemperatures1(int[] temperatures) {
        Deque<Integer> stack = new LinkedList<>();
        int[] res = new int[temperatures.length];

        stack.push(0);
        for (int i = 1; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int preIndex = stack.pop();
                res[preIndex] = i - preIndex;
            }
            stack.push(i);
        }
        return res;
    }


    // 暴力递归
    public int[] dailyTemperatures2(int[] temperatures) {
        int[] ret = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            int temperature = temperatures[i];
            for (int j = i + 1; j < temperatures.length; j++) {
                if (temperatures[j] > temperature) {
                    ret[i] = j - i;
                    break;
                }
            }
        }
        return ret;
    }
}
