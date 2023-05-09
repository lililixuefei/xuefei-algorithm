package zuoshen.daily;

/**
 * @description: 数组a,b 变成相同数组的最小代价
 * @author: xuefei
 * @date: 2023/05/09 23:03
 */
public class ChangeToSame {


	public static int minCost(int[] a, int[] b, int ai, int bi) {
		if (ai == a.length && bi == b.length) {
			return 0;
		}
		if (ai != a.length && bi == b.length) {
			return a[ai] + minCost(a, b, ai + 1, bi);
		}
		if (ai == a.length && bi != b.length) {
			return b[bi] + minCost(a, b, ai, bi + 1);
		}
		// 删掉 a[ai]
		int p1 = a[ai] + minCost(a, b, ai + 1, bi);
		// 删掉 b[bi]
		int p2 = b[ai] + minCost(a, b, ai, bi + 1);
		// 同时删掉 a[ai]、b[bi]
//		int p3 = a[ai] + b[bi] +  minCost(a, b, ai+1, bi +1);
		// a[ai] -> b[ai]、b[bi] -> a[ai]
		int p4 = Math.abs(a[ai] - b[bi]) + minCost(a, b, ai + 1, bi + 1);
		// p5 a[ai] == b[bi]
		return Math.min(p1, Math.min(p2, p4));
	}
}
