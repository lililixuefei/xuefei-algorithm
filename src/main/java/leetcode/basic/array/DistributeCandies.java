package leetcode.basic.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @description: 分糖果
 * @author: xuefei
 * @date: 2023/05/05 22:46
 */
public class DistributeCandies {

	public int distributeCandies(int[] candyType) {
		Set<Integer> set = new HashSet<>();
		for (int i : candyType) {
			set.add(i);
		}
		return Math.min(candyType.length / 2, set.size());
	}


	public int distributeCandies_me(int[] candyType) {
		int count = candyType.length / 2;
		int length = Arrays.stream(candyType).distinct().toArray().length;
		return Math.min(count, length);
	}

}
