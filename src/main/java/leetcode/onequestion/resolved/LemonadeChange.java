package leetcode.onequestion.resolved;

/**
 * @description: 柠檬水找零
 * @author: xuefei
 * @date: 2023/07/22 16:50
 */
public class LemonadeChange {

	public boolean lemonadeChange(int[] bills) {

		if (bills[0] != 5) {
			return false;
		}

		int fiveCount = 1;
		int tenCount = 0;
		int twentyCount = 0;
		for (int i = 1; i < bills.length; i++) {
			int bill = bills[i];
			if (bill == 5) {
				fiveCount++;
			} else if (bill == 10) {
				tenCount++;
				if (--fiveCount < 0) {
					return false;
				}
			} else {
				twentyCount++;
				if (tenCount > 0 && fiveCount > 0) {
					tenCount--;
					fiveCount--;
					continue;
				}
				if (fiveCount > 2) {
					fiveCount -= 3;
					continue;
				}
				return false;
			}
		}
		return true;
	}

}
