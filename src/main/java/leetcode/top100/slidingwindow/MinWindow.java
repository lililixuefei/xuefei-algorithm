package leetcode.top100.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 最小覆盖子串
 * @Author xuefei
 * @Date 2023/10/28 19:31
 * @Version 1.0
 */
public class MinWindow {

    public String minWindow(String s, String t) {
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }

        int start = 0;
        int len = Integer.MAX_VALUE;
        int valid = 0;
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            char curChar = s.charAt(right);
            right++;

            if (need.containsKey(curChar)) {
                window.put(curChar, window.getOrDefault(curChar, 0) + 1);
                if (window.get(curChar).equals(need.get(curChar))) {
                    valid++;
                }
            }

            while (valid == need.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                // d 是将移出窗口的字符
                char d = s.charAt(left);
                // 缩小窗口
                left++;
                // 进行窗口内数据的一系列更新
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }
        // 返回最小覆盖子串
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

}
