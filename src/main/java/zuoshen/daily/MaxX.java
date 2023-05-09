package zuoshen.daily;

/**
 * @description:
 * @author: xuefei
 * @date: 2023/05/09 22:50
 */
public class MaxX {

	/**
	 * 给定一个数组arr,表示连续n天的股价,数组下标表示第几天
	 * 指标x = 任意两天的股价之和 - 此两天间隔的天数
	 * 返回arr中最大的指标x
	 * @param arr
	 * @return
	 */
	public static int maxX(int[] arr) {
		if (arr == null || arr.length < 2) {
			return -1;
		}
		int ans = 0;
		int preBest = arr[0];
		for (int i = 1; i < arr.length; i++) {
			ans = Math.max(ans, arr[i] - i + preBest);
			preBest = Math.max(preBest, arr[i] + i);
		}
		return ans;

	}
}
