package xuefei.done.me.daily;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

/**
 * @description: 最长有效括号
 * https://leetcode.cn/problems/longest-valid-parentheses/
 * @author: xuefei
 * @date: 2022/10/09 23:34
 */
public class LongestValidParentheses {

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("()()"));
    }

    public static int longestValidParentheses(String s) {
        int maxans = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }

    public static int longestValidParentheses_me(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }

        Deque<Integer> stack = new LinkedList<>();

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(' && (i + 1 < chars.length) && chars[i + 1] == ')') {
                if (Objects.isNull(stack.peek())) {
                    stack.push(1);
                } else {
                    int pre = stack.peek();
                    if (pre > 0) {
                        pre = stack.pop();
                        stack.push(pre + 1);
                    } else {
                        stack.push(1);
                    }
                }
                i++;
            } else {
                stack.push(0);
            }
        }

        int ans = 0;
        while (!stack.isEmpty()) {
            ans = Math.max(ans, stack.pop());
        }
        return ans * 2;
    }
}
