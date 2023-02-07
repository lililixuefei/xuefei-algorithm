package xuefei.done.leetcode.hot_100;

import java.util.HashMap;

/**
 * @description: 无重复字符的最长子串   https://leetcode.cn/problems/longest-substring-without-repeating-characters/
 * @author: xuefei
 * @date: 2022/06/26 21:05
 */
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            // 不管是否更新left，都要更新 s.charAt(i) 的位置！
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}
