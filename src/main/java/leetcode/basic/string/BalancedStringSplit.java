package leetcode.basic.string;


/**
 * @description: 分割平衡字符串
 * @author: xuefei
 * @date: 2023/02/09 22:38
 */
public class BalancedStringSplit {


    public int balancedStringSplit(String s) {
        int ans = 0, d = 0;
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (ch == 'L') {
                ++d;
            } else {
                --d;
            }
            if (d == 0) {
                ++ans;
            }
        }
        return ans;
    }


    public int balancedStringSplit_wrong(String s) {

        int l = 0;
        int r = 1;
        int count = 0;
        while (r < s.length()) {
            char lChar = s.charAt(l);
            char rChar = s.charAt(r);
            if (check(lChar, rChar)) {
                count++;
                l += 2;
                r += 2;
            } else {
                l += 1;
                r += 1;
            }
        }
        return count;

    }

    private boolean check(char lChar, char rChar) {
        if (lChar == 'L' && rChar == 'R') {
            return true;
        }
        if (lChar == 'R' && rChar == 'L') {
            return true;
        }
        return false;
    }

}
