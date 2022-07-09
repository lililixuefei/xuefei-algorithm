package a.labuladong;

/**
 * @description: 二分搜索
 * https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247485044&idx=1&sn=e6b95782141c17abe206bfe2323a4226&scene=21#wechat_redirect
 * @author: xuefei
 * @date: 2022/07/09 19:57
 */
public class BinarySearch {


    // 普通二分搜索
    public int binarySearch(int[] nums, int target) {
        assert nums.length > 0;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return -1;
    }

}
