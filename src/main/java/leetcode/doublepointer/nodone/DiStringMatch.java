package leetcode.doublepointer.nodone;

/**
 * @description: 增减字符串匹配
 * @author: xuefei
 * @date: 2023/02/28 23:03
 */
public class DiStringMatch {

	public int[] diStringMatch(String s) {
		int n = s.length();
		int lo = 0;
		int hi = n;
		int[] perm = new int[n + 1];
		for (int i = 0; i < n; ++i) {
			perm[i] = s.charAt(i) == 'I' ? lo++ : hi--;
		}
		// 最后剩下一个数，此时 lo == hi
		perm[n] = lo;
		return perm;
	}

}
