package leetcode.basic.dp.basic.fibonaccitype;

/**
 * @description: 斐波那契数
 * @author: xuefei
 * @date: 2023/06/04 23:29
 */
public class Fibonacci {

	public int fib(int n) {
		if (n < 2) {
			return n;
		}
		int p = 0;
		int m = 1;
		int ans = 0;
		for (int i = 2; i <= n; i++) {
			ans = p + m;
			p = m;
			m = ans;
		}
		return ans;
	}

}
