package leetcode.daily;

import java.util.Arrays;

/**
 * @description: 救生艇
 * @author: xuefei
 * @date: 2023/05/20 22:32
 */
public class NumRescueBoats {

	public int numRescueBoats(int[] people, int limit) {
		Arrays.sort(people);
		int length = people.length;
		int ans = 0;
		int l = 0;
		int r = length - 1;
		while (l <= r) {
			if (people[l] + people[r] <= limit) {
				l++;
			}
			ans++;
			r--;
		}
		return ans;
	}

}
