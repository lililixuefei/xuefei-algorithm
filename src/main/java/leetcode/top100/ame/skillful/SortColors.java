package leetcode.top100.ame.skillful;


/**
 * @Description
 * @Author xuefei
 * @Date 2024/4/18 22:35
 * @Version 1.0
 */
public class SortColors {


    // [2,0,2,1,1,0]
    public void sortColors(int[] nums) {
        int l = 0;
        int i = 0;
        int r = nums.length - 1;
        while (i <= r) {
            if (nums[i] == 0) {
                swap(nums, i, l);
                i++;
                l++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                swap(nums, i, r);
                r--;
            }
        }
    }


    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
