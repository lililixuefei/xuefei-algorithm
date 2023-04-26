package leetcode.basic.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 最长回文串
 * @author: xuefei
 * @date: 2023/02/09 22:38
 */
public class LongestPalindrome {

    public int longestPalindrome_good(String s) {
        char[] occurs = new char[128];
        int ans = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            occurs[c]++;
            if (occurs[c] == 2) {
                ans += 2;
                occurs[c] = 0;
            }
        }

        if (ans < s.length()) ans++;
        return ans;
    }

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
//        for (Integer value : map.values()) {
//            if (value == 1) {
//                l++;
//                break;
//            }
//        }
        if (l < s.length()) l++;

        return l;
    }
}
