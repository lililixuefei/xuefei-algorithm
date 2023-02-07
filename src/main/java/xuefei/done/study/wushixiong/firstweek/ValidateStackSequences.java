package xuefei.done.study.wushixiong.firstweek;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description: 验证栈序列
 * @author: xuefei
 * @date: 2022/06/19 23:26
 */
public class ValidateStackSequences {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new LinkedList<>();
        int index = 0;

        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == popped[index]) {
                stack.pop();
                index++;
            }
        }

       return stack.isEmpty();
    }
}
