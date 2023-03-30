package leetcode.basic.dp;

/**
 * @description: 比特位计数
 * @author: xuefei
 * @date: 2023/03/30 23:45
 */
public class CountBits {

	public int[] countBits(int n) {
		int[] bits = new int[n + 1];
		int highBit = 0;
		for (int i = 1; i <= n; i++) {
			if ((i & (i - 1)) == 0) {
				highBit = i;
			}
			bits[i] = bits[i - highBit] + 1;
		}
		return bits;
	}

}
