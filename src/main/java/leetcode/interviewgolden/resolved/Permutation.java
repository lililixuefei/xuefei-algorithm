package leetcode.interviewgolden.resolved;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 无重复字符串的排列组合
 * @author: xuefei
 * @date: 2023/08/31 20:32
 */
public class Permutation {


    List<String> res = new ArrayList<>();

    boolean[] visited;

    public String[] permutation(String S) {
        visited = new boolean[S.length()];
        permutation(S.toCharArray(), new LinkedList<>());
        return res.toArray(new String[0]);
    }


    public void permutation(char[] chars, LinkedList<Character> characters) {
        if (characters.size() == chars.length) {
            StringBuilder stringBuilder = new StringBuilder();
            for (Character character : characters) {
                stringBuilder.append(character);
            }
            res.add(stringBuilder.toString());
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            characters.add(chars[i]);
            permutation(chars, characters);
            characters.removeLast();
            visited[i] = false;
        }
    }


    public void permutation2(char[] chars, StringBuilder stringBuilder) {
        final String s = stringBuilder.toString();
        if (s.length() == chars.length) {
            res.add(stringBuilder.toString());
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (s.contains(chars[i] + "")) {
                continue;
            }
            stringBuilder.append(chars[i]);
            permutation2(chars, stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.toString().length() - 1);
        }
    }


}
