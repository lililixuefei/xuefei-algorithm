package leetcode.onequestion.resolved;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Description 环和杆
 * @Author xuefei
 * @Date 2023/11/2 22:09
 * @Version 1.0
 */
public class CountPoints {

    public static void main(String[] args) {
        countPoints_me_r("B0B6G0R6R0R6G9");
    }

    public static int countPoints_me_r(String rings) {
        Map<Character, Set<Character>> map = new HashMap<>();
        for (int i = 1; i < rings.length(); i += 2) {
            char color = rings.charAt(i - 1);
            char index = rings.charAt(i);
            map.putIfAbsent(index,new HashSet<>());
            map.get(index).add(color);
        }
        int count = 0;
        for (Set<Character> value : map.values()) {
            if (value.size() == 3) {
                count++;
            }
        }
        return count;
    }

}
