package leetcode.daily;

/**
 * @description: 分发糖果
 * @author: xuefei
 * @date: 2023/05/16 23:33
 */
public class Candy {

	public static void main(String[] args) {
		int[] ratings = {1,0,2};
		candy(ratings);
	}

	public static int candy(int[] ratings) {
		int n = ratings.length;
		int[] leftCandy = new int[n];
		leftCandy[0] = 1;
		for (int i = 1; i < n; i++) {
			leftCandy[i] = ratings[i] > ratings[i - 1] ? leftCandy[i - 1] + 1 : 1;
		}

		int[] rightCandy = new int[n];
		rightCandy[n - 1] = 1;
		for (int i = n - 2; i >= 0; i--) {
			rightCandy[i] = ratings[i] > ratings[i + 1] ? rightCandy[i + 1] + 1 : 1;
		}
		int ans = 0;
		for (int i = 0; i < n; i++) {
			ans += Math.max(leftCandy[i], rightCandy[i]);
		}
		return ans;
	}

}
