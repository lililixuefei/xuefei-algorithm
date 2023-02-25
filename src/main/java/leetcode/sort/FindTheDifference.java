package leetcode.sort;

import java.util.Arrays;

/**
 * @description: 找不同
 * @author: xuefei
 * @date: 2023/02/25 18:08
 */
public class FindTheDifference {

	public char findTheDifference(String s, String t) {

		byte[] sBytes = s.getBytes();
		byte[] tBytes = t.getBytes();

		Arrays.sort(sBytes);
		Arrays.sort(tBytes);

		int i = 0;
		while (i < sBytes.length) {
			if (sBytes[i] != tBytes[i]) {
				return (char) tBytes[i];
			}
			i++;
		}
		return (char) tBytes[tBytes.length - 1];

	}

}
