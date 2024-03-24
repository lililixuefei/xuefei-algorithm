package leetcode.top100.stack;

import java.util.Stack;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/11/25 21:01
 * @Version 1.0
 */
public class IsValid {

    // '('，')'，'{'，'}'，'['，']'

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char curC = s.charAt(i);
            if (curC == '(' || curC == '{' || curC == '[') {
                stack.push(curC);
            } else {
                char needC = getNeedC(curC);
                if (!stack.isEmpty() && stack.pop().equals(needC)) {
                    continue;
                }
                return false;
            }
        }
        return stack.isEmpty();
    }

    private char getNeedC(char curC) {
        if (curC == ')') {
            return '(';
        } else if (curC == ']') {
            return '[';
        } else {
            return '{';
        }
    }

}
