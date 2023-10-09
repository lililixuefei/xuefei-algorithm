package leetcode.onequestion.unresolved;

import java.util.Arrays;

/**
 * @description: 最小和分割
 * @author: xuefei
 * @date: 2023/10/09 18:42
 */
public class SplitNum {

    public static void main(String[] args) {
        System.out.println(splitNum(100));
    }

    public static int splitNum(int num) {
        char[] stnum = Integer.toString(num).toCharArray();
        Arrays.sort(stnum);
        int num1 = 0;
        int num2 = 0;
        for (int i = 0; i < stnum.length; ++i) {
            if (i % 2 == 0) {
                num1 = num1 * 10 + (stnum[i] - '0');
            } else {
                num2 = num2 * 10 + (stnum[i] - '0');
            }
        }
        return num1 + num2;
    }

}
