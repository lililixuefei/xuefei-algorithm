package labuladong.brackets;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description 有效的括号
 * @Author xuefei
 * @Date 2023/11/14 23:23
 * @Version 1.0
 */
public class IsValid {


    public static Boolean isValid(String str) {
        Deque<Character> left = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                left.push(c);
            } else {
                if (!left.isEmpty() && leftOf(c) == left.getFirst()) {
                    left.pop();
                } else {
                    return false;
                }
            }
        }
        return left.isEmpty();
    }

    public static char leftOf(char c) {
        if (c == '}') {
            return '{';
        }
        if (c == ')') {
            return '(';
        }
        return '[';
    }

}
