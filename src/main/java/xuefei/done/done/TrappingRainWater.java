package xuefei.done.done;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description: 接雨水
 * @author: xuefei
 * @date: 2022/07/17 22:40
 */
public class TrappingRainWater {

    public static void main(String[] args) {

        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        System.out.println(trap1(height));
    }

    // 暴力
    public int trap2(int[] height) {
        int ans = 0;
        int size = height.length;
        for (int i = 1; i < size - 1; i++) {
            int max_left = 0;
            int max_right = 0;
            for (int j = i; j >= 0; j--) {
                max_left = Math.max(max_left, height[j]);
            }
            for (int j = i; j < size; j++) {
                max_right = Math.max(max_right, height[j]);
            }
            ans += Math.min(max_left, max_right) - height[i];
        }
        return ans;
    }


    // 动态规划
    public int trap3(int[] height) {
        int sum = 0;
        int[] max_left = new int[height.length];
        int[] max_right = new int[height.length];

        for (int i = 1; i < height.length - 1; i++) {
            max_left[i] = Math.max(max_left[i - 1], height[i - 1]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            max_right[i] = Math.max(max_right[i + 1], height[i + 1]);
        }
        for (int i = 1; i < height.length - 1; i++) {
            int min = Math.min(max_left[i], max_right[i]);
            if (min > height[i]) {
                sum = sum + (min - height[i]);
            }
        }
        return sum;
    }

    public static int trap1(int[] height) {
        int ans = 0;
        Deque<Integer> stack = new LinkedList<>();
        int n = height.length;
        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                int currWidth = i - left - 1;
                int currHeight = Math.min(height[left], height[i]) - height[top];
                ans += currWidth * currHeight;
            }
            stack.push(i);
        }
        return ans;
    }

    public int trap(int[] height) {
        // 只有两根柱子，必然无法形成一个凹槽，那么水的面积就是 0
        if (height.length <= 2) {
            return 0;
        }
        // 构建一个栈，用来存储对应的柱子的下标
        // 注意：stack 存储的是下标而非高度
        Deque<Integer> stack = new LinkedList<>();
        // 一开始水的面积是 0
        int result = 0;
        // 从头开始遍历整个数组
        for (int i = 0; i < height.length; i++) {
            // 如果栈为空，那么直接把当前索引加入到栈中
            if (stack.isEmpty()) {
                // 把当前索引加入到栈中
                stack.push(i);
                // 否则的话，栈里面是有值的，我们需要去判断此时的元素、栈顶元素、栈顶之前的元素能否形成一个凹槽
                // 情况一：此时的元素小于栈顶元素，凹槽的右侧不存在，无法形成凹槽
            } else if (height[i] <= height[stack.peek()]) {
                // 把当前索引加入到栈中
                stack.push(i);
                // 情况三：此时的的元素大于栈顶元素，有可能形成凹槽
                // 注意是有可能形成，因为比如栈中的元素是 2 、2 ，此时的元素是 3，那么是无法形成凹槽的
            } else {
                // 由于栈中有可能存在多个元素，移除栈顶元素之后，剩下的元素和此时的元素也有可能形成凹槽
                // 因此，我们需要不断的比较此时的元素和栈顶元素
                // 此时的元素依旧大于栈顶元素时，我们去计算此时的凹槽面积
                // 借助 while 循环来实现这个操作
                while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                    // 1、获取栈顶的下标，bottom 为凹槽的底部位置
                    int bottom = stack.peek();
                    // 将栈顶元素推出，去判断栈顶之前的元素是否存在，即凹槽的左侧是否存在
                    stack.pop();
                    // 2、如果栈不为空，即栈中有元素，即凹槽的左侧存在
                    if (!stack.isEmpty()) {
                        // 凹槽左侧的高度 height[stack.peek() 和 凹槽右侧的高度 height[i]
                        // 这两者的最小值减去凹槽底部的高度就是凹槽的高度
                        int h = Math.min(height[stack.peek()], height[i]) - height[bottom];
                        // 凹槽的宽度等于凹槽右侧的下标值 i 减去凹槽左侧的下标值 stack.peek 再减去 1
                        int w = i - stack.peek() - 1;
                        System.out.println("凹槽右侧-->" + i);
                        System.out.println("凹槽左侧-->" + stack.peek());
                        System.out.println("凹槽高度-->" + h);
                        System.out.println("凹槽宽度-->" + w);
                        System.out.println("凹槽面积-->" + h * w);
                        System.out.println("---------------");
                        // 将计算的结果累加到最终的结果上去
                        result += h * w;
                    }
                }
                // 栈中和此时的元素可以形成栈的情况在上述 while 循环中都已经判断了
                // 那么，此时栈中的元素必然不可能大于此时的元素，所以可以把此时的元素添加到栈中
                stack.push(i);
            }
        }
        // 最后返回结果即可
        return result;
    }

}
