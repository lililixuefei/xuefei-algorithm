package leetcode.top100;

import java.util.*;

/**
 * @Description 字母异位词分组
 * @Author xuefei
 * @Date 2023/10/28 17:39
 * @Version 1.0
 */
public class GroupAnagrams {

    public static void main(String[] args) {
        String[] strings = {"eat", "tea", "tan", "ate", "nat", "bat"};
        groupAnagrams(strings);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        // 编码到分组的映射
        HashMap<String, List<String>> codeToGroup = new HashMap<>();
        for (String s : strs) {
            // 对字符串进行编码
            String code = encode(s);
            // 把编码相同的字符串放在一起
            codeToGroup.putIfAbsent(code, new LinkedList<>());
            codeToGroup.get(code).add(s);
        }

        // 获取结果
        List<List<String>> res = new LinkedList<>();
        for (List<String> group : codeToGroup.values()) {
            res.add(group);
        }

        return res;
    }

    // 利用每个字符的出现次数进行编码
    static String encode(String s) {
        char[] count = new char[26];
        for (char c : s.toCharArray()) {
            int delta = c - 'a';
            count[delta]++;
        }
        return new String(count);
    }


    public static List<List<String>> groupAnagrams_me(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String arrayString = Arrays.toString(charArray);
            map.put(arrayString, map.getOrDefault(arrayString, new ArrayList<>()));
            map.get(arrayString).add(str);
        }
        List<List<String>> ans = new ArrayList<>();
        for (List<String> value : map.values()) {
            ans.add(value);
        }
        return ans;
    }

}
