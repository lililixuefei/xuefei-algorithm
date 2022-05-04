package wushixiong.stack;

import java.util.Stack;

/**
 * @description: 有效的括号   https://leetcode-cn.com/problems/valid-parentheses/
 * @author: xuefei
 * @date: 2022/05/04 23:52
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        // 当字符串长度为奇数的时候，属于无效情况，直接返回 false
        if (s.length() % 2 == 1) {
            // 无效情况，返回 false
            return false;
        }

        //构建一个栈，用来存储括号
        Stack<Character> stack = new Stack<Character>();

        // 把字符串转换为数组的形式，方便获取字符串中的每个字符
        char[] charArray = s.toCharArray();

        // 遍历字符串数组中的所有元素
        for (char c : charArray) {

            // 获取此时的字符
            // 如果字符为左括号 ( ，那么就在栈中添加对左括号 （
            if (c == '(') {

                // 添加对左括号 （
                stack.push('(');

                // 如果字符为左括号 [ ，那么就在栈中添加对左括号 [
            } else if (c == '[') {

                // 添加对应的右括号 ]
                stack.push('[');

                // 如果字符为左括号 { ，那么就在栈中添加对左括号 {
            } else if (c == '{') {

                // 添加对应的右括号 }
                stack.push('{');

                // 否则的话，说明此时 c 是 ）] } 这三种符号中的一种
            } else {

                // 如果栈已经为空，而现在遍历的字符 c 是 ）] } 这三种符号中的一种
                // 找不到可以匹配的括号，返回 false
                // 比如这种情况  }{，直接从右括号开始，此时栈为空
                if (stack.isEmpty()) {
                    return false;
                }

                // 如果栈不为空，获取栈顶元素
                char top = stack.peek();

                // 将栈顶元素和此时的元素 c 进行比较，如果相同，则将栈顶元素移除
                if (top == '(' && c == ')' || top == '[' && c == ']' || top == '{' && c == '}') {
                    // 移除栈顶元素
                    stack.pop();
                } else {
                    // 如果不相同，说明不匹配，返回 false
                    return false;
                }

            }

        }

        // 遍历完整个字符数组，判断栈是否为空
        // 如果栈为空，说明字符数组中的所有括号都是闭合的
        // 如果栈为空，说明有未闭合的括号
        return stack.isEmpty();
    }
}
