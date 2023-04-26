package leetcode.basic.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 最长回文串
 * @author: xuefei
 * @date: 2023/02/09 22:38
 */
public class LongestPalindrome {

    public int longestPalindrome(String s) {
        int l = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            if (map.get(s.charAt(i)) == 2) {
                l += 2;
                map.put(s.charAt(i), 0);
            }
        }
        for (Integer value : map.values()) {
            if (value == 1) {
                l++;
                break;
            }
        }
        return l;
    }
}
