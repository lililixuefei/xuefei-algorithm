package labuladong.brackets;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/11/15 0:01
 * @Version 1.0
 */
public class MinInsertions {

    public static int minInsertions(String s) {
        int res = 0, need = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                need += 2;
                if (need % 2 == 1) {
                    // 插入一个右括号
                    res++;
                    // 对右括号的需求减一
                    need--;
                }
            }
            if (c == ')') {
                need--;
                // 说明右括号太多了
                if (need == -1) {
                    // 需要插入一个左括号
                    res++;
                    // 同时，对右括号的需求变为 1
                    need = 1;
                }
            }
        }

        return res + need;
    }

}
