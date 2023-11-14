package labuladong.brackets;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/11/14 23:58
 * @Version 1.0
 */
public class MinAddToMakeValid {

    public static int minAddToMakeValid(String s) {
        // res 记录插入次数
        int res = 0;
        // need 变量记录右括号的需求量
        int need = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                // 对右括号的需求 + 1
                need++;
            }
            if (c == ')') {
                // 对右括号的需求 - 1
                need--;
                if (need == -1) {
                    need = 0;
                    // 需插入一个左括号
                    res++;
                }
            }
        }
        return res + need;
    }

}
