package leetcode.basic.string;

/**
 * @description: 旋转字符串
 * @author: xuefei
 * @date: 2023/02/09 22:38
 */
public class RotateString {

    public static void main(String[] args) {

        String s = "bbbacddceeb";
        String goal = "ceebbbbacdd";
        System.out.println(rotateString(s, goal));

    }

    public static boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        goal = goal + goal;
        return goal.contains(s);
    }

    public static boolean rotateString_wrong(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        goal = goal + goal;
        goal.contains(s);
        int v = 0;
        int j = 0;
        for (int i = 0; i < goal.length(); i++) {
            if (v == s.length()) {
                return true;
            }
            if (j > s.length() - 1) {
                return false;
            }
            if (goal.charAt(i) == s.charAt(j)) {
                v++;
                j++;
            } else {
                v = 0;
                j = 0;
            }
        }
        return false;
    }

}
