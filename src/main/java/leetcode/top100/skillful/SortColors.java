package leetcode.top100.skillful;

/**
 * @description: 颜色分类
 * @author: xuefei
 * @date: 2023/11/09 17:44
 */
public class SortColors {

    public static void main(String[] args) {
        int[] nums = {2,0,1};
        sortColors(nums);

    }


    public static void sortColors(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int less = 0;
        int more = nums.length - 1;
        int i = 0;
        while (i <= more) {
            if (nums[i] == 0) {
                swap(nums, less, i);
                less++;
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                swap(nums, more, i);
                more--;
            }
        }
    }


    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
