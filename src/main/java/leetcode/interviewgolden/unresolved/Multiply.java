package leetcode.interviewgolden.unresolved;

/**
 * @description: 递归乘法
 * @author: xuefei
 * @date: 2023/08/27 22:28
 */
public class Multiply {

    public int multiply(int A, int B) {
        int min = Math.min(A, B);
        int max = Math.max(A, B);
        int ans = 0;

        for (int i = 0; min != 0; i++) {
            if ((min & 1) == 1) {
                ans += max << i;
            }
            min >>= 1;
        }

        return ans;
    }

}
