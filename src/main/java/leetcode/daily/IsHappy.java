package leetcode.daily;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: 快乐数
 * @author: xuefei
 * @date: 2023/02/26 14:14
 */
public class IsHappy {

	public static void main(String[] args) {
		System.out.println(isHappy(2));
	}

	private static int getNext(int n) {
		int totalSum = 0;
		while (n > 0) {
			int d = n % 10;
			n = n / 10;
			totalSum += d * d;
		}
		return totalSum;
	}

	public static boolean isHappy(int n) {
		Set<Integer> seen = new HashSet<>();
		while (n != 1 && !seen.contains(n)) {
			seen.add(n);
			n = getNext(n);
		}
		return n == 1;
	}


}
