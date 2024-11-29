package leetcode.top100.matrix;

/**
 * @Description
 * @Author xuefei
 * @Date 2024/3/24 20:19
 * @Version 1.0
 */
public class SearchMatrix {

	public boolean searchMatrix(int[][] matrix, int target) {
		int i = matrix.length - 1;
		int j = 0;
		while (i >= 0 && j < matrix[0].length) {
			if (matrix[i][j] > target) {
				i--;
			} else if (matrix[i][j] < target) {
				j++;
			} else {
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
String s = "https://i.st.maoyan.com/swan/activityProxy/api/activity/spendMoney/sendCoupon.json?channelId=70001&timestamp=1714103441524&index=10&sign=dfdab6908eef1c9f744b8f5b7b1e4a39&code=0f3Vvy000RlEZR1Vke300M39UR1Vvy0x&clientType=wechat_small_program&uuid=be971706351d4f5773097b29f89c476a";
		System.out.println(s.length());
	}


}
