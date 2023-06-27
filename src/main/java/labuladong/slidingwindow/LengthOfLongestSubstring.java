package labuladong.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/2/1 5:25 PM
 * @Version 1.0
 */
public class LengthOfLongestSubstring {

    int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();

        int left = 0, right = 0;
        int res = 0; // 记录结果
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            // 进行窗口内数据的一系列更新
            window.put(c, window.getOrDefault(c, 0) + 1);
            // 判断左侧窗口是否要收缩
            while (window.get(c) > 1) {
                char d = s.charAt(left);
                left++;
                // 进行窗口内数据的一系列更新
                window.put(d, window.getOrDefault(d, 0) - 1);
            }
            // 在这里更新答案
            res = Math.max(res, right - left);
        }
        return res;
    }
}
