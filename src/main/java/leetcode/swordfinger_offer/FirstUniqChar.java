package leetcode.swordfinger_offer;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @description: 剑指 Offer 50. 第一个只出现一次的字符
 * @author: xuefei
 * @date: 2022/11/13 16:34
 */
public class FirstUniqChar {

    public static void main(String[] args) {
        System.out.println(firstUniqChar1("loveleetcode"));
    }

    public static char firstUniqChar1(String s) {
        if (s == null || s.length() < 1) {
            return ' ';
        }
        int[] ans = new int[26];
        for (int i = 0; i < s.length(); i++) {
            ans[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (ans[s.charAt(i) - 'a'] == 1) {
                return s.charAt(i);
            }
        }
        return ' ';
    }


    public static char firstUniqChar2(String s) {
        if (s == null || s.length() < 1) {
            return ' ';
        }
        LinkedHashMap<Character, Boolean> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), true);
                continue;
            }
            map.put(s.charAt(i), false);
        }
        for (Map.Entry<Character, Boolean> entry : map.entrySet()) {
            if (Boolean.FALSE.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return ' ';
    }
}
