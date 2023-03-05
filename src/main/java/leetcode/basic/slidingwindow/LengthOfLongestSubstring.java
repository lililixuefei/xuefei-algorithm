package leetcode.basic.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 无重复字符的最长子串
 * @author: xuefei
 * @date: 2023/02/07 23:34
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("tmmzuxt"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            if (map.containsKey(s.charAt(right))) {
                left = Math.max(left, map.get(s.charAt(right)) + 1);
            }
            map.put(s.charAt(right), right);
            res = Math.max(res, (right - left + 1));
            right++;
        }
        return res;
    }
}
