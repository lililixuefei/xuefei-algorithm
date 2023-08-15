package leetcode.onequestion.unresolved;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 字符串中的查找与替换
 * @author: xuefei
 * @date: 2023/08/15 23:04
 */
public class FindReplaceString {

    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {

        int k = indices.length;

        // 是否替换的标志
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < k; i++) {
            if (s.startsWith(sources[i], indices[i])) {
                map.put(indices[i], i);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(i)) {
                sb.append(s.charAt(i));
            } else {
                sb.append(targets[map.get(i)]);
                i += sources[map.get(i)].length() - 1;
            }
        }

        return sb.toString();
    }

}
