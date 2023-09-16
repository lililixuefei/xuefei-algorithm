package leetcode.interviewgolden.unresolved;

/**
 * @Description 最大数值
 * @Author xuefei
 * @Date 2023/9/16 15:09
 * @Version 1.0
 */
public class Maximum {

    public int maximum(int a, int b) {
        long x = (long) a - (long) b;
        int k = (int) (x >> 63);

        return (1 + k) * a - b * k;
    }

}
