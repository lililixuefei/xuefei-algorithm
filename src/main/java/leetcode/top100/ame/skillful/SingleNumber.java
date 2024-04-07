package leetcode.top100.ame.skillful;

/**
 * @Description
 * @Author xuefei
 * @Date 2024/4/7 23:08
 * @Version 1.0
 */
public class SingleNumber {

	public int singleNumber(int[] nums) {
		int ans = 0;
		for (int num : nums) {
			ans = ans ^ num;
		}
		return ans;
	}

}
