package leetcode.basic.string;


/**
 * @description: 最长公共前缀
 * @author: xuefei
 * @date: 2023/02/09 22:38
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return null;
        }
        if (strs.length == 1) {
            return strs[0];
        }
        int i = -1;
        boolean flag = true;
        while (flag) {
            char c = 0;
            i++;

            for (String str : strs) {
                int length = str.length();
                if (length <= i) {
                    flag = false;
                    break;
                }
                if (c == 0) {
                    c = str.charAt(i);
                } else {
                    if (c != str.charAt(i)) {
                        flag = false;
                        break;
                    }
                }
            }

        }
        return strs[0].substring(0, i);
    }

}
