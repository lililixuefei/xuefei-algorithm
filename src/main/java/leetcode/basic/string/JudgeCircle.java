package leetcode.basic.string;

/**
 * @description: 机器人能否返回原点
 * @author: xuefei
 * @date: 2023/02/09 22:38
 */
public class JudgeCircle {

    public boolean judgeCircle(String moves) {
        int r = 0;
        int l = 0;
        int u = 0;
        int d = 0;
        for (int i = 0; i < moves.length(); i++) {
            char c = moves.charAt(i);
            if (c == 'R') {
                r++;
            } else if (c == 'L') {
                l++;
            } else if (c == 'U') {
                u++;
            } else {
                d++;
            }
        }
        return (r == l) && (u == d);
    }

}
