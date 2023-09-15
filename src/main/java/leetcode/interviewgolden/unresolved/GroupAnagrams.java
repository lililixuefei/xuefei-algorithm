package leetcode.interviewgolden.unresolved;

import java.util.*;

/**
 * @Description 变位词组
 * @Author xuefei
 * @Date 2023/9/15 22:52
 * @Version 1.0
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }


}
