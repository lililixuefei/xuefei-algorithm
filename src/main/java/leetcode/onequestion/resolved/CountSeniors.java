package leetcode.onequestion.resolved;

/**
 * @description: 老人的数目
 * @author: xuefei
 * @date: 2023/10/23 18:44
 */
public class CountSeniors {

    public static void main(String[] args) {
        String[] strings = {"7868190130M7522"};
        countSeniors(strings);
    }

    public static int countSeniors(String[] details) {
        int count = 0;
        for (String detail : details) {
            String substring = detail.substring(11, detail.length());
            if (Integer.parseInt(substring) > 6099) {
                count++;
            }
        }
        return count;
    }
}
