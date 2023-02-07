package xuefei.done.study.wushixiong.firstweek;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description: 每日温度
 * @author: xuefei
 * @date: 2022/06/19 23:55
 */
public class DailyTemperatures {

    /**
     * 维护一个单调递增栈，栈内元素从栈底到栈顶依次减小
     * 入栈的元素要和当前栈内栈首元素进行比较
     * 如果大于栈首元素，说明温度比之前更高，那么它们的下标差就是栈首元素等了多少天等到的更高温度的结果
     * 如果小于栈首元素，说明温度比之前更低，说明还没有等到更高的温度，直接放入到栈中
     */
    public static int[] dailyTemperatures(int[] temperatures) {
        // 构建一个栈,用来存放每日温度的下标
        Deque<Integer> stack = new LinkedList<>();

        // 构建一个数组，用来保存输出结果
        int[] res = new int[temperatures.length];

        // 从头开始遍历每天的温度
        for (int i = 0; i < temperatures.length; i++) {

            // 拿到当天的温度，需要和栈首元素进行比较
            // 如果此时栈不为空并且当天的温度大于栈首元素
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {

                // 首先获取栈首元素的值，并将元素从栈中移除
                int preIndex = stack.pop();

                // 它们的下标差就是栈首元素等了多少天等到的更高温度的结果，保存到输出数组 res 中
                res[preIndex] = i - preIndex;
            }

            // 再把当天的温度的下标值存放到栈中
            stack.push(i);
        }
        // 最后输出 res 数组即可
        return res;
    }
}
