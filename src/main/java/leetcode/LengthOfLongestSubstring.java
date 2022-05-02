package leetcode;

import java.util.HashMap;

/**
 * @description: 无重复字符的最长子串    https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * @author: xuefei
 * @date: 2022/05/02 19:36
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {

        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));

    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}
