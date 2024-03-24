package leetcode.top100.skillful;

/**
 * @Description
 * @Author xuefei
 * @Date 2024/3/24 19:57
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
