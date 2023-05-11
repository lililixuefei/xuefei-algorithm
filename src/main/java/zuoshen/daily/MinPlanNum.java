package zuoshen.daily;

/**
 * @description:
 * @author: xuefei
 * @date: 2023/05/12 00:13
 */
public class MinPlanNum {


	/**
	 * 方案1:{7.10}
	 * xxxx:{a,b}
	 * FunnyGoal = 100;
	 * OffenceGoal = 130;
	 * 找到一个最小方案数，让FunnyGoal、OffenceGoal都小于等于0
	 * @param arr
	 * @param index
	 * @param restFunny
	 * @param restOffence
	 * @return
	 */
	public static int minPlanNum(int[][] arr, int index, int restFunny, int restOffence) {
		if (restFunny <= 0 && restOffence <= 0) {
			return 0;
		}
		// 有值，还没扣完
		if (index == arr.length) {
			return Integer.MAX_VALUE;
		}
		// index号方案不要
		int p1 = minPlanNum(arr, index + 1, restFunny, restOffence);

		// index号方案要
		int p2 = Integer.MAX_VALUE;
		int next = minPlanNum(arr, index + 1, restFunny - arr[index][0], restOffence - arr[index][1]);
		if (next != Integer.MAX_VALUE) {
			p2 = 1 + next;
		}
		return Math.min(p1, p2);
	}
}
