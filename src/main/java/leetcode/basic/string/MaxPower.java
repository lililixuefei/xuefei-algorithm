package leetcode.basic.string;


/**
 * @description: 连续字符
 * @author: xuefei
 * @date: 2023/02/09 22:38
 */
public class MaxPower {

    public int maxPower(String s) {
        if (s.length() == 1) {
            return 1;
        }
        int l = 0;
        int r = 0;
        int maxPower = 0;
        while (r < s.length()) {
            if (s.charAt(l) == s.charAt(r)) {
                r++;
                maxPower = Math.max(r - l, maxPower);
            } else {
                l = r;
                r++;
            }

        }
        return maxPower;
    }

}
