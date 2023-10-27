package leetcode.me;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 有重复字符串的排列组合
 * @author: xuefei
 * @date: 2023/10/27 19:18
 */
public class Permutation2 {


    List<String> ans;

    LinkedList<String> path;

    boolean[] visited;

    public String[] permutation(String str) {
        if (str == null || str.isEmpty()) {
            return new String[0];
        }

        ans = new ArrayList<>();
        path = new LinkedList<>();
        visited = new boolean[str.length()];

        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);

        process(charArray, path);

        return ans.toArray(new String[0]);

    }

    private void process(char[] charArray, LinkedList<String> path) {
        if (path.size() == charArray.length) {
            StringBuilder stringBuilder = new StringBuilder();
            for (String s : path) {
                stringBuilder.append(s);
            }
            ans.add(stringBuilder.toString());
            return;
        }

        for (int j = 0; j < charArray.length; j++) {
            if (visited[j]) {
                continue;
            }
            if (j > 0 && charArray[j] == charArray[j - 1] && !visited[j - 1]) {
                continue;
            }
            visited[j] = true;
            path.add(String.valueOf(charArray[j]));
            process(charArray, path);
            visited[j] = false;
            path.removeLast();
        }

    }

}
