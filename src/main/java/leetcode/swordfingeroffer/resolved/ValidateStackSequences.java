package leetcode.swordfingeroffer.resolved;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description: 剑指 Offer 31. 栈的压入、弹出序列
 * @author: xuefei
 * @date: 2023/08/10 23:05
 */
public class ValidateStackSequences {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed == null || popped == null || popped.length != pushed.length) {
            return false;
        }
        Deque<Integer> stack = new LinkedList<>();
        int popIndex = 0;
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == popped[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        return popIndex == pushed.length;
    }

}
