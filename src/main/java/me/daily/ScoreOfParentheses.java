package me.daily;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @description: 括号的分数 - Not done
 * https://leetcode.cn/problems/score-of-parentheses/
 * @author: xuefei
 * @date: 2022/10/09 23:14
 */
public class ScoreOfParentheses {

    public int scoreOfParentheses(String s) {
        Deque<Integer> st = new ArrayDeque<>();
        st.push(0);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push(0);
            } else {
                int v = st.pop();
                int top = st.pop() + Math.max(2 * v, 1);
                st.push(top);
            }
        }
        return st.pop();
    }
}
