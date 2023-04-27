package leetcode.basic.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 字符串相加
 * @author: xuefei
 * @date: 2023/02/09 22:38
 */
public class FindWords {

    int[] numDic = new int[]{1, 2, 2, 1, 0, 1, 1, 1, 0, 1, 1, 1, 2, 2, 0, 0, 0, 0, 1, 0, 0, 2, 0, 2, 0, 2};

    public String[] findWords(String[] words) {
        List<String> ret = new ArrayList<>();
        for (String word : words) {
            if (check(word.toLowerCase())) {
                ret.add(word);
            }
        }
        return ret.toArray(new String[ret.size()]);
    }

    boolean check(String word) {
        int idx = numDic[word.charAt(0) - 'a'];
        for (char ch : word.toCharArray()) {
            if (numDic[ch - 'a'] != idx) {
                return false;
            }
        }
        return true;
    }

}
