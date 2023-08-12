package leetcode.interviewgolden.resolved;

/**
 * @description: 字符串轮转
 * @author: xuefei
 * @date: 2023/08/12 13:55
 */
public class IsFlipedString {

    public static void main(String[] args) {
        isFlipedString("waterbottle", "erbottlewat");
    }

    public static boolean isFlipedString(String s1, String s2) {
        return s1.length() == s2.length() && (s1 + s1).contains(s2);
    }

    public static boolean isFlipedString_me(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }
        if (s1.length() == 0) {
            return true;
        }

        String newS1 = s1 + s1;
        int l = 0;
        int i = 0;
        int r = newS1.length();
        while (l < r) {
            int k = l;
            while (k < r && i < s2.length() && newS1.charAt(k) == s2.charAt(i)) {
                k++;
                i++;
            }
            if (i == s2.length()) {
                return true;
            }
            i = 0;
            l++;
        }
        return false;
    }


}
