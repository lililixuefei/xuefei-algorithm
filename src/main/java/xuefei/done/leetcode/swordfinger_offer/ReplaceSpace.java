package xuefei.done.leetcode.swordfinger_offer;

/**
 * @description: 剑指 Offer 05. 替换空格
 * @author: xuefei
 * @date: 2022/11/12 23:29
 */
public class ReplaceSpace {

    public String replaceSpace(String s) {
        if (s == null || s.length() < 1) {
            return s;
        }
        return s.replace(" ", "%20");
    }
}
