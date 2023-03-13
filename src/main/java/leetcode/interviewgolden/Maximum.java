package leetcode.interviewgolden;

/**
 * @description: 最大数值
 * @author: xuefei
 * @date: 2023/03/13 23:47
 */
public class Maximum {

	public int maximum_me(int a, int b) {
		return a > b ? a : b;
	}

	public int maximum(int a, int b) {
		long x = (long) a - (long) b;
		int k = (int) (x >> 63);
		return (1 + k) * a - b * k;
	}

}
