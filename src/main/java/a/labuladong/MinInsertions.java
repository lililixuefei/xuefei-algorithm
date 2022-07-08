package a.labuladong;

/**
 * @description: 平衡括号字符串的最少插入次数
 * @author: xuefei
 * @date: 2022/07/09 01:01
 */
public class MinInsertions {

    public static void main(String[] args) {
        System.out.println(minInsertions(")()"));
    }

    public static int minInsertions(String s) {
        // need 记录需右括号的需求量
        int res = 0;
        int need = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 一个左括号对应两个右括号
            if (c == '(') {
                need += 2;
                if (need % 2 == 1) {
                    res++;
                    need--;
                }
            }

            if (c == ')') {
                need--;
                if (need == -1) {
                    res++;
                    need = 1;
                }
            }
        }
        return res + need;
    }
}
