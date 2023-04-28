package leetcode.basic.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: “气球” 的最大数量
 * @author: xuefei
 * @date: 2023/02/09 22:38
 */
public class MaxNumberOfBalloons {

    public int maxNumberOfBalloons(String text) {
        Map<Character, Integer> charCount = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            charCount.put(text.charAt(i), charCount.getOrDefault(text.charAt(i), 0) + 1);
        }
        char[] chars = {'b', 'a', 'l', 'o', 'n'};

        int maxNumberOfBalloons = Integer.MAX_VALUE;
        for (char aChar : chars) {
            maxNumberOfBalloons = Math.min(charCount.getOrDefault(aChar, 0), maxNumberOfBalloons);
        }
        if (maxNumberOfBalloons == 0) {
            return 0;
        }

        int lCount = charCount.getOrDefault('l', 0);
        int oCount = charCount.getOrDefault('o', 0);

        return Math.min(Math.min(maxNumberOfBalloons, lCount / 2), oCount / 2);
    }

}
