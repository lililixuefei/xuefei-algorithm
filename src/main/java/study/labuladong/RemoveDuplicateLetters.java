package study.labuladong;

import java.util.*;

/**
 * @description: 去除重复字母
 * @author: xuefei
 * @date: 2022/07/11 23:17
 */
public class RemoveDuplicateLetters {


    String removeDuplicateLetters(String s) {
        // 存放去重的结果
        Deque<Character> stk = new LinkedList<>();
        int[] count = new int[256];

        for (char c : s.toCharArray()) {
            count[c]++;
        }

        boolean[] inStack = new boolean[256];
        for (char c : s.toCharArray()) {
            count[c]--;
            if (inStack[c]) {
                continue;
            }

            while (!stk.isEmpty() && stk.peek() > c) {
                if (count[stk.peek()] == 0) {
                    break;
                }
                inStack[stk.pop()] = false;
            }
            stk.push(c);
            inStack[c] = true;
        }
        StringBuilder sb = new StringBuilder();
        while (!stk.isEmpty()) {
            sb.append(stk.pop());
        }
        return sb.reverse().toString();

    }


    String removeDuplicateLetters2(String s) {
        // 存放去重的结果
        Deque<Character> stk = new LinkedList<>();
        // 布尔数组初始值为 false，记录栈中是否存在某个字符
        // 输入字符均为 ASCII 字符，所以大小 256 够用了
        boolean[] inStack = new boolean[256];

        for (char c : s.toCharArray()) {
            // 如果字符 c 存在栈中，直接跳过
            if (inStack[c]) {
                continue;
            }
            // 若不存在，则插入栈顶并标记为存在
            stk.push(c);
            inStack[c] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (!stk.isEmpty()) {
            sb.append(stk.pop());
        }
        // 栈中元素插入顺序是反的，需要 reverse 一下
        return sb.reverse().toString();
    }


    public String removeDuplicateLetters1(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        Set<Character> set = new HashSet<>();

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                continue;
            }
            stringBuilder.append(s.charAt(i));
            set.add(s.charAt(i));
        }
        return stringBuilder.toString();
    }
}
