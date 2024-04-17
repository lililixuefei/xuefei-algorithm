package leetcode.top100.ame.greed.undo;

/**
 * @Description
 * @Author xuefei
 * @Date 2024/4/17 22:51
 * @Version 1.0
 */
public class CanJump {

    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }

//    public boolean canJump(int[] nums) {
//        int rightMost = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == 0){
//                continue;
//            }
//            if (nums[i] >= rightMost) {
//                rightMost = Math.max(rightMost, nums[i] + i);
//            }
//            if (rightMost >= nums.length - 1) {
//                return true;
//            }
//        }
//        return false;
//    }

}
