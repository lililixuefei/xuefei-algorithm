package xuefei.done.study.labuladong;

/**
 * @description: 使括号有效的最少添加
 * @author: xuefei
 * @date: 2022/07/09 00:55
 */
public class MinAddToMakeValid {

    public int minAddToMakeValid(String s) {
        // 记录的左括号的插入次数
        int res = 0;
        // 右括号的需求
        int need = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                need++;
            }

            if (c == ')') {
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
