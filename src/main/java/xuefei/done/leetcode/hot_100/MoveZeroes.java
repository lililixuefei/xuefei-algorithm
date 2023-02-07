package xuefei.done.leetcode.hot_100;


/**
 * @description: 移动零   https://leetcode.cn/problems/move-zeroes/
 * @author: xuefei
 * @date: 2022/06/27 23:04
 */
public class MoveZeroes {

    public static void main(String[] args) {

        moveZeroes(new int[]{4, 2, 4, 0, 0, 3, 0, 5, 1, 0});
    }

    public static void moveZeroes(int[] nums) {

        if (nums == null || nums.length == 1) {
            return;
        }

        int index = 0;
        int swapIndex = 1;

        for (int i = 0; i < nums.length; i++) {
            if (swapIndex > nums.length - 1) {
                break;
            }
            if (nums[index] != 0) {
                index++;
                swapIndex++;
                continue;
            }
            if (nums[swapIndex] == 0) {
                swapIndex++;
                continue;
            }
            swap(nums, index, swapIndex);
            index++;
            swapIndex++;
        }

    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
