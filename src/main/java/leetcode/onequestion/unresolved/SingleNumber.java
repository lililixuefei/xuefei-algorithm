package leetcode.onequestion.unresolved;


/**
 * @Description 只出现一次的数字 III
 * @Author xuefei
 * @Date 2023/10/12 00:11
 * @Version 1.0
 */
public class SingleNumber {

	public int[] singleNumber(int[] numbers) {
		int i = 0;
		for (int number : numbers) {
			i = i ^ number;
		}

		int m = 1;
		while ((m & i) == 0) {
			m = m << 1;
		}

		int x = 0;
		int y = 0;
		for (int number : numbers) {
			if ((number & m) == 0) {
				x = x ^ number;
			} else {
				y = y ^ number;
			}
		}
		return new int[]{x, y};
	}

}
