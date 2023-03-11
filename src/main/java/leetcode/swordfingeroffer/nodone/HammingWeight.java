package leetcode.swordfingeroffer.nodone;

/**
 * @description: 二进制中1的个数
 * @author: xuefei
 * @date: 2023/03/11 17:45
 */
public class HammingWeight {

	public int hammingWeight_good(int n) {
		int ret = 0;
		while (n != 0) {
			n &= n - 1;
			ret++;
		}
		return ret;
	}


	public int hammingWeight_me(int n) {
		String binaryString = Integer.toBinaryString(n);
		int count = 0;
		for (int i = 0; i < binaryString.length(); i++) {
			if (binaryString.charAt(i) == '1') {
				count++;
			}
		}
		return count;
	}

}
