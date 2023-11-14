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
