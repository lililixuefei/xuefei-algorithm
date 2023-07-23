package leetcode.onequestion.resolved;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: 771. 宝石与石头
 * @author: xuefei
 * @date: 2023/07/24 00:01
 */
public class NumJewelsInStones {

	public int numJewelsInStones(String jewels, String stones) {
		Set<Character> jewelsSet = new HashSet();
		for (char c : jewels.toCharArray()) {
			jewelsSet.add(c);
		}

		int num = 0;
		for (char c : stones.toCharArray()) {
			if (jewelsSet.contains(c)) {
				num++;
			}
		}
		return num;
	}

}
