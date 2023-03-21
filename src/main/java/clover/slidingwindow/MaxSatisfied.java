package clover.slidingwindow;

/**
 * @description: 爱生气的书店老板
 * @author: xuefei
 * @date: 2023/03/21 21:51
 */
public class MaxSatisfied {

	public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
		int ans = 0;
		for (int i = 0; i < customers.length; i++) {
			if (grumpy[i] == 0) {
				ans += customers[i];
				customers[i] = 0;
			}
		}
		int cur = 0;
		int max = 0;
		for (int i = 0; i < customers.length; i++) {
			cur += customers[i];
			if (i >= minutes) {
				cur -= customers[i - minutes];
			}
			max = Math.max(max, cur);
		}
		return ans + max;
	}

}
