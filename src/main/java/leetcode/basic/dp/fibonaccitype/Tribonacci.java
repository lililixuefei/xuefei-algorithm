package leetcode.basic.dp.fibonaccitype;

/**
 * @description: 第 N 个泰波那契数
 * @author: xuefei
 * @date: 2023/05/28 12:46
 */
public class Tribonacci {

	public int tribonacci(int n) {
		if (n <= 1){
			return n;
		}
		if (n == 2){
			return 1;
		}
		int t0 = 0;
		int t1 = 1;
		int t2 = 1;
		int ans = 0;
		for (int i = 0; i < n; i++) {
			ans = t0 + t1 + t2;
			t0 = t1;
			t1 = t2;
			t2 = ans;
		}
		return ans;
	}

}
