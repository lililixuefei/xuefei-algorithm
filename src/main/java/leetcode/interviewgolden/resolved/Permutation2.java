package leetcode.interviewgolden.resolved;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @description:  有重复字符串的排列组合
 * @author: xuefei
 * @date: 2023/08/31 20:32
 */
public class Permutation2 {

    StringBuilder stringBuilder = new StringBuilder();

    List<String> res = new ArrayList<>();

    boolean[] used;


    public String[] permutation(String S) {

        char[] chars = S.toCharArray();
        // 先排序，让相同的元素靠在一起
        Arrays.sort(chars);
        used = new boolean[chars.length];
        backtrack(chars);
        return res.toArray(new String[0]);
    }

    public void backtrack(char[] chars) {
        String str = stringBuilder.toString();
        if (str.length() == chars.length) {
            res.add(str);
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && chars[i] == chars[i - 1] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            stringBuilder.append(chars[i]);
            backtrack(chars);
            stringBuilder.deleteCharAt(stringBuilder.toString().length() - 1);
            used[i] = false;
        }
    }



}
